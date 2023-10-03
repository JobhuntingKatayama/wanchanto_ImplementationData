package domain;

import java.util.Base64;
import java.util.Date;

public class Destination {

	private Integer ownerId;
	private Integer destinationId;
	private Integer genreId;
	private String name;
	private byte[] desImg;
	private String desImgData;
	private Integer evaluation;
	private Integer statusId;
	private Date addedDate;
	private String formattedDate;
	private byte[] ownerImg;
	private String ownerImgData;

	public Destination() {
	}

	public Destination(Integer ownerId, Integer destinationId, Integer genreId, String name, byte[] desImg,
			Integer evaluation, byte[] ownerImg, Date addedDate, String formattedDate) {
		this.ownerId = ownerId;
		this.destinationId = destinationId;
		this.genreId = genreId;
		this.name = name;
		this.desImg = desImg;
		this.evaluation = evaluation;
		this.addedDate = addedDate;
		this.formattedDate = formattedDate;
		this.ownerImg = ownerImg;
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

	public byte[] getDesImg() {
		return desImg;
	}

	public void setDesImg(byte[] desImg) {
		this.desImg = desImg;
	}

	public String getDesImgData() {
		if (desImg != null) {
			this.desImgData = Base64.getEncoder().encodeToString(desImg);
		}
		return desImgData;
	}
	public void setDesImgData(String desImgData) {
		this.desImgData = desImgData;
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

	public byte[] getOwnerImg() {
		return ownerImg;
	}

	public void setImg(byte[] ownerImg) {
		this.ownerImg = ownerImg;
	}

	public String getOwnerImgData() {
		if (ownerImg != null) {
			this.ownerImgData = Base64.getEncoder().encodeToString(ownerImg);
		}
		return ownerImgData;
	}

	public void setOwnerImgData(String ownerImgData) {
		this.ownerImgData = ownerImgData;
	}
}