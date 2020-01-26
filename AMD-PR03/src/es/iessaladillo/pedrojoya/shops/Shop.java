package es.iessaladillo.pedrojoya.shops;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import static es.iessaladillo.pedrojoya.shops.TimeUtils.randomDelay;

// Clase que modela una tienda
public class Shop {

    private final String name;

    public Shop(String name) {
        this.name = name;
    }

    // Método que debe ser llamado desde fuera para obtener el precio de un producto en la tienda.
    // Debemos fijarnos en que retorna una cadena con el formato
    // nombreTienda:precio:tipoDescuento
    public String getPrice(String product) {
        return String.format(Locale.US, "%s:%.2f:%s", name, calculatePrice(product), calculateDiscount());
    }

    // Método interno para obtener aleatoriamente el tipo de descuento a aplicar.
    private DiscountService.Code calculateDiscount() {
        int discountCodesNumber = DiscountService.Code.values().length;
        return DiscountService.Code.values()[ThreadLocalRandom.current().nextInt(discountCodesNumber)];
    }

    // Método interno para obtener aleatoriamente el precio del producto.
    private float calculatePrice(String product) {
        // Simulate query time.
        randomDelay();
        return ThreadLocalRandom.current().nextFloat() * product.charAt(0) + product.charAt(1);
    }

}
