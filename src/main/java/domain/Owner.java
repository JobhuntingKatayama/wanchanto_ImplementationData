package domain;

import java.util.Base64;
import java.util.Date;

public class Owner {
	private Integer ownerId;
	private String loginId;
	private String loginPassword;
	private String thumbnail;

	private byte[] img;
	private String imgData;

	private Integer statusId;
	private Date registrationDate;

	public Owner() {

	}

	public Owner(Integer ownerId, String thumbnail, byte[] img, String loginId, String loginPassword, Integer statusId, Date registrationDate) {
		this.ownerId = ownerId;
		this.thumbnail = thumbnail;
		this.img = img;
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

//	// InputStream → byte[ ]
//	public void setImgFromInputStream(InputStream is) {
//		try {
//			ByteArrayOutputStream bout = new ByteArrayOutputStream();
//			byte[] buffer = new byte[1024];
//			while (true) {
//				int len = is.read(buffer);
//				if (len < 0) {
//					break;
//				}
//				bout.write(buffer, 0, len);
//			}
//			this.img = bout.toByteArray();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
}
