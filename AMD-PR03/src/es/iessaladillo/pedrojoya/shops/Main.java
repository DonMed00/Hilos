package es.iessaladillo.pedrojoya.shops;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

// El objetivo de nuestra práctica es a partri de un producto introducido
// por teclado, calcular de manera asíncrona el precio de dicho producto en
// todas las tiendas de una determinada red de tiendas, mostrar dichos precios
// y mostrar finalmente el tiempo total que se ha tardado en realizar la búsqueda.
public class Main {

    private final ShopNetwork shopNetwork;
    private long startTime;

    public static void main(String[] args) {
        new Main(new ShopNetwork(new DiscountService()));
    }

    public Main(ShopNetwork shopNetwork) {
        this.shopNetwork = shopNetwork;
        calculatePriceOfProduct();
    }

    private void calculatePriceOfProduct() {
        System.out.print("Product to search: ");
        Scanner keyboard = new Scanner(System.in);
        String product = keyboard.nextLine();
        startTime = System.nanoTime();
        search(product);
        System.out.printf("Search took %d ms", (System.nanoTime() - startTime) / 1000000);

        //System.exit(0); Para que finalice cuando acaben todos
    }

    private void search(String product) {
        CompletableFuture[] cfTiendas =shopNetwork.findPricesStream(product)//Llamamos al método de shopNetwork para los precios
                .map(cf ->{
                    cf.thenAcceptAsync(System.out::println);//Al mapearlo, obtenemos el objeto que contiene el Stream que sería el CompletableFuture<String>
                    return cf;
                }).toArray(CompletableFuture[]::new);
        try {
            CompletableFuture.allOf(cfTiendas).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
