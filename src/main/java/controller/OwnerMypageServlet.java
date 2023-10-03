package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.DestinationDao;
import dao.OwnerDao;
import domain.Destination;
import domain.Owner;


@WebServlet("/ownerMypage")
public class OwnerMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			String loginId = (String) session.getAttribute("loginId");

			// OwnerDAOによるデータ取得
			OwnerDao OwnerDao = DaoFactory.createOwnerDao();
			Owner owner = OwnerDao.findByLoginId(loginId);
			session.setAttribute("owner", owner);
			int ownerId = owner.getOwnerId();

			// DestinationDAOによるデータ取得
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			List<Destination> destinationList = destinationDao.findByOwnerId(ownerId);
			
			// リクエスト属性に設定
			request.setAttribute("destinationList",destinationList);

		} catch (Exception e) {
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/WEB-INF/view/ownerMypage.jsp").forward(request, response);
	}

}