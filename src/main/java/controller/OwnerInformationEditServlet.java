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
			byte[] ownerImg = owner.getOwnerImg();
			String ownerImgData = owner.getOwnerImgData();
			String thumbnail = owner.getThumbnail();

			// ownerIdとサムネイル画像の情報をセッションスコープへ格納
			session.setAttribute("ownerId", ownerId);

			// 編集する愛犬家をリクエストスコープへ格納
			request.setAttribute("loginId", loginId);
			request.setAttribute("loginPassword", loginPassword);
			request.setAttribute("ownerImg", ownerImg);
			request.setAttribute("ownerImgData", ownerImgData);
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

		// 編集するownerIDをパラメーターから取得してセッションスコープへ格納
		Integer ownerId = Integer.parseInt(request.getParameter("ownerId"));

		

		// バリデーション用のフラグ
		boolean isError = false;

		// 各パラメータの取得とバリデーション
		String loginId = request.getParameter("loginId");
		session.setAttribute("loginId", loginId);// 入力されたloginIdをセッションへ格納

		String loginPassword = request.getParameter("loginPassword");
		session.setAttribute("loginPassword", loginPassword);// 入力されたloginPasswordをセッションへ格納

		// 画像がアップロードされたらそのデータをセッションへ格納
		if((request.getPart("newOwnerImg")).getSize() > 0) {
			Part part = request.getPart("newOwnerImg");
			String newOwnerImgFileName = part.getSubmittedFileName();
			
			// partオブジェクトをbyte[ ]に変換
			FileInputStream fis;
			byte[] newOwnerImgBytes=null;
			String newOwnerImgData=null;
			if(part.getSize()>0) {
				fis = (FileInputStream)part.getInputStream();
				newOwnerImgBytes = fis.readAllBytes();
				//確認用に画像をエンコード
				newOwnerImgData = Base64.getEncoder().encodeToString(newOwnerImgBytes);
				
				session.setAttribute("ownerImg", newOwnerImgBytes);
				session.setAttribute("ownerImgData", newOwnerImgData);
				session.setAttribute("thumbnail", newOwnerImgFileName);
			} 
		} else {
			try {
				// 編集する愛犬家データを取得してownerに格納
				OwnerDao ownerDao = DaoFactory.createOwnerDao();
				Owner owner = ownerDao.findByOwnerId(ownerId);
				
				// 愛犬家サムネイル画像をセッションへ格納
				session.setAttribute("ownerImg", owner.getOwnerImg());
				session.setAttribute("ownerImgData", owner.getOwnerImgData());
				session.setAttribute("thumbnail", owner.getThumbnail());

			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
//		String ownerImg = (String) request.getAttribute("ownerImg");
//		Part part = request.getPart(ownerImg);
//		String thumbnail = part.getSubmittedFileName();

//		Part part = request.getPart("ownerImg");
//		String thumbnail = (String) request.getAttribute("thunbnail");
//		if ((Object) request.getPart("ownerImg") != null) {
//			part = request.getPart("ownerImg");
//			thumbnail = part.getSubmittedFileName();
//			request.setAttribute("thumbnail", thumbnail);
//		}
//		// partオブジェクトをbyte[ ]に変換
//		FileInputStream fis;
//		byte[] ownerImgBytes = (byte[]) request.getAttribute("ownerImg");
//		String ownerImgData = null;
//		if (part.getSize() > 0) {
//			fis = (FileInputStream) part.getInputStream();
//			ownerImgBytes = fis.readAllBytes();
//			// 確認用に画像をエンコード
//			ownerImgData = Base64.getEncoder().encodeToString(ownerImgBytes);
//		}
//
//		session.setAttribute("ownerImg", ownerImgBytes);// 画像ファイルをセッションへ格納
//		session.setAttribute("ownerImgData", ownerImgData);// 画像ファイルをエンコードした情報をセッションへ格納
//		session.setAttribute("thumbnail", thumbnail);// 画像ファイル名をセッションへ格納

		// 入力不備がある場合は、フォームを再表示し、処理を中断
		if (isError == true) {
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationEdit.jsp").forward(request, response);
			return;
		}

		// submitでConfirmへPostフォワード
		request.getRequestDispatcher("/WEB-INF/view/ownerInformationEditConfirm.jsp").forward(request, response);

	}

}