package controllers;

import entities.Hierarchy;
import entities.HierarchyType;
import entities.Objective;
import entities.ObjectiveType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.HierarchyTypeRepository;
import repositories.ObjectiveTypeRepository;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

@RestController
@EnableJpaRepositories("repositories")
@RequestMapping("/objective-type")
public class ObjectiveTypeController {

    private final ObjectiveTypeRepository objectiveTypeRepository;
    private  final HierarchyTypeRepository hierarchyTypeRepository;

    @Autowired
    public ObjectiveTypeController(ObjectiveTypeRepository objectiveTypeRepository, HierarchyTypeRepository hierarchyTypeRepository) {
        this.objectiveTypeRepository = objectiveTypeRepository;
        this.hierarchyTypeRepository = hierarchyTypeRepository;
    }

    /*@GetMapping(value = "/all")
    public ResponseEntity listObjectiveType() {
        return ResponseEntity.status(HttpStatus.OK).body(objectiveTypeRepository.findAll());
    }*/

    @PostMapping(value = "/create")
    public ResponseEntity createObjectiveType(@Valid @RequestBody Map<String, String> input) {

        if (input.get("name").isEmpty()) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        ObjectiveType objectiveType = new ObjectiveType();
        if (!input.get("parentId").isEmpty()){
            HierarchyType hierarchyType = hierarchyTypeRepository.getOne(Integer.parseInt(input.get("parentId")));
            objectiveType.addObjective(hierarchyType);
            hierarchyType.addObjective(objectiveType);
            hierarchyTypeRepository.save(hierarchyType);
        }

        if (!input.get("tipo_padre_id").isEmpty()){
            objectiveType.setParent(objectiveTypeRepository.getOne(Integer.parseInt(input.get("tipo_padre_id"))));
        }
        objectiveType.setName(input.get("name"));
        objectiveTypeRepository.save(objectiveType);
        return HierarchyController.customMessage(HierarchyController.SUCCESFUL_CREATION, HttpStatus.OK);

    }

   /* public ResponseEntity createObjectiveType(@Valid @RequestBody ObjectiveType objectiveType, @RequestParam(required = false) Integer parentId) {
        if (objectiveType == null) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        if (parentId != null){
            HierarchyType hierarchyType = hierarchyTypeRepository.getOne(parentId);
            objectiveType.addObjective(hierarchyType);
            hierarchyType.addObjective(objectiveType);
            hierarchyTypeRepository.save(hierarchyType);
        }
        objectiveTypeRepository.save(objectiveType);
        return HierarchyController.customMessage(HierarchyController.SUCCESFUL_CREATION, HttpStatus.OK);
    }
*/
    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateObjectiveType(@RequestBody ObjectiveType objectiveType, @PathVariable(value = "id") Integer id) throws ParseException {
        if (objectiveType == null || id == null) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        Optional<ObjectiveType> objectiveTypeOptional = objectiveTypeRepository.findById(id);
        if (!objectiveTypeOptional.isPresent()) return new ResponseEntity(HttpStatus.NOT_FOUND);
        ObjectiveType objectiveType1 = objectiveTypeOptional.get();
        objectiveType1.setName(objectiveType.getName());
        objectiveType1.setParent(objectiveType.getParent());
        objectiveTypeRepository.save(objectiveType1);
        return HierarchyController.customMessage(HierarchyController.SUCCESFUL_UPDATE, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getObjectiveType(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(objectiveTypeRepository.findById(id));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteObjectiveType(@PathVariable(value = "id") Integer id){
        if (id == null) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        objectiveTypeRepository.deleteById(id);
        return HierarchyController.customMessage(HierarchyController.SUCCESFUL_DELETE, HttpStatus.OK);
    }
}
