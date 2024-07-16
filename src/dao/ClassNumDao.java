package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Class_Num;
import bean.School;

public class ClassNumDao extends DAO{

		public List<String> Filter(School school) throws Exception {
			List<String> list=new ArrayList<>();

			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
				"select * from CLASS_NUM where SCHOOL_CD like ?");
			st.setString(1,school.getCd());
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("class_num"));
			}

			st.close();
			con.close();

			return list;
		}


