package domain;

import java.util.Date;

public class Destination {

	private Integer ownerId;
	private Integer destinationId;
	private Integer genreId;
	private String name;
	private String image;
	private Integer evaluation;
	private Integer statusId;
	private Date addedDate;

	public Destination() {

	}

	public Destination( Integer ownerId, Integer destinationId, Integer genreId, String name,
			/* String image, */ Integer evaluation/* , */
	 /*Integer statusId*/, Date addedDate ) {
		this.ownerId = ownerId;
		this.destinationId = destinationId;
		this.genreId = genreId;
		this.name = name;
//		this.image = image;
		this.evaluation = evaluation;
//		this.statusId = statusId;
		this.addedDate = addedDate;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

}
