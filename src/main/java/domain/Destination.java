package domain;

import java.util.Base64;
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
	private String formattedDate;
	private byte[] img;
	private String imgData;

	
	public Destination() {
	}

	public Destination( Integer ownerId, Integer destinationId, Integer genreId, String name,Integer evaluation,byte[] img, Date addedDate, String formattedDate ) {
		this.ownerId = ownerId;
		this.destinationId = destinationId;
		this.genreId = genreId;
		this.name = name;
		this.evaluation = evaluation;
		this.addedDate = addedDate;
		this.formattedDate = formattedDate;
		this.img = img;
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
	
	public String getFormattedDate() {
		return formattedDate;
	}
	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
	public String getImgData() {
		if (img != null) {
			this.imgData = Base64.getEncoder().encodeToString(img);
		}
		return imgData;
	}

	public void setImgData(String imgData) {
		this.imgData = imgData;
	}
}
