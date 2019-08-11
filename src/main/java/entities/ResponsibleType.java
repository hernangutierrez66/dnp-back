package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="tipo_responsable")
@Data
@EqualsAndHashCode(callSuper = true)
public class ResponsibleType extends NamedEntityModel implements Serializable {

    @Column(name = "requiere_municipio")
    private boolean requiresMunicipality;

    public boolean isRequiresMunicipality() {
        return requiresMunicipality;
    }

    public void setRequiresMunicipality(boolean requiresMunicipality) {
        this.requiresMunicipality = requiresMunicipality;
    }
}
