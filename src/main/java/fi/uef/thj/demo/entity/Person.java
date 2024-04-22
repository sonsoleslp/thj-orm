package fi.uef.thj.demo.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="person")
public class Person {
    enum Gender {M,F,O}
    enum Role {teacher, student};

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    
    @Column(name="name", nullable = false)
    private String name;
    
    @Column(name="surname", nullable = false)
    private String surname;
    
    @Column(name="city", nullable = false)
    private String city;
    
    @Column(name="address", nullable = false)
    private String address;
    
    @Column(name="phone", nullable = false)
    private String phone;
    
    @Column(name="birthdate", nullable = false)
    private Date birthdate;
    
    @Column(name="gender", nullable = false)
    private Gender gender;
    
    @Column(name="role", nullable = false)
    private Role role;

    public Person(Long id,  String name, String surname, String city, String address, String phone,
    Date birthdate, Gender gender, Role role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.birthdate = birthdate;
        this.gender = gender;
        this.role = role;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getCity() {
        return city;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public Gender getGender() {
        return gender;
    }
    public Role getRole() {
        return role;
    }
    public Person(){}

    public void setAddress(String address) {
        this.address = address;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
}   
