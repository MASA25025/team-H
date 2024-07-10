package bean;
import bean.School;
import java.io.Serializable;

public class Student implements Serializable {
	//学生番号
	private String no;
	//学生名
	private String name;
	//入学年度
	private int entYear;
	//クラス番号
	private String classNum;
	//在学中フラグ
	private boolean isAttend;
	//学校コード
	private School school ;

	public String getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public int getEntYear() {
		return entYear;
	}
	public String getClassNum() {
		return classNum;
	}
	public boolean isAttend() {
		return isAttend;
	}
	public School getSchool() {
		return school;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEntYear(int entYear) {
		this.entYear = entYear;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	public void setAttend(boolean isAttend) {
		this.isAttend = isAttend;
	}
	public void setSchool(School school) {
		this.school = school;
	}


}
