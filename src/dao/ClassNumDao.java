package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Class_Num;
import bean.School;

public class ClassNumDao extends DAO{

		public List<Class_Num> Filter(School school) throws Exception {
			List<Class_Num> list=new ArrayList<>();

			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
				"select * from CLASS_NUM where CLASS_CD like ?");
			st.setSchool(1,school);
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
		public List<Class_Num> all() throws Exception {
			List<Class_Num> list = new ArrayList<Class_Num>();

			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement("select * from class_num");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Class_Num s = new Class_Num();
				s.setClass_num(rs.getString("class_num"));
				list.add(s);
			}

			// 学生リストを返却
			return list;
		}
}


