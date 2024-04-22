package fi.uef.thj.demo.Controller;
// https://www.youtube.com/watch?v=f5pCihgnRi8

import org.antlr.v4.runtime.misc.Array2DHashSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import fi.uef.thj.demo.service.PersonService;
import fi.uef.thj.demo.service.CourseService;
import fi.uef.thj.demo.entity.Person;
import fi.uef.thj.demo.entity.Course;
@Controller
public class PersonController {
    private final PersonService personService;
    private final CourseService courseService;
    public PersonController(PersonService personService, CourseService courseService){
        this.personService = personService;
        this.courseService = courseService;
    }
    @GetMapping("/Persons") 
    public String listPersons(Model model){
        model.addAttribute("Persons",personService.getAllPersons());
        return "Persons";
    }

    @GetMapping("/Persons/new")
    public String newPerson(Model model){
        Person person = new Person();
        model.addAttribute("person", person);
        return("AddPerson");
    }

    @PostMapping("/Persons")
    public String createPerson(@ModelAttribute("person")Person person){
        personService.savePerson(person);
        return "redirect:/Persons";
    }

    @GetMapping("Persons/edit/{id}")
    public String editPerson(@PathVariable  Long id, Model model){
        model.addAttribute("person", personService.getPersonById(id));
        return "EditPerson";
    }

    @PostMapping("/Persons/{id}")
    public String updatePerson(@PathVariable Long id, @ModelAttribute("person") Person person, Model model){
        Person existingPerson = personService.getPersonById(id);
        existingPerson.setName(person.getName());
        existingPerson.setSurname(person.getSurname());
        existingPerson.setGender(person.getGender());
        existingPerson.setCity(person.getCity());
        existingPerson.setAddress(person.getAddress());
        existingPerson.setPhone(person.getPhone());
        existingPerson.setRole(person.getRole());
        existingPerson.setBirthdate(person.getBirthdate());
        personService.updatePerson(existingPerson);
        return "redirect:/Persons";
    }

    @PostMapping("/Persons/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return "redirect:/Persons";
    }

    @GetMapping("/Persons/enroll/{id}")
    public String enrollPersonForm(@PathVariable Long id, @ModelAttribute("person") Person person, Model model){
        model.addAttribute("person", personService.getPersonById(id));
        model.addAttribute("enrolledCourses", courseService.getAllCourses());
        return "EnrollPerson";
    }
    @PostMapping("/Persons/enroll/{id}")
    public String enrollPerson(@PathVariable Long id,  @RequestParam("enrolledCourses") List<Long> enrolledCourseIds){
        Person existingPerson = personService.getPersonById(id);  
       
        existingPerson.setEnrolledCourses(existingPerson.getEnrolledCourses());
        List<Course> courses = courseService.getAllCourses();

        // Update enrollments
        for (Course course : courses) {
            boolean enrolled = enrolledCourseIds.contains(course.getId());
            if (enrolled) {
                // Add student to the course if not already enrolled
                if (!existingPerson.getEnrolledCourses().contains(course)) {
                    existingPerson.getEnrolledCourses().add(course);
                }
            } else {
                // Remove student from the course if enrolled
                existingPerson.getEnrolledCourses().remove(course);
            }
             
        }
        
        personService.updatePerson(existingPerson);
        return "redirect:/Persons";
    }
    
}
