package ben.desmedt.springdemopet.services;

import ben.desmedt.springdemopet.models.Pet;
import ben.desmedt.springdemopet.repositories.PetRepo;
import ben.desmedt.springdemopet.services.validators.PetValidator;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class PetService {

    private final PetRepo repository;
    private final PetValidator validator;

    public PetService(PetRepo repository, PetValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    public Optional<Pet> create(Pet pet) {
        return save(pet, validator::validateForCreate);
    }

    public Optional<Pet> update(Pet pet) {
        return save(pet, validator::validateForUpdate);
    }

    private Optional<Pet> save(Pet pet, Predicate<Pet> predicate) {
        if (predicate == null || predicate.test(pet))
            return Optional.of(repository.save(pet));

        return Optional.empty();
    }

    public Optional<Pet> findById(Long id) {
        if (validator.validateId(id))
            return repository.findById(id);

        return Optional.empty();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<List<Pet>> findByStatus(String[] statuses) {
        if (validator.validateStatus(statuses)) {
            var petStatuses = Arrays.stream(statuses)
                    .map(stat -> Pet.Status.valueOf(stat.toUpperCase()))
                    .distinct()
                    .toArray(Pet.Status[]::new);

            var pets = repository.findAllByStatus(petStatuses);

            return Optional.of(pets);

        }

        return Optional.empty();
    }

    public Optional<List<Pet>> findByTags(String[] tags) {
        if (validator.validateTags(tags)) {

            var pets = repository.findAllByTags(tags);

            return Optional.of(pets);
        }

        return Optional.empty();
    }

    public Optional<Pet> uploadImage(Long id, String photoUrl) {

        var optionalPet = findById(id);

        if (optionalPet.isPresent()) {

            var pet = optionalPet.get();
            pet.addPhotoUrl(photoUrl);

            return Optional.of(repository.save(pet));
        }

        return Optional.empty();
    }
}
