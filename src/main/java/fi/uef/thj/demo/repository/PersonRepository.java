package fi.uef.thj.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import fi.uef.thj.demo.entity.Person;
public interface PersonRepository extends JpaRepository<Person,Long>{
    
}
