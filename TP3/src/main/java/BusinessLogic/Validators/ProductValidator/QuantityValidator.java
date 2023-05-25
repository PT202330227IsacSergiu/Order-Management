package BusinessLogic.Validators.ProductValidator;

import BusinessLogic.Validators.Validator;
import Model.Product;

/**
 * The type product quantity validator.
 */
public class QuantityValidator implements Validator<Product> {
    @Override
    public void validate(Product t) {
        if(t.getQuantity() < 0){
            throw new IllegalArgumentException("Quantity must pe a positive integer!");
        }
    }
}
