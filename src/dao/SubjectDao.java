package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDao extends DAO{

		public List<Subject> Filter(School school) throws Exception {
			List<Subject> list=new ArrayList<>();
			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
				"select * from SUBJECT where CD like ?");
			st.setString(1,school.getCd());
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				Subject p=new Subject();
				p.setCd(rs.getString("cd"));
				p.setName(rs.getString("name"));
				list.add(p);
			}

			st.close();
			con.close();

			return list;
		}

}