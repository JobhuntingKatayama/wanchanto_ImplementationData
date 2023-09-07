package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			String strLoginId = (String) session.getAttribute("loginId");

			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/wanchanto");
			Connection con = ds.getConnection();

			int odid = 0;
			String sql = "SELECT ownerId FROM owners WHERE loginId = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, strLoginId); // プレースホルダーに変数の値を設定
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				odid = rs.getInt("ownerId");
			}
			request.setAttribute("ownerId", odid);
						
			//OwnerDAOによるデータ取得
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			List<Owner> ownerList = ownerDao.findByOwnerId(odid);
			// JSP へフォワード
			request.setAttribute("ownerList", ownerList);
			
			//DestinationDAOによるデータ取得
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			List<Destination> destinationList = destinationDao.findByOwnerId(odid);
			// JSP へフォワード
			request.setAttribute("destinationList", destinationList);
			
		} catch (Exception e) {
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/WEB-INF/view/ownerMypage.jsp").forward(request, response);
	}
}