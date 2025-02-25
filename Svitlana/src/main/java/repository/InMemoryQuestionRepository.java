package repository;

import entity.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class InMemoryQuestionRepository implements QuestionRepository {
    private static InMemoryQuestionRepository INSTANCE;

    private final ArrayList<Question> questions = new ArrayList<>();

    private InMemoryQuestionRepository() {
        ArrayList<String> answers = new ArrayList<>();
        answers.add("git fetch");
        answers.add("git pull");
        answers.add("git merge");

        ArrayList<String> answers2 = new ArrayList<>();
        answers2.add("git fetch  і git push");
        answers2.add("git pull і git push");
        answers2.add("git fetch  і git merge");

        questions.add(Question.builder()
                .text("Яка команда синхронізує два репозиторії, але не встановлює новий контент файлу у файловій системі?")
                .answers(answers)
                .correctAnswer(1)
                .build());

        questions.add(Question.builder()
                .text("Комбінацією яких двох команд є git pull?")
                .answers(answers2)
                .correctAnswer(3)
                .build());
    }

    public static InMemoryQuestionRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryQuestionRepository();
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
