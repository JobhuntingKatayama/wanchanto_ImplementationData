package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import domain.DetailImage;

public class DetailImageDaoImpl implements DetailImageDao {

	private DataSource ds;

	public DetailImageDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<DetailImage> findAll() throws Exception {
		List<DetailImage> detailImageList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM detailimages";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				detailImageList.add(mapToDetailImage(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return detailImageList;
	}

	@Override
	public List<DetailImage> findByDestinationId(Integer destinationId) throws Exception {
		List<DetailImage> detailImageList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM detailimages WHERE destinationId = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, destinationId, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				detailImageList.add(mapToDetailImage(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return detailImageList;
	}


	@Override
	public void insert(DetailImage detailImage) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO detailimages"
					+ " (destinationId,imgCategory,fileName,img,comment,registrationDate)"
					+ " VALUES (?,?,?,?,?,NOW())";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, detailImage.getDestinationId());
			stmt.setObject(2, detailImage.getImgCategory());
			stmt.setString(3, detailImage.getFileName());
			stmt.setBytes(4, detailImage.getImg());
			stmt.setString(5, detailImage.getComment());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(DetailImage detailImage) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(DetailImage detailImage) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	/**
	 * ResultSet から DetailImage オブジェクトへの変換
	 */
	private DetailImage mapToDetailImage(ResultSet rs) throws Exception {
		Integer destinationId = (Integer) rs.getObject("destinationId");
//		Integer imgId = (Integer) rs.getObject("imgId");
		Integer imgCategory = (Integer) rs.getObject("imgCategory");
		String fileName = rs.getString("fileName");
		byte[] img = rs.getBytes("img");
		String comment = rs.getString("comment");
		Date registrationDate = rs.getTimestamp("registrationDate");

		return new DetailImage(destinationId, imgCategory, fileName, img, comment, registrationDate);
	}

}
