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
 * Servlet implementation class AddDetailImageServlet
 */
@WebServlet("/addDetailImage")
@MultipartConfig(location = "D:\\Users\\zd1P09\\tmp")
public class AddDetailImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/addDetailImage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// パラメータの取得
//		Integer destinationId = Integer.parseInt(request.getParameter("destinationId")); 
//		Integer imgId = Integer.parseInt(request.getParameter("imgId")); 
		String strCategory = (String) request.getParameter("imgCategory");
		Integer imgCategory = Integer.parseInt(strCategory);
		String comment = request.getParameter("comment");

		// 画像パラメータの取得
		Part part = request.getPart("upfile");
		String fileName = part.getSubmittedFileName();

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

		// データの追加
		DetailImage detailImage = new DetailImage();
		detailImage.setDestinationId(1);
		detailImage.setImgCategory(imgCategory);
		detailImage.setFileName(fileName);
		detailImage.setImg(bytes);
		detailImage.setComment(comment);

		try {
			DetailImageDao detailImageDao = DaoFactory.createDetailImageDao();
			detailImageDao.insert(detailImage);	
			request.getRequestDispatcher("/WEB-INF/view/addDetailImageDone.jsp").forward(request, response);
		
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
