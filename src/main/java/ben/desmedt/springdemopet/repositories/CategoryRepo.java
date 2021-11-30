package ben.desmedt.springdemopet.repositories;

import ben.desmedt.springdemopet.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}