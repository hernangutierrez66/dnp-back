package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="tipo_responsable")
@Data
@EqualsAndHashCode(callSuper = true)
public class ResponsibleType extends NamedEntityModel implements Serializable {

    @Column(name = "requiere_municipio")
    private boolean requiresMunicipality;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_responsableid")
    @NotNull(message = "Responsable type needs a parent")
    private ResponsibleType parent;

    public boolean isRequiresMunicipality() {
        return requiresMunicipality;
    }

    public void setRequiresMunicipality(boolean requiresMunicipality) {
        this.requiresMunicipality = requiresMunicipality;
    }
}
