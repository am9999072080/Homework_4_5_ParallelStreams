package ru.skypro.homework_4_5_parallelstreams.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework_4_5_parallelstreams.model.Faculty;
import ru.skypro.homework_4_5_parallelstreams.model.Student;
import ru.skypro.homework_4_5_parallelstreams.services.FacultyService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }


  }
