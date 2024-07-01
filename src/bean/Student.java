package bean;

import java.io.Serializable;

public class Student implements Serializable {
	//学生番号
	private String no;
	//学生名
	private String name;
	//入学年度
	private int ent_year;
	//クラス番号
	private String class_num;
	//在学中フラグ
	private boolean is_attend;
	//学校コード
	private String school_cd;
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEnt_year() {
		return ent_year;
	}
	public void setEnt_year(int ent_year) {
		this.ent_year = ent_year;
	}
	public String getClass_num() {
		return class_num;
	}
	public void setClass_num(String class_num) {
		this.class_num = class_num;
	}
	public boolean isIs_attend() {
		return is_attend;
	}
	public void setIs_attend(boolean is_attend) {
		this.is_attend = is_attend;
	}
	public String getSchool_cd() {
		return school_cd;
	}
	public void setSchool_cd(String school_cd) {
		this.school_cd = school_cd;
	}
	
}
