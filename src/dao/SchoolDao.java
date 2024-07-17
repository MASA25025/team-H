package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.School;

public class SchoolDao extends DAO{
	public School get(String no) throws Exception {
		School school = new School();

		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select STUDENT_CD from STUDENT where NO like ?");
		st.setString(1,no);
		ResultSet rs=st.executeQuery();

		if(rs.next()){
			school.setCd(rs.getString("cd"));
			school.setName(rs.getString("name"));
		}else{
			school = null;
		}

		st.close();
		con.close();

		return school;
	}
}
