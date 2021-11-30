package ben.desmedt.springdemopet.models;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "orders")
public class Order implements ValidatableEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long petId;

    private Integer quantity;

    private LocalDateTime shipDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Boolean complete;


    public enum Status {
        PLACED, APPROVED, DELIVERED;
    }

}
