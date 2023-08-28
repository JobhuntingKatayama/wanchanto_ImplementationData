package domain;

public class Owner {
	private String loginId;
	private String loginPassword;

	public Owner(/*String ownerId, */String loginId, String loginPassword/*, Integer statusId, String ownerstatus*/) {
		this.loginId = loginId;
		this.loginPassword = loginPassword;
	}

	public Owner() {
		// TODO 自動生成されたコンストラクター・スタブ
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
