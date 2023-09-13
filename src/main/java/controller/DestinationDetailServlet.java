package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.DestinationDao;
import domain.Destination;

/**
 * Servlet implementation class DestinationDetailServlet
 */
@WebServlet("/destinationDetail")
public class DestinationDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strDestinationId = request.getParameter("destinationId");
		Integer intDestinationId = Integer.parseInt(strDestinationId);
		HttpSession session = request.getSession();
		session.setAttribute("destinationId", intDestinationId);

		try {
			// 編集するお出掛け先データの取得
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			Destination destination = destinationDao.findByDestinationId(intDestinationId);

			// データの情報をリクエストに格納
			request.setAttribute("ownerId", destination.getOwnerId());
			request.setAttribute("genreId", destination.getGenreId());
			request.setAttribute("name", destination.getName());
			request.setAttribute("evaluation", destination.getEvaluation());
		
		} catch (Exception e) {
			throw new ServletException(e);
		}

		
		request.getRequestDispatcher("/WEB-INF/view/destinationDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
