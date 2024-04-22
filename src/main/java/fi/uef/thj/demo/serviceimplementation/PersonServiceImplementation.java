package fi.uef.thj.demo.serviceimplementation;

import fi.uef.thj.demo.entity.Person;
import fi.uef.thj.demo.repository.PersonRepository;
import fi.uef.thj.demo.service.PersonService;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImplementation implements PersonService{
    private PersonRepository personRepository;
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
    
}
