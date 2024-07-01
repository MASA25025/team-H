package bean;

import java.io.Serializable;


public class School implements Serializable {
	// 学校コード
	private char cd;
	// 学校名
	private String name;
	public char getCd() {
		return cd;
	}
	public void setCd(char cd) {
		this.cd = cd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
