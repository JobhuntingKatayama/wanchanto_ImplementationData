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

/**
 * Servlet implementation class ListDestinationServlet
 */
@WebServlet("/ownerMypage")
public class OwnerMypageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private static final Integer Integer = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession session = request.getSession();
			String loginId = (String) session.getAttribute("loginId");

//			InitialContext ctx = new InitialContext();
//			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/wanchanto");
//			Connection con = ds.getConnection();

			// OwnerDAOによるデータ取得
			OwnerDao OwnerDao = DaoFactory.createOwnerDao();
			Owner owner = OwnerDao.findByLoginId(loginId);
			session.setAttribute("owner", owner);
			int ownerId = owner.getOwnerId();
			byte[] img = owner.getImg();

			// ownerIdと愛犬家のサムネイル画像の取得とリクエストへの格納
			session.setAttribute("ownerId", ownerId);
			if (img != null) {
				session.setAttribute("img", img);
			}else {
				session.setAttribute("img", null);
			}

			// DestinationDAOによるデータ取得
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			List<Destination> destinationList = destinationDao.findByOwnerId(ownerId);
			request.setAttribute("destinationList", destinationList);
			
//			// 重複を排除するためにHashSetを使用
//			Set<Integer> uniqueDestinationIds = new HashSet<>();
//			List<Destination> uniqueDestinationList = new ArrayList<>();
//
//			for (Destination destination : destinationList) {
//			    Integer destinationId = destination.getDestinationId();
//
//			    // HashSetに追加し、重複をチェック
//			    if (uniqueDestinationIds.add(destinationId)) {
//			        // 重複しない場合、新しいリストに追加
//			        uniqueDestinationList.add(destination);
//			    }
//			}

			// リクエスト属性に設定
			request.setAttribute("destinationList", /* unique */destinationList);

		} catch (Exception e) {
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/WEB-INF/view/ownerMypage.jsp").forward(request, response);
	}

}