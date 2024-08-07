package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;

public class SubjectDao extends DAO{
	public Subject get(String cd, School school)throws  Exception{
		Subject subject = new Subject();

		Connection connection = getConnection();

		PreparedStatement statement = null;

		try{
			statement = connection.prepareStatement("select * from subject where cd =? and school_cd = ?");
			statement.setString(1, cd);
			statement.setString(2, school.getCd());

			System.out.print("sql"+statement);

			ResultSet rSet = statement.executeQuery();

			SchoolDao schoolDao = new SchoolDao();
			if(rSet.next()){
				subject.setCd(rSet.getString("cd"));
				subject.setName(rSet.getString("name"));
				subject.setSchool(schoolDao.get(rSet.getString("school_cd")));
			}else{
				subject = null;
			}

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
		return subject;
	}

		public List<Subject> filter(School school) throws Exception {
			List<Subject> list=new ArrayList<>();
			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
				"select * from SUBJECT where SCHOOL_CD = ?");
			st.setString(1,school.getCd());
			ResultSet rs=st.executeQuery();

			while (rs.next()) {
				Subject p=new Subject();
				p.setCd(rs.getString("cd"));
				p.setName(rs.getString("name"));
				p.setSchool(school);
				list.add(p);
			}

			st.close();
			con.close();

			return list;
		}

		public boolean save(Subject subject) throws Exception{
			Connection connection = getConnection();
			PreparedStatement statement = null;
//			実行件数
			int count = 0;

			try{
				Subject reg = get(subject.getCd(), subject.getSchool());
				if ( reg==null ){
//					学生が存在しなかった場合
//					プリペアードステートメントにINSERT文をセット
					statement = connection.prepareStatement(
							"insert into subject(cd, name, school_cd) values(?, ?, ?)");
//					プリペアードステートメントに値をバインド
					statement.setString(1, subject.getCd());
					statement.setString(2, subject.getName());
					statement.setString(3, subject.getSchool().getCd());
				}else{
//					学生が存在した場合
//					プリペアードステートメントにUPDATE文をセット
					statement = connection.prepareStatement(
							"update subject set name =? where cd=?");
					statement.setString(1, subject.getName());
					statement.setString(2, subject.getCd());
				}

//				プリペアードステートメントの実行
				count = statement.executeUpdate();
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

			if(count >0){
//				実行件数が1件以上ある場合
				return true;
			}else{
//				実行件数が0件の場合
				return false;
			}
	}

		public boolean delete(Subject subject) throws Exception{
			Connection connection = getConnection();
			PreparedStatement statement = null;
//			実行件数
			int count = 0;

			try{
//					学生が存在した場合
//					プリペアードステートメントにUPDATE文をセット
					statement = connection.prepareStatement(
							"delete from subject where cd=?");
					statement.setString(1, subject.getCd());

//				プリペアードステートメントの実行
				count = statement.executeUpdate();
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

			if(count >0){
//				実行件数が1件以上ある場合
				return true;
			}else{
//				実行件数が0件の場合
				return false;
			}
	}
}

