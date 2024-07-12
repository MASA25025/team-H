package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;


public class StudentDao extends DAO {
//	汎用的に使うselect文を定義しておく
	private String baseSql = "select * from student where school_cd =?";

	public Student get(String no)throws  Exception{
		Student student = new Student();

		Connection connection = getConnection();

		PreparedStatement statement = null;

		try{
			statement = connection.prepareStatement("select * from student where no =?");
			statement.setString(1, no);

			ResultSet rSet = statement.executeQuery();

			SchoolDao schoolDao = new SchoolDao();
			if(rSet.next()){
				student.setNo(rSet.getString("no"));
				student.setName(rSet.getString("name"));
				student.setEntYear(rSet.getInt("ent_yaer"));
				student.setClassNum(rSet.getString("class_num"));
				student.setAttend(rSet.getBoolean("is_attend"));
				student.setSchool(SchoolDao.get(rSet.getString("school_cd")));
			}else{
				student = null;
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
		return student;
	}
//	フィルター後のリストへの格納処理をするメソッド
	public List<Student> postFilter(ResultSet rSet, School school)throws Exception {
		List<Student> list = new ArrayList<>();
		try{
			while (rSet.next()){
//				Studentインスタンスの初期化
				Student student = new Student();
//				インスタンスに結果をセット
				student.setNo(rSet.getString("no"));
				student.setName(rSet.getString("name"));
				student.setEntYear(rSet.getInt("ent_yaer"));
				student.setClassNum(rSet.getString("class_num"));
				student.setAttend(rSet.getBoolean("is_attend"));
				student.setSchool(school);

				list.add(student);
			}
		}catch (SQLException | NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

//	学校、入学年度、クラス番号、在学フラグを指定s手学生の一覧を取得するメソッド
	public List<Student> filter(School school, int entYear, String classNum, Boolean isAttend ) throws Exception {
		List<Student> list = new ArrayList<>();

		Connection connection = getConnection();

		PreparedStatement statement = null;

		ResultSet rSet = null;

		String condition = "and ent_yaer =? and class_num =?";

		String order = "order by no asc";
//		SQL文の在学フラッグ条件
		String conditionIsAttend = "";
		if(isAttend){
			conditionIsAttend = "and_is_attend = true";
		}

		try{
			statement = connection.prepareStatement(baseSql + condition + conditionIsAttend + order);
//			各カラムをバインド
			statement.setString(1, school.getCd());
			statement.setInt(2, entYear);
			statement.setString(3, classNum);
			rSet = statement.executeQuery();
			list = postFilter(rSet, school);
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
		return list;
	}

	public List<Student> filter(School school, int entYear, Boolean isAttend ) throws Exception{
		List<Student> list = new ArrayList<>();

		Connection connection = getConnection();

		PreparedStatement statement = null;

		ResultSet rSet = null;

		String condition = "and ent_yaer=?";

		String order = "order by no asc";

//		SQL文の在学フラグ
		String conditionIsAttend="";
//		trueだった場合
		if (isAttend) {
			conditionIsAttend = "and is_attend=true";
		}

		try{
			statement = connection.prepareStatement(baseSql + condition + conditionIsAttend + order);
			statement.setString(1, school.getCd());
			statement.setInt(2, entYear);
			rSet = statement.executeQuery();
			list = postFilter(rSet, school);
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
		return list;
	}

	// 学校、在学フラグを指定して学生の一覧を取得するメソッド
	//＝＝＝＝＝＝＝＝＝＝＝＝＝初期表示時にこのメソッドを表示する＝＝＝＝＝＝＝＝＝＝＝
	public List<Student> filter(School school, Boolean isAttend ) throws Exception{
		List<Student> list = new ArrayList<>();

		Connection connection = getConnection();

		PreparedStatement statement = null;

		ResultSet rSet = null;

		String order = "order by no asc";

//		SQL文の在学フラグ
		String conditionIsAttend="";
//		trueだった場合
		if (isAttend) {
			conditionIsAttend = "and is_attend=true";
		}

		try{
			statement = connection.prepareStatement(baseSql + conditionIsAttend + order);
			statement.setString(1, school.getCd());
			rSet = statement.executeQuery();
			list = postFilter(rSet, school);
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

		return list;
	}

	//	studentインスタンスをデータベースに保存するメソッド
	public boolean save(Student student) throws Exception{
			Connection connection = getConnection();
			PreparedStatement statement = null;
//			実行件数
			int count = 0;

			try{
				Student old = get(student.getNo());
				if ( old==null ){
//					学生が存在しなかった場合
//					プリペアードステートメントにINSERT文をセット
					statement = connection.prepareStatement(
							"insert into student(no, name, ent_yaer, class_num, is_attend, school_cd) values(?, ?, ?, ?, ?, ?)");
//					プリペアードステートメントに値をバインド
					statement.setString(1, student.getNo());
					statement.setString(2, student.getName());
					statement.setInt(3, student.getEntYear());
					statement.setString(4, student.getClassNum());
					statement.setBoolean(5, student.isAttend());
					statement.setString(6, student.getSchool().getCd());
				}else{
//					学生が存在した場合
//					プリペアードステートメントにUPDATE文をセット
					statement = connection.prepareStatement(
							"update student set name =?, ent_yaer =?, class_num=?, is_attend=?, where no=?");
					statement.setString(1, student.getName());
					statement.setInt(2, student.getEntYear());
					statement.setString(3, student.getClassNum());
					statement.setBoolean(4, student.isAttend());
					statement.setString(5, student.getNo());
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



}
