package assignment;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ClaimProcessingServlet extends HttpServlet {
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     // Retrieve the ClaimBean from the session
     HttpSession session = request.getSession();
     ClaimBean claim = (ClaimBean) session.getAttribute("claimBean");
     
     // Process the claim (in a real application, this would involve more complex logic)
     claim.setStatus("Processed");
     
     // Forward to the confirmation servlet
     RequestDispatcher dispatcher = request.getRequestDispatcher("/ClaimConfirmationServlet");
     dispatcher.forward(request, response);
 }
}
