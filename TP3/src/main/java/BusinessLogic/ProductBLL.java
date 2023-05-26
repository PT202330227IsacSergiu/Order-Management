package BusinessLogic;

import BusinessLogic.Validators.ProductValidator.PriceValidator;
import BusinessLogic.Validators.ProductValidator.QuantityValidator;
import BusinessLogic.Validators.Validator;

import DataAccess.ProductDAO;
import Model.Client;
import Model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type ProductBLL.
 */
public class ProductBLL {

    private ProductDAO productDAO;
    private List<Validator<Product>> validators;

    /**
     * Instantiates a new ProductBLL.
     */
    public ProductBLL(){
        validators = new ArrayList<>();
        validators.add(new PriceValidator());
        validators.add(new QuantityValidator());

        productDAO = new ProductDAO();
    }

    /**
     * Insert product.
     *
     * @param p the p
     * @return the product
     */
    public Product insertProduct(Product p){
        try {
            for (Validator<Product> validator : validators) {
                validator.validate(p);
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
        Product product = productDAO.insert(p);
        if(product == null){
            throw new NoSuchElementException("Product can't be inserted!");
        }
        return product;
    }

    /**
     * Update product.
     *
     * @param p the p
     * @return the product
     */
    public Product updateProduct(Product p) {
        Product product = productDAO.update(p);
        if(product == null){
            throw new NoSuchElementException("Product can't be updated!");
        }
        return product;
    }

    /**
     * Find product by id product.
     *
     * @param id the id
     * @return the product
     */
    public Product findProductById(int id){
        Product product = productDAO.findById(id);
        if(product == null){
            throw new NoSuchElementException("Product " + id + "doesn't exist!");
        }
        return product;
    }

    /**
     * Find products list.
     *
     * @return the list
     */
    public List<Product> findProducts(){
        List<Product> products = productDAO.findAll();
        if(products == null || products.size() == 0){
            throw new NoSuchElementException("No products!");
        }
        return products;
    }

    /**
     * Delete product.
     *
     * @param id the id
     */
    public void deleteProduct(int id){
        try {
            if (findProductById(id) != null)
                (new ProductDAO()).delete(id);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Product with id " + id + " doesn't exist!");
        }
    }

    public DefaultTableModel createProductsTable(List<Product> products){
        return productDAO.createTable(products);
    }
}
