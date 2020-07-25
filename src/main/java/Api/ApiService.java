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
    Call<ResponseBody> createNewToDo(@Body Todo todo);

    @Headers("Content-Type: application/json")
    @GET("api/todo")
    Call<List<Responce>> getListTodo();

    @Headers("Content-Type: application/json")
    @DELETE("api/todo/{b3ad53d6-c3e6-4aac-b5f0-911c69a3c1a4}")
    Call<ResponseBody> deleteListTodo();

    @Headers("Content-Type: application/json")
    @PUT("api/todo/")
    Call<ResponseBody> patchListTodo(@Body UpdateTodo updateTodo);

}
