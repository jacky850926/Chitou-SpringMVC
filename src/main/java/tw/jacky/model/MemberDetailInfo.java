package tw.jacky.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="memberdetailinfo")
public class MemberDetailInfo {
	
	@Id
	@Column(name="memberid")
	private int memberid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="nickname")
	private String nickname;
	
	@Column(name="nationality")
	private String nationality;
	
	@Column(name="birth")
	private String brith;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="createtime")
	private String createtime;
	
	@Column(name="modifytime")
	private String modifytime;
	
	
	public MemberDetailInfo(int memberid, String name, String phone, String address, String nickname,
			String nationality, String brith, String gender, String createtime, String modifytime) {
		super();
		this.memberid = memberid;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.nickname = nickname;
		this.nationality = nationality;
		this.brith = brith;
		this.gender = gender;
		this.createtime = createtime;
		this.modifytime = modifytime;
	}
	
	
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getBrith() {
		return brith;
	}
	public void setBrith(String brith) {
		this.brith = brith;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}



	@Override
	public String toString() {
		return "MemberDetailInfo [memberid=" + memberid + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ ", nickname=" + nickname + ", nationality=" + nationality + ", brith=" + brith + ", gender=" + gender
				+ ", createtime=" + createtime + ", modifytime=" + modifytime + "]";
	}
	
	
	
	

}
