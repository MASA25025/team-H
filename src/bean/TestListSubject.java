package bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;



public class TestListSubject implements Serializable{

private String studentNo;
private String studentName;
private String classNum;
private Map < Integer , Integer > point = new HashMap<>();
private int entYear;

public String getStudentNo() {
	return studentNo;
}
public void setStudentNo(String studentNo) {
	this.studentNo = studentNo;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getClassNum() {
	return classNum;
}
public void setClassNum(String classNum) {
	this.classNum = classNum;
}
public Map<Integer, Integer> getPoint() {
	return point;
}
public void setPoint(Map<Integer, Integer> point) {
	this.point = point;
}
public int getEntYear() {
	return entYear;
}
public void setEntYear(int entYear) {
	this.entYear = entYear;
}
}

