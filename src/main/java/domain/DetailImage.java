package domain;

import java.util.Base64;
import java.util.Date;

public class DetailImage {

	private Integer destinationId;
//	private Integer imgId;
	private Integer imgCategory;
	private String fileName;
	private byte[] img;
	private String comment;

	private String imgData;
	private Date registrationDate;

	public DetailImage() {

	}

	public DetailImage(Integer destinationId,/* Integer imgId,*/ Integer imgCategory, String fileName, byte[] img,
			String comment, Date registrationDate) {
		this.destinationId = destinationId;
//		this.imgId = imgId;
		this.imgCategory = imgCategory;
		this.fileName = fileName;
		this.img = img;
		this.comment = comment;
		this.registrationDate = registrationDate;
	}

//	public Integer getImgId() {
//		return imgId;
//	}
//
//	public void setImgId(Integer imgId) {
//		this.imgId = imgId;
//	}

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
