package quiz;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import java.sql.Statement;

public class PictureResponse extends QuestionTemplate{
	
	private String url; //contains the url for the picture (this is an additional property of this type of question

	
	/**
	 * Constructor: builds a Picture Response question builds based on the info stored in the data base 
	 */
	public PictureResponse(String questionId, String questionType) {
		super(questionId, questionType);
		try {
			Connection con = MyDB.getConnection();
			Statement statment = con.createStatement();
			ResultSet rs = statment.executeQuery(query);
			rs.next();
			url = rs.getString(6);  //DB for PR question is different than for other questions
		} catch (SQLException e) {
			System.out.println("error on URL retrival from DB");
			e.printStackTrace();
		}
	}
	
	/**
	 * Constructor: builds a Picture Response question builds based on the info stored in the data base 
	 */
	public PictureResponse(String questionType, String authorId, String questionDescription, 
				int maximumPossibleScore, String answer, String url) {
		super(questionType, authorId, questionDescription, maximumPossibleScore, answer);
		this.url = url;
	}
	
	
	@Override
	public String getInsertQueryStringToSaveQuestion() {
		return "INSERT INTO " + PR_db + " VALUES (\""+ super.getNewValuesString() + ")"; //insert values using parent method
	}

}
