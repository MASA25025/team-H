package main;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		String no = req.getParameter("no");
		Student students = null;
		StudentDao sDao = new StudentDao();
		ClassNumDao classNumDao = new ClassNumDao();

		List<String> list = classNumDao.Filter(teacher.getSchool());

		students = sDao.get(no);

		System.out.print(students.isAttend());

		req.setAttribute("students", students);
		req.setAttribute("class_num_set", list);

		req.getRequestDispatcher("student_update.jsp").forward(req, resp);
	}
}
