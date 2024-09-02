package assignment;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ClaimConfirmationServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the confirmation JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/claimConfirmation.jsp");
        dispatcher.forward(request, response);
    }
}