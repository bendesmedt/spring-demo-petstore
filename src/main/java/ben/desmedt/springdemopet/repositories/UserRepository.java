package ben.desmedt.springdemopet.repositories;

import ben.desmedt.springdemopet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsernameEqualsAndPasswordEquals(String name, String password);

    Optional<User> findUserByUsernameEquals(String name);

    @Transactional
    Long deleteByUsername(@Param("name") String name);
}
