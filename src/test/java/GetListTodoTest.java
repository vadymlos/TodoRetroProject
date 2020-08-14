import Api.ApiService;
import Api.Responce;
import Utils.ClearTodoList;
import Utils.DeleteForTodoList;
import com.google.gson.GsonBuilder;
import entity.Todo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import steps.Apistep;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetListTodoTest extends BaseTest{

    @BeforeMethod
    public void createTodo() throws IOException {
        ClearTodoList clearTodoList = new ClearTodoList();
        clearTodoList.clearTodo(retrofit);
        apistep.shouldCanCreateTodo(new Todo("Test11"));
        apistep.shouldCanCreateTodo(new Todo("Test12"));
    }

    @Test(description = "Get list of todo")
    public void canGetListTodo () throws IOException {
        Response <List<Responce>> responce = apistep.shouldCanGetListTodo();
        assertThat(responce.code(), is(200));
        assertThat(responce.body().size(), is(2));
    }

    @AfterMethod
    public void deleteTodo() {
        DeleteForTodoList deleteForTodoList = new DeleteForTodoList();
        deleteForTodoList.deleteTodoListForGet(retrofit);
    }
}

