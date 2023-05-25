package BusinessLogic.Validators.OrderValidator;

import BusinessLogic.Validators.Validator;
import Model.Client;
import Model.Order;

/**
 * The type id validator.
 */
public class IDValidator implements Validator<Order> {

    @Override
    public void validate(Order t) {
        if(t.getId_client() < 0  || t.getId_product() < 0){
            throw new IllegalArgumentException("ID must pe a positive integer!");
        }
    }
}
