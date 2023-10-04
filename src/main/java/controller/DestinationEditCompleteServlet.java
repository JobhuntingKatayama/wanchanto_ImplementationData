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

		if (session.getAttribute("imgCategory") != null ) {
			
			// 画像情報をセッションから取得
			Integer imgCategory = (Integer) session.getAttribute("imgCategory");
			String comment = (String) session.getAttribute("comment");
			String fileName = (String) session.getAttribute("fileName");
			byte[] bytes = (byte[]) session.getAttribute("bytes");
			
			// お出掛け先画像（detailimages）
			DetailImage detailImage = new DetailImage();
			detailImage.setDestinationId(destinationId);
			detailImage.setImgCategory(imgCategory);
			detailImage.setFileName(fileName);
			detailImage.setActualImg(bytes);
			detailImage.setComment(comment);
			
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


			// 更新完了ページの表示
			request.getRequestDispatcher("/WEB-INF/view/destinationEditComplete.jsp").forward(request, response);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
