//わからないからここに棄てる
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.Test;

public class TestDao extends DAO{

	public List<Test> filter(int ent_year,String class_num,String subject_name,int sub_cou) throws Exception {
		List<Student> list=new ArrayList<>();
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select ENT_YEAR,CLASS_NUM,NO,NAME from STUDENT where ENT_YEAR,CLASS_NUM like ?,?");
		st.setInt(1,ent_year);
		st.setString(1,class_num);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Student p=new Student();
			p.setEntYear(rs.getInt("ent_year"));
			p.setClassNum(rs.getString("class_num"));
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}

}

