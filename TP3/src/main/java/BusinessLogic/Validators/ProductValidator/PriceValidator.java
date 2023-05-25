package BusinessLogic.Validators.ProductValidator;

import BusinessLogic.Validators.Validator;
import Model.Product;

/**
 * The type price validator.
 */
public class PriceValidator implements Validator<Product> {
    @Override
    public void validate(Product t) {
        if(t.getPrice() < 0){
            throw new IllegalArgumentException("Price must pe a positive real number!");
        }
    }
}
