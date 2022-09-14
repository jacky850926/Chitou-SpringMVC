package originalversion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



//@Entity
//@Table(name="membership")
//@Scope("session")
public class MemberBean implements Serializable {

@Transient
private String info;
//特殊寫法使用的


@Id
//annoId代表的是pk 
@Column(name="memberid")
//應該是什麽type
@GeneratedValue(strategy = GenerationType.IDENTITY)
private String memberid;

@Column(name="statusid")
private String statusid;
@Column(name="userid")
private String userid;
@Column(name="password")
private String password;
@Column(name="name")
private String name;
@Column(name="nickname")
private String nickname;
@Column(name="phone")
private String phone;
@Column(name="nationality")
private String nationality;
@Column(name="birth")
private String birth;
@Column(name="gender")
private String gender;
@Column(name="address")
private String address;
@Column(name="email")
private String email;
@Column(name="createtime")
private String createtime;
@Column(name="modifytime")
private String modifytime;

public MemberBean() {
}

public MemberBean(String statusid, String userid, String password, String name, String nickname, String phone, 
		String nationality, String birth, String gender, String address, String email,String createtime, String modifytime) {
	super();
	this.statusid = statusid;
	this.userid = userid;
	this.password = password;
	this.name = name;
	this.nickname = nickname;
	this.phone = phone;
	this.nationality = nationality;
	this.birth = birth;
	this.gender = gender;
	this.address = address;
	this.email = email;
	this.createtime = createtime;
	this.modifytime = modifytime;
}

public MemberBean(String memberid,  String statusid, String userid, String password, String name, String nickname, String phone, 
		String nationality, String birth, String gender, String address, String email,String createtime, String modifytime) {
	super();
	this.memberid = memberid;
	this.statusid = statusid;
	this.userid = userid;
	this.password = password;
	this.name = name;
	this.nickname = nickname;
	this.phone = phone;
	this.nationality = nationality;
	this.birth = birth;
	this.gender = gender;
	this.address = address;
	this.email = email;
	this.createtime = createtime;
	this.modifytime = modifytime;
}
//for 顯示信息用的
public MemberBean(String info) {
	super();
	this.info=info;

}

public MemberBean(String userid, String password) {
	super();
	this.userid = userid;
	this.password = password;
}

public String getMemberid() {
	return memberid;
}

public void setMemberid(String memberid) {
	this.memberid = memberid;
}

public String getStatusid() {
	return statusid;
}

public void setStatusid(String statusid) {
	this.statusid = statusid;
}



public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getNickname() {
	return nickname;
}

public void setNickname(String nickname) {
	this.nickname = nickname;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}


public String getNationality() {
	return nationality;
}

public void setNationality(String nationality) {
	this.nationality = nationality;
}

public String getBirth() {
	return birth;
}

public void setBirth(String birth) {
	this.birth = birth;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
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
	return "MemberBean [memberid=" + memberid + ", statusid=" + statusid + ", userid=" + userid
			+ ", password=" + password + ", name=" + name + ", nickname=" + nickname + ", phone=" + phone
			+ ", nationality=" + nationality + ", birth=" + birth + ", gender=" + gender + ", address=" + address
			+ ", email=" + email + ", createtime=" + createtime + ", modifytime=" + modifytime + "]";
}





}
