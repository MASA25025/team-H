package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Class_Num;
import bean.Test;

public class TestDao extends DAO{

	public List<Test> filter(int ent_year,String class_num,String subject_name,int sub_cou) throws Exception {
		List<Test> list=new ArrayList<>();
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement(
			"select * from CLASS_NUM where CLASS_CD like ?");
		st.setString(1,keyword);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Class_Num p=new Class_Num();
			p.setSchool_cd(rs.getString("school_cd"));
			p.setClass_num(rs.getString("class_num"));
			list.add(p);
		}

		st.close();
		con.close();

		return list;
	}

}

