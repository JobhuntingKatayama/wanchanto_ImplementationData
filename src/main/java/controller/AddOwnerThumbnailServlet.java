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
 * Servlet implementation class AddOwnerThumbnailServlet
 */
@WebServlet("/addOwnerThumbnail")
@MultipartConfig(location = "D:\\Users\\zd1P09\\tmp")

public class AddOwnerThumbnailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			// 編集するownerIDをパラメーターから取得してセッションスコープへ格納
			Integer ownerId = Integer.parseInt(request.getParameter("ownerId"));

			HttpSession session = request.getSession();

			// 編集する愛犬家データを取得してownerに格納
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			Owner owner = ownerDao.findByOwnerId(ownerId);
			request.setAttribute("owner", owner);

			//愛犬家サムネイルをキャストしてリクエストへ格納
			byte[] img = owner.getImg();
			String imgData = owner.getImgData();
			String thumbnail = owner.getThumbnail();
			request.setAttribute("img", img);
			request.setAttribute("imgData", imgData);
			request.setAttribute("thumbnail", thumbnail);

		} catch (Exception e) {
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/WEB-INF/view/addOwnerThumbnail.jsp").forward(request, response);
		
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
//		HttpSession session = request.getSession();
//		session.setAttribute("img", bytes);// 画像ファイルをセッションへ格納
//		session.setAttribute("imgData", imgData);// 画像ファイルをエンコードした情報をセッションへ格納
//		session.setAttribute("thumbnail", thumbnail);// 画像ファイル名をセッションへ格納
		HttpSession session = request.getSession();
		Integer ownerId =(Integer)session.getAttribute("ownerId");
		String loginId =(String) session.getAttribute("loginId");

		// 入力に不備がなければ、データの更新
		Owner owner = new Owner();
		owner.setOwnerId(ownerId);
		owner.setLoginId(loginId);
		owner.setImg(bytes);
		owner.setImgData(imgData);
		owner.setThumbnail(thumbnail);

		try {
			// データの更新
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			ownerDao.update(owner);

			// 編集ページの表示
			request.getRequestDispatcher("/WEB-INF/view/ownerMypage.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
}
