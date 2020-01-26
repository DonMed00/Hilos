package es.iessaladillo.pedrojoya.shops;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

// Red de tiendas en las que se puede buscar el precio de un producto.
public class ShopNetwork {

    private final DiscountService discountService;
    // Lista de tiendas con las que trabaja la red de tiendas
    private final List<Shop> shops = Arrays.asList(
            new Shop("BuyItAll"),
            new Shop("MyFavoriteShop"),
            new Shop("LetsSaveBig"),
            new Shop("ShopEasy"),
            new Shop("BestPrice"));
    // Ejecutor en el que deben ejecutarse las operaciones asíncronas.
    private final Executor executor = Executors.newFixedThreadPool(shops.size());

    // El constructor recibe el servicio de descuentos con el que trabaja la red de tiendas
    public ShopNetwork(DiscountService discountService) {
        this.discountService = discountService;
    }

    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        CompletableFuture<String>[] cfTiendas =new CompletableFuture[shops.size()];//Array CF

        for(int i=0;i<shops.size();i++) {
            int finalI = i;
            cfTiendas[i] = CompletableFuture.supplyAsync(() -> shops.get(finalI).getPrice(product), executor)//Tienda a tienda obteniendo el precio del producto
                    .thenApplyAsync(ShopResponse::parse, executor)//Parseamos a ShopResponse usando el executor
                    .thenApplyAsync(discountService::applyDiscount);//Aplicamos el descuento
        }
        return Stream.of(cfTiendas);//Retornamos un Stream de CompletableFuture<String>
    }

}
