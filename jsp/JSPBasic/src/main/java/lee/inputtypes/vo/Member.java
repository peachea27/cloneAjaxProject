package lee.inputtypes.vo;

import java.sql.Date;

public class Member {
	
	private String userId;
	private String pwd1;
	private String email;
	private String mobile;
	private Date birth;
	private String gender;
	private int age;
	private String hobby;
	private String job;
	private String memo;
	
	public Member() {}


	public Member(String userId, String pwd1, String email, String mobile, Date birth, String gender, int age,
			String hobby, String job, String memo) {
		super();
		this.userId = userId;
		this.pwd1 = pwd1;
		this.email = email;
		this.mobile = mobile;
		this.birth = birth;
		this.gender = gender;
		this.age = age;
		this.hobby = hobby;
		this.job = job;
		this.memo = memo;
	}
	
	
	public String getUserId() {
		return userId;
	}


	public String getPwd1() {
		return pwd1;
	}


	public String getEmail() {
		return email;
	}


	public String getMobile() {
		return mobile;
	}


	public Date getBirth() {
		return birth;
	}


	public String getGender() {
		return gender;
	}


	public int getAge() {
		return age;
	}


	public String getHobby() {
		return hobby;
	}


	public String getJob() {
		return job;
	}


	public String getMemo() {
		return memo;
	}


	@Override
	public String toString() {
		return "Member [userId=" + userId + ", pwd1=" + pwd1 + ", email=" + email + ", mobile=" + mobile + ", birth="
				+ birth + ", gender=" + gender + ", age=" + age + ", hobby=" + hobby + ", job=" + job + ", memo=" + memo
				+ "]";
	}
	

}
