package repositories;


import entities.Hierarchy;
import entities.ResponsibleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsibleTypeRepository extends JpaRepository<ResponsibleType, Integer> {


}
