package Presentation;

import BusinessLogic.ProductBLL;
import Model.Product;
import Model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The type Product controller.
 */
public class ProductController {

    private ProductView productView;

    /**
     * Instantiates a new Product controller.
     *
     * @param productView the product view
     */
    public ProductController(ProductView productView){
        this.productView = productView;
        this.productView.insertBtnListener(new insertListener());
        this.productView.selectBtnListener(new selectListener());
        this.productView.updateBtnListener(new updateListener());
        this.productView.deleteBtnListener(new deleteListener());
        this.productView.backBtnListener(new backListener());
    }

    /**
     * The type Insert listener.
     */
    class insertListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String name = productView.getTF2text();
            Double price = Double.parseDouble(productView.getTF3text());
            Integer quantity = Integer.parseInt(productView.getTF4text());

            ProductBLL productBLL = new ProductBLL();
            Product product = new Product(name, price, quantity);
            productBLL.insertProduct(product);

            List<Product> products = productBLL.findProducts();
                productView.updateData(productBLL.createProductsTable(products));
        }
    }

    /**
     * The type Select listener.
     */
    class selectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            ProductBLL productBLL = new ProductBLL();
            try {
                List<Product> products = productBLL.findProducts();
                productView.updateData(productBLL.createProductsTable(products));
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }


        }
    }

    /**
     * The type Update listener.
     */
    class updateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            Integer id = Integer.parseInt(productView.getTF1text());
            String name = productView.getTF2text();
            Double price = Double.parseDouble(productView.getTF3text());
            Integer quantity = Integer.parseInt(productView.getTF4text());

            ProductBLL productBLL = new ProductBLL();
            Product product = new Product(id, name, price, quantity);
            productBLL.updateProduct(product);

            List<Product> products = productBLL.findProducts();
            productView.updateData(productBLL.createProductsTable(products));
        }
    }

    /**
     * The type Delete listener.
     */
    class deleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            int id = Integer.parseInt(productView.getTF1text());
            productView.getTF2().setText("");
            productView.getTF3().setText("");
            productView.getTF4().setText("");

            ProductBLL productBLL = new ProductBLL();
            productBLL.deleteProduct(id);

            List<Product> products = productBLL.findProducts();
                productView.updateData(productBLL.createProductsTable(products));

        }
    }

    /**
     * The type Back listener.
     */
    class backListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            productView.dispose();
            new GeneralController(new GeneralView());
        }
    }

    /**
     * Convert data to strings string [ ] [ ].
     *
     * @param products the products
     * @return the string [ ] [ ]
     */
    public String[][] convertDataToStrings(List<Product> products){
        String[][] productsList = new String[products.size()][4];
        int i = 0;
        for (Product c: products) {
            productsList[i][0] = Integer.toString(c.getId());
            productsList[i][1] = c.getName();
            productsList[i][2] = Double.toString(c.getPrice());
            productsList[i][3] = Integer.toString(c.getQuantity());
            i++;
        }
        return productsList;
    }
}
