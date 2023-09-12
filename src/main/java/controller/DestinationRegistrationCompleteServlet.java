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
 * Servlet implementation class DestinationRegistrationCompleteServlet
 */
@WebServlet("/destinationRegistrationComplete")
public class DestinationRegistrationCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getで受信せず
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ownerIdをセッションから取得
		HttpSession session = request.getSession();
		Integer ownerId = (Integer)session.getAttribute("ownerId");

		//その他の新規登録情報をセッションから取得
		Integer genreId = (Integer)session.getAttribute("genreId");
		String name = (String)session.getAttribute("name");
		Integer evaluation = (Integer)session.getAttribute("evaluation");

		// 入力に不備がなければ、データの更新
		Destination destination = new Destination();
		destination.setOwnerId(ownerId);
		destination.setGenreId(genreId);
		destination.setName(name);
		destination.setEvaluation(evaluation);

		try {
			// データの更新
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			destinationDao.insert(destination);

			// 更新完了ページの表示
			request.getRequestDispatcher("/WEB-INF/view/destinationRegistrationComplete.jsp").forward(request,response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
