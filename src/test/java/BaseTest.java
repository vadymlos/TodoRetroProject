import com.google.gson.GsonBuilder;
import org.testng.annotations.BeforeMethod;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import steps.Apistep;

public class BaseTest {
    Apistep apistep;
    Retrofit retrofit;

    @BeforeMethod
    public void BeforeMethod(){

        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .build();
        apistep = new Apistep(retrofit);
    }
}
