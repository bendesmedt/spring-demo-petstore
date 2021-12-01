package ben.desmedt.springdemopet.services;

import ben.desmedt.springdemopet.models.Order;
import ben.desmedt.springdemopet.models.Pet;
import ben.desmedt.springdemopet.repositories.OrderRepository;
import ben.desmedt.springdemopet.repositories.PetRepository;
import ben.desmedt.springdemopet.services.validators.OrderValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    private final OrderRepository orderRepository;
    private final PetRepository petRepository;
    private final OrderValidator validator;

    public StoreService(OrderRepository orderRepository, PetRepository petRepository, OrderValidator validator) {
        this.orderRepository = orderRepository;
        this.petRepository = petRepository;
        this.validator = validator;
    }

    public Optional<List<Pet>> getInventory() {
        return Optional.of(petRepository.findAll());
    }

    public Optional<Order> placeOrder(Order order) {
        if (validator.validateForCreate(order))
            Optional.of(orderRepository.save(order));

        return Optional.empty();
    }

    public Optional<Order> findById(Long id) {
        if (validator.validateId(id))
            return orderRepository.findById(id);

        return Optional.empty();
    }

    public boolean deleteById(Long id) {
        if (validator.validateId(id)) {
            orderRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
