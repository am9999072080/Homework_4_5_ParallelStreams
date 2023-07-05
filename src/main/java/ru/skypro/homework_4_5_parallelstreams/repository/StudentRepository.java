package ru.skypro.homework_4_5_parallelstreams.repository;

import ru.skypro.homework_4_5_parallelstreams.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


}