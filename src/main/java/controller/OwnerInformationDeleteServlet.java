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
 * Servlet implementation class OwnerInformationDeleteServlet
 */
@WebServlet("/ownerInformationDelete")
public class OwnerInformationDeleteServlet extends HttpServlet {
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

			request.setAttribute("owner", owner);
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationDelete.jsp").forward(request, response);
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
		String loginId = request.getParameter("loginId");

		Owner owner = new Owner();
		owner.setLoginId(loginId);

		try {
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			ownerDao.delete(owner);

			request.getRequestDispatcher("/WEB-INF/view/ownerInformationDeleteComplete.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
