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

        ArrayList<String> answers3 = new ArrayList<>();
        answers3.add("blob");
        answers3.add("club");
        answers3.add("leaf");

        ArrayList<String> answers4 = new ArrayList<>();
        answers4.add("git reset --soft HEAD^");
        answers4.add("git reset --mixed HEAD^");
        answers4.add("git reset --hard HEAD^");

        questions.add(Question.builder()
                .text("Яка команда синхронізує два репозиторії, але не встановлює новий контент файлу у файловій системі?")
                .answers(answers)
                .correctAnswer(0)
                .build());

        questions.add(Question.builder()
                .text("Комбінацією яких двох команд є git pull?")
                .answers(answers2)
                .correctAnswer(2)
                .build());

        questions.add(Question.builder()
                .text("Мінімальна атомарна комірка збереження інформації?")
                .answers(answers3)
                .correctAnswer(0)
                .build());

        questions.add(Question.builder()
                .text("Як відмінити коміт з локального репозиторію, і повернутись на stage area?")
                .answers(answers4)
                .correctAnswer(0)
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
