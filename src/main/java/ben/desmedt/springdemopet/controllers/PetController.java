package ben.desmedt.springdemopet.controllers;

import ben.desmedt.springdemopet.services.PetService;
import ben.desmedt.springdemopet.models.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity postPet(@RequestBody Pet pet) {

        var saved = petService.create(pet);

        if (saved.isPresent())
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(saved.get().getId());

        return ResponseEntity.badRequest().body("Invalid pet supplied in request");
    }

    @PutMapping
    public ResponseEntity putPet(@RequestBody Pet pet) {

        Optional<Pet> saved = petService.update(pet);

        if (saved.isPresent())
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(saved.get());

        return ResponseEntity.badRequest().body("Invalid pet supplied in request");
    }

    //GET: http://localhost:8080/pet/findByStatus?status=available&status=pending
    @GetMapping("/findByStatus")
    public ResponseEntity findByStatus(@RequestParam("status") String... status) {

        var pets = petService.findByStatus(status);

        if (pets.isPresent())
            return ResponseEntity.ok(pets.get());

        return ResponseEntity.badRequest().body("Invalid status supplied in request");
    }

    //GET: http://localhost:8080/pet/findByTags?tags=safe%20with%20kids&tags=can%20be%20home%20alone
    @GetMapping("/findByTags")
    public ResponseEntity findByTags(@RequestParam("tags") String... tags) {

        var pets = petService.findByTags(tags);

        if (pets.isPresent())
            return ResponseEntity.ok(pets.get());

        return ResponseEntity.badRequest().body("Invalid tag supplied in request");
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {

        var optionalPet = petService.findById(id);

        if (optionalPet.isPresent())
            return ResponseEntity.ok(optionalPet.get());
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePet(@PathVariable Long id) {

        petService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/uploadImage")
    public ResponseEntity postPetPic(@PathVariable Long id, @RequestBody String imageUrl) {

        var optionalPet = petService.uploadImage(id, imageUrl);

        if (optionalPet.isPresent())
            return ResponseEntity.ok(optionalPet.get());
        else
            return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> handleNumberFormatException(NumberFormatException e) {
        return ResponseEntity.badRequest().body("Invalid input supplied in request. Expecting a number!\n" + e.getMessage());
    }

}
