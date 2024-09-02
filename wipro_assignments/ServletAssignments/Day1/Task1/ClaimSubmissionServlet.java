package assignment;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ClaimSubmissionServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Get parameters from the form
		String claimantName = request.getParameter("claimantName");
		String claimantPolicy = request.getParameter("claimantPolicy");
		String claimAmount = request.getParameter("claimAmount");

		// Create and populate the ClaimBean
		ClaimBean claim = new ClaimBean();
		claim.setClaimantName(claimantName);
		claim.setClaimantPolicy(claimantPolicy);
		claim.setClaimAmount(Double.parseDouble(claimAmount));

		// Store the bean in the session
		HttpSession session = request.getSession();
		session.setAttribute("claimBean", claim);

		// Forward to the processing servlet
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ClaimProcessingServlet");
		dispatcher.forward(request, response);
	}
}
