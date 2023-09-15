package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class OwnerRegistrationConfirmServlet
 */
@WebServlet("/ownerRegistrationConfirm")
public class OwnerRegistrationConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//getは受信せず
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションから情報を取得
		HttpSession session = request.getSession();
		session.getAttribute("loginId");
		session.getAttribute("loginPassword");
		session.getAttribute("thumbnail");
		session.getAttribute("bytes");
		session.getAttribute("ownerImg");
		
		request.getRequestDispatcher("/WEB-INF/view/ownerRegistrationComplete.jsp").forward(request, response);
	}


}
