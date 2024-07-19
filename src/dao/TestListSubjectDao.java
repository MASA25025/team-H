package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.School;
import bean.TestListSubject;

public class TestListSubjectDao extends DAO{
	private String baleSql = "select";

	public List<TestListSubject> postFilter(ResultSet rSet) {
		return null;
	}

	public List<TestListSubject> filter(int entYear, String classNum, String subject_cd, String school_cd) {
		List<TestListSubject> testListSubject = new ArrayList<TestListSubject>();

		try{
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(

				"select   t.student_No, s.Name, t.class_Num,t.point, s.ent_Year, t.no"+
				"from     test t join student s on t.student_No = s.no"+
				"where  s.ent_Year =? and t.class_Num =? and t.subject_cd =? and t.school_cd=? "
				);
			statement.setInt(1, entYear);
			statement.setString(2, classNum);
			statement.setString(3, subject_cd);
			statement.setString(4, school_cd);

			TestListSubject listSubject = new TestListSubject();
			ResultSet rSet = statement.executeQuery();
			String Num = null;

			if{
				int prevStudent_no = 0;
				int prevPoint = 0;
				Map<Integer, Integer> map = map<0,0>;
						while(rSet.next()){
						student_no = 学生番号を取得
						student_point = 点数を取得
						if(prevStudent_no == student_no){
						mapにprevpointとrSetのポイントをput
						マップをリストにadd
						map = null
						} else {
						if (map != null) {
						マップをリストにadd
						}
						map = new hashmap<>()
						mapにrSetのポイントとnullをセット
						prevStudent_no = student_no
						prevPoint = student_point
						}
						}
			}
			while (rSet.next()) {

				listSubject.setStudentNo(rSet.getString("studentNo"));
				listSubject.setStudentName(rSet.getString("stundetName"));
				listSubject.setClassNum(rSet.getString("classNum"));
				listSubject.setPoint();
				listSubject.setEntYear(rSet.getInt("entYear"));

			}

		}catch (Exception e) {
			// TODO: handle exception
		}

		return testListSubject;
	}



}
