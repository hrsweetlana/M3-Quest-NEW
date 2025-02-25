package controller;

import entity.Question;
import entity.Quiz;
import repository.InMemoryQuizRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QuizServlet", value = "/quiz")
public class QuizServlet extends HttpServlet {
    InMemoryQuizRepository quizList = InMemoryQuizRepository.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String questIndex = req.getParameter("index");
        int index = Integer.parseInt(questIndex);
        HttpSession session = req.getSession();
        session.setAttribute("index", index);

        ArrayList<Quiz> quizzes = quizList.findAll();
        Quiz quiz = quizzes.get(index);
        session.setAttribute("quiz", quiz);

        List<Question> questions = quiz.getQuestions().findAll();
        int quizSize = questions.size();
        session.setAttribute("quizSize", quizSize);

        Question question = quiz.getQuestions().findAll().get(0);
        session.setAttribute("questionIndex", 0);
        session.setAttribute("questions", questions);
        session.setAttribute("question", question);

        getServletContext().getRequestDispatcher("/quiz_questions.jsp").forward(req, resp);
    }

}
