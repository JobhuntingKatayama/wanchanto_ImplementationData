package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.DestinationDao;
import domain.Destination;

/**
 * Servlet implementation class DestinationInformationRegistrationServket
 */
@WebServlet("/destinationInformationRegistration")
public class DestinationInformationRegistrationServket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/destinationInformationRegistration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer genreId = Integer.parseInt(request.getParameter("genreId"));
		String name = request.getParameter("name");
		Integer evaluation = Integer.parseInt(request.getParameter("evaluation"));
		
		Destination destination = new Destination();
		destination.setGenreId(genreId);
		destination.setName(name);
		destination.setEvaluation(evaluation);
		
		try {
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			destinationDao.insert(destination);
			request.getRequestDispatcher("/WEB-INF/view/destinationInformationRegistrationComplete.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
