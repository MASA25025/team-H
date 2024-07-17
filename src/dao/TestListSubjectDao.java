package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bean.School;
import bean.TestListSubject;

public class TestListSubjectDao extends DAO{
	private String baleSql = "select";

	public List<TestListSubject> postFilter(ResultSet rSet) {
		return null;
	}

	public List<TestListSubject> filter(int entYear, String classNum, String subject, School school) {
		List<TestListSubject> testListSubject = new ArrayList<TestListSubject>();

		try{
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(
				"select t.studentNo, t.sutudentName, t.classNum,"+
				"t.point, s.entYear, t.num"+
				"from test t join student s on t.studentNo = s.cd "+
				"where entYear =?, classNum =?, subject =?"
				);

			statement.setInt(1, entYear);
			statement.setString(2, classNum);
			statement.setString(3, subject);

			TestListSubject listSubject = new TestListSubject();
			ResultSet rSet = statement.executeQuery();
			Integer p1;
			Integer p2;
			while (rSet.next()) {

				listSubject.setStudentNo(rSet.getString("studentNo"));
				listSubject.setStudentName(rSet.getString("stundetName"));
				listSubject.setClassNum(rSet.getString("classNum"));
				listSubject.setPoint(new HashMap<Integer, Integer>());
				listSubject.setEntYear(rSet.getInt("entYear"));

			}

		}catch (Exception e) {
			// TODO: handle exception
		}

		return testListSubject;
	}



}
