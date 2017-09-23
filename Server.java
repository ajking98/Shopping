/**
 * @author Ahmed Gedi
 * @version 1.0
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;
/**
 * Represents the website server
 *
 * @author Isabella Plonk
 * @author Your name
 * @version 1.0
 */
public class Server {

    private static Random random = new Random();
    private static final int PERCENT_FAIL =  50;
    private static final int PERCENT_OUT_OF_STOCK = 10;

    /**
     * @throws SiteOverloadException when the site overload temporaily
     */
    public static void checkTraffic() throws SiteOverloadException {
        if (new Random().nextInt(100) < PERCENT_FAIL) {
            throw new SiteOverloadException();
        }
    }

    /**
     * @throws ProductOutOfStockException when the product is finished
     * @param product the product in the cart
     */
    public static void checkStock(Product product)
    throws ProductOutOfStockException {
        if (new Random().nextInt(100) < PERCENT_OUT_OF_STOCK) {
            throw new ProductOutOfStockException(product);

        }


    }
    /**
     * Scans in all of the products
     * from a text file into an array list
     * @return an array list of all of the products
     * @throws FileNotFoundException file not found exception
     */
    public static ArrayListInterface<Product> getProducts() {
        try {
            ArrayListInterface<Product> products = new MyArrayList<>();
            Scanner csv = new Scanner(new File("products.csv"));
            csv.nextLine(); // Skip the header
            while (csv.hasNext()) {
                String[] line = csv.nextLine().split("-");
                Product product;
                if (line[0].equals("Kyshadow")) {
                    product = new Kyshadow(line[1],
                        Boolean.valueOf(line[2]));
                } else if (line[0].equals("Kyliner")) {
                    product = new Kyliner(line[1],
                        Boolean.valueOf(line[2]));
                } else {
                    product = new LipKit(line[1],
                        Boolean.valueOf(line[2]));
                }
                products.add(product);
            }
            return products;
        } catch (FileNotFoundException e) {
            System.out.println("Check location of products.csv.");
            System.exit(1);
        }
        return new MyArrayList<>();
    }
}
