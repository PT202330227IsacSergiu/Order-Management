package BusinessLogic.Validators.ClientValidaor;

import BusinessLogic.Validators.Validator;
import Model.Client;

/**
 * The type id validator.
 */
public class IDValidator implements Validator<Client> {
    @Override
    public void validate(Client t) {
        if(t.getId() < 0){
            throw new IllegalArgumentException("ID must pe a positive integer!");
        }
    }
}
