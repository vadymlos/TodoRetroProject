package Api;

import entity.Todo;
import entity.UpdateTodo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.List;

public interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("api/todo")
    Call<Responce> createNewToDo(@Body Todo todo);

    @Headers("Content-Type: application/json")
    @GET("api/todo")
    Call<List<Responce>> getListTodo();

    @Headers("Content-Type: application/json")
    @DELETE("api/todo/{id}")
    Call<List<Responce>> deleteListTodo(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @PUT("api/todo/")
    Call<Responce> patchListTodo(@Body UpdateTodo updateTodo);

}
