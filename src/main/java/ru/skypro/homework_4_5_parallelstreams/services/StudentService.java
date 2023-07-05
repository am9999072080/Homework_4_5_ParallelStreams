package ru.skypro.homework_4_5_parallelstreams.services;

import liquibase.repackaged.org.apache.commons.lang3.tuple.Pair;
import ru.skypro.homework_4_5_parallelstreams.model.Student;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public interface StudentService {
    Student add(Student student);

    Student remove(Long id);

    Student update(Student student);

    Student get(Long id);

    Collection<Student> getByAge(Integer startAge, Integer endAge);

    Collection<Student> getAll();

    Integer getStudentsCount();

    Float getStudentsAverageAge();

    List<Student> getLastFiveStudents();

    List<Student> getByName(String name);
    Stream<Student> findStudentByNameWithInitial_(Character letter);
    Pair<Long, Long> getIntegerValueByFormula(int repetition);

}
