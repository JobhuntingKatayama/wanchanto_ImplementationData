package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DestinationRegistrationServlet
 */
@WebServlet("/destinationRegistration")
public class DestinationRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String strId = (String) request.getParameter("ownerId");
		Integer ownerId = Integer.parseInt(strId);
		HttpSession session = request.getSession();
		session.setAttribute("ownerId", ownerId);

		request.getRequestDispatcher("/WEB-INF/view/destinationRegistration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//登録情報の取得
		String strGenreId =(String)request.getParameter("genreId");
		Integer genreId = Integer.parseInt(strGenreId);
		String name =(String)request.getParameter("name");
		String strEvaluation=(String)request.getParameter("evaluation");
		Integer evaluation = Integer.parseInt(strEvaluation);
		
		//取得した情報をセッションに格納
		HttpSession session = request.getSession();
		session.setAttribute("genreId", genreId);
		session.setAttribute("name", name);
		session.setAttribute("evaluation", evaluation);
		
		//確認ページへフォワード
		request.getRequestDispatcher("/WEB-INF/view/destinationRegistrationConfirm.jsp").forward(request, response);

	}

}
