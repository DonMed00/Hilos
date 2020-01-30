package demoretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface Swapi {

    @GET("people/{personId}/")
     Call<Person> getPerson(@Path("personId") int personId);
}
