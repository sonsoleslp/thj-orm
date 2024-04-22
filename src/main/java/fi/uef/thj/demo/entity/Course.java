package fi.uef.thj.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name="course")
public class Course {
    enum Type {mandatory, basic, elective}

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;
    
    @Column(name="credits", nullable = false)
    private Double credits;
    
    @Column(name="type", nullable = false)
    private Type type;
    
    public Course (){}
    public Course (Long id){this.id = id;}
    public Course(Long id, String name, Double credits, Type type) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getCredits() {
        return credits;
    }

    public Type getType() {
        return type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public void setType(Type type) {
        this.type = type;
    }
    


    @ManyToMany()
    @JoinTable(name = "enrollments", joinColumns = @JoinColumn(name = "course_id"), 
        inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Person> enrolledStudents;

    public void setEnrolledStudents(Set<Person> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Set<Person> getEnrolledStudents() {
        return enrolledStudents;
    }
}   
