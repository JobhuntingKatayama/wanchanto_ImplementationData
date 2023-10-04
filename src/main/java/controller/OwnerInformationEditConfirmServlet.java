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
@WebServlet("/ownerInformationEditConfirm")
public class OwnerInformationEditConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//getは受信せず
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Editページからポストされた情報をセッションスコープから取得
		HttpSession session = request.getSession();
		session.getAttribute("ownerId");
		session.getAttribute("loginId");
		session.getAttribute("loginPassword");
		session.getAttribute("ownerImgData");
		session.getAttribute("thumbnail");
		
		request.getRequestDispatcher("/WEB-INF/view/ownerInformationEditConfirm.jsp").forward(request, response);
	}

}