package uz.oyatjon.unittesting.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> get(@PathVariable Integer id) {
        return studentService.get(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAll(@Valid StudentCriteria criteria) {
        return studentService.getAll(criteria);
    }


}
