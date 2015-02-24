package quiz;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import java.sql.Statement;

/**
 * QuestionTemplate: is an abstract class that has the basic methods every question class (e.g. multiple choice) should have.
 * This class is never used but serves as the parent of all children question type classes
 * @author benlimonchik
 */
public abstract class QuestionTemplate {
	
	protected String query;
	
	public static final String FiB = "Fill_in_the_blank";
	public static final String QR = "Question_response";
	public static final String MC = "Multiple_choice";
	public static final String PR = "Picture_response";
	
	protected final String authorId; //the author id who created the question
	protected final String questionId;
	protected final String questionDescription;
	protected final int maximumPossibleScore;
	protected final String answer;
	protected final String questionType;
	
	protected final String FiB_db = "Fill_in_the_blank_db";
	protected final String QR_db = "Question_response_db";
	protected final String MC_db = "Multiple_choice_db";
	protected final String PR_db = "Picture_response_db";
	
	/**
	 * Constructor: constructs a question from the create option web page. 
	 * (Use this constructor when the user wants to add a new question to the
	 * quiz they are building.)
	 */
	public QuestionTemplate(String questionType, String authorId, String questionDescription, int maximumPossibleScore, String answer){
		super();
		//create a questionId:
		this.questionId = generateQuestionId(questionType);
		
		this.questionType = questionType;
		this.authorId = authorId;
		this.questionDescription = questionDescription;
		this.maximumPossibleScore = maximumPossibleScore;
		this.answer = answer;
	}
	
	


	/**
	 * Constructor: builds a question based on the info stored in the data base 
	 * (use this constructor to retrieve questions during quiz taking) 
	 */
	public QuestionTemplate(String questionId ,String questionType){
		this.questionId = questionId;
		this.questionType = questionType;
		
		//build the query to the data base:
		String questionDataBase = getQuestionDataBase(questionType);
		query = "SELECT * FROM " + questionDataBase + " WHERE question_id = '"+ questionId + "'";
		
		String tempAuthorId = "-1";
		String tempQuestionDescription = "-1";
		String tempAnswer = "-1";
		int tempMaximumPossibleScore = -1; 
		
		//get all the entries in the DB:
		try {
			Connection con = MyDB.getConnection(); // To Do: Fix based on Miro's DB java file. 
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();

			tempAuthorId = rs.getString(2);
			tempQuestionDescription = rs.getString(3);
			tempAnswer = rs.getString(4);
			tempMaximumPossibleScore = rs.getInt(5);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//update the final variables:
		authorId = tempAuthorId;
		questionDescription = tempQuestionDescription;
		answer = tempAnswer;
		maximumPossibleScore = tempMaximumPossibleScore;
	}
	
	/**
	 * saveQuestionToDatabase: Saves the question to the required question type data base
	 */
	public void saveQuestionToDatabase() {
		String myQuery = getInsertQueryStringToSaveQuestion();
		try {
			Connection con = MyDB.getConnection(); // To Do: Fix based on Miro's DB java file. 
			Statement stmt = con.createStatement();
			stmt.executeUpdate(myQuery);
		} catch (SQLException e) {
			System.out.println("failed to connect to database");
			e.printStackTrace();
		}
	}
	
	/**
	 * getNewValuesString: returns the values portion of the the SQL query (this string is attached to the string 
	 * at getInsertQueryStringToSaveQuestion in order to form the full String to query the data base).
	 */
	protected String getNewValuesString(){
		String value = questionId + "\", \"" + authorId + "\", \"" + questionDescription + "\", \"" + answer + "\", \"" + maximumPossibleScore;
		return value;
	}
	
	/**
	 * getInsertQueryStringToSaveQuestion: holds the string for the query that will store the new question to the correct data base 
	 * Note: look at any question type class to see how this method is used.
	 */
	public abstract String getInsertQueryStringToSaveQuestion();
	
	
	/**
	 * getScoreForQuestion: returns the score the user gets for the answer they have given. 
	 */
	public int getScoreForQuestion(String userAnswer){
		if(userAnswer.equals(answer)){
			return getMaximumPossibleScore();
		}
		return 0;
	}
	
	
	//------ The following methods are simple methods to get the variables that define a question (e.g. answer and Id):  -----
	public String getQuestionId(){
		return questionId;
	}
	
	public int getMaximumPossibleScore(){
		return maximumPossibleScore;
	}
	
	public String getQuestionDescription(){
		return questionDescription;
	}
	
	public String getQuestionType(){
		return questionType;
	}
	
	public String getAnswer(){
		return answer;
	}
	
	
	// ------------------------ Private utility functions: -------------------
	
	/**
	 * getQuestionDataBase: returns the data base name of the question type.
	 */
	private String getQuestionDataBase(String questionType) {
		String nameOfQuestionDataBase = null;
		if(questionType.equals(FiB)){
			nameOfQuestionDataBase = FiB_db;
		}
		else if(questionType.equals(QR)){
			nameOfQuestionDataBase = QR_db;
		}
		else if(questionType.equals(MC)){
			nameOfQuestionDataBase = MC_db;
		}
		else if(questionType.equals(PR)){
			nameOfQuestionDataBase = PR_db;
		}
		return nameOfQuestionDataBase;
	}
	
	
	/**
	 * generateQuestionId: generates a unique question Id to be stored in the question data base (question Id is the first column of each
	 * question data base).
	 */
	private String generateQuestionId(String questionType) {
		long current_time = System.currentTimeMillis();
		String newId = String.valueOf(current_time) + questionType;
		return newId;  //TO DO: create a better mechanism that will randomize questionIds  ****
	}
	
}
