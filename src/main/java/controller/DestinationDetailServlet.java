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
			request.setAttribute("desImgData", destination.getDesImgData());
			request.setAttribute("ownerId", destination.getOwnerId());
			request.setAttribute("genreId", destination.getGenreId());
			request.setAttribute("name", destination.getName());
			request.setAttribute("evaluation", destination.getEvaluation());		
			request.setAttribute("detailImageList", detailImageList);
					
			//愛犬家情報の取得
			OwnerDao ownerDao = DaoFactory.createOwnerDao();
			Owner owner = ownerDao.findByOwnerId(destination.getOwnerId());
			request.setAttribute("owner", owner);

			//ownerIdの取得と再定義
			int ownerId=(Integer)request.getAttribute("ownerId");
			request.setAttribute("ownerId", ownerId);
			
			//愛犬家サムネイル画像の取得とリクエストスコープへの格納
			String ownerImgData = owner.getOwnerImgData();
			request.setAttribute("ownerImgData", ownerImgData);
			if (ownerImgData == null) {
				request.setAttribute("ownerImgData", null);
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
