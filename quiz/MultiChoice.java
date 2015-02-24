package quiz;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import java.sql.Statement;

public class MultiChoice extends QuestionTemplate {

	protected String allChoices;  //A String that holds all the choices for the answer (can hold more than 4) 
	
	/**
	 * Constructor: builds a Multiple Choice question builds based on the info stored in the data base 
	 */
	public MultiChoice(String questionId, String questionType) {
		super(questionId, questionType);
		String tmp= "";
		try {
			Connection con = MyDB.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			tmp = rs.getString(6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		allChoices = tmp;
	}
	
	/**
	 * Constructor: constructs a Multiple Choice question from the create question web page. 
	 */
	public MultiChoice(String questionType, String authorId,
			String questionDescription, int maximumPossibleScore, String answer, String allChoices) {
		super(questionType, authorId, questionDescription, maximumPossibleScore, answer);
		this.allChoices = allChoices;
		
	}

	@Override
	public String getInsertQueryStringToSaveQuestion() {
		return "INSERT INTO " + MC_db + " VALUES (\""+ super.getNewValuesString() + ")"; //insert values using parent method
	}

}
