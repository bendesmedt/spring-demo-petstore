package ben.desmedt.springdemopet.models;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Accessors(chain = true)
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotEmpty
    private String name;
}
