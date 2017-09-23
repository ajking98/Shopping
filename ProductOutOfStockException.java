/**
 * @author Ahmed Gedi
 * @version 1.0
 */
public class ProductOutOfStockException extends ElementNotFoundException {

    /**
     * @param product the product in the cart
     */
    public ProductOutOfStockException(Product product) {
        super(product, product.toString() + "Product is out of stock.");

    }

    /**
     * @param product the product in the cart
     * @param msg the message for exceptions
     */
    public ProductOutOfStockException(Product product, String msg) {
        super(product, msg);
    }

}
