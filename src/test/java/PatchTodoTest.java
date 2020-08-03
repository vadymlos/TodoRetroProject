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
        retrofit.create(ApiService.class).createNewToDo(new Todo("Test5")).execute();
        Response <List<Responce>> responce = retrofit.create(ApiService.class).getListTodo().execute();
        idTodo = responce.body().get(0).getId();
    }

    @Test(description = "Update todo")
    public void shouldCanUpdateTodo () throws IOException {
        Response <Responce> responce2 = retrofit.create(ApiService.class).patchListTodo(new UpdateTodo(idTodo, "test 20")).execute();
        Response<List<Responce>> responce = retrofit.create(ApiService.class).getListTodo().execute();
        assertThat(responce.code(), is(200));
        String description = responce.body().get(0).getDescription();
        assertThat(description, is("test 20"));
    }

    @AfterMethod
    public void deleteTodo() throws IOException {
        retrofit.create(ApiService.class).deleteListTodo(idTodo).execute();
    }
}

