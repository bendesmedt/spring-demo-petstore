package ben.desmedt.springdemopet.services;

import ben.desmedt.springdemopet.models.User;
import ben.desmedt.springdemopet.repositories.UserRepository;
import ben.desmedt.springdemopet.services.validators.UserValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserValidator validator;

    public UserService(UserRepository repository, UserValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public Optional<User> create(User user) {
        return save(user, validator::validateForCreate);
    }

    public Optional<User> update(User user) {
        return save(user, validator::validateForUpdate);
    }


    private Optional<User> save(User user, Predicate<User> predicate) {
        if (predicate == null || predicate.test(user))
            return Optional.of(repository.save(user));

        return Optional.empty();
    }

    public Optional<User> findByUsername(String username) {
        if (validator.validateStringProperties(username))
            return repository.findUserByUsernameEquals(username);

        return Optional.empty();
    }

    public boolean deleteByUsername(String username) {
        if (validator.validateStringProperties(username)) {
            repository.deleteByUsername(username);
            return true;
        }

        return false;
    }

    public Optional<User> loginUser(String username, String password) {

        if (validator.validateStringProperties(username, password))
            return repository.findUserByUsernameEqualsAndPasswordEquals(username, password);

        return Optional.empty();
    }

    public Optional<List<User>> createUsers(List<User> users) {
        if (users.stream().allMatch(validator::validateForCreate))
            return Optional.of(repository.saveAll(users));

        return Optional.empty();
    }
}
