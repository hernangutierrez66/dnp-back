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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(int expectedValue) {
        this.expectedValue = expectedValue;
    }

    public int getActualValue() {
        return actualValue;
    }

    public void setActualValue(int actualValue) {
        this.actualValue = actualValue;
    }

    public List<Hierarchy> getHierarchies() {
        return hierarchies;
    }

    public void setHierarchies(List<Hierarchy> hierarchies) {
        this.hierarchies = hierarchies;
    }
}
