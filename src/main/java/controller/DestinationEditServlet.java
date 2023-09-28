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
		String strDestinationId = request.getParameter("destinationId");
		Integer intDestinationId = Integer.parseInt(strDestinationId);
		session.setAttribute("destinationId", intDestinationId);

		try {
			// 編集するお出掛け先データの取得
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			Destination destination = destinationDao.findByDestinationId(intDestinationId);

			// お出掛け先データの情報をリクエストに格納
			request.setAttribute("destinationId", destination.getDestinationId());
			request.setAttribute("genreId", destination.getGenreId());
			request.setAttribute("name", destination.getName());
			request.setAttribute("evaluation", destination.getEvaluation());

			// お出掛け先のイメージ画像のテーブルを取得してリストをリクエストへの格納
			DetailImageDao detailImageDao = DaoFactory.createDetailImageDao();
			List<DetailImage> detailImageList = detailImageDao.findByDestinationId(intDestinationId);
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

		// destinationIdを取得してセッションに格納
		Integer intDestinationId = Integer.parseInt(request.getParameter("destinationId"));
		session.setAttribute("destinationId", intDestinationId);

		// お出掛け先ジャンル
		// 編集されたパラメータを取得しセッションに格納
		Integer intGenreId = Integer.parseInt(request.getParameter("genreId"));
		session.setAttribute("genreId", intGenreId);

//		// お出掛け先名前
//		// 編集されたパラメータを取得し取得しセッションに格納
		String strName = request.getParameter("name");
		session.setAttribute("name", strName);

//		// 評価の変更を取得しセッションに格納
		Integer intEvaluation = Integer.parseInt(request.getParameter("evaluation"));
		session.setAttribute("evaluation", intEvaluation);

		
		// 画像の登録有無の確認
		Part filePart = request.getPart("upfile");
		if (filePart != null && filePart.getSize() > 0) {
//		if (request.getParameter("imgCategory") != null && !request.getParameter("imgCategory").isEmpty()) {

			// 画像カテゴリーを取得しセッションに格納
			String strImgCategory = (String) request.getParameter("imgCategory");
			Integer imgCategory = Integer.parseInt(strImgCategory);
			session.setAttribute("imgCategory", imgCategory);

			// 画像コメントを取得しセッションに格納
			String comment = request.getParameter("comment");
			session.setAttribute("comment", comment);

			// 画像の取得しpartへ代入、ファイル名はセッションへ格納
			Part part = request.getPart("upfile");
			String fileName = part.getSubmittedFileName();
			session.setAttribute("fileName", fileName);

			// partオブジェクトをbyte[ ]に変換
			FileInputStream fis;
			byte[] bytes = null;
			String strBytes = null;
			if (part.getSize() > 0) {
				fis = (FileInputStream) part.getInputStream();
				bytes = fis.readAllBytes();
				// 確認用に画像をエンコード
				strBytes = Base64.getEncoder().encodeToString(bytes);
			}
			// 画像のエンコードされたものをセッションへ格納
			session.setAttribute("bytes", bytes);
			session.setAttribute("strBytes", strBytes);

		} 
//			else {
//			session.removeAttribute("imgCategory");
//			session.removeAttribute("comment");
//			session.removeAttribute("fileName");
//			session.removeAttribute("strBytes");
//		}

		// 上記に不備がある場合はdestinationEditを再表示
		if (isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/destinationEdit.jsp").forward(request, response);
			return;
		}

		// 問題なければConfirmの表示
		request.getRequestDispatcher("/WEB-INF/view/destinationEditConfirm.jsp").forward(request, response);
	}

}
