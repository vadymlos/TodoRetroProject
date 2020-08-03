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
import static org.hamcrest.Matchers.notNullValue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetListTodo extends BaseTest{

    ArrayList<String> idTodo = new ArrayList<String>();

    public void clearTodo() throws IOException {
        ArrayList<String> id = new ArrayList<String>();

        Response <List<Responce>> responce1 = retrofit.create(ApiService.class).getListTodo().execute();
        if (responce1.body().size() > 0){
            for (int i = 0; i < responce1.body().size(); i++) {
                String tod = responce1.body().get(i).getId();
                id.add(tod);
            }
        }
        for (int i = 0; i < id.size(); i++) {
            retrofit.create(ApiService.class).deleteListTodo(id.get(i)).execute();
        }
    }

    @BeforeMethod
    public void createTodo() throws IOException {
        clearTodo();
        retrofit.create(ApiService.class).createNewToDo(new Todo("Test11")).execute();
        retrofit.create(ApiService.class).createNewToDo(new Todo("Test12")).execute();
    }

    @Test(description = "Get list of todo")
    public void shouldCanGetListTodo () throws IOException {
        Response <List<Responce>> responce = retrofit.create(ApiService.class).getListTodo().execute();
        assertThat(responce.code(), is(200));
        assertThat(responce.body(), is(notNullValue()));
        responce.body().size();
        assertThat(responce.body().size(), is(2));
        for (int i = 0; i < responce.body().size(); i++) {
            String tod = responce.body().get(i).getId();
            idTodo.add(tod);
        }
    }

    @AfterMethod
    public void deleteTodo() throws IOException {
        for (int i = 0; i < idTodo.size(); i++) {
            retrofit.create(ApiService.class).deleteListTodo(idTodo.get(i)).execute();
        }
    }
}

