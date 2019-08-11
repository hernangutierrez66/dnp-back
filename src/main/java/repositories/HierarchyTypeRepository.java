package repositories;

import entities.HierarchyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HierarchyTypeRepository extends JpaRepository<HierarchyType, Integer> {
}
