package demoretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://swapi.co/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    Swapi apiService = retrofit.create(Swapi.class);

    public Main(){
         getPersonWithPlanet(1)
                 .thenAccept(personPlanet -> System.out.printf("%s - %s\n", personPlanet.getPersonName(), personPlanet.getPlanetName()));

        getPersonWithPlanet(1)
                .thenApply(personPlanet -> personPlanet.getPersonName() + " - " + personPlanet.getPlanetName())
                .thenAccept(System.out::println);
    }

    private CompletableFuture<PersonPlanet> getPersonWithPlanet(int personId) {
        return apiService.getPerson(1)
                .thenCompose(person ->
                        // Algo que retorna un CompletableFuture
                        // Obtengo el planeta, y después lo transformo en un PersonaPlaneta
                    apiService.getPlanetByUrl(person.getHomeworld()).thenApply(planet ->
                            new PersonPlanet(person.getName(), planet.getName())
                    )
        );
    }

}
