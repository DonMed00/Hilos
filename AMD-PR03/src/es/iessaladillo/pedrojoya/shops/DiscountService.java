package es.iessaladillo.pedrojoya.shops;

import static es.iessaladillo.pedrojoya.shops.TimeUtils.randomDelay;

// Servicio general de cálculo de descuentos, al que la red de tiendas solicitan
// que se le aplique el descuento correspondiente a un determinado producto.
public class DiscountService {

    // Existen 5 tipos de descuentos, cada uno de ellos con un porcentage asociado.
    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    // Este es el método que llamará la red de tiendas para aplicar un determinado
    // descuento a un producto.
    // Recibe un objeto ShopResponse sobre el que aplicar el descuento.
    // Debemos tener en cuenta que la aplicación del servicio es un proceso que puede
    // tardar un tiempo considerable, ya que se supone que se trata de un servicio
    // externo.
    public String applyDiscount(ShopResponse shopResponse) {
        return String.format("%s price is %.2f (%.2f - %d%% discount)\n",
                shopResponse.getShopName(),
                apply(shopResponse.getPrice(), shopResponse.getDiscountCode()),
                shopResponse.getPrice(),
                shopResponse.getDiscountCode().percentage
        );
    }

    // Método interno que simula la aplicación del descuento.
    private float apply(float price, Code discountCode) {
        randomDelay();
        return price * (100 - discountCode.percentage) / 100;
    }

}
