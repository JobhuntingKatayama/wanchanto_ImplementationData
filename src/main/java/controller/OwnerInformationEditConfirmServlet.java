package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.OwnerDao;
import domain.Owner;

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

		request.getParameter("ownerId");
		request.getParameter("loginId");
		request.getParameter("hashedPassword");

		request.getRequestDispatcher("/WEB-INF/view/ownerInformationEditConfirm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer ownerId = Integer.parseInt(request.getParameter("ownerId"));
		String loginId = request.getParameter("loginId");
		HttpSession session = request.getSession();
		String hashedPassword = (String)session.getAttribute("hashedPassword");

		// 入力に不備がなければ、データの更新
		Owner owner = new Owner();
		owner.setOwnerId(ownerId);
		owner.setLoginId(loginId);
		owner.setLoginPassword(hashedPassword);
		
		try {
			// データの更新
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			ownerDao.update(owner);

			// 更新完了ページの表示
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationEditComplete.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
