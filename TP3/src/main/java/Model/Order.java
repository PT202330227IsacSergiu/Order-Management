package Model;

import BusinessLogic.ClientBLL;
import BusinessLogic.ProductBLL;

import java.io.File;
import java.io.FileWriter;

/**
 * The type Order.
 */
public class Order {

    private Integer id;
    private Integer id_client;
    private Integer id_product;
    private Integer quantity;

    /**
     * Instantiates a new Order.
     */
    public Order() {
    }

    /**
     * Instantiates a new Order.
     *
     * @param id         the id
     * @param id_client  the id client
     * @param id_product the id product
     * @param quantity   the quantity
     */
    public Order(Integer id, Integer id_client, Integer id_product, Integer quantity) {
        this.id = id;
        this.id_client = id_client;
        this.id_product = id_product;
        this.quantity = quantity;
    }

    /**
     * Instantiates a new Order.
     *
     * @param id_client  the id client
     * @param id_product the id product
     * @param quantity   the quantity
     */
    public Order(Integer id_client, Integer id_product, Integer quantity) {
        this.id_client = id_client;
        this.id_product = id_product;
        this.quantity = quantity;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets id client.
     *
     * @return the id client
     */
    public Integer getId_client() {
        return id_client;
    }

    /**
     * Sets id client.
     *
     * @param id_client the id client
     */
    public void setId_client(Integer id_client) {
        this.id_client = id_client;
    }

    /**
     * Gets id product.
     *
     * @return the id product
     */
    public Integer getId_product() {
        return id_product;
    }

    /**
     * Sets id product.
     *
     * @param id_product the id product
     */
    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String toString(){
        return "(" + id + ", " + id_client + ", " + id_product + ", " + quantity + ")";
    }
}
