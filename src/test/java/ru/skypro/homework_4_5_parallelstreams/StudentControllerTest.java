package ru.skypro.homework_4_5_parallelstreams;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.skypro.homework_4_5_parallelstreams.controller.StudentController;

import ru.skypro.homework_4_5_parallelstreams.model.Student;
import ru.skypro.homework_4_5_parallelstreams.repository.StudentRepository;
import ru.skypro.homework_4_5_parallelstreams.services.impl.StudentServiceImpl;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.skypro.homework_4_5_parallelstreams.TestConstants.*;

@WebMvcTest(controllers = StudentController.class)
public class StudentControllerTest {

}
