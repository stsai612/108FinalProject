package quiz;

import javax.servlet.http.HttpServletRequest;

/**
 * QuestionMaker class : 
 * is responsible for building questions (i.e. multiple choice, fill in etc.) based on the information passed by
 * the HttpServletRequest.
 * 
 * @author benlimonchik
 *
 *To Dos:
 *get rid of the user parameter in createQuestion method once the session will include this data
 */

public class QuestionMaker {

	public static QuestionTemplate createQuestion(String questionType, HttpServletRequest request, String userName) {
		String questionDescription = request.getParameter("QuestionDescription");
		String answer  = request.getParameter("Answer");
		int maximumPossibleScore = Integer.parseInt(request.getParameter("MaximumPossibleScore"));
		
		if(questionType.equals(QuestionTemplate.QR)){
			QuestionResponse newQR = new QuestionResponse(questionType, userName, questionDescription, maximumPossibleScore, answer);
			return newQR;
		}
		else if(questionType.equals(QuestionTemplate.FiB)){
			FillInBlank newQR = new FillInBlank(questionType, userName, questionDescription, maximumPossibleScore, answer);
			return newQR;
		}
		
		//make other question cases:
		return null;
	}

}
