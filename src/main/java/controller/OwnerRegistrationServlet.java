package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import dao.DaoFactory;
import dao.OwnerDao;
import domain.Owner;

/**
 * Servlet implementation class OwnerRegistrationServlet
 */
@WebServlet("/ownerRegistration")
public class OwnerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/ownerRegistration.jsp").forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String loginPassword = request.getParameter("loginPassword");
		
		String hashedPassword = BCrypt.hashpw(loginPassword, BCrypt.gensalt());
		
		Owner owner = new Owner();
		owner.setLoginId(loginId);
		owner.setLoginPassword(hashedPassword);
		
		try {
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			ownerDao.insert(owner);
			
			request.setAttribute("loginId", loginId);

			request.getRequestDispatcher("/WEB-INF/view/ownerRegistrationConfirm.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	

	}

}
