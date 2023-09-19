package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import dao.DetailImageDao;
import dao.OwnerDao;
import domain.Destination;
import domain.DetailImage;
import domain.Owner;

/**
 * Servlet implementation class DestinationDetailServlet
 */
@WebServlet("/destinationDetail")
public class DestinationDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int destinationId = Integer.parseInt(request.getParameter("destinationId"));
		HttpSession session = request.getSession();
		session.setAttribute("destinationId", destinationId);

		try {
			// 編集するお出掛け先データの取得
			DestinationDao destinationDao = DaoFactory.createDestinationDao();
			Destination destination = destinationDao.findByDestinationId(destinationId);
			
			//お出掛け先のイメージ画像を取得
			DetailImageDao detailImageDao = DaoFactory.createDetailImageDao();
			List<DetailImage>detailImageList = detailImageDao.findByDestinationId(destinationId);

			// データの情報をリクエストに格納
			request.setAttribute("ownerId", destination.getOwnerId());
			request.setAttribute("genreId", destination.getGenreId());
			request.setAttribute("name", destination.getName());
			request.setAttribute("evaluation", destination.getEvaluation());
			
			request.setAttribute("detailImageList", detailImageList);
					
			//愛犬家情報の取得
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			List<Owner> ownerList = ownerDao.findByOwnerId(destination.getOwnerId());
			request.setAttribute("ownerList", ownerList);
			
			//データベース接続
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/wanchanto");
			Connection con = ds.getConnection();

			//リクエストからownerIdの取得と再定義
			int ownerId=(Integer)request.getAttribute("ownerId");
			
			//ownerIdからのサムネイル取得
			byte[] byteImg = null;			
			String sql = "SELECT img FROM owners WHERE ownerId = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, ownerId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				byteImg = rs.getBytes("img");
			}
			request.setAttribute("ownerId", ownerId);
			if (byteImg != null) {
				String strImg = Base64.getEncoder().encodeToString(byteImg);
				request.setAttribute("ownerImg", strImg);
			} else {
				request.setAttribute("ownerImg", null);
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}

		
		request.getRequestDispatcher("/WEB-INF/view/destinationDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
