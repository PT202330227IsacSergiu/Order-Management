package BusinessLogic.Validators.ClientValidaor;

import BusinessLogic.Validators.Validator;
import Model.Client;

import java.util.regex.Pattern;

/**
 * The type phone number validator.
 */
public class PhoneNumberValidator implements Validator<Client> {

    private static final String PATTERN = "^0\\d{9}$";
    @Override
    public void validate(Client t) {
        Pattern pattern = Pattern.compile(PATTERN);
        if(!pattern.matcher(t.getPhone_number()).matches()){
            throw new IllegalArgumentException("Phone number is not valid!\nMust start with 0 and have 10 digits");
        }
    }
}
