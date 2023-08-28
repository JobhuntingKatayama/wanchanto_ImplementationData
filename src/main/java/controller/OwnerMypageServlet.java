package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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
		Connection con = null;
		try {
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/wanchanto");
			con = ds.getConnection();

			String sql = "SELECT * FROM destinations";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			List<Destination>destinationList = new ArrayList<>();
			while (rs.next()) {
				Integer genreId =(Integer)rs.getObject("genreId");
				String name = rs.getString("name");
				Integer evaluation =(Integer)rs.getObject("evaluation");
				
				Destination destination = new Destination(genreId,name,evaluation);
				destinationList.add(destination);
				
				request.setAttribute("destinationList", destinationList);
				request.getRequestDispatcher("/WEB-INF/view/ownerMypage.jsp").forward(request, response);
			}

		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}
	}

}
