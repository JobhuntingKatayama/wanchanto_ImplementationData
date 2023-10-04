package domain;

import java.util.Base64;
import java.util.Date;

public class DetailImage {

	private Integer destinationId;
	private Integer imgId;
	private Integer imgCategory;
	private String fileName;
	private byte[] actualImg;
	private String comment;

	private String actualImgData;
	private Date registrationDate;

	public DetailImage() {

	}

	public DetailImage(Integer destinationId, Integer imgId, Integer imgCategory, String fileName, byte[] actualImg,
			String comment, Date registrationDate) {
		this.destinationId = destinationId;
		this.imgId = imgId;
		this.imgCategory = imgCategory;
		this.fileName = fileName;
		this.actualImg = actualImg;
		this.comment = comment;
		this.registrationDate = registrationDate;
	}

	public Integer getImgId() {
		return imgId;
	}

	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}

	public Integer getImgCategory() {
		return imgCategory;
	}

	public void setImgCategory(Integer imgCategory) {
		this.imgCategory = imgCategory;
	}

	public Integer getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getActualImg() {
		return actualImg;
	}

	public void setActualImg(byte[] actualImg) {
		this.actualImg = actualImg;
	}

	public String getImgData() {
		if (actualImg != null) {
			this.actualImgData = Base64.getEncoder().encodeToString(actualImg);
		}
		return actualImgData;
	}

	public void setImgData(String actualImgData) {
		this.actualImgData = actualImgData;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}


}
