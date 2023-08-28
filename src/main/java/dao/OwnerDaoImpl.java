package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		 // TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Owner findById(Integer id)throws Exception {
		 // TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void insert(Owner owner) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

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
		Owner owner = new Owner();
		owner.setLoginId(rs.getString("loginId"));
		owner.setLoginPassword(rs.getString("loginPassword"));
		
		return owner;

	}
}
