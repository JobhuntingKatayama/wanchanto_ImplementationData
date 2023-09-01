package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String strOwnerId = request.getParameter("ownerId");
		Integer ownerId = Integer.parseInt(strOwnerId);

		try {
			// 編集する会員データの取得
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			Owner owner = ownerDao.findById(ownerId);

			// 編集ページの表示
			request.setAttribute("loginId", owner.getLoginId());
			request.setAttribute("loginPassword", owner.getLoginPassword());
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationEdit.jsp").forward(request, response);

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

		// 編集する会員のIDの取得
		String strOwnerId = request.getParameter("ownerId");
		Integer ownerId = Integer.parseInt(strOwnerId);

		// バリデーション用のフラグ
		boolean isError = false;

		// 各パラメータの取得とバリデーション
		String loginId = request.getParameter("loginId");
		request.setAttribute("loginId", loginId);// 再表示用
		if (loginId.isEmpty()) {
			// エラーメッセージの作成
			request.setAttribute("loginIdError", "ログインIDが未入力です.");
			isError = true;
		}

		String loginPassword = request.getParameter("loginPassword");
		request.setAttribute("loginPassword", loginPassword);// 再表示用
		if (loginPassword.isEmpty()) {
			request.setAttribute("loginPasswordError", "パスワードが未入力です.");
			isError = true;
		}

		// 入力不備がある場合は、フォームを再表示し、処理を中断
		if (isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationEdit.jsp").forward(request, response);
			return;
		}

		// 入力に不備がなければ、データの更新
		Owner owner = new Owner();
		owner.setOwnerId(ownerId);
		owner.setLoginId(loginId);
		owner.setLoginPassword(loginPassword);
		try {
			// データの更新
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			ownerDao.update(owner);

			// 更新完了ページの表示
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationEditComplete.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
