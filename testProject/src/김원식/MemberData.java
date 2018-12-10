package ±è¿ø½Ä;

public class MemberData {
	
	private String memberID;
	private String name;
	private String tel;
	private String gender;
	
	MemberData(String memberID, String name, String tel, String gender){
		this.memberID = memberID;
		this.name = name;
		this.tel = tel;
		this.gender = gender;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
