package fi.uef.thj.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.uef.thj.demo.entity.Course;
public interface CourseRepository extends JpaRepository<Course,Long>{
    
}
