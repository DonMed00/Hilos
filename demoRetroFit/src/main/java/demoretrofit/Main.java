package demoretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
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

    public Main() {
        getPersonWithPlanet(1)
                .thenAccept(personPlanet -> System.out.printf("%s - %s\n", personPlanet.getPersonName(), personPlanet.getPlanetName()));

       /* getPersonWithPlanet(1)
                .thenApply(personPlanet -> personPlanet.getPersonName() + " - " + personPlanet.getPlanetName())
                .thenAccept(System.out::println);*/

        getPersonWithFilms(1)
                .thenAccept(personFilms -> System.out.printf("%s - %s\n",personFilms.getPersonName(),personFilms.getFilmList()));
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

    private CompletableFuture<PersonFilms> getPersonWithFilms(int personId) {
        CompletableFuture<PersonFilms> algo = apiService.getPerson(1)
                .thenComposeAsync(person -> {
                    //Queremos retornar un cf de person with films
                    int numFilms = person.getFilms().size();
                    CompletableFuture<Film>[] arrayCFF = new CompletableFuture[numFilms];
                    for (int i = 0; i < numFilms; i++) {
                        arrayCFF[i] = apiService.getFilmByUrl(person.getFilms().get(i));
                    }

                    //Esperar que todos terminen
                    CompletableFuture<Void> todos = CompletableFuture.allOf(arrayCFF);
                    //Construyo el completablefuture a retornar.
                    CompletableFuture<PersonFilms> cpf = todos.thenApplyAsync(nada -> {
                        //Recorro el array y para cada cf obtengo el film y lo añado a una lista
                        List<String> pelis = new ArrayList<>();
                        for (int j = 0; j < numFilms; j++) {
                            pelis.add(arrayCFF[j].join().getTitle());
                        }
                        return new PersonFilms(person.getName(), pelis);
                    });
                    return cpf;
                });
        return algo;
    }

}
