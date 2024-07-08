package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Class_Num;

public class ClassNumDao extends DAO{

		public List<Class_Num> Filter(String keyword) throws Exception {
			List<Class_Num> list=new ArrayList<>();

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
