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
 * Servlet implementation class OwnerLoginServlet
 */
@WebServlet("/ownerLogin")
public class OwnerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/ownerLogin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String loginId = request.getParameter("loginId");
			String loginPassword = request.getParameter("loginPassword");
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			Owner owner = ownerDao.findByLoginIdAndLoginPass(loginId, loginPassword);
			if (owner != null) {
				request.getSession().setAttribute("loginId", owner.getLoginId());
				response.sendRedirect("ownerMypage");
			} else {
				request.setAttribute("error", true);
				request.getRequestDispatcher("/WEB-INF/view/ownerLogin.jsp").forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
