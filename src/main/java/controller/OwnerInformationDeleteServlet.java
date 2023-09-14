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
 * Servlet implementation class OwnerInformationDeleteServlet
 */
@WebServlet("/ownerInformationDelete")
public class OwnerInformationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//削除する会員のIDの取得
		String strId = request.getParameter("ownerId");
		Integer ownerId = Integer.parseInt(strId);

		try {
			// 削除する会員データの取得
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			Owner owner = ownerDao.findById(ownerId);
			// 削除ページの表示
			request.setAttribute("owner", owner);
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationDelete.jsp").forward(request, response);
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

		//削除する会員のIDの取得
		String strId = request.getParameter("ownerId");
		Integer ownerId = Integer.parseInt(strId);

		// 削除メソッドの引数用にOwnerオブジェクトを作成
		Owner owner = new Owner();
		owner.setOwnerId(ownerId);

		try {
			// データの削除
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			ownerDao.delete(owner);

			//セッションの削除とログアウト完了ページのフォワード
			request.getSession().invalidate();
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationDeleteComplete.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
