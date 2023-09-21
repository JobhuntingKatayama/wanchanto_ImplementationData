package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.Owner;

public class OwnerDaoImpl implements OwnerDao {

	private DataSource ds;

	public OwnerDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Owner> findAll() throws Exception {
		List<Owner> ownerList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM owners";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ownerList.add(mapToOwner(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return ownerList;
	}

	@Override
	public List<Owner> findByOwnerId(Integer ownerId) throws Exception {
		List<Owner> ownerList = new ArrayList<>();

		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM owners WHERE owners.ownerId = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, ownerId, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ownerList.add(mapToOwner(rs));
			}
		} catch (Exception e) {
			throw e;
		}
		return ownerList;
	}

	@Override
	public Owner findByLoginId(String loginId) throws Exception {
		Owner owner = new Owner();
		
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM owners WHERE owners.loginId = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				owner = mapToOwner(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return owner;
	}

	@Override
	public Owner findByLoginIdAndLoginPass(String loginId, String loginPassword) throws Exception {
		Owner owner = null;
		
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM owners WHERE loginId = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(loginPassword, rs.getString("loginPassword"))) {
					owner = mapToOwner(rs);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return owner;
	}

	@Override
	public void insert(Owner owner) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO owners (thumbnail, img, loginId, loginPassword, registrationDate) VALUES (?,?,?,?,NOW())";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,owner.getThumbnail());
			stmt.setBytes(2, owner.getImg());
			stmt.setString(3, owner.getLoginId());
			stmt.setString(4, owner.getLoginPassword());
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void update(Owner owner) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "UPDATE owners SET thumbnail =?, img = ?, loginId = ?, loginPassword = ? WHERE ownerId = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,owner.getThumbnail());
			stmt.setBytes(2, owner.getImg());
			stmt.setString(3, owner.getLoginId());
			stmt.setString(4, owner.getLoginPassword());
			stmt.setObject(5, owner.getOwnerId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void delete(Owner owner) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "DELETE FROM owners WHERE ownerId = ? ";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, owner.getOwnerId(), Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * ResultSetからOwnerオブジェクトへの変換
	 */
	private Owner mapToOwner(ResultSet rs) throws Exception {
		Integer ownerId = (Integer) rs.getObject("ownerId");
		String thumbnail = rs.getString("thumbnail");
		byte[] img = rs.getBytes("img");
		String loginId = rs.getString("loginId");
		String loginPassword = rs.getString("loginPassword");
		Integer statusId = (Integer) rs.getObject("statusId");
		Date registrationDate = rs.getTimestamp("registrationDate");

		return new Owner(ownerId, thumbnail, img, loginId, loginPassword, statusId, registrationDate);

	}
}
