package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.OwnerDao;
import domain.Owner;

/**
 * Servlet implementation class ListOwnerServlet
 */
@WebServlet("/listOwner")
public class ListOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/***
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			List<Owner>ownerList = ownerDao.findAll();
			
			request.setAttribute("ownerList", ownerList);
			
			request.getRequestDispatcher("/WEB-INF/view/listOwner.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
				}

}
