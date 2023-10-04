package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.OwnerDao;
import domain.Owner;

/**
 * Servlet implementation class OwnerRegistrationConfirmServlet
 */
@WebServlet("/ownerRegistrationComplete")
public class OwnerRegistrationCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//getは受信せず

	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String loginId =(String)session.getAttribute("loginId");
		String loginPassword =(String)session.getAttribute("loginPassword");
		String thumbnail =(String)session.getAttribute("thumbnail");
		byte[] ownerImg = (byte[])session.getAttribute("ownerImg");
		String ownerImgData =(String)session.getAttribute("ownerImgData");
		
		// 入力に不備がなければ、データの更新
		Owner owner = new Owner();
		owner.setLoginId(loginId);
		owner.setLoginPassword(loginPassword);
		owner.setThumbnail(thumbnail);
		owner.setOwnerImg(ownerImg);
		owner.setOwnerImgData(ownerImgData);

		try {
			// データの更新
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			ownerDao.insert(owner);

			// 更新完了ページの表示
			request.getRequestDispatcher("/WEB-INF/view/ownerRegistrationComplete.jsp").forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}



}
