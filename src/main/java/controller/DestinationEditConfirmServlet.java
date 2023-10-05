package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DestinationEditServlet
 */
@WebServlet("/destinationEditConfirm")
@MultipartConfig(location = "D:\\Users\\zd1P09\\tmp")

public class DestinationEditConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		HttpSession session = request.getSession();
//		Integer destinationId = (Integer) session.getAttribute("destinatinId");
//		session.setAttribute("destinationId", destinationId);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Editページからポストされた情報をセッションスコープから取得
		HttpSession session = request.getSession();
		session.getAttribute("destinationId");
		session.getAttribute("genreId");
		session.getAttribute("name");
		session.getAttribute("evaluation");
		session.getAttribute("desImg");
		session.getAttribute("desImgData");
		if (session.getAttribute("newActualImgBytes") != null) {
			session.getAttribute("newActualImgBytes");
			session.getAttribute("newActualImgData");
			session.getAttribute("newImgCategory");
			session.getAttribute("newImgComment");
		} else {
			//画像の新規追加がない場合はセッションを削除
			session.removeAttribute("newActualImgBytes");
			session.removeAttribute("newImgCategory");
			session.removeAttribute("newImgComment");
			session.removeAttribute("newActualImgData");
		}

		request.getRequestDispatcher("/WEB-INF/view/destinationEditConfirm.jsp").forward(request, response);

	}

}
