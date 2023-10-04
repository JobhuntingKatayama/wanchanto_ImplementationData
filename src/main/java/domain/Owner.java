package domain;

import java.util.Base64;
import java.util.Date;

public class Owner {
	private Integer ownerId;
	private String loginId;
	private String loginPassword;
	private String thumbnail;

	private byte[] ownerImg;
	private String ownerImgData;

	private Integer statusId;
	private Date registrationDate;

	public Owner() {

	}

	public Owner(Integer ownerId, String thumbnail, byte[] ownerImg, String loginId, String loginPassword, Integer statusId, Date registrationDate) {
		this.ownerId = ownerId;
		this.thumbnail = thumbnail;
		this.ownerImg = ownerImg;
		this.loginId = loginId;
		this.loginPassword = loginPassword;
		this.statusId = statusId;
		this.registrationDate = registrationDate;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public byte[] getOwnerImg() {
		return ownerImg;
	}

	public void setOwnerImg(byte[] ownerImg) {
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

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
}
