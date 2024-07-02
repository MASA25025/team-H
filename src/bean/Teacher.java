package bean;

import java.io.Serializable;

public class Teacher implements Serializable {
	private String id;
	private String password;
	private String name;
	private School school;

	public String getId() {
		return id;
	}
	public String getPassword(){
		return password;
	}
	public String getName() {
		return name;
	}
	public School getSchool() {
		return school;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCd(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSchool(School school) {
		this.school = school;
	}
}
