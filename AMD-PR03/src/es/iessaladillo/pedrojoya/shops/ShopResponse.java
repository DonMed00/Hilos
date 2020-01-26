package es.iessaladillo.pedrojoya.shops;

// Clase que modela la respuesta de una petición de precio a una tienda.
public class ShopResponse {

    private final String shopName;
    private final float price;
    private final DiscountService.Code discountCode;

    // Constructor privado porque la única manera de construir un objeto de esta clase
    // será a través del método factoría estático parse(cadena)
    private ShopResponse(String shopName, float price, DiscountService.Code discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }

    // Construye un objeto ShopResponse a partir del parseo de la cadena retornada
    // por una tienda cuando se le consulta el precio de un producto.
    public static ShopResponse parse(String response) {
        String[] responseParts = response.split(":");
        return new ShopResponse(
                responseParts[0],
                Float.parseFloat(responseParts[1]),
                DiscountService.Code.valueOf(responseParts[2])
        );
    }

    public String getShopName() {
        return shopName;
    }

    public float getPrice() {
        return price;
    }

    public DiscountService.Code getDiscountCode() {
        return discountCode;
    }

}
