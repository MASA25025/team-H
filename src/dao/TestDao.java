//わからないからここに棄てる
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;

public class TestDao extends DAO{

//	public List<Test> filter(int ent_year,String class_num,String subject_name,int sub_cou) throws Exception {
//		List<Test> list=new ArrayList<>();
//		Connection con=getConnection();
//
//		PreparedStatement st=con.prepareStatement(
//			"select ENT_YEAR,CLASS_NUM,NO,NAME from STUDENT where ENT_YEAR,CLASS_NUM like ?,?");
//		st.setInt(1,ent_year);
//		st.setString(1,class_num);
//		ResultSet rs=st.executeQuery();
//
//		while (rs.next()) {
//			Test p=new Test();
//			p.setEntYear(rs.getInt("ent_year"));
//			p.setClassNum(rs.getString("class_num"));
//			p.setNo(rs.getString("no"));
//			p.setName(rs.getString("name"));
//			list.add(p);
//		}
//
//		st.close();
//		con.close();
//
//		return list;
//	}

	private String baseSql = "select * from Test where school_cd =?";


	public Test get(Student student, Subject subject, School school, int no)throws  Exception{
		Test test = new Test();

		Connection connection = getConnection();

		PreparedStatement statement = null;

		try{
			statement = connection.prepareStatement("");
			statement.setString(1, );

			ResultSet rSet = statement.executeQuery();
			StudentDao studentDao = new StudentDao();
			SchoolDao schoolDao = new SchoolDao();


			if(rSet.next()){
				student.setNo(rSet.getString("no"));
				student.setName(rSet.getString("name"));
				student.setEntYear(rSet.getInt("ent_yaer"));
				student.setClassNum(rSet.getString("class_num"));
				student.setAttend(rSet.getBoolean("is_attend"));
				student.setSchool(schoolDao.get(rSet.getString("school_cd")));
			}else{
				student = null;
			}
//
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
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
		return student;
	}

	public List<Test> postFilter(ResultSet rSet, School school) {

	}

	public List<Test> filter(int entYear, String classNum, Subject subject, int num, School school) {

	}

	public boolean save(List<Test> list) {

	}

	public boolean save(Test test, Connection connection) {

	}

	public boolean delete(List<Test> list) {

	}

	public boolean delete(Test test, Connection connection) {

	}
}

