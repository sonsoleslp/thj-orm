package fi.uef.thj.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fi.uef.thj.demo.service.CourseService;
import fi.uef.thj.demo.entity.Course;

@Controller
public class CourseController {
    private final CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }
    @GetMapping("/Courses") 
    public String listCourses(Model model){
        model.addAttribute("Courses", courseService.getAllCourses());
        return "Courses";
    }

    @GetMapping("/Courses/new")
    public String newCourse(Model model){
        Course course = new Course();
        model.addAttribute("course", course);
        return("AddCourse");
    }

    @PostMapping("/Courses")
    public String createCourse(@ModelAttribute("course")Course course){
        courseService.saveCourse(course);
        return "redirect:/Courses";
    }

    @GetMapping("Courses/edit/{id}")
    public String editCourse(@PathVariable Long id, Model model){
        model.addAttribute("course", courseService.getCourseById(id));
        return "EditCourse";
    }

    @PostMapping("/Courses/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute("course") Course course, Model model){
        Course existingCourse = courseService.getCourseById(id);
        existingCourse.setName(course.getName());
        existingCourse.setCredits(course.getCredits());
        existingCourse.setType(course.getType());
 
        courseService.saveCourse(existingCourse);
        return "redirect:/Courses";
    }

    @PostMapping("/Courses/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return "redirect:/Courses";
    }
}
