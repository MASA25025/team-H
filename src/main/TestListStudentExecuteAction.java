package main;

import java.time.LocalDate;
import java.util.ArrayList;
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

		req.setAttribute("f1", null);
		req.setAttribute("student", student);
		req.setAttribute("studentList", studentlist);

		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear();
//		入学年度をInt型にし、プルダウン用にリストをつくる
		List<Integer> entYearSet = new ArrayList<>();
//		10年前から1年後までの年をリストに追加
		for (int i = year - 10; i < year + 1; i++){
			entYearSet.add(i);
		}
		req.setAttribute("s1", entYearSet);

		req.getRequestDispatcher("test_list.jsp").forward(req, resp);

	}

}
