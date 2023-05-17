package repositories;

import entities.Hierarchy;
import entities.HierarchyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HierarchyTypeRepository extends JpaRepository<HierarchyType, Integer> {

    

    //List<Hierarchy> findByParent(HierarchyType hierarchyType);
}
