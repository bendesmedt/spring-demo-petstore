package ben.desmedt.springdemopet.repositories;

import ben.desmedt.springdemopet.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepo extends JpaRepository<Pet, Long> {

    @Query("SELECT p FROM Pet p WHERE p.status IN :stats")
    List<Pet> findAllByStatus(@Param("stats") Pet.Status[] stats);

    @Query( "SELECT p FROM Pet p INNER JOIN p.tags t WHERE t.name IN :tags" )
    List<Pet> findAllByTags(@Param("tags") String[] tags);

}
