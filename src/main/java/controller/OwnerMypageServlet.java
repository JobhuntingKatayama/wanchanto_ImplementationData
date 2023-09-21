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
			request.setAttribute("owner", owner);
			int ownerId = owner.getOwnerId();
			byte[] img = owner.getImg();

			// ownerIdと愛犬家のサムネイル画像の取得とリクエストへの格納
			request.setAttribute("ownerId", ownerId);
			if (img != null) {
				request.setAttribute("ownerImg", img);
			}else {
				request.setAttribute("ownerImg", null);
			}

			// DestinationDAOによるデータ取得
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			List<Destination> destinationList = destinationDao.findByOwnerId(ownerId);
			request.setAttribute("destinationList", destinationList);
			
//			int destinationId = 0;
//			for (Destination destination : destinationList) {
//				destinationId = destination.getDestinationId();
//			}

//
//			// お出掛け先画像を１つ書き出してリクエストへ格納
//			byte[] detailImage = null;
//			String sqlForDetailImage = "SELECT img FROM detailimages WHERE destinationId = ? LIMIT 1;";
//			PreparedStatement stmtForDetailImage = con.prepareStatement(sqlForDetailImage);
//			stmtForDetailImage.setObject(1, destinationId, Types.INTEGER);
//			ResultSet rsForDetailImage = stmtForDetailImage.executeQuery();
//			if (rsForDetailImage.next() == true) {
//				detailImage = rsForDetailImage.getBytes("img");
//			}
//			if (detailImage != null) {
//				String strDetailImage = Base64.getEncoder().encodeToString(detailImage);
//				request.setAttribute("destinationThumbnail", strDetailImage);
//			} else {
//				request.setAttribute("destinationThumbnail", null);
//			}

		} catch (Exception e) {
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/WEB-INF/view/ownerMypage.jsp").forward(request, response);
	}

}