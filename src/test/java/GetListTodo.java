import Api.ApiService;
import Api.Responce;
import com.google.gson.GsonBuilder;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class GetListTodo {
    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();
//        System.out.println(retrofit.create(ApiService.class).getListTodo().execute());
        Response <List<Responce>> responce = retrofit.create(ApiService.class).getListTodo().execute();
        System.out.println(responce.body().get(0).getId());
        System.out.println(responce.body().get(1).getId());
        System.out.println(responce.body().get(2).getId());
        System.out.println(responce.body().get(3).getId());
        System.out.println(responce.body().get(4).getId());
        System.out.println(responce.body().get(0).getDescription());
        System.out.println(responce.body().get(1).getDescription());
        System.out.println(responce.body().get(2).getDescription());
        System.out.println(responce.body().get(3).getDescription());
        System.out.println(responce.body().get(4).getDescription());

//        List<Api<Responce>> list = retrofit.create(ApiService.class).getListTodo().execute();
//        String id = list.get(0).getId();
    }
}

