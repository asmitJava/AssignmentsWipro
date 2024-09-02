
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insurance Claim Submission</title>
</head>
<body>
	<h2>Submit Insurance Claim</h2>
	<form action="ClaimSubmissionServlet" method="post">
		<label for="claimantName">ClaimantName:</label> 
		<input type="text" id="claimantName" name="claimantName" required><br>
	<br><label for="claimantPolicy">PolicyName:</label>
	    <input type="text" id="claimantPolicy" name="claimantPolicy" required><br>
    <br><label for="claimAmount">Claim Amount:</label> 
    	<input type="number" id="claimAmount" name="claimAmount" required><br>
    <br><input type="submit" value="Submit Claim">
	</form>
</body>
</html>

