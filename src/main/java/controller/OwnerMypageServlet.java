package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Base64;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

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

			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/wanchanto");
			Connection con = ds.getConnection();

			// ownerIdと愛犬家のサムネイル画像の取得とリクエストへの格納
			int ownerId = 0;
			byte[] byteImg = null;
			String sql = "SELECT ownerId, img FROM owners WHERE loginId = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				ownerId = rs.getInt("ownerId");
				byteImg = rs.getBytes("img");
			}
			request.setAttribute("ownerId", ownerId);
			if (byteImg != null) {
				String strImg = Base64.getEncoder().encodeToString(byteImg);
				request.setAttribute("ownerImg", strImg);
			} else {
				request.setAttribute("ownerImg", null);
			}

			// ownerIdに紐づくdestinationIdを抽出
			int destinationId = 0;
			String sqlForDestination = "SELECT destinationId From destinations WHERE ownerId = ?;";
			PreparedStatement stmtForDestination = con.prepareStatement(sqlForDestination);
			stmtForDestination.setObject(1, ownerId, Types.INTEGER);
			ResultSet rsForDestination = stmtForDestination.executeQuery();
			if (rsForDestination.next() == true) {
				destinationId = (Integer) rsForDestination.getObject("destinationId");
			}
			request.setAttribute("destinationId", destinationId);

			// お出掛け先画像を１つ書き出してリクエストへ格納
			byte[] detailImage = null;
			String sqlForDetailImage = "SELECT img FROM detailimages WHERE destinationId = ? LIMIT 1;";
			PreparedStatement stmtForDetailImage = con.prepareStatement(sqlForDetailImage);
			stmtForDetailImage.setObject(1, destinationId, Types.INTEGER);
			ResultSet rsForDetailImage = stmtForDetailImage.executeQuery();
			if (rsForDetailImage.next() == true) {
				detailImage = rsForDetailImage.getBytes("img");
			}
			if (detailImage != null) {
				String strDetailImage = Base64.getEncoder().encodeToString(detailImage);
				request.setAttribute("destinationThumbnail", strDetailImage);
			} else {
				request.setAttribute("destinationThumbnail", null);
			}

			// OwnerDAOによるデータ取得
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			List<Owner> ownerList = ownerDao.findByOwnerId(ownerId);
			request.setAttribute("ownerList", ownerList);

			// DestinationDAOによるデータ取得
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			List<Destination> destinationList = destinationDao.findByOwnerId(ownerId);
			request.setAttribute("destinationList", destinationList);

//			//お出掛け先のイメージ画像のテーブルを取得してリストをリクエストへの格納
//			DetailImageDao detailImageDao = DaoFactory.createDetailImageDao();
//			List<DetailImage>detailImageList = detailImageDao.findByDestinationId(destinationId);
//			request.setAttribute("detailImageList", detailImageList);

		} catch (Exception e) {
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/WEB-INF/view/ownerMypage.jsp").forward(request, response);
	}

}