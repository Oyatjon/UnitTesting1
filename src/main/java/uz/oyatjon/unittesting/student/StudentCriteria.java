package uz.oyatjon.unittesting.student;

import lombok.Getter;
import lombok.Setter;
import org.springdoc.api.annotations.ParameterObject;

import java.util.Objects;

@Getter
@Setter
@ParameterObject
public class StudentCriteria {
    private Integer size;
    private Integer page;

    public Integer getSize() {
        return Objects.isNull(size) ? 10 : size;
    }

    public Integer getPage() {
        return Objects.isNull(page) ? 0 : page;
    }
}
