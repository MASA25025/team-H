package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.TestListSubject;;

public class TestListSubjectDao extends DAO{

	public String getSubjectName(String subject_cd) throws Exception{
		String SubjectName = null;

		Connection connection =getConnection();
		try{
		PreparedStatement statement = connection
				.prepareStatement("SELECT name FROM subject WHERE cd = ?");
		statement.setString(1, subject_cd);
		ResultSet rSet = statement.executeQuery();
		if (rSet.next()) {
			SubjectName =rSet.getString("Name");
		}

		}catch (Exception e) {
			System.out.print(e);
			System.out.print("DAO側"+subject_cd);
			// TODO: handle exception
		}
		return SubjectName;
	}

	public List<TestListSubject> filter(int entYear, String classNum, String subject_cd, String school_cd) throws Exception{
		List<TestListSubject> testListSubject = new ArrayList<TestListSubject>();

		try{
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(
				"SELECT  s.ent_Year, t.class_Num, t.student_No, s.Name, MAX(CASE WHEN t.no = 1 THEN t.point ELSE NULL END) AS POINT_NO1,MAX(CASE WHEN t.no = 2 THEN t.point ELSE NULL END) AS POINT_NO2 "+
				"FROM test t JOIN student s ON t.student_No = s.no "+
				"WHERE s.ent_Year = ? AND t.class_Num = ? AND t.subject_cd = ? AND t.school_cd = ? "+
				"GROUP BY t.student_No, s.Name, t.class_Num, s.ent_Year;");
			statement.setInt(1, entYear);
			statement.setString(2, classNum);
			statement.setString(3, subject_cd);
			statement.setString(4, school_cd);


			ResultSet rSet = statement.executeQuery();
			while (rSet.next()) {
				TestListSubject listSubject = new TestListSubject();
				listSubject.setEntYear(rSet.getInt("ent_Year"));
				listSubject.setClassNum(rSet.getString("class_Num"));
				listSubject.setStudentNo(rSet.getString("student_No"));
				listSubject.setStudentName(rSet.getString("Name"));
				listSubject.setPoint01(rSet.getString("point_No1"));
				listSubject.setPoint02(rSet.getString("point_No2"));

				testListSubject.add(listSubject);

			}

		}catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}

		return testListSubject;
	}



}
