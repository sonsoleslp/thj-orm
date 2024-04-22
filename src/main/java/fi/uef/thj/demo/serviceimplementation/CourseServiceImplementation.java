package fi.uef.thj.demo.serviceimplementation;

import fi.uef.thj.demo.entity.Course;
import fi.uef.thj.demo.repository.CourseRepository;
import fi.uef.thj.demo.service.CourseService;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseServiceImplementation implements CourseService{
    private CourseRepository courseRepository;
    public CourseServiceImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
    @Override
    public Course saveCourse(Course course){
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id){
        return courseRepository.findById(id).get();
    }

    @Override
    public Course updateCourse(Course course){
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
}
