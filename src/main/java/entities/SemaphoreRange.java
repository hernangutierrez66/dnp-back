package entities;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="rango_semaforo")
@Data
@EqualsAndHashCode(callSuper = true)
public class SemaphoreRange extends NamedEntityModel implements Serializable {

    @Column(name = "color")
    private int color;

    @Column(name = "rango_inicio")
    private int start;

    @Column(name = "rango_fin")
    private int end;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
