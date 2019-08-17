package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="indicador")
@Data
@EqualsAndHashCode(callSuper = true)
public class Indicator extends NamedEntityModel implements Serializable {

    @Column(name = "unidad")

    private int unity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orientacion_indicadorid")
    @NotNull(message = "Indicator needs an orientation indicator")
    private OrientationIndicator orientationIndicator;

}
