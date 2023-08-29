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
 * Servlet implementation class UseSessionServlet
 */
@WebServlet("/useSession")
public class UseSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String item = (String) session.getAttribute("item");
		Member member = (Member)session.getAttribute("member");
		
		request.setAttribute("info1", "商品：" + "item");
		request.setAttribute("info2", member.toString());
		
		request.getRequestDispatcher("/WEB-INF/view/useSession.jsp").forward(request,response);

	}

}
