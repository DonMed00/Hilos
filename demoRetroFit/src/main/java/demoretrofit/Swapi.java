package demoretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface Swapi {

    @GET("people/{personId}/")
    CompletableFuture<Person> getPerson(@Path("personId") int personId);


    @GET("planets/{planetId}/")
    CompletableFuture<Planet> getPlanet(@Path("planetId") int planetId);
}
