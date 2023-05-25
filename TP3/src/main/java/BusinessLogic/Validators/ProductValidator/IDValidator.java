package BusinessLogic.Validators.ProductValidator;

import BusinessLogic.Validators.Validator;
import Model.Product;

/**
 * The type id validator.
 */
public class IDValidator implements Validator<Product> {
    @Override
    public void validate(Product t) {
        if(t.getId() < 0){
            throw new IllegalArgumentException("ID must pe a positive integer!");
        }
    }
}
