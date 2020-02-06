package demoretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface Swapi {

    @GET("people/{personId}/")
    CompletableFuture<Person> getPerson(@Path("personId") int personId);


    @GET
    CompletableFuture<Planet> getPlanetByUrl(@Url String planetUrl);
    @GET
    CompletableFuture<Film> getFilmByUrl(@Url String filmUrl);
}
