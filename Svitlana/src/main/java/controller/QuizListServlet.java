package controller;

import entity.Quiz;
import repository.InMemoryQuizRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "QuizListServlet", value = "/choseQuiz")
public class QuizListServlet extends HttpServlet {
    InMemoryQuizRepository quizzesRepository = InMemoryQuizRepository.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Quiz> quizzes = quizzesRepository.findAll();
        req.getSession().setAttribute("quizzes", quizzes);
        getServletContext().getRequestDispatcher("/chose_quiz.jsp").forward(req, resp);
    }
}
