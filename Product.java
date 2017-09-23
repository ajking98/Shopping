/**
 * @author Ahmed Gedi
 * @version 1.0
 */
public class Product {


    private String color;
    private boolean isLimitedEdition;
    private double price;

    /**
     * @param color a string color
     * @param isLimitedEdition whether or not the product is limited edition
     * @param price a double value for the price of the product
     */
    public Product(String color, boolean isLimitedEdition, double price) {
        this.color = color;
        this.isLimitedEdition = isLimitedEdition;
        this.price = price;
    }

    /**
     * @return color returns the color
     */
    public String getColor() {
        return this.color;
    }

    /**
     * @return isLimitedEdition returns the boolean value of what is limited
     */
    public boolean getIsLimitedEdition() {
        return this.isLimitedEdition;
    }

    /**
     * @return price the price of the product
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * @return format of the limited edition and color
     */
    @Override
    public String toString() {
        if (isLimitedEdition) {
            String format = "Limited Edition " + this.color;
            return format;
        } else {
            String format = this.color;
            return format;
        }
    }

    /**
     * @return false or true
     */
    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == null) {
            return true;
        }

        if (!(other instanceof Product)) {
            return false;
        }
        Product that = (Product) other;
        return this.color == (that.color)
            && this.isLimitedEdition == (that.isLimitedEdition)
                && this.price == (that.price);

    }



}
