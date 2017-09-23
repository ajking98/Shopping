/**
 * @author Ahmed Gedi
 * @version 1.0
 */
public class SiteOverloadException extends Exception {

    /**
     *
     */
    public SiteOverloadException() {
        super("Site is experiencing an increased amount of traffic");
    }

    /**
     * @param msg the exception messsage
     */
    public SiteOverloadException(String msg) {
        super(msg);
    }

}
