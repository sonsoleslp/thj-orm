package fi.uef.thj.demo.Controller;
// https://www.youtube.com/watch?v=f5pCihgnRi8

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fi.uef.thj.demo.service.PersonService;
import fi.uef.thj.demo.entity.Person;

@Controller
public class PersonController {
    private final PersonService personService;
    public PersonController(PersonService personService){
        this.personService = personService;
    }
    @GetMapping("/") 
    public String listPersons(Model model){
        model.addAttribute("Persons",personService.getAllPersons());
        return "Persons";
    }

    @GetMapping("/Persons/new")
    public String studentFORM(Model model){
        Person person = new Person();
        model.addAttribute("person", person);
        return("AddPerson");
    }

    @PostMapping("/Persons")
    public String savePerson(@ModelAttribute("person")Person person){
        personService.savePerson(person);
        return "redirect:/";
    }
}
