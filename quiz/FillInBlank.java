package quiz;

public class FillInBlank extends QuestionTemplate {

	
	/**
	 * Constructor: builds a Fill in the Blank question builds based on the info stored in the data base 
	 */
	public FillInBlank(String questionId, String questionType) {
		super(questionId, questionType);
	}
	
	/**
	 * Constructor: constructs a Fill in the Blank  question from the create question web page. 
	 */
	public FillInBlank(String questionType, String authorId, String questionDescription, int maximumPossibleScore, String answer) {
		super(questionType, authorId, questionDescription, maximumPossibleScore, answer);
	}
	

	@Override
	public String getInsertQueryStringToSaveQuestion() {
		return "INSERT INTO " + FiB_db + " VALUES (\""+ super.getNewValuesString() + ")";  //FiB_db= "Fill_in_the_blank_db"
	}

}
