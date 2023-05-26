import Model.Bill;
import Model.Order;
import Presentation.*;

import java.lang.reflect.Field;

/**
 * The type Main.
 */
public class Main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        GeneralView view = new GeneralView();
        GeneralController controller = new GeneralController(view);

    }
}