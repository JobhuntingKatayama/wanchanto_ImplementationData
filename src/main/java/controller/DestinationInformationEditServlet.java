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
 * Servlet implementation class DestinationInformationEditServlet
 */
@WebServlet("/destinationInformationEdit")
public class DestinationInformationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getから編集するお出掛け先IDの取得しセッションへ格納
		String strId = request.getParameter("destinationId");
		Integer destinationId = Integer.parseInt(strId);
		HttpSession session = request.getSession();
		session.setAttribute("destinationId", destinationId);

		try {
			// 編集するお出掛け先データの取得
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			Destination destination = destinationDao.findByDestinationId(destinationId);

			// 編集ページの表示
			request.setAttribute("genreId", destination.getGenreId());
			request.setAttribute("name", destination.getName());
			request.setAttribute("evaluation", destination.getEvaluation());
			
			request.getRequestDispatcher("/WEB-INF/view/destinationInformationEdit.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		// バリデーション用のフラグ
		boolean isError = false;

		// お出掛け先ジャンルの変更
		String genreId = request.getParameter("genreId");
		request.setAttribute("genreId", genreId);// 再表示用
		if (genreId!=null) {
				// 整数に変換できない場合の処理
				request.setAttribute("genreIdError", "お出掛け先ジャンルを指定してください。");
				isError = true;
		}
		
		// 各パラメータの取得とバリデーション
		String name = request.getParameter("name");
		request.setAttribute("name", name);// 再表示用
		if (name.isEmpty()) {
			// エラーメッセージの作成
			request.setAttribute("nameError", "名前が未入力です。");
			isError = true; // 入力に不備ありと判定
		}

		// 評価の変更
		String evaluation = request.getParameter("evaluation");
		request.setAttribute("evaluation", evaluation);// 再表示用

		// 入力不備がある場合は、フォームを再表示し、処理を中断
		if (isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/destinationInformationEdit.jsp").forward(request, response);
			return;
		}


			// 更新完了ページの表示
			request.getRequestDispatcher("/WEB-INF/view/destinationInformationEditConfirm.jsp").forward(request, response);
	}

}
