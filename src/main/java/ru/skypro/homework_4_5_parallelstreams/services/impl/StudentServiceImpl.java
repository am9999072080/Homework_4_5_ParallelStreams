package ru.skypro.homework_4_5_parallelstreams.services.impl;

import liquibase.repackaged.org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.skypro.homework_4_5_parallelstreams.exceptions.EntityNotFoundException;
import ru.skypro.homework_4_5_parallelstreams.model.Student;
import ru.skypro.homework_4_5_parallelstreams.repository.StudentRepository;
import ru.skypro.homework_4_5_parallelstreams.services.StudentService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@Service
public class StudentServiceImpl implements StudentService {


    private final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {

        this.repository = repository;
    }


    @Override
    public Student add(Student student) {
        logger.info("Creating a student: {}", student);
        logger.info("Created by student: {}", student);
        return repository.save(student);
    }

    @Override
    public Student remove(Long id) {
        logger.info("Deleting a student: {}", id);
        Student student = get(id);
        repository.deleteById(id);
        logger.info("Removed student: {}", id);
        return student;
    }

    @Override
    public Student update(Student student) {
        logger.info("Student update: {}", student);
        Student existedStudent = get(student.getId());
        logger.info("Already updated student: {}", student);
        return repository.save(student);
    }

    @Override
    public Student get(Long id) {
        logger.info("Getting a student by ID: {}", id);
        Optional<Student> student = repository.findById(id);

        if (student.isPresent()) {
            logger.info("Student Getting by ID: {}", id);
            return student.get();
        } else {
            logger.error("There is not student with id = " + id);
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Collection<Student> getByAge(Integer startAge, Integer endAge) {
        logger.info("Getting a list of all students by age: {},{}", startAge, endAge);
        checkAge(startAge);
        checkAge(endAge);
        logger.info("list of all students by age: {},{}", startAge, endAge);
        return repository.findStudentsByAgeBetween(startAge, endAge);
    }

    private void checkAge(Integer age) {
        if (age <= 10 || age >= 80) {
            logger.error("Incorrect student age {} ", age);
            throw new IllegalArgumentException("INCORRECT STUDENT AGE");
        }
    }

    @Override
    public Collection<Student> getAll() {
        logger.info("Getting a list of all students");

        logger.info("List of all students");
        return repository.findAll();
    }

    @Override
    public Integer getStudentsCount() {
        logger.info("Getting the total number of students");

        logger.info("Total number of students");
        return repository.getCount();
    }

    @Override
    public Float getStudentsAverageAge() {
        logger.info("Obtaining the average age of students");

        logger.info("Average age of students");
        return repository.getAverageAge();
    }

    @Override
    public List<Student> getLastFiveStudents() {
        logger.info("Getting the last 5 students");

        logger.info("List of the last five students");
        return repository.getLastFive();
    }

    @Override
    public List<Student> getByName(String name) {
        logger.info("Getting a student by name");

        logger.info("Student by name");
        return repository.findAll();
    }

    @Override
    public List<String> getNamesByA() {
        logger.info("Was invoked method for get students names by A");
        return repository.findAll().stream()
                .filter(s -> s.getName().startsWith("A"))
                .map(s -> s.getName().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public Double getStudentsAverageAgeByStream() {
        logger.info("Was invoked method for get student average age with stream");
        return repository.findAll().stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
    }

    @Override
    public Stream<Student> findStudentByNameWithInitial_(Character letter) {
        logger.info("search for students, encountered name starts with a letter {A}");
        logger.info("Received a list of names starting with the letter A");
        return repository.findAll().stream()
                .filter(student -> student.getName().charAt(0) == letter)
                .sorted((student1, student2) -> student1.getName()
                        .compareToIgnoreCase(student2.getName())
                );
    }

    @Override
    public void calculateWithStream() {
        int limit = 1_000_000;
        calculateWithStream(limit);
        calculateWithStreamParallel(limit);
        calculateWithLongStream(limit);

    }

    private void calculateWithStream(int limit) {
        long start = System.currentTimeMillis();

        int sum = Stream.iterate(1, a -> a + 1)
                .limit(limit)
                .reduce(0, (a, b) -> a + b);

        long end = System.currentTimeMillis();


        logger.info("Time 1: " + (end - start));
    }

    private void calculateWithStreamParallel(int limit) {
        long start = System.currentTimeMillis();

        int sum = Stream.iterate(1, a -> a + 1)
                .limit(limit)
                .reduce(0, (a, b) -> a + b);

        long end = System.currentTimeMillis();


        logger.info("Time 2: " + (end - start));

    }

    private void calculateWithLongStream(int limit) {
        long start = System.currentTimeMillis();

        long sum = LongStream
                .range(1, limit)
                .sum();

        long end = System.currentTimeMillis();


        logger.info("Time 3: " + (end - start));

    }
}

