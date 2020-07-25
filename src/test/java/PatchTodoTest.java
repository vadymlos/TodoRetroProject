import Api.ApiService;
import com.google.gson.GsonBuilder;
import entity.Todo;
import entity.UpdateTodo;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class PatchTodoTest {
    public static void main(String[] args) throws IOException {
        UpdateTodo updateTodo = new UpdateTodo("5a865d4e-f790-47cb-84e7-46e5baea140f", "test 8");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();
        System.out.println(retrofit.create(ApiService.class).patchListTodo(updateTodo).execute().toString());
    }
}
