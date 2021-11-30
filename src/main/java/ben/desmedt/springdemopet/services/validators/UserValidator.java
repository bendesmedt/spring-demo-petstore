package ben.desmedt.springdemopet.services.validators;

import ben.desmedt.springdemopet.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidator implements EntityValidator<User> {

    @Override
    public boolean validate(User user) {
        return validateStringProperties(
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        );
    }
}
