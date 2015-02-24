<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Question-Response question</title>
</head>
<body>
<h1>Create Question-Response question</h1>

<form action="quizCreationAndSavingServlet" method="post">
	 	Question Description: <input type="text" name="QuestionDescription" /> <br />
		Answer: 				<input type="text" name="Answer" /> <br />
		<input type="hidden" name="MaximumPossibleScore" value="1"> <!-- switch to int later-->
		<input type="hidden" name="questionType" value="Question_response">
		<!-- remember to pass the author based on the current user connected to the current session-->
		<input type="submit" value="add this question" />
</form>

</body>
</html>