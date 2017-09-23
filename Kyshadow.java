/**
 * @author Ahmed Gedi
 * @version 1.0
 */
public class Kyshadow extends Product {

    /**
     * @param isLimitedEdition the boolean value of the limited edition case
     * @param color the element to be removed
     */
    public Kyshadow(String color, boolean isLimitedEdition) {
        super(color, isLimitedEdition, 42.00);

    }

    /**
     * @return E the element removed
     */
    @Override
    public String toString() {
        if (getIsLimitedEdition()) {
            String format = String.format("Limited Edition  %1$s Kyshadow: $"
                + "%2$.2f", getColor(), getPrice());
            return format;
        } else {
            String format = String.format("%1$s Kyshadow: $"
                + "%2$.2f", getColor(), getPrice());
            return format;
        }
    }
}
