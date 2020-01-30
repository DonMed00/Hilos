package demoretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main();
    }
    public Main(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Swapi apiService = retrofit.create(Swapi.class);
         apiService.getPerson(1).whenComplete((person, throwable) -> {
             if ((throwable==null)){
                 System.out.println(person.getName());

             }
         }).thenAccept(person -> {
             apiService.getPlanet(Integer.parseInt(person.getHomeworld().substring(29,30))).whenComplete((planet, throwable) -> {
                 if ((throwable == null)) {
                     System.out.println(planet.getName());

                 }
             }).join();

         });
    }
}
