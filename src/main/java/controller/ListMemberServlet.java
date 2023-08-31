package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import domain.Member;

/**
 * Servlet implementation class ListMemberServlet
 */
@WebServlet("/listMember")
public class ListMemberServlet extends HttpServlet {
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
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mydb");
			con = ds.getConnection();
			System.out.println("接続完了");

			String sql = "SELECT * FROM members";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			List<Member> memberList = new ArrayList<>();
			while (rs.next()) {
				Integer id = (Integer) rs.getObject("id");
				String name = rs.getString("name");
				Integer age = (Integer) rs.getObject("age");
				String address = rs.getString("address");
				Integer typeId = (Integer) rs.getObject("type_id");
				Date created = rs.getTimestamp("created");

				Member member = new Member(id, name, age, address, typeId, created);
				memberList.add(member);
			}

			request.setAttribute("memberList", memberList);
			request.getRequestDispatcher("/WEB-INF/view/listMember.jsp").forward(request, response);

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