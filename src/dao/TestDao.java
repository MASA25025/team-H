//わからないからここに棄てる
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;

public class TestDao extends DAO {
    private String baseSql = "SELECT * FROM test WHERE school_cd = ?";

    public Test get(Student student, Subject subject, School school, int no) throws Exception {
        Test test = new Test();

        Connection connection = getConnection();

        PreparedStatement statement = null;

        try {
        	statement = connection.prepareStatement(
                 baseSql + " AND student_no = ? AND subject_cd = ? AND no = ?");

            statement.setString(1, school.getCd());
            statement.setString(2, student.getNo());
            statement.setString(3, subject.getCd());
            statement.setInt(4, no);

            ResultSet rSet = statement.executeQuery();

            if (rSet.next()) {
                test.setStudent(student);
                test.setClassNum(rSet.getString("class_num"));
                test.setSubject(subject);
                test.setSchool(school);
                test.setNo(rSet.getInt("no"));
                test.setPoint(rSet.getInt("point"));
            }else{
				test = null;
			}
        } catch (Exception e) {
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

        return test;
    }

    private List<Test> postFilter(ResultSet rSet, School school) throws Exception {
        List<Test> list = new ArrayList<>();

        while (rSet.next()) {
            Test test = new Test();
            Student student = new Student();
            Subject subject = new Subject();

            student.setNo(rSet.getString("student_no"));
            student.setSchool(school);
            subject.setCd(rSet.getString("subject_cd"));
            subject.setSchool(school);

            test.setStudent(student);
            test.setClassNum(rSet.getString("class_num"));
            test.setSubject(subject);
            test.setSchool(school);
            test.setNo(rSet.getInt("no"));
            test.setPoint(rSet.getInt("point"));

            list.add(test);
        }

        return list;
    }

    public List<Test> filter(int entYear, String classNum, Subject subject, int num, School school) throws Exception {
        List<Test> list = new ArrayList<>();

        String sql = baseSql + " AND ent_year = ? AND class_num = ? AND subject_cd = ? AND no = ? ORDER BY student_no ASC";

        Connection connection = getConnection();

        PreparedStatement statement = null;

        try{
        	statement = connection.prepareStatement(sql);

            statement.setString(1, school.getCd());
            statement.setInt(2, entYear);
            statement.setString(3, classNum);
            statement.setString(4, subject.getCd());
            statement.setInt(5, num);

            ResultSet rSet = statement.executeQuery();
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

    public boolean save(List<Test> list) throws Exception {
        boolean result = true;

        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);

            for (Test test : list) {
                if (!save(test, connection)) {
                    result = false;
                    break;
                }
            }

            if (result) {
                connection.commit();
            } else {
                connection.rollback();
            }
        }

        return result;
    }

    private boolean save(Test test, Connection connection) throws Exception {
        boolean result;
        String sql;

        if (get(test.getStudent(), test.getSubject(), test.getSchool(), test.getNo()) == null) {
            sql = "INSERT INTO test (student_no, class_num, subject_cd, school_cd, no, point) VALUES (?, ?, ?, ?, ?, ?)";
        } else {
            sql = "UPDATE test SET class_num = ?, point = ? WHERE student_no = ? AND subject_cd = ? AND school_cd = ? AND no = ?";
        }

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, test.getStudent().getNo());
            statement.setString(2, test.getClassNum());
            statement.setString(3, test.getSubject().getCd());
            statement.setString(4, test.getSchool().getCd());
            statement.setInt(5, test.getNo());
            statement.setInt(6, test.getPoint());

            result = statement.executeUpdate() > 0;
        }

        return result;
    }

    public boolean delete(List<Test> list) throws Exception {
        boolean result = true;

        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);

            for (Test test : list) {
                if (!delete(test, connection)) {
                    result = false;
                    break;
                }
            }

            if (result) {
                connection.commit();
            } else {
                connection.rollback();
            }
        }

        return result;
    }

    private boolean delete(Test test, Connection connection) throws Exception {
        boolean result;

        String sql = "DELETE FROM test WHERE student_no = ? AND subject_cd = ? AND school_cd = ? AND no = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, test.getStudent().getNo());
            statement.setString(2, test.getSubject().getCd());
            statement.setString(3, test.getSchool().getCd());
            statement.setInt(4, test.getNo());

            result = statement.executeUpdate() > 0;
        }

        return result;
    }
}