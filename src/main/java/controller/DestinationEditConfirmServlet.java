package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DestinationEditServlet
 */
@WebServlet("/destinationEditConfirm")
public class DestinationEditConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer destinationId=(Integer)session.getAttribute("destinatinId");
		session.setAttribute("destinationId", destinationId);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Editページからポストされた情報をセッションスコープから取得
		HttpSession session = request.getSession();
		session.getAttribute("genreId");
		session.getAttribute("name");
		session.getAttribute("evaluation");

		request.getRequestDispatcher("/WEB-INF/view/destinationEditConfirm.jsp").forward(request, response);

	}

}
