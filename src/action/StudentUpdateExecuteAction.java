package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");


		 String no = req.getParameter("no");
	     String name = req.getParameter("name");
	     int entYear = Integer.parseInt(req.getParameter("entYear"));
	     String classNum = req.getParameter("classNum");
	     boolean isAttend = Boolean.parseBoolean(req.getParameter("isAttend"));
	     String schoolCd = req.getParameter("schoolCd");

	     School school = new School();
	     school.setCd(schoolCd);

         // 学生オブジェクトを作成
         Student student = new Student();
         student.setNo(no);
         student.setName(name);
         student.setEntYear(entYear);
         student.setClassNum(classNum);
         student.setAttend(isAttend);
         student.setSchool(school);

	     StudentDao studentDao = new StudentDao();

	     try {
	            boolean success = studentDao.save(student);
	            if (success) {
	                req.setAttribute("message", "学生情報が更新されました。");
	            } else {
	                req.setAttribute("message", "学生情報の更新に失敗しました。");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            req.setAttribute("message", "エラーが発生しました: " + e.getMessage());
	        }

	     req.getRequestDispatcher(".jsp").forward(req, resp);

	}

}
