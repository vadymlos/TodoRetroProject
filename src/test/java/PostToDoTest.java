import Api.ApiService;
import Api.Responce;
import com.google.gson.GsonBuilder;
import entity.Todo;
import okhttp3.ResponseBody;
import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PostToDoTest extends BaseTest{
    String idTodo;

    @Test(description = "Create new todo")
    public void shouldCanCreateTodo() throws IOException {
          Response<Responce> response = retrofit.create(ApiService.class).createNewToDo(new Todo("Test11")).execute();
          Response <List<Responce>> responce = retrofit.create(ApiService.class).getListTodo().execute();
          idTodo = responce.body().get(0).getId();
          assertThat(response.code(), is(201));
          assertThat(response.body(), is(notNullValue()));
          String description = response.body().getDescription();
          assertThat(description, is("Test11"));
    }

    @AfterMethod
    public void deleteTodo() throws IOException {
          retrofit.create(ApiService.class).deleteListTodo(idTodo).execute();
    }
}

//    @Test(description = "Registration new user")
//    public void testCanRegisterNewUser() {
//        User user3 = new User(Utils.randomUserName(), "Vadym", "Test", "form@com.com", "123");
//
//        Response response = userApiService.registerNewUser(user3);
//        assertThat(response.statusCode(), equalTo(200));
//        String body = response.body().jsonPath().get("id").toString();
//        assertThat(body, not(isEmptyOrNullString()));
//    }