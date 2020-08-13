package steps;

import Api.ApiService;
import Api.Responce;
import entity.Todo;
import entity.UpdateTodo;
import io.qameta.allure.Step;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class Apistep {
    private Retrofit retrofit;

    public Apistep(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Step("Create new todo")
    public Response<Responce> shouldCanCreateTodo(Todo todo) throws IOException {
        return retrofit.create(ApiService.class).createNewToDo(todo).execute();
    }

    @Step("Get list of Todo")
    public Response<List<Responce>> shouldCanGetListTodo() throws IOException {
        return retrofit.create(ApiService.class).getListTodo().execute();
    }

    @Step("Delete Todo")
    public Response<List<Responce>> shouldCanDeleteTodo(String id) throws IOException {
        return retrofit.create(ApiService.class).deleteListTodo(id).execute();
    }

    @Step("Update Todo")
    public Response<Responce> shouldCanUpdateTodo(UpdateTodo updateTodo) throws IOException {
        return retrofit.create(ApiService.class).patchListTodo(updateTodo).execute();
    }
}
