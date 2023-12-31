package dao;

import java.util.List;

import domain.Owner;

public interface OwnerDao {

	List<Owner> findAll() throws Exception;

	List<Owner> findByOwnerList(Integer ownerId) throws Exception;

	void insert(Owner owner) throws Exception;

	void update(Owner owner) throws Exception;

	void delete(Owner owner) throws Exception;

	Owner findByLoginIdAndLoginPass(String loginId, String loginPassword) throws Exception;

	Owner findByOwnerId(Integer ownerId) throws Exception;
	
	Owner findByLoginId(String loginId) throws Exception;
}
