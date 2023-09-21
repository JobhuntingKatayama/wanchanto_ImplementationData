package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DaoFactory;
import dao.DetailImageDao;
import domain.DetailImage;

/**
 * Servlet implementation class UpdateDetailImageServlet
 */
@WebServlet("/updateDetailImage")
@MultipartConfig(location = "D:\\Users\\zd1P09\\tmp")

public class UpdateDetailImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 画像削除のためimgIdを取得してリクエストに格納
		Integer imgId = Integer.parseInt(request.getParameter("imgId"));

		try {
			// お出掛け先のイメージ画像のテーブルを取得してリストをリクエストへの格納
			DetailImageDao detailImageDao = DaoFactory.createDetailImageDao();
			DetailImage detailImage = detailImageDao.findByImgId(imgId);

			// 画像情報をリクエストへ格納
			request.setAttribute("img", detailImage.getImg());
			request.setAttribute("fileName", detailImage.getFileName());
			request.setAttribute("imgCategory", detailImage.getImgCategory());
			request.setAttribute("comment", detailImage.getComment());

			// 画像情報変更ページへのフォワード
			request.getRequestDispatcher("/WEB-INF/view/updateDetailImage.jsp").forward(request, response);

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

		// 画像削除のためimgIdを取得してリクエストに格納
		Integer imgId = Integer.parseInt(request.getParameter("imgId"));

		// バリデーション用のフラグ
		boolean isError = false;

		// 画像カテゴリーを取得しセッションに格納
		String strImgCategory = (String) request.getParameter("imgCategory");
		Integer imgCategory = Integer.parseInt(strImgCategory);
		request.setAttribute("imgCategory", imgCategory);

		// 画像コメントを取得しセッションに格納
		String comment = request.getParameter("comment");
		request.setAttribute("comment", comment);

		// 画像の取得しpartへ代入、ファイル名はセッションへ格納
		Part part = request.getPart("upfile");
		String fileName = part.getSubmittedFileName();
		request.setAttribute("fileName", fileName);

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
		request.setAttribute("bytes", bytes);
		request.setAttribute("strBytes", strBytes);

		// 上記に不備がある場合はdestinationEditを再表示
		if (isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/updateDetailImage.jsp").forward(request, response);
			return;
		}

		// 入力に不備がなければデータの更新
		DetailImage detailImage = new DetailImage();
		detailImage.setImgId(imgId);
		detailImage.setImg(bytes);
		detailImage.setFileName(fileName);
		detailImage.setImgCategory(imgCategory);
		detailImage.setComment(comment);
		try {
			// データの更新
			DetailImageDao detailImageDao = DaoFactory.createDetailImageDao();
			detailImageDao.update(detailImage);
			
			//お出掛け先編集ページへ戻る
			request.getRequestDispatcher("/WEB-INF/view/updateDetailImageDone.jsp").forward(request, response);			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

}
