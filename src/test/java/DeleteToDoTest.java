import Api.ApiService;
import Api.Responce;
import com.google.gson.GsonBuilder;
import entity.Todo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;
import java.util.List;

public class DeleteToDoTest extends BaseTest{

    String idTodo;

    @BeforeMethod
    public void createTodo() throws IOException {
        retrofit.create(ApiService.class).createNewToDo(new Todo("Test5")).execute();
        Response <List<Responce>> responce = retrofit.create(ApiService.class).getListTodo().execute();
        idTodo = responce.body().get(0).getId();
    }

    @Test(description = "Delete list of todo")
    public void shouldCanDeleteAllTodo () throws IOException {
        Response<List<Responce>> responce2 = retrofit.create(ApiService.class).deleteListTodo(idTodo).execute();
        assertThat(responce2.code(), is(204));
    }

    @AfterMethod
    public void getTodo() throws IOException {
        retrofit.create(ApiService.class).getListTodo().execute();
    }
}
