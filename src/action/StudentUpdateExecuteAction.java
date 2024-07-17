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

	     boolean students = studentDao.save(student);

            if (students = true) {
            	req.getRequestDispatcher("student_update_done.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "学生情報の更新に失敗しました。");
            }

	     req.getRequestDispatcher("student_update_done.jsp").forward(req, resp);

	}

}
