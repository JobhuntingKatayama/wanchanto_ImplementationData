package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
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
			String sql = "SELECT destinations.ownerId, destinations.genreId, destinations.destinationId,"
					+ " destinations.name, destinations.evaluation, destinations.addedDate"
					+ " FROM destinations";
			PreparedStatement stmt = con.prepareStatement(sql);
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
	public List<Destination> findByOwnerId(Integer ownerId) throws Exception {
		List<Destination> destinationList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "SELECT destinations.ownerId, destinations.genreId, destinations.destinationId,"
					+ " destinations.name, destinations.evaluation, destinations.addedDate" + " FROM destinations" + " WHERE ownerId = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, ownerId, Types.INTEGER);
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
	public Destination findByDestinationId(Integer destinationId) throws Exception {
		Destination destination = new Destination();

		try (Connection con = ds.getConnection()) {
			String sql = "SELECT destinations.ownerId, destinations.genreId, destinations.destinationId,"
					+ " destinations.name, destinations.evaluation, destinations.addedDate"
					+ " FROM destinations" + " WHERE destinationId = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, destinationId, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				destination = mapToDestination(rs);
			}
		} catch (Exception e) {
			throw e;
		}

		return destination;
	}

	@Override
	public void insert(Destination destination) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO destinations" + " (ownerId,genreId,name,evaluation,addedDate)"
					+ " VALUES(?,?,?,?,NOW())";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, destination.getOwnerId(), Types.INTEGER);
			stmt.setObject(2, destination.getGenreId(), Types.INTEGER);
			stmt.setString(3, destination.getName());
			stmt.setObject(4, destination.getEvaluation(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void update(Destination destination) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE destinations SET genreId = ?, name = ?, evaluation = ?, addedDate = NOW()"
					+ " WHERE destinationId = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, destination.getGenreId(), Types.INTEGER);
			stmt.setString(2, destination.getName());
			stmt.setObject(3, destination.getEvaluation(), Types.INTEGER);
			stmt.setObject(4, destination.getDestinationId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Destination destination) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	private Destination mapToDestination(ResultSet rs) throws Exception {
		Integer ownerId = (Integer) rs.getObject("ownerId");
		Integer genreId = (Integer) rs.getObject("genreId");
		Integer destinationId = (Integer) rs.getObject("destinationId");
		String name = rs.getString("name");
//		String image = rs.getString("image");
		Integer evaluation = (Integer) rs.getObject("evaluation");
//		Integer statusId = (Integer) rs.getObject("statusId");
		Date addedDate = rs.getTimestamp("addedDate");
		
		return new Destination(ownerId, destinationId, genreId, name, /* image, */ evaluation ,/* statusId,*/ addedDate );
	}


}