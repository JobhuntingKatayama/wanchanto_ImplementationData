package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.OwnerDao;
import domain.Owner;

/**
 * Servlet implementation class OwnerInformationEditServlet
 */
@WebServlet("/ownerInformationEdit")
public class OwnerInformationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		try {
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			Owner owner = ownerDao.findById(loginId);
			
			request.setAttribute("loginId", owner.getLoginId());
			request.setAttribute("loginPassword", owner.getLoginPassword());
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationEdit.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isError=false;

		String loginId = request.getParameter("loginId");

		String newLoginId = loginId;
		request.setAttribute("loginId", newLoginId);
		if(loginId.isEmpty()) {
			request.setAttribute("loginIdError", "ログインIDが未入力です.");
			isError = true;
		}

		String loginPassword=request.getParameter("loginPassword");
		request.setAttribute("loginPassword", loginPassword);
		if(loginPassword.isEmpty()) {
			request.setAttribute("loginPasswordError", "パスワードが未入力です.");
			isError = true;
		}
		
		if(isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationEdit.jsp").forward(request, response);
			return;
		}
		
		Owner owner = new Owner();
		owner.setLoginId(newLoginId);
		owner.setLoginPassword(loginPassword);
		try {
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			ownerDao.update(owner);
			
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationEditComplete.jsp").forward(request, response);
		} catch(Exception e) {
			throw new ServletException(e);
		}
	}

}
