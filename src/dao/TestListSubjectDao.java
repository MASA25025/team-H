package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.TestListSubject;;

public class TestListSubjectDao extends DAO{

	public List<TestListSubject> postFilter(ResultSet rSet) {
		return null;
	}
//
//	public List<String> Sub_List(School school) throws Exception{
//		List<String> subject_list = new ArrayList<>();
//		Connection connection = getConnection();
//		String schoolCd = school.getCd();
//		PreparedStatement statement = connection.prepareStatement(
//				"select Name"+
//				"from SUBJECT"+
//				"where SCHOOL_CD =?"
//				);
//		statement.setString(1, schoolCd);
//	}
	public List<TestListSubject> filter(int entYear, String classNum, String subject_cd, String school_cd) {
		List<TestListSubject> testListSubject = new ArrayList<TestListSubject>();

		try{
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(
				"SELECT"+
					"s.ent_Year"+
					"t.class_Num,"+
					"t.student_No,"+
					"s.Name,"+
					"MAX(CASE WHEN t.no = 1 THEN t.point ELSE NULL END) AS POINT_NO1,"+
					"MAX(CASE WHEN t.no = 2 THEN t.point ELSE NULL END) AS POINT_NO2,"+
				"FROM"+
					"test t"+
					"JOIN"+
					"student s ON t.student_No = s.no"+
				"WHERE"+
					"s.ent_Year = ?"+
					"AND t.class_Num = ?"+
					"AND t.subject_cd = ?"+
					"AND t.school_cd = ?"+
				"GROUP BY"+
					"t.student_No, s.Name, t.class_Num, s.ent_Year;");
			statement.setInt(1, entYear);
			statement.setString(2, classNum);
			statement.setString(3, subject_cd);
			statement.setString(4, school_cd);


			ResultSet rSet = statement.executeQuery();

			while (rSet.next()) {
				TestListSubject listSubject = new TestListSubject();
				listSubject.setStudentNo(rSet.getString("studentNo"));
				listSubject.setStudentName(rSet.getString("stundetName"));
				listSubject.setClassNum(rSet.getString("classNum"));
				listSubject.setPoint01(rSet.getString("point01"));
				listSubject.setPoint02(rSet.getString("point02"));
				listSubject.setEntYear(rSet.getInt("entYear"));

			}

		}catch (Exception e) {
			// TODO: handle exception
		}

		return testListSubject;
	}



}
