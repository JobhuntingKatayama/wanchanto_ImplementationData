package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Member;

/**
 * Servlet implementation class SaveSessionServlet
 */
@WebServlet("/saveSession")
public class SaveSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("item", "テレビ");
		session.setAttribute("member", new Member("山田太郎",28));
		
		request.getRequestDispatcher("/WEB-INF/view/saveSession.jsp").forward(request, response);
	
	}

}
