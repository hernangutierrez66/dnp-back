package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "orientacion_indicador")
@Data
@EqualsAndHashCode(callSuper = true)
public class OrientationIndicator extends NamedEntityModel implements Serializable {
}
