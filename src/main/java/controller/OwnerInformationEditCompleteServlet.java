package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import dao.DaoFactory;
import dao.OwnerDao;
import domain.Owner;

/**
 * Servlet implementation class OwnerRegistrationConfirmServlet
 */
@WebServlet("/ownerInformationEditComplete")
public class OwnerInformationEditCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//getは受信せず
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Editページからポストされた情報をセッションスコープから取得してキャスト
		HttpSession session = request.getSession();
		Integer ownerId =(Integer)session.getAttribute("ownerId");
		String loginId =(String) session.getAttribute("loginId");
		String loginPassword =(String) session.getAttribute("loginPassword");

		//パスワードをハッシュ化
		String hashedPassword = BCrypt.hashpw(loginPassword, BCrypt.gensalt());
		
		// 入力に不備がなければ、データの更新
		Owner owner = new Owner();
		owner.setOwnerId(ownerId);
		owner.setLoginId(loginId);
		owner.setLoginPassword(hashedPassword);
		
		try {
			// データの更新
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			ownerDao.update(owner);

			// 更新完了ページの表示
			request.getRequestDispatcher("/WEB-INF/view/ownerInformationEditComplete.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
