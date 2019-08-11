package entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class EntityModel implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.AUTO )
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
