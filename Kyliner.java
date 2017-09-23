/**
 * @author Ahmed Gedi
 * @version 1.0
 */
public class Kyliner extends Product {

    /**
     * @param isLimitedEdition the boolean value of the limited edition case
     * @param color the element to be removed
     */
    public Kyliner(String color, boolean isLimitedEdition) {
        super(color, isLimitedEdition, 26.00);

    }

    /**
     * @return E the element removed
     */
    @Override
    public String toString() {
        if (getIsLimitedEdition()) {
            String format = String.format("Limited Edition  %1$s Kyliner: $"
                + "%2$.2f", getColor(), getPrice());
            return format;
        } else {
            String format = String.format("%1$s Kyliner: $"
                + "%2$.2f", getColor(), getPrice());
            return format;
        }
    }
}
