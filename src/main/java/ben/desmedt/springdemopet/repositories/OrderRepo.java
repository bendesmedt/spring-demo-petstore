package ben.desmedt.springdemopet.repositories;

import ben.desmedt.springdemopet.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
