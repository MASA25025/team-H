package bean;

import java.io.Serializable;

public class Class_num implements Serializable {
	// 学校コード
	private char school_cd;
	// クラス番号
	private String class_num;
	public char getSchool_cd() {
		return school_cd;
	}
	public void setSchool_cd(char school_cd) {
		this.school_cd = school_cd;
	}
	public String getClass_num() {
		return class_num;
	}
	public void setClass_num(String class_num) {
		this.class_num = class_num;
	}

}