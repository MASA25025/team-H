package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import bean.TestListStudent;
import dao.StudentDao;
import dao.TestListStudentDao;
import tool.Action;

public class TestListStudentExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
//		HttpSession session = req.getSession();
		String noStr = "";
		List<TestListStudent> studentlist = null;
		TestListStudentDao tsDao = new TestListStudentDao();
		Student student = null;
		StudentDao sDao = new StudentDao();
		noStr = req.getParameter("f1");

		studentlist = tsDao.filter(noStr);
		student = sDao.get(noStr);

		System.out.print(noStr);
		System.out.print(studentlist);
		System.out.print(student);

		req.setAttribute("f1", null);
		req.setAttribute("student", student);
		req.setAttribute("studentList", studentlist);

		req.getRequestDispatcher("test_list.jsp").forward(req, resp);

	}

}
