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

/**
 * Servlet implementation class DestinationRegistrationServlet
 */
@WebServlet("/destinationRegistration")
@MultipartConfig(location = "D:\\Users\\zd1P09\\tmp")
public class DestinationRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer ownerId = Integer.parseInt(request.getParameter("ownerId"));
		session.setAttribute("ownerId", ownerId);

		request.getRequestDispatcher("/WEB-INF/view/destinationRegistration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 登録情報の取得
		Integer genreId = Integer.parseInt(request.getParameter("genreId"));
		String name = (String) request.getParameter("name");
		String strEvaluation = (String) request.getParameter("evaluation");
		Integer evaluation = Integer.parseInt(strEvaluation);

		HttpSession session = request.getSession();

		// 画像の取得
		Part part = request.getPart("upfile");
		byte[] desImgBytes = null;
		String desImgData = null;
		String desImgName = null;
		if (part != null && part.getSize() > 0) {
			desImgName = part.getSubmittedFileName();
			session.setAttribute("desImgName", desImgName);

			// partオブジェクトをbyte[ ]に変換
			FileInputStream fis;
			if (part.getSize() > 0) {
				fis = (FileInputStream) part.getInputStream();
				desImgBytes = fis.readAllBytes();
		
				// 確認用に画像をエンコード
				desImgData = Base64.getEncoder().encodeToString(desImgBytes);
				session.setAttribute("desImgData", desImgData);
			}
		}

		// 取得した情報をセッションに格納
		session.setAttribute("genreId", genreId);
		session.setAttribute("name", name);
		session.setAttribute("evaluation", evaluation);
		session.setAttribute("desImgBytes", desImgBytes);
		

		// 確認ページへフォワード
		request.getRequestDispatcher("/WEB-INF/view/destinationRegistrationConfirm.jsp").forward(request, response);

	}

}