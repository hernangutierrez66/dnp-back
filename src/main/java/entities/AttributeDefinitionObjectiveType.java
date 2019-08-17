package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name="atributo_definicion_tipo_objetivo")
@Data
@EqualsAndHashCode(callSuper = true)
public class AttributeDefinitionObjectiveType extends EntityModel implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "atributo_definicionid")
    private AttributeDefinition attributeDefinition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_objetivoid")
    private ObjectiveType objectiveType;
}
