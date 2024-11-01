package nahom.nahi.Service;

import lombok.RequiredArgsConstructor;
import nahom.nahi.dto.StudentDTO;
import nahom.nahi.entity.Student;
import nahom.nahi.repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo repo;

    public String addStudent(StudentDTO studentDTO) {
        boolean StudentExists = repo.existsByEmail(studentDTO.email());

        if (StudentExists){
            return "The Email is all ready registered";
        }

        Student student = Student.builder()
                .name(studentDTO.name())
                .email(studentDTO.email())
                .password(studentDTO.password())
                .build();

        repo.save(student);
        return "success";

    }

    public List<Student> getStudents() {
        return repo.findAll();
    }

    public Optional<Student> getStudent(Integer id) {
        return repo.findById(id);
    }
}
