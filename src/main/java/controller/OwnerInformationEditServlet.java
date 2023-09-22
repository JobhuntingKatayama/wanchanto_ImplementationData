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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.DaoFactory;
import dao.OwnerDao;
import domain.Owner;

/**
 * Servlet implementation class OwnerInformationEditServlet
 */
@WebServlet("/ownerInformationEdit")
@MultipartConfig(location = "D:\\Users\\zd1P09\\tmp")

public class OwnerInformationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 編集するownerIDをパラメーターから取得してセッションスコープへ格納
			Integer ownerId = Integer.parseInt(request.getParameter("ownerId"));

			HttpSession session = request.getSession();

			// 編集する愛犬家データを取得してownerに格納
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			Owner owner = ownerDao.findByOwnerId(ownerId);
			request.setAttribute("owner", owner);

			// それぞれの愛犬家データをキャスト
			String loginId = owner.getLoginId();
			String loginPassword = owner.getLoginPassword();
			byte[] img = owner.getImg();
			String imgData = owner.getImgData();
			String thumbnail = owner.getThumbnail();

			// ownerIdとサムネイル画像の情報をセッションスコープへ格納
			session.setAttribute("ownerId", ownerId);

			// 編集する愛犬家をリクエストスコープへ格納
			request.setAttribute("loginId", loginId);
			request.setAttribute("loginPassword", loginPassword);
			request.setAttribute("img", img);
			request.setAttribute("imgData", imgData);
			request.setAttribute("thumbnail", thumbnail);

			// 編集ページへフォワード
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationEdit.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// バリデーション用のフラグ
		boolean isError = false;

		// 各パラメータの取得とバリデーション
		String loginId = request.getParameter("loginId");
		session.setAttribute("loginId", loginId);// 入力されたloginIdをセッションへ格納
//		if (loginId.isEmpty()) {
//			// エラーメッセージの作成
//			request.setAttribute("loginIdError", "ログインIDが未入力です。");
//			isError = true; // 入力に不備ありと判定
//		}

		String loginPassword = request.getParameter("loginPassword");
		session.setAttribute("loginPassword", loginPassword);// 入力されたloginPasswordをセッションへ格納
//		if (loginPassword.isEmpty()) {
//			// エラーメッセージの作成
//			request.setAttribute("loginPasswordError", "パスワードが未入力です。");
//			isError = true; // 入力に不備ありと判定
//		}

		// 画像が更新・アップロードされたらそのデータをセッションへ格納
		Part part = request.getPart("upfile");
		String thumbnail = part.getSubmittedFileName();

		// partオブジェクトをbyte[ ]に変換
		FileInputStream fis;
		byte[] bytes = null;
		String imgData = null;
		if (part.getSize() > 0) {
			fis = (FileInputStream) part.getInputStream();
			bytes = fis.readAllBytes();
			// 確認用に画像をエンコード
			imgData = Base64.getEncoder().encodeToString(bytes);
		}
		
		session.setAttribute("img", bytes);// 画像ファイルをセッションへ格納
		session.setAttribute("imgData", imgData);// 画像ファイルをエンコードした情報をセッションへ格納
		session.setAttribute("thumbnail", thumbnail);// 画像ファイル名をセッションへ格納

		// 入力不備がある場合は、フォームを再表示し、処理を中断
		if (isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationEdit.jsp").forward(request, response);
			return;
		}

		// submitでConfirmへPostフォワード
		request.getRequestDispatcher("/WEB-INF/view/ownerInformationEditConfirm.jsp").forward(request, response);

	}

}