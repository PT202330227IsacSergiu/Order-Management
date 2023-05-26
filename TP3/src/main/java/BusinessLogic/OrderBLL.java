package BusinessLogic;

import BusinessLogic.Validators.OrderValidator.QuantityValidator;
import BusinessLogic.Validators.Validator;
import DataAccess.OrderDAO;
import Model.Client;
import Model.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Order bll.
 */
public class OrderBLL {

    private OrderDAO orderDAO;
    private List<Validator<Order>> validators;

    /**
     * Instantiates a new Order bll.
     */
    public OrderBLL() {
        validators = new ArrayList<>();
        validators.add(new QuantityValidator());

        orderDAO = new OrderDAO();
    }

    /**
     * Insert order order.
     *
     * @param o the o
     * @return the order
     */
    public Order insertOrder(Order o) {
        try {
            for (Validator<Order> validator : validators) {
                validator.validate(o);
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
        Order order = orderDAO.insert(o);
        if (order == null) {
            throw new NoSuchElementException("Order can't be inserted!");
        }
        return null;
    }

    /**
     * Find orders list.
     *
     * @return the list
     */
    public List<Order> findOrders() {
        List<Order> orders = orderDAO.findAll();
        if(orders == null || orders.size() == 0){
            throw new NoSuchElementException("No orders!");
        }
        return orders;
    }

    /**
     * Last element's id.
     *
     * @return the int
     */
    public int lastElementId(){
        Order order = orderDAO.lastElement();
        if(order == null){
            throw new NoSuchElementException("No order with this id!");
        }
        return order.getId();
    }

    public DefaultTableModel createOrdersTable(List<Order> orders){
        return orderDAO.createTable(orders);
    }
}
