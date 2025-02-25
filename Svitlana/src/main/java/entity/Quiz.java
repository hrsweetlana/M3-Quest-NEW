package entity;

import lombok.Builder;
import lombok.Data;
import repository.QuestionRepository;


@Data
@Builder
public class Quiz {

    private String name;
    private Boolean isImage; 
    private QuestionRepository questions;
    private String description;
}
