package ben.desmedt.springdemopet.repositories;

import ben.desmedt.springdemopet.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepo extends JpaRepository<Tag, Long> {

    @Query("SELECT t FROM Tag t WHERE t.name IN :tags")
    List<Tag> findAllByName(@Param("tags") String[] tags);
}