package controller;

import entity.Question;
import entity.Quiz;
import repository.QuestionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "QuizQuestions", value = "/quizQuestions")
public class QuizQuestions extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session == null) {
            System.err.println("Session is null");
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
            return;
        }


        Question question = (Question) session.getAttribute("question");
        if (question == null) {
            System.err.println("Question is null");
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
            return;
        }

        int correctAnswer = question.getCorrectAnswer();
        int answerIndex = Integer.parseInt(req.getParameter("answerIndex"));

        if (correctAnswer != answerIndex) {
            getServletContext().getRequestDispatcher("/quiz_questions.jsp").forward(req, resp);
        } else {

            int questionIndex = Integer.parseInt(session.getAttribute("questionIndex").toString());
            int quizSize = (int) session.getAttribute("quizSize");
            if (questionIndex < quizSize - 1) {
                questionIndex++;
                Quiz quiz = (Quiz) session.getAttribute("quiz");
                Question newQuestion = quiz.getQuestions().findAll().get(questionIndex);
                session.setAttribute("question", newQuestion);
                getServletContext().getRequestDispatcher("/quiz_questions.jsp").forward(req, resp);
            } else {
                getServletContext().getRequestDispatcher("/restart_quiz.jsp").forward(req, resp);
            }


        }
    }
}
