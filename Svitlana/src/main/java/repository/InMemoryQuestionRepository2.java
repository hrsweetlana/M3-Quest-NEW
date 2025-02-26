package repository;

import entity.Question;

import java.util.ArrayList;
import java.util.Optional;

public class InMemoryQuestionRepository2 implements QuestionRepository{
    private static InMemoryQuestionRepository2 INSTANCE;

    private final ArrayList<Question> questions = new ArrayList<>();

    private InMemoryQuestionRepository2() {
        ArrayList<String> answers = new ArrayList<>();
        answers.add("/img/blue.jpg");
        answers.add("/img/pale.jpg");
        answers.add("/img/rainbow.jpg");

        ArrayList<String> answers2 = new ArrayList<>();
        answers2.add("/img/baranhol.jpg");
        answers2.add("/img/lysychky1.jpg");
        answers2.add("/img/kozar2.jpg");

        ArrayList<String> answers3 = new ArrayList<>();
        answers3.add("/img/syroyizh2.jpg");
        answers3.add("/img/kozar.jpg");
        answers3.add("/img/white1.jpg");

        ArrayList<String> answers4 = new ArrayList<>();
        answers4.add("/img/pidosykovyk.jpg");
        answers4.add("/img/kozar3.jpg");
        answers4.add("/img/lysychky.jpg");

        ArrayList<String> answers5 = new ArrayList<>();
        answers5.add("/img/pe4erytsya3.jpg");
        answers5.add("/img/white3.jpg");
        answers5.add("/img/pidosykovyk3.jpg");

        ArrayList<String> answers6 = new ArrayList<>();
        answers6.add("/img/pe4erytsya2.jpg");
        answers6.add("/img/syroyizh3.jpg");
        answers6.add("/img/maslyuk.jpg");

        ArrayList<String> answers7 = new ArrayList<>();
        answers7.add("/img/syroyizh1.jpg");
        answers7.add("/img/pe4erytsya.jpg");
        answers7.add("/img/baranhol3.jpg");

        ArrayList<String> answers8 = new ArrayList<>();
        answers8.add("/img/maslyuk2.jpg");
        answers8.add("/img/baranhol2.jpg");
        answers8.add("/img/pidosykovyk.jpg");

        ArrayList<String> answers9 = new ArrayList<>();
        answers9.add("/img/white.jpg");
        answers9.add("/img/maslyuk3.jpg");
        answers9.add("/img/lysychky.jpg");

        questions.add(Question.builder()
                .text("На якій картинці гіропорус синіючий?")
                .answers(answers)
                .correctAnswer(0)
                .build());
        questions.add(Question.builder()
                .text("На якій картинці бараняча голова?")
                .answers(answers2)
                .correctAnswer(0)
                .build());
        questions.add(Question.builder()
                .text("На якій картинці козар?")
                .answers(answers3)
                .correctAnswer(1)
                .build());
        questions.add(Question.builder()
                .text("На якій картинці лисички?")
                .answers(answers4)
                .correctAnswer(2)
                .build());
        questions.add(Question.builder()
                .text("На якій картинці білий гриб?")
                .answers(answers5)
                .correctAnswer(1)
                .build());
        questions.add(Question.builder()
                .text("На якій картинці печериці?")
                .answers(answers6)
                .correctAnswer(0)
                .build());
        questions.add(Question.builder()
                .text("На якій картинці сироїжка?")
                .answers(answers7)
                .correctAnswer(0)
                .build());
        questions.add(Question.builder()
                .text("На якій картинці підосиковик?")
                .answers(answers8)
                .correctAnswer(2)
                .build());
        questions.add(Question.builder()
                .text("На якій картинці маслюк?")
                .answers(answers9)
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
