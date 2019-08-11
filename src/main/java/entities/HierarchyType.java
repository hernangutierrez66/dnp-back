package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tipo_jerarquia")
@Data
@EqualsAndHashCode(callSuper = true)
public class HierarchyType extends NamedEntityModel implements Serializable {
}
