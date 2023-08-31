package dao;

import java.util.List;

import domain.Owner;

public interface OwnerDao {

	List<Owner> findAll() throws Exception;
	
	Owner findById(String loginId)throws Exception;

	Owner findByLoginIdAndLoginPass(String loginId, String loginPassword) throws Exception;

	void insert(Owner owner) throws Exception;

	void update(Owner owner) throws Exception;

	void delete(Owner owner) throws Exception;



}
