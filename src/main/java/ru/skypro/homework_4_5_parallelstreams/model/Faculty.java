package ru.skypro.homework_4_5_parallelstreams.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "faculties")
@JsonIgnoreProperties(value = {"students"})
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;

    @OneToMany(mappedBy = "faculty")
    @JsonManagedReference
    private List<Student> students;

    public Faculty(Long id, String name, String color, List<Student> students) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.students = students;
    }

    public Faculty() {

    }

    public Faculty(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Student> getStudents() {

        return students;
    }

    public void setStudents(List<Student> students) {

        this.students = students;
    }

    public Long getId() {
        return id;
    }


    public String getName() {

        return name;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getColor() {

        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty)) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(id, faculty.id) && Objects.equals(name, faculty.name) && Objects.equals(color, faculty.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color);
    }

    @Override
    public String toString() {
        return "Faculty{" + "id=" + id + ", name='" + name + '\'' + ", color='" + color + '\'' + '}';
    }
}
