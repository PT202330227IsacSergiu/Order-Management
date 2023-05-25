package Presentation;

import BusinessLogic.ClientBLL;
import BusinessLogic.OrderBLL;
import BusinessLogic.ProductBLL;
import Model.Bill;
import Model.Client;
import Model.Order;
import Model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The type Order controller.
 */
public class OrderController {

    private OrderView orderView;

    /**
     * Instantiates a new Order controller.
     *
     * @param orderView the order view
     */
    public OrderController(OrderView orderView){
        this.orderView = orderView;
        this.orderView.insertBtnListener(new insertListener());
        this.orderView.selectBtnListener(new selectListener());
        this.orderView.backBtnListener(new backListener());
    }

    /**
     * The type Insert listener.
     */
    class insertListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer id_client = Integer.parseInt(orderView.getTF1text());
            Integer id_product = Integer.parseInt(orderView.getTF2text());
            Integer quantity = Integer.parseInt(orderView.getTF3text());

            ProductBLL productBLL = new ProductBLL();
            ClientBLL clientBLL = new ClientBLL();
            Product product = null;
            Client client = null;

            try{
                productBLL.findProductById(id_product);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            try{
                clientBLL.findClientById(id_client);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            product = productBLL.findProductById(id_product);
            if(product.getQuantity() < quantity ){
                JOptionPane.showMessageDialog(null, "Not enough products for this order!");
            }else{
                OrderBLL orderBLL = new OrderBLL();
                Order order = new Order(id_client, id_product, quantity);
                orderBLL.insertOrder(order);

                Bill bill = new Bill(order);
                int id_order = orderBLL.lastElementId();
                bill.writeToLog(id_order);

                if(product.getQuantity() - quantity != 0) {
                    Product updatedProduct = new Product(id_product, product.getName(), product.getPrice(), product.getQuantity() - quantity);
                    productBLL.updateProduct(updatedProduct);
                }else{
                    productBLL.deleteProduct(id_product);
                }

                List<Order> orders = orderBLL.findOrders();
                String[][] ordersList = convertDataToStrings(orders);
                orderView.updateData(ordersList);
            }
        }
    }

    /**
     * The type Select listener.
     */
    class selectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            OrderBLL orderBLL = new OrderBLL();
            try{
                List<Order> orders = orderBLL.findOrders();
                String[][] ordersList = convertDataToStrings(orders);
                orderView.updateData(ordersList);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    /**
     * The type Back listener.
     */
    class backListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            orderView.dispose();
            new GeneralController(new GeneralView());
        }
    }

    /**
     * Convert data to strings string [ ] [ ].
     *
     * @param orders the orders
     * @return the string [ ] [ ]
     */
    public String[][] convertDataToStrings(List<Order> orders){
        String[][] clientsList = new String[orders.size()][4];
        int i = 0;
        for (Order o: orders) {
            clientsList[i][0] = Integer.toString(o.getId());
            clientsList[i][1] = Integer.toString(o.getId_client());
            clientsList[i][2] = Integer.toString(o.getId_product());
            clientsList[i][3] = Integer.toString(o.getQuantity());
            i++;
        }
        return clientsList;
    }

}
