package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "objetivo")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"hierarchies"})
public class Objective extends NamedEntityModel implements Serializable {

    @Column(name = "descripcion")
    private String description;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "cantidad_esperada")
    private int expectedValue;

    @Column(name = "cantidad_actual")
    private int actualValue;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "objetivo_jerarquia",
            joinColumns = {@JoinColumn(name = "objetivoid")},
            inverseJoinColumns = {@JoinColumn(name = "linea_baseid")}
    )
    private List<Hierarchy> hierarchies;

    public void addObjective(Hierarchy hierarchy) {
        if (hierarchies == null) hierarchies = new ArrayList<>();
        hierarchies.add(hierarchy);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_objetivoid")
    private ObjectiveType objectiveType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objetivo_padre_id")
    private Objective parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indicadorid")
    private Indicator indicator;
}
