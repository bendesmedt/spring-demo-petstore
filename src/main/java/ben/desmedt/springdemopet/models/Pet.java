package ben.desmedt.springdemopet.models;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Accessors(chain = true)
public class Pet implements ValidatableEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Category category;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<String> photoUrls;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Tag> tags;

    @Enumerated(EnumType.STRING)
    private Status status;

    public void addPhotoUrl(String photoUrl) {
        if (this.photoUrls == null) this.photoUrls = new ArrayList<>();
        this.photoUrls.add(photoUrl);
    }

    public enum Status {
        AVAILABLE, PENDING, SOLD;
    }
}
