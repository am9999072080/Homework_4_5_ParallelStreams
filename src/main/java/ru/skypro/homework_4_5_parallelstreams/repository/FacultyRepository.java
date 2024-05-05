package ru.skypro.homework_4_5_parallelstreams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework_4_5_parallelstreams.model.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Collection<Faculty> findFacultiesByNameIgnoreCaseOrColorIgnoreCase(String name, String color);
}
