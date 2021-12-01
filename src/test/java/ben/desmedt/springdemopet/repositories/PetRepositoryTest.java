package ben.desmedt.springdemopet.repositories;

import ben.desmedt.springdemopet.models.Pet;
import ben.desmedt.springdemopet.models.Tag;
import ben.desmedt.springdemopet.utils.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PetRepositoryTest {

    @Autowired
    PetRepository repository;
    @Autowired
    TagRepository tagRepository;

    static List<Tag> tags;
    static List<Pet> pets;

    @BeforeEach
    void SavePets() {
        tagRepository.deleteAll();
        repository.deleteAll();

        tags = tagRepository.saveAll(DataFactory.getTags());
        pets = repository.saveAll(DataFactory.getPets(tags, null));
    }


    @Test
    void findByStatus() {
        Pet.Status[] status = { Pet.Status.AVAILABLE };

        var petList = pets.stream()
                .filter(p -> Arrays.stream(status)
                        .anyMatch(s -> s.equals(p.getStatus())))
                .collect(Collectors.toList());

        var allByStatus = repository.findAllByStatus(status);

        Assertions.assertIterableEquals(petList, allByStatus);
    }

    @Test
    void findByTags() {

        var tagList = ThreadLocalRandom.current()
                .ints(0, tags.size())
                .distinct()
                .limit(3)
                .mapToObj(tags::get)
                .collect(Collectors.toList());

        var petList = pets
                .stream()
                .filter(p -> p.getTags().stream().anyMatch(tagList::contains))
                .collect(Collectors.toList());


        var tagsForQuery = tagList
                .stream()
                .map(Tag::getName)
                .toArray(String[]::new);

        var allByTags = repository.findAllByTags(tagsForQuery);

        Assertions.assertIterableEquals(petList, allByTags);
    }
}