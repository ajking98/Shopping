
/**
 * Represents the checkout page
 * @author Ahmed Gedi
 * @version 1.0
 */
public class CheckoutPage extends MyArrayList {

    private MyArrayList<Product> shoppingCart;
    private MyArrayList<Product> itemsInStock;
    // private Server server = new Server();
    // private double shippingCost;
    // private double priceTotal;

    /**
     * CheckoutPage() the actual name of the class
     */
    public CheckoutPage() {
        shoppingCart = new MyArrayList<>();
        itemsInStock = new MyArrayList<>();

        ArrayListInterface<Product> holder = Server.getProducts();
        int count = 0;
        for (Product p : holder) {
            itemsInStock.add(p);

        }
    }

    // private class myArrayListIterator {
    //     private int cursor = 0;

    //     public boolean hasNext() {
    //         return cursor <= lastIndex;
    //     }

    //     public E next() {
    //         if (!hasNext()) { throw new NoSuchElementException(); }
    //             E answer = get(cursor++);
    //             return answer;
    //     }

    //     public void remove() {
    //         DynamicArray.this.remove(cursor - 1);
    //     }
    // }
    /**
     *
     * @return priceTotal returns the total price of the products
     */
    public double getSubtotal() {
        double priceTotal = 0;
        for (Product product : shoppingCart) {
            if (product != null) {
                priceTotal += product.getPrice();
            }

        } return priceTotal;
    }

    /**
     *
     * @return shippingCost the total of the shippinf cost
     */
    public double getShipping() {
        double shippingCost = 8.95;
        if (this.getSubtotal() > 50 || this.getSubtotal() == 0.0) {
            return 0.0;
        } else {
            return shippingCost;
        }
        // if (priceTotal > 50 || shoppingCart.isEmpty()) {
        //     shippingCost = 0.00;
        // }
        // else {
        //     shippingCost = 8.95;
        // }
        // return shippingCost;
    }

    /**
     *
     * @return getTotal the sum of the shipping and price cost
     */
    public double getTotal() {
        return getShipping() + getSubtotal();
    }

    /**
     *
     * addToCart the name of the method
     * @param product the actual product in the shopping Cart
     */
    public void addToCart(Product product) {
        boolean current = false;
        int counter = 0;
        if (product.getIsLimitedEdition()) {
            try {
                Server.checkStock(product);
                shoppingCart.add(product);
                System.out.println(product.toString() + " added to cart");
            } catch (ProductOutOfStockException e) {
                itemsInStock.removeAll(product);
                System.err.println(e.getMessage());
            }

        } else {
            shoppingCart.add(product);
            System.out.println(product.toString() + " added to cart.");
        }


    }

    /**
     * payForCart the name of the method the pay for products
     * @param card the card that will pay for the products
     */
    public void payForCart(CreditCard card) {

        if (!(shoppingCart.isEmpty())) {
            try {
                Server.checkTraffic();
                card.pay(this.getTotal());
                shoppingCart.clear();
                System.out.println("Payment successful!");
            } catch (SiteOverloadException ex) {
                System.err.println(ex.getMessage());
            } catch (InsufficientFundsException e) {
                System.err.println(e.getMessage());

            }

        }
    }
    /**
     * @param positon the position in the cart
     */
    public void removeFromCart(int positon) {
        shoppingCart.remove(positon);
        System.out.println("Successful removal!");


    }

    /**
     * @return E the element removed
     */
    public MyArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    /**
     * @return E the element removed
     */
    public MyArrayList<Product> getItemsInStock() {
        return itemsInStock;
    }

    /**
     * @return E the element removed
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append("                           KYLIE COSMETICS℠\n");
        s.append("----------------------------------------------------------"
            + "------------\n");
        int i = 1;
        for (Product product : shoppingCart) {
            s.append("(" + i + ") " + product + "\n");
            i++;
        }
        s.append(String.format("Total number of items: %d%n",
            shoppingCart.size()));
        s.append(String.format("Subtotal: $%.2f%n", getSubtotal()));
        s.append(String.format("Shipping: $%.2f%n", getShipping()));
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append(String.format("Total: $%.2f%n", getTotal()));
        s.append("Enter 'pay' to checkout or 'back' to"
                + " return to the main menu.\n");
        s.append("Enter the number of an item to remove it"
                + " from the shopping cart.\n");
        return s.toString();
    }
}
