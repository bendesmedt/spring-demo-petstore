package ben.desmedt.springdemopet.services.validators;

import ben.desmedt.springdemopet.models.Pet;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PetValidator implements EntityValidator<Pet> {

    @Override
    public boolean validate(Pet pet) {
        return validateStringProperties(pet.getName()) &&
                validateStringProperties(pet.getPhotoUrls().toArray(String[]::new));
    }

    private boolean isValidStatus(String testStatus) {
        return testStatus != null &&
                Arrays.stream(Pet.Status.values())
                        .map(Enum::name)
                        .anyMatch(s -> s.equalsIgnoreCase(testStatus));
    }

    public boolean validateStatus(String... testStatuses) {
        return testStatuses != null &&
                testStatuses.length > 0 &&
                Arrays.stream(testStatuses)
                        .allMatch(this::isValidStatus);
    }

    public boolean validateTags(String... testTags) {
        return validateStringProperties(testTags);
    }
}
