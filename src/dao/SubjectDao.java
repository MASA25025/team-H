package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SubjectDao extends DAO{

		public String get(String cd) throws Exception {
			String name = null;
			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
				"select * from SUBJECT where CD like ?");
			st.setString(1,cd);
			ResultSet rs=st.executeQuery();

			if (rs.next()) {
                name =rs.getString("name");
            }

			st.close();
			con.close();

			return name;
		}

}