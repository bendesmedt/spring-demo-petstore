package ben.desmedt.springdemopet.services.validators;

import ben.desmedt.springdemopet.models.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator implements EntityValidator<Order> {

    @Override
    public boolean validate(Order order) {
        return validateId(order.getPetId());
    }
}
