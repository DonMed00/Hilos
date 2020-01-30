package demoretrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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
// Se crea el cliente REST de acceso a la API a partir del
// objeto Retrofit.
        Swapi apiService = retrofit.create(Swapi.class);
        Call<Person> call = apiService.getPerson(1);
        call.enqueue(new Callback<Person>() {
            @Override
            public void onResponse(Call<Person> call, Response<Person> response) {
                if(response.isSuccessful()){
                    Person person = response.body();
                    System.out.println(person.getName());
                }
            }

            @Override
            public void onFailure(Call<Person> call, Throwable t) {

            }
        });
    }
}
