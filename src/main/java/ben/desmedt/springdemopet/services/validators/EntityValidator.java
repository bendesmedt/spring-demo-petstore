package ben.desmedt.springdemopet.services.validators;

import ben.desmedt.springdemopet.models.ValidatableEntity;

import java.util.Arrays;

public interface EntityValidator<E extends ValidatableEntity> {

    boolean validate(E entity);

    default boolean validateId(Long id) {
        return id != null && id > 0;
    }

    default boolean validateForCreate(E entity) {
        return entity != null && !validateId(entity.getId());
    }

    default boolean validateForUpdate(E entity) {
        return entity != null && validateId(entity.getId());
    }

    default boolean validateStringProperties(String... strings) {
        return strings != null &&
                strings.length > 0 &&
                Arrays.stream(strings)
                        .allMatch(s -> s != null && s.length() > 0);
    }
}
