package dao;

import java.util.List;

import domain.Destination;

public interface DestinationDao {

	List<Destination> findAll() throws Exception;

	List<Destination> findByOwnerId(Integer ownerId) throws Exception;

	void insert(Destination destination) throws Exception;

	void update(Destination destination) throws Exception;

	void delete(Destination destination) throws Exception;

	Destination findByDestinationId(Integer destinationId) throws Exception;

}
