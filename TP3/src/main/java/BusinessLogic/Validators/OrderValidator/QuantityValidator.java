package BusinessLogic.Validators.OrderValidator;

import BusinessLogic.Validators.Validator;
import Model.Order;

/**
 * The type product quantity validator.
 */
public class QuantityValidator implements Validator<Order> {
    @Override
    public void validate(Order t) {
        if(t.getQuantity() < 0){
            throw new IllegalArgumentException("Quantity must pe a positive integer!");
        }
    }
}
