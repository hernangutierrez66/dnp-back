package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="jerarquia")
@Data
@EqualsAndHashCode(callSuper = true)
public class Hierarchy extends NamedEntityModel implements Serializable {

    public static final DateFormat DATE_FORMAT= new SimpleDateFormat("yyyy-mm-dd");

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Hierarchy needs a start date")
    private Date startDate;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Hierarchy needs and end date")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "periodoid")
    private Period period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jerarquia_padre_id")
    private Hierarchy parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jerarquia_id")
    private HierarchyType type;

    @ManyToMany(mappedBy = "hierarchies", fetch = FetchType.LAZY)
    private List<Objective> objectives;

    @ManyToMany(mappedBy = "hierarchies", fetch = FetchType.LAZY)
    private List<Responsible> responsibles;

    @Column(name = "is_open")
    private boolean open = true;

    public void addObjective(Objective objective){
        if (objectives == null) objectives = new ArrayList<>();
        objectives.add(objective);
    }

    public static DateFormat getDateFormat() {
        return DATE_FORMAT;
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

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Hierarchy getParent() {
        return parent;
    }

    public HierarchyType getType() {
        return type;
    }

    public void setType(HierarchyType type) {
        this.type = type;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public List<Responsible> getResponsibles() {
        return responsibles;
    }

    public void setResponsibles(List<Responsible> responsibles) {
        this.responsibles = responsibles;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
