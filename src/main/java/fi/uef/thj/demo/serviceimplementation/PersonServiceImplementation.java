package fi.uef.thj.demo.serviceimplementation;

import fi.uef.thj.demo.entity.Person;
import fi.uef.thj.demo.entity.Course;
import fi.uef.thj.demo.repository.PersonRepository;
import fi.uef.thj.demo.service.PersonService;
import fi.uef.thj.demo.repository.CourseRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImplementation implements PersonService{
    private PersonRepository personRepository;
    @Autowired
    private CourseRepository courseRepository;
    public PersonServiceImplementation(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }
    @Override
    public Person savePerson(Person person){
        return personRepository.save(person);
    }

    @Override
    public Person getPersonById(Long id){
        return personRepository.findById(id).get();
    }

    @Override
    public Person updatePerson(Person person){
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
 
}
