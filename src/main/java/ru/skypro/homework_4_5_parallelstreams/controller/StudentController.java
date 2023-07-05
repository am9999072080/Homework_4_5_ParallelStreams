package ru.skypro.homework_4_5_parallelstreams.controller;

import liquibase.repackaged.org.apache.commons.lang3.tuple.Pair;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework_4_5_parallelstreams.model.Faculty;
import ru.skypro.homework_4_5_parallelstreams.model.Student;
import ru.skypro.homework_4_5_parallelstreams.services.StudentService;

import java.util.Optional;
import java.util.Collection;
import java.util.stream.Stream;

@RestController
@RequestMapping("student")
@Tag(name = "Api: Для работы со студентами")
public class StudentController {

}


