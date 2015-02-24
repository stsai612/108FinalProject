package quizServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quiz.QuestionMaker;
import quiz.QuestionTemplate;

import com.sun.tools.javac.util.List;

/**
 * Servlet implementation class quizCreationAndSavingServlet
 */
@WebServlet("/quizCreationAndSavingServlet")
public class quizCreationAndSavingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quizCreationAndSavingServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//Following 2 lines to be swapped:
		//String userName = (String) session.getAttribute("currentUser"); //TO DO make sure the author/current user is stored as a attribute
		String userName = "error";
		
		String questionType = request.getParameter("questionType");
		
		ArrayList<QuestionTemplate> questionList = new ArrayList<QuestionTemplate>();  //To do extend this class to hold multiple questions
		
		QuestionTemplate newQuestion =  QuestionMaker.createQuestion(questionType, request, userName);
		newQuestion.saveQuestionToDatabase();
		questionList.add(newQuestion);
		
		//Temporary redirect to quiz.create_question_response
		RequestDispatcher dispatch = request.getRequestDispatcher("quiz.create_question_response.jsp");
		dispatch.forward(request, response);
	}

}
