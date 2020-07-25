import Api.ApiService;
import Api.Responce;
import com.google.gson.GsonBuilder;
import entity.Todo;
import okhttp3.ResponseBody;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PostToDoTest extends BaseTest{

    @Test(description = "Create new todo")
    public void shouldCanCreateTodo() throws IOException {
//        Todo todo = new Todo("Test5");
//        System.out.println(retrofit.create(ApiService.class).createNewToDo(new Todo("Test5")).execute().toString());
          Response<ResponseBody> response = retrofit.create(ApiService.class).createNewToDo(new Todo("Test5")).execute();
          assertThat(response.code(), is(201));



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