package fi.uef.thj.demo.service;
import fi.uef.thj.demo.entity.Person;
import java.util.List;
public interface PersonService {
    List<Person> getAllPersons();
    public Person savePerson(Person person);
    public Person updatePerson(Person person);
    public  Person getPersonById(Long id);
    public void deletePerson(Long id);
}
