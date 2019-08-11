package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "responsable")
@Data
@EqualsAndHashCode(callSuper = true)
public class Responsible extends NamedEntityModel implements Serializable {

    @Column(name = "nit")
    private Integer nit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipioid")
    private Municipality municipality;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "linea_baseid",
            joinColumns = {@JoinColumn(name = "responsableid")},
            inverseJoinColumns = {@JoinColumn(name = "linea_baseid")}
    )
    private List<Hierarchy> hierarchies;

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public List<Hierarchy> getHierarchies() {
        return hierarchies;
    }

    public void setHierarchies(List<Hierarchy> hierarchies) {
        this.hierarchies = hierarchies;
    }
}
