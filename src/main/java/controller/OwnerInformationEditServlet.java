package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.OwnerDao;
import domain.Owner;

/**
 * Servlet implementation class OwnerInformationEditServlet
 */
@WebServlet("/ownerInformationEdit")
public class OwnerInformationEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
//		String loginId = (String) session.getAttribute("loginId");

		// 編集するownerIDの取得とセッションスコープへ格納
		String strId = request.getParameter("ownerId");
		Integer ownerId = Integer.parseInt(strId);
		session.setAttribute("ownerId", ownerId);

		try {
			// 編集するownerデータの取得
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			List<Owner> ownerList = ownerDao.findByOwnerId(ownerId);

			for (Owner owner : ownerList) {
				String loginId = owner.getLoginId();
				String loginPassword = owner.getLoginPassword();
				String imgData = owner.getImgData();
				// 編集するownerデータをリクエストスコープへ格納
				request.setAttribute("loginId", loginId);
				request.setAttribute("loginPassword", loginPassword);
				request.setAttribute("ownerImg", imgData);
			}

			// 編集するownerデータを編集ページで表示
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

		// 入力不備がある場合は、フォームを再表示し、処理を中断
		if (isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationEdit.jsp").forward(request, response);
			return;
		}

		// submitでConfirmへPostフォワード
		request.getRequestDispatcher("/WEB-INF/view/ownerInformationEditConfirm.jsp").forward(request, response);

	}

}