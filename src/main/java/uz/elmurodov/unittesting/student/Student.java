package uz.elmurodov.unittesting.student;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Student {
    @Id
    private Integer id;
    private String fullName;
    private Integer age;
    private String email;
}
