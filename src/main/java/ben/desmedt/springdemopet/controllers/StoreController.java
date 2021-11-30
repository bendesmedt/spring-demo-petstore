package ben.desmedt.springdemopet.controllers;

import ben.desmedt.springdemopet.models.Order;
import ben.desmedt.springdemopet.services.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/inventory")
    public ResponseEntity getInventory() {

        var pets = storeService.getInventory();

        if (pets.isPresent())
            return ResponseEntity.ok(pets.get());

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/order")
    public ResponseEntity postOrder(@RequestBody Order order) {

        var optionalOrder = storeService.placeOrder(order);
        if (optionalOrder.isPresent())
            return ResponseEntity.ok(optionalOrder.get());

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity getById(@PathVariable Long id) {

        var optionalOrder = storeService.findById(id);

        if (optionalOrder.isPresent())
            return ResponseEntity.ok(optionalOrder.get());

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id) {

        if (storeService.deleteById(id))
            return ResponseEntity.ok().build();

        return ResponseEntity.badRequest().build();
    }
}
