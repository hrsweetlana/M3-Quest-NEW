package repository;

import entity.Quiz;
import lombok.Builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Builder
public class InMemoryQuizRepository implements QuizRepository {
    private static InMemoryQuizRepository INSTANCE;

    private final ArrayList<Quiz> quizzes = new ArrayList<>();

    private InMemoryQuizRepository() {
        InMemoryQuestionRepository quiz1 = InMemoryQuestionRepository.getInstance();
        InMemoryQuestionRepository2 quiz2 = InMemoryQuestionRepository2.getInstance();

        String quizDescription0 = "Цей тест допоможе Вам вивчити основні команди Git. Ви зможете перейти до наступного запитання, тільки коли оберете правильну відповідь.";
        String quizDescription1 = "Цей тест допоможе Вам розрізняти різні види грибів. Ви зможете перейти до наступного запитання, тільки коли оберете правильну відповідь.";

        quizzes.add(Quiz.builder().name("Основні команди Git").isImage(false).questions(quiz1).description(quizDescription0).build());
        quizzes.add(Quiz.builder().name("Вивчаємо назви грибів").isImage(true).questions(quiz2).description(quizDescription1).build());
    }

    public static InMemoryQuizRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InMemoryQuizRepository();
        }

        return INSTANCE;

    }

    public ArrayList<Quiz> findAll() {
        return quizzes;
    }

    @Override
    public Quiz save(Quiz save) {
        return null;
    }

    @Override
    public Optional<Quiz> findByName(String name) {
        return Optional.empty();
    }
}
