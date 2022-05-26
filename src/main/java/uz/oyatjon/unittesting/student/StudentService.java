package uz.oyatjon.unittesting.student;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public ResponseEntity<Student> create(@NotNull Student student) {
        return null;
    }

    public ResponseEntity<Student> get(@NotNull Integer id) {
        return null;
    }

    public ResponseEntity<List<Student>> getAll(StudentCriteria criteria) {
        Pageable pageRequest = PageRequest.of(criteria.getPage(), criteria.getSize());
        return ResponseEntity.ok(studentRepository.findAll(pageRequest).stream().toList());
    }
}
