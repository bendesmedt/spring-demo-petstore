package ben.desmedt.springdemopet.repositories;

import ben.desmedt.springdemopet.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}