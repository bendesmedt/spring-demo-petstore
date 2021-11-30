package ben.desmedt.springdemopet.controllers;

import ben.desmedt.springdemopet.models.User;
import ben.desmedt.springdemopet.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity postUser(@RequestBody User user) {

        var optionalUser = service.create(user);

        if (optionalUser.isPresent())
            return ResponseEntity.ok(optionalUser.get());

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/createWithArray")
    public ResponseEntity createWithArray(@RequestBody User[] users) {
        return createWithList(Arrays.asList(users));
    }

    @PostMapping("/createWithList")
    public ResponseEntity createWithList(@RequestBody List<User> users) {

        var optionalUsers = service.createUsers(users);

        if (optionalUsers.isPresent())
            return ResponseEntity.ok(optionalUsers.get());

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/login")
    public ResponseEntity loginUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        Optional<User> optionalUser = service.loginUser(username, password);

        if (optionalUser.isPresent())
            return ResponseEntity.ok().build();

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/logout")
    public ResponseEntity logoutUser() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{username}")
    public ResponseEntity findByUsername(@PathVariable String username) {
        var optionalUser = service.findByUsername(username);

        if (optionalUser.isPresent())
            return ResponseEntity.ok(optionalUser.get());

        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{username}")
    public ResponseEntity putUser(@PathVariable String username, @RequestBody User user) {

        if (!username.equals(user.getUsername()))
            return ResponseEntity.badRequest().build();
        else {
            var optionalUser = service.update(user);

            if (optionalUser.isPresent())
                return ResponseEntity.ok(optionalUser.get());

            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteUser(@PathVariable String username) {

        if (service.deleteByUsername(username))
            return ResponseEntity.ok().build();


        return ResponseEntity.notFound().build();

    }
}
