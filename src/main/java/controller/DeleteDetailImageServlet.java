package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.DetailImageDao;
import domain.DetailImage;

/**
 * Servlet implementation class DeleteDetailImageServlet
 */
@WebServlet("/deleteDetailImage")
public class DeleteDetailImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 削除するimgIdの取得
		Integer imgId = Integer.parseInt(request.getParameter("imgId"));

		try {
			// 削除する画像のデータを取得
			DetailImageDao detailImageDao = DaoFactory.createDetailImageDao();
			DetailImage detailImage = detailImageDao.findByImgId(imgId);

			// 削除ページの表示
			request.setAttribute("detailImage", detailImage);
			request.getRequestDispatcher("/WEB-INF/view/deleteDetailImage.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//削除するimgIdの取得
		Integer imgId=Integer.parseInt(request.getParameter("imgId"));
		
		//削除メソッドの引数用にdetailImage オブジェクトを作成
		DetailImage detailImage=new DetailImage();
		detailImage.setImgId(imgId);
		
		try {
			//データの削除
			DetailImageDao detailImageDao =DaoFactory.createDetailImageDao();
			detailImageDao.delete(detailImage);
			
			//削除完了ページの表示（お出掛け先情報編集ページへ戻る）
			request.getRequestDispatcher("/WEB-INF/view/deleteDetailImageComplete.jsp").forward(request, response);
			
			} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
