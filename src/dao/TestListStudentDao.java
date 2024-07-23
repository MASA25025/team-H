package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.TestListStudent;

public class TestListStudentDao extends DAO{

	public List<TestListStudent> filter(String no) throws Exception{
		List<TestListStudent> testListStudent = new ArrayList<TestListStudent>();

		Connection connection = getConnection();
		PreparedStatement statement = connection
				.prepareStatement("select s.Name,s.cd, t.no, t.point from subject  s join test t on  s.cd = t.subject_cd where student_no = ?");
		try{
		statement.setString(1, no);


		ResultSet rSet = statement.executeQuery();
		while (rSet.next()) {
			TestListStudent listStudent = new TestListStudent();
			listStudent.setSubjectName(rSet.getString("Name"));
			listStudent.setSubjectCd(rSet.getString("Cd"));
			listStudent.setNum(rSet.getInt("No"));
			listStudent.setPoint(rSet.getInt("Point"));

			testListStudent.add(listStudent);
		}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {

			if (statement !=null){
				try{
					statement.close();
				}catch (SQLException sqle) {
					// TODO: handle exception
					throw sqle;
				}
			}
			if (connection != null){
				try{
					connection.close();
				}catch (SQLException sqle) {
					// TODO: handle exception
					throw sqle;
				}
			}
		}

		return testListStudent;
	}

}
