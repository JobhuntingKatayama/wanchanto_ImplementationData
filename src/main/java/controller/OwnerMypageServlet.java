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
import domain.Destination;

/**
 * Servlet implementation class ListDestinationServlet
 */
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
			String strLoginId = (String) session.getAttribute("loginId");
//			Integer IntOwnerId = (Integer) session.getAttribute("ownerId"); // セッションからownerIdを取得
//			String strOwnerId = String.valueOf(IntOwnerId);

			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/wanchanto");
			Connection con = ds.getConnection();

			int odid = 0;
			String sql = "SELECT ownerId FROM owners WHERE loginId = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, strLoginId); // プレースホルダーに変数の値を設定
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				odid = rs.getInt("ownerId");
			}
			request.setAttribute("ownerId", odid);
						
			//DestinationDAOによるデータ取得
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			List<Destination> destinationList = destinationDao.findAll();
			// JSP へフォワード
			request.setAttribute("destinationList", destinationList);
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/WEB-INF/view/ownerMypage.jsp").forward(request, response);
	}
}
