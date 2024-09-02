<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="assignment.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Claim Confirmation</title>
</head>
<body>
	<h2>Claim Confirmation</h2>
	<% ClaimBean claim = (ClaimBean) session.getAttribute("claimBean"); %>
	<p>Claim submitted successfully!</p>
	<p>
		Claimant Name:
		<%= claim.getClaimantName() %></p>
	<p>
		Policy Name:
		<%= claim.getClaimantPolicy() %></p>

	<p>
		Claim Amount: $<%= claim.getClaimAmount() %></p>
	<p>
		Status:
		<%= claim.getStatus() %></p>
</body>
</html>