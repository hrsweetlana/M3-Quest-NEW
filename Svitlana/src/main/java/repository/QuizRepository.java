package repository;

import entity.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizRepository  {
    Quiz save(Quiz save);
    Optional<Quiz> findByName(String name);
    List<Quiz> findAll();
}
