package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.DaoFactory;
import dao.DestinationDao;
import dao.DetailImageDao;
import domain.Destination;
import domain.DetailImage;

/**
 * Servlet implementation class DestinationEditServlet
 */
@WebServlet("/destinationEdit")
@MultipartConfig(location = "D:\\Users\\zd1P09\\tmp")

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
		Integer destinationId = Integer.parseInt(request.getParameter("destinationId"));
		session.setAttribute("destinationId", destinationId);

		try {
			// 編集するお出掛け先データの取得
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			Destination destination = destinationDao.findByDestinationId(destinationId);

			// お出掛け先データの情報をリクエストに格納
			request.setAttribute("destinationId", destination.getDestinationId());
			request.setAttribute("genreId", destination.getGenreId());
			request.setAttribute("name", destination.getName());
			request.setAttribute("evaluation", destination.getEvaluation());
			
			//イメージはセッションへ格納
			session.setAttribute("desImg", destination.getDesImg());
			session.setAttribute("desImgData", destination.getDesImgData());

			// お出掛け先のイメージ画像のテーブルを取得してリストをセッションへの格納
			DetailImageDao detailImageDao = DaoFactory.createDetailImageDao();
			List<DetailImage> detailImageList = detailImageDao.findByDestinationId(destinationId);
			request.setAttribute("detailImageList", detailImageList);

			// 画像削除のためimgIdを取得してリクエストに格納
			request.getParameter("imgId");

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

		// 各入力情報を取得してセッションに格納
		Integer intDestinationId = Integer.parseInt(request.getParameter("destinationId"));
		Integer intGenreId = Integer.parseInt(request.getParameter("genreId"));
		String name = (String) request.getParameter("name");
		Integer intEvaluation = Integer.parseInt(request.getParameter("evaluation"));
		
		session.setAttribute("destinationId", intDestinationId);
		session.setAttribute("genreId", intGenreId);
		session.setAttribute("name", name);
		session.setAttribute("evaluation", intEvaluation);

		
		// 画像の登録有無の確認
		if (request.getPart("newActualImg").getSize() > 0) {

			FileInputStream fis;
			byte[] newActualImgBytes = null;
			String newActualImgData = null;

			// 画像カテゴリーを取得しセッションに格納
			Integer newImgCategory = Integer.parseInt(request.getParameter("newImgCategory"));

			// 画像コメントを取得しセッションに格納
			String newImgComment = request.getParameter("newImgComment");

			// 画像を取得しpartへ代入
			Part part = request.getPart("newActualImg");

			// partオブジェクトをbyte[ ]に変換
			fis = (FileInputStream) part.getInputStream();
			newActualImgBytes = fis.readAllBytes();

			// 確認用に画像をエンコード
			newActualImgData = Base64.getEncoder().encodeToString(newActualImgBytes);

			// 追加された画像の情報をセッションへ格納
			session.setAttribute("newImgCategory", newImgCategory);
			session.setAttribute("newImgComment", newImgComment);
			session.setAttribute("newActualImgBytes", newActualImgBytes);
			session.setAttribute("newActualImgData", newActualImgData);

		}
		// 上記に不備がある場合はdestinationEditを再表示
		if (isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/destinationEdit.jsp").forward(request, response);
			return;
		}

		// 問題なければConfirmの表示
		request.getRequestDispatcher("/WEB-INF/view/destinationEditConfirm.jsp").forward(request, response);
	}

}
