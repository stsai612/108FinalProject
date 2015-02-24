package quiz;

/**
 * QuestionResponse: defines a single Question Response question type.
 * @author benlimonchik
 */
public class QuestionResponse extends QuestionTemplate{
	

	/**
	 * Constructor: builds a Question Response question builds based on the info stored in the data base 
	 */
	public QuestionResponse(String questionId, String questionType) {
		super(questionId, questionType);
	}
	
	/**
	 * Constructor: constructs a Question Response question from the create question web page. 
	 */
	public QuestionResponse(String questionType, String authorId, String questionDescription, int maximumPossibleScore, String answer) {
		super(questionType, authorId, questionDescription, maximumPossibleScore, answer);
	}

	
	
	@Override
	public String getInsertQueryStringToSaveQuestion() {
		return "INSERT INTO " + QR_db + " VALUES (\""+ super.getNewValuesString() + ")"; //insert values using parent method
	}
	

}
