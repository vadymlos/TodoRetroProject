package Utils;

import Api.ApiService;
import Api.Responce;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClearTodoList {
    public void clearTodo(Retrofit retrofit) throws IOException {
        ArrayList<String> id = new ArrayList<String>();

        Response<List<Responce>> responce1 = retrofit.create(ApiService.class).getListTodo().execute();
        if (responce1.body().size() > 0){
            for (int i = 0; i < responce1.body().size(); i++) {
                String todo = responce1.body().get(i).getId();
                id.add(todo);
            }
        }
        for (int i = 0; i < id.size(); i++) {
            retrofit.create(ApiService.class).deleteListTodo(id.get(i)).execute();
        }
    }
}
