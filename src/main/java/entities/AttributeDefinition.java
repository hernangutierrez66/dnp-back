package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="atributo_definicion")
@Data
@EqualsAndHashCode(callSuper = true)
public class AttributeDefinition extends NamedEntityModel implements Serializable {

    @Column(name = "descripcion")
    @NotNull(message = "Atribute definition needs a description")
    private String description;

    @Column(name = "tipo")
    @NotNull(message = "Atribute definition needs a type")
    private int type;
}
