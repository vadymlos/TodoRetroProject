import Api.ApiService;
import Api.Responce;
import com.google.gson.GsonBuilder;
import entity.Todo;
import entity.UpdateTodo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PatchTodoTest extends BaseTest{

    String idTodo;

    @BeforeMethod
    public void createTodo() throws IOException {
        apistep.shouldCanCreateTodo(new Todo("Test5"));
        Response <List<Responce>> responce = apistep.shouldCanGetListTodo();
        idTodo = responce.body().get(0).getId();
    }

    @Test(description = "Update todo")
    public void canUpdateTodo () throws IOException {
        Response <Responce> responce2 = apistep.shouldCanUpdateTodo(new UpdateTodo(idTodo, "Test10X"));
        Response<List<Responce>> responce = apistep.shouldCanGetListTodo();
        assertThat(responce.code(), is(200));
        assertThat(responce.body().get(0).getDescription(), is("Test10X"));
    }

    @AfterMethod
    public void deleteTodo() throws IOException {
        apistep.shouldCanDeleteTodo(idTodo);
    }
}

