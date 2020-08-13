package Utils;

import Api.ApiService;
import Api.Responce;
import retrofit2.Response;
import retrofit2.Retrofit;
import steps.Apistep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteForTodoList {

    ArrayList<String> idTodo = new ArrayList<String>();

    public void deleteTodoListForGet(Retrofit retrofit){
        Response<List<Responce>> responce = null;
        try {
            responce = retrofit.create(ApiService.class).getListTodo().execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < responce.body().size(); i++) {
            String todo = responce.body().get(i).getId();
            idTodo.add(todo);
        }

        for (int i = 0; i < idTodo.size(); i++) {
            try {
                retrofit.create(ApiService.class).deleteListTodo(idTodo.get(i)).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
