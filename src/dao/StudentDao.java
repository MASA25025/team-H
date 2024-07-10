package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;


public class StudentDao extends DAO {

	// 学生情報を学生番号で取得するメソッド
    public Student get(String no) {
        String sql = "SELECT * FROM students WHERE student_number = ?";
        Connection connection = getConnection();
         	PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, no);
            ResultSet rs = preparedStatement.executeQuery();

            //            resultSet.next();
// 				学生情報を取得してStudentオブジェクトを作成
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");

                // 他のカラムも同様に取得
			// Productクラスをインスタンス化
			Student p = new Student();
			School q = new School();
			// 値をセット
			p.setEntYear(rs.getInt("id"));
			p.setNo(rs.getString("name"));
			p.setName(rs.getString("price"));
			p.setClassNum(rs.getString("classnum"));
			p.setAttend(rs.getBoolean("attend"));

			q.setCd(rs.getString("cd"));
			p.setSchool(q);
            return ;



    }



	public List<Student> filter(School school, String entYear, String classNum, String isAttend ) throws Exception {
		List<Student> studentlist = new ArrayList<Student>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from student where ent_year like ?");
		st.setString(1, "%" + entYear + "%");
		st.setString(2, "%" + classNum + "%");
		st.setString(3, "%" + isAttend + "%");

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			// Productクラスをインスタンス化
			Student p = new Student();
			School q = new School();
			// 値をセット
			p.setEntYear(rs.getInt("id"));
			p.setNo(rs.getString("name"));
			p.setName(rs.getString("price"));
			p.setClassNum(rs.getString("classnum"));
			p.setAttend(rs.getBoolean("attend"));

			q.setCd(rs.getString("cd"));
			p.setSchool(q);

			// リストに追加
			studentlist.add(p);
		}

		st.close();
		con.close();

		return studentlist;
	}





}
