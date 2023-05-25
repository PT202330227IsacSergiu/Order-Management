package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The type General controller.
 */
public class GeneralController {

    private GeneralView view;

    /**
     * Instantiates a new General controller.
     *
     * @param view the view
     */
    public GeneralController(GeneralView view){
        this.view = view;
        this.view.clientsBtnListener(new clientsListener());
        this.view.productsBtnListener(new productsListener());
        this.view.ordersBtnListener(new ordersListener());
    }

    /**
     * The type clients listener.
     */
    class clientsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            ClientView clientView = new ClientView();
            ClientController clientController = new ClientController(clientView);
        }
    }

    /**
     * The type products listener.
     */
    class productsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            ProductView productView = new ProductView();
            ProductController productController = new ProductController(productView);
        }
    }

    /**
     * The type orders listener.
     */
    class ordersListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
            OrderView orderView = new OrderView();
            OrderController orderController = new OrderController(orderView);
        }
    }
}
