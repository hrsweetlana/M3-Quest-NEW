package repository;

import entity.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class InMemoryQuestionRepository2 implements QuestionRepository{
    private static InMemoryQuestionRepository2 INSTANCE;

    private final ArrayList<Question> questions = new ArrayList<>();

    private InMemoryQuestionRepository2() {
        ArrayList<String> answers = new ArrayList<>();
        answers.add("/img/blue.jpg");
        answers.add("/img/pale.jpg");
        answers.add("/img/rainbow.jpg");

        questions.add(Question.builder()
                .text("На якій картинці гіропорус синіючий?")
                .answers(answers)
                .correctAnswer(1)
                .build());
    }

    public static InMemoryQuestionRepository2 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryQuestionRepository2();
        }

        return INSTANCE;

    }

    public ArrayList<Question> findAll() {
        return questions;
    }

    @Override
    public Question save(Question save) {
        return null;
    }

    @Override
    public Optional<Question> findById(Integer id) {
        return Optional.empty();
    }

}
