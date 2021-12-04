package ben.desmedt.springdemopet.models;

import com.sun.istack.NotNull;
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

    @NotNull
    private Long petId;

    @NotNull
    private Integer quantity;

    private LocalDateTime shipDate;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    private Boolean complete;


    public enum Status {
        PLACED, APPROVED, DELIVERED;
    }

}
