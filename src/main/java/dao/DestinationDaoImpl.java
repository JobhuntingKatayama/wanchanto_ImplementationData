package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Destination;

public class DestinationDaoImpl implements DestinationDao {

	private DataSource ds;

	public DestinationDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Destination> findAll() throws Exception {
		List<Destination> destinationList = new ArrayList<>();


		try (Connection con = ds.getConnection()) {
	        int ownerId = 0; // 変数 owner の値を設定
			String sql = "SELECT" + " destinations.genreId,"
					+ " destinations.name, destinations.evaluation"
					+ " FROM destinations"
					+ " WHERE ownerId = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, ownerId); // プレースホルダーに変数の値を設定
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				destinationList.add(mapToDestination(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return destinationList;
	}

	@Override
	public Destination findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Destination destination) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql = "INSERT INTO destinations" +
			" (genreId,name,evaluation,addedDate)" + " VALUES(?,?,?,NOW())";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, destination.getGenreId(),Types.INTEGER);
			stmt.setString(2, destination.getName());
			stmt.setObject(3, destination.getEvaluation(),Types.INTEGER);
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		}
		
	}

	@Override
	public void update(Destination destination) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Destination destination) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private Destination mapToDestination(ResultSet rs) throws Exception {
		Integer genreId = (Integer) rs.getObject("genreId");
		String name = rs.getString("name");
		Integer evaluation = (Integer) rs.getObject("evaluation");

		return new Destination(genreId, name, evaluation);

	}

}
