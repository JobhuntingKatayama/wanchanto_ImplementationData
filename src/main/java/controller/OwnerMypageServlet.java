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

			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			List<Destination> destinationList = destinationDao.findAll();

			request.setAttribute("destinationList", destinationList);

			HttpSession session = request.getSession();
			String loginId = (String) session.getAttribute("loginId");
			session.setAttribute("loginId", loginId);

			int odid = 0;

			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/wanchanto");
			Connection con = ds.getConnection();

			String sql = "SELECT ownerId FROM owners WHERE loginId = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId); // プレースホルダーに変数の値を設定
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				odid = rs.getInt("ownerId");
			}
			request.setAttribute("ownerId", odid);

		} catch (Exception e) {
			throw new ServletException(e);
		}

		request.getRequestDispatcher("/WEB-INF/view/ownerMypage.jsp").forward(request, response);
	}
}
