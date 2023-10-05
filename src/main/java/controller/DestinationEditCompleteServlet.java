package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.DestinationDao;
import dao.DetailImageDao;
import domain.Destination;
import domain.DetailImage;

/**
 * Servlet implementation class DestinationEditServlet
 */
@WebServlet("/destinationEditComplete")
@MultipartConfig(location = "D:\\Users\\zd1P09\\tmp")

public class DestinationEditCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getで受信せず

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// お出掛け先情報をセッションから取得
		Integer destinationId = (Integer) session.getAttribute("destinationId");
		Integer ownerId = (Integer) session.getAttribute("ownerId");
		Integer genreId = (Integer) session.getAttribute("genreId");
		String name = (String) session.getAttribute("name");
		byte[] desImg= (byte[]) session.getAttribute("desImg");
		Integer evaluation = (Integer) session.getAttribute("evaluation");


		// 入力に不備がなければ、データの更新
		Destination destination = new Destination();
		destination.setGenreId(ownerId);
		destination.setGenreId(genreId);
		destination.setDestinationId(destinationId);
		destination.setName(name);
		destination.setDesImg(desImg);
		destination.setEvaluation(evaluation);

		// 画像情報をセッションから取得
		if (session.getAttribute("newActualImgBytes") != null) {			
			byte[] newActualImgBytes = (byte[]) session.getAttribute("newActualImgBytes");
			Integer newImgCategory = (Integer) session.getAttribute("newImgCategory");
			String newImgComment = (String) session.getAttribute("newImgComment");
			
			// お出掛け先画像（detailimages）
			DetailImage detailImage = new DetailImage();
			detailImage.setDestinationId(destinationId);
			detailImage.setImgCategory(newImgCategory);
			detailImage.setActualImg(newActualImgBytes);
			detailImage.setComment(newImgComment);
			
			DetailImageDao detailImageDao = DaoFactory.createDetailImageDao();
			try {
				detailImageDao.insert(detailImage);
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		
		try {
			// データの更新
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			destinationDao.update(destination);

			//セッションの削除
			session.removeAttribute("destinationId");
			session.removeAttribute("genreId");
			session.removeAttribute("name");
			session.removeAttribute("desImg");
			session.removeAttribute("evaluation");
			session.removeAttribute("newActualImgBytes");
			session.removeAttribute("newActualImgData");
			session.removeAttribute("newImgCategory");
			session.removeAttribute("newImgComment");

			// 更新完了ページの表示
			request.getRequestDispatcher("/WEB-INF/view/destinationEditComplete.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
