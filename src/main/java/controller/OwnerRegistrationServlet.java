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

import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class OwnerRegistrationServlet
 */
@WebServlet("/ownerRegistration")
@MultipartConfig(location = "D:\\Users\\zd1P09\\tmp")
public class OwnerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/ownerRegistration.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String loginId = request.getParameter("loginId");
		String loginPassword = request.getParameter("loginPassword");
		String hashedPassword = BCrypt.hashpw(loginPassword, BCrypt.gensalt());

		// 画像の取得
		Part part = request.getPart("upfile");
		String thumbnail = part.getSubmittedFileName();

		// partオブジェクトをbyte[ ]に変換
		FileInputStream fis;
		byte[] bytes=null;
		String imgData=null;
		if(part.getSize()>0) {
			fis = (FileInputStream)part.getInputStream();
			bytes = fis.readAllBytes();
			//確認用に画像をエンコード
			imgData = Base64.getEncoder().encodeToString(bytes);
		} 
		
		session.setAttribute("loginId", loginId);
		session.setAttribute("loginPassword", hashedPassword);
		session.setAttribute("thumbnail", thumbnail);
		session.setAttribute("img", bytes);
		session.setAttribute("imgData", imgData);

		request.getRequestDispatcher("/WEB-INF/view/ownerRegistrationConfirm.jsp").forward(request, response);

	}

}
