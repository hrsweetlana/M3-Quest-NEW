package repository;

import entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {
    Question save(Question save);
    Optional<Question> findById(Integer id);
    List<Question> findAll();
}
