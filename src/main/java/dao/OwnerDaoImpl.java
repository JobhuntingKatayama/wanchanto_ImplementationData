package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public Owner findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Owner owner) throws Exception {
		try (Connection con = ds.getConnection()) {			
			
			String sql = "INSERT INTO owners" + " (loginId, loginPassword, registrationDate)" + " VALUES (?,?,NOW())";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, owner.getLoginId());
			stmt.setString(2, owner.getLoginPassword());
			stmt.executeUpdate();
				
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void update(Owner owner) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void delete(Owner owner) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public Owner findByLoginIdAndLoginPass(String loginId, String loginPassword) throws Exception {

		Owner owner = null;

		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM owners WHERE loginId=?";
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

	private Owner mapToOwner(ResultSet rs) throws Exception {
		Integer ownerId = (Integer) rs.getObject("ownerId");
		String thumbnail = rs.getString("thumbnail");
		String loginId = rs.getString("loginId");
		String loginPassword = rs.getString("loginPassword");
		Integer statusId = (Integer) rs.getObject("statusId");
		Date registrationDate = rs.getTimestamp("registrationDate");

		return new Owner(ownerId, thumbnail, loginId, loginPassword, statusId, registrationDate);
		
		//		Owner owner = new Owner();
//		owner.setLoginId(rs.getString("loginId"));
//		owner.setLoginPassword(rs.getString("loginPassword"));
//
//		return owner;

	}
}
