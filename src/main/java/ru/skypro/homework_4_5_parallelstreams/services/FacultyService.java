package ru.skypro.homework_4_5_parallelstreams.services;

import ru.skypro.homework_4_5_parallelstreams.model.Faculty;

import java.util.Collection;

public interface FacultyService {
    Faculty add(Faculty faculty);

    Faculty remove(Long id);

    Faculty update(Faculty faculty);

    Faculty get(Long id);

    Collection<Faculty> getByNameOrColor(String name, String color);

    Collection<Faculty> getAll();
    String findLongestFacultyName();
}
