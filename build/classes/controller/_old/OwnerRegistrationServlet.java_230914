package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class OwnerRegistrationServlet
 */
@WebServlet("/ownerRegistration")
public class OwnerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/ownerRegistration.jsp").forward(request, response);
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	

		HttpSession session = request.getSession();

		String loginId = request.getParameter("loginId");
		String loginPassword = request.getParameter("loginPassword");		
		String hashedPassword = BCrypt.hashpw(loginPassword, BCrypt.gensalt());
		
		session.setAttribute("loginId", loginId);
		session.setAttribute("loginPassword", hashedPassword);
	
		request.getRequestDispatcher("/WEB-INF/view/ownerRegistrationConfirm.jsp").forward(request, response);

	}

}
