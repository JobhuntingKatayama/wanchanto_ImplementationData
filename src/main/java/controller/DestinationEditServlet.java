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
 * Servlet implementation class DestinationEditServlet
 */
@WebServlet("/destinationEdit")
public class DestinationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		
		// getから編集するお出掛け先IDの取得しセッションへ格納
		String strDestinationId = request.getParameter("destinationId");
		Integer intDestinationId = Integer.parseInt(strDestinationId);
		session.setAttribute("destinationId", intDestinationId);

		try {
			// 編集するお出掛け先データの取得
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			Destination destination = destinationDao.findByDestinationId(intDestinationId);

			// データの情報をリクエストに格納
			request.setAttribute("genreId", destination.getGenreId());
			request.setAttribute("name", destination.getName());
			request.setAttribute("evaluation", destination.getEvaluation());

			// ページの出力（フォワード）
			request.getRequestDispatcher("/WEB-INF/view/destinationEdit.jsp").forward(request, response);

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
		
		HttpSession session = request.getSession();
		
		// バリデーション用のフラグ
		boolean isError = false;

//		// お出掛け先ジャンル
//		// 編集されたパラメータを取得しリクエストにnewとして格納
		Integer intGenreId = Integer.parseInt(request.getParameter("genreId"));
		session.setAttribute("genreId", intGenreId);

//		// お出掛け先名前
//		// 編集されたパラメータを取得しリクエストにnewとして格納
		String strName = request.getParameter("name");
		session.setAttribute("name", strName);

//		// 評価の変更をリクエストにnewとして格納
		Integer intEvaluation = Integer.parseInt(request.getParameter("evaluation"));
		session.setAttribute("evaluation", intEvaluation);

		// 上記に不備がある場合はdestinationEditを再表示
		if (isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/destinationEdit.jsp").forward(request, response);
			return;
		}

		// 問題なければConfirmの表示
		request.getRequestDispatcher("/WEB-INF/view/destinationEditConfirm.jsp").forward(request, response);
	}

}
