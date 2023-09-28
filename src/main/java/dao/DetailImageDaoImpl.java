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
	public DetailImage findByImgId(Integer imgId) throws Exception {
		DetailImage detailImage = new DetailImage();

		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM detailimages WHERE imgId = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, imgId, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				detailImage = mapToDetailImage(rs);
			}
		} catch (Exception e) {
			throw e;
		}

		return detailImage;

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
					+ " (destinationId,imgId,imgCategory,fileName,img,comment,registrationDate)"
					+ " VALUES (?,?,?,?,?,?,NOW())";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, detailImage.getDestinationId());
			stmt.setObject(2, detailImage.getImgId());
			stmt.setObject(3, detailImage.getImgCategory());
			stmt.setString(4, detailImage.getFileName());
			stmt.setBytes(5, detailImage.getImg());
			stmt.setString(6, detailImage.getComment());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(DetailImage detailImage) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE detailimages SET img=?,fileName=?, imgCategory=?, comment=?,registrationDate=NOW() WHERE imgId=?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setBytes(1, detailImage.getImg());
			stmt.setString(2, detailImage.getFileName());
			stmt.setObject(3,detailImage.getImgCategory(), Types.INTEGER);
			stmt.setString(4, detailImage.getComment());
			stmt.setObject(5,detailImage.getImgId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(DetailImage detailImage) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "DELETE FROM detailimages WHERE imgId=?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, detailImage.getImgId(), Types.INTEGER);
			stmt.executeUpdate();
		}catch (Exception e) {
			throw e;
		}
	}

	/**
	 * ResultSet から DetailImage オブジェクトへの変換
	 */
	private DetailImage mapToDetailImage(ResultSet rs) throws Exception {
		Integer destinationId = (Integer) rs.getObject("destinationId");
		Integer imgId = (Integer) rs.getObject("imgId");
		Integer imgCategory = (Integer) rs.getObject("imgCategory");
		String fileName = rs.getString("fileName");
		byte[] img = rs.getBytes("img");
		String comment = rs.getString("comment");
		Date registrationDate = rs.getTimestamp("registrationDate");

		return new DetailImage(destinationId, imgId, imgCategory, fileName, img, comment, registrationDate);
	}

}
