package domain;

public class Owner {
	private Integer ownerId;
	private String loginId;
	private String loginPassword;

	public Owner(Integer ownerId, String loginId, String loginPassword/*, Integer statusId, String ownerstatus*/) {
		this.loginId = loginId;
		this.loginPassword = loginPassword;
	}

	public Owner() {
		// TODO 自動生成されたコンストラクター・スタブ
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
	
}
