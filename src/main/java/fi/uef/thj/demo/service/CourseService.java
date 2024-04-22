package fi.uef.thj.demo.service;
import fi.uef.thj.demo.entity.Course;
import java.util.List;
public interface CourseService {
    List<Course> getAllCourses();
    public Course saveCourse(Course course);
    public Course updateCourse(Course course);
    public Course getCourseById(Long id);
    public void deleteCourse(Long id);
}
