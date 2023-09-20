package dao;

import java.util.List;

import domain.DetailImage;

public interface DetailImageDao {

	List<DetailImage>findAll() throws Exception;
	DetailImage findByImgId(Integer id)throws Exception;
	public List<DetailImage> findByDestinationId(Integer destinationId)throws Exception;
	void insert(DetailImage detailImage)throws Exception;
	void update(DetailImage detailImage)throws Exception;
	void delete(DetailImage detailImage)throws Exception;
	
}
