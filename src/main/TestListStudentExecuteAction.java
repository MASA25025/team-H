package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.TestListStudent;
import dao.TestListStudentDao;
import tool.Action;

public class TestListStudentExecuteAction extends Action{

	public TestListStudentExecuteAction(){
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = req.getSession();
		String noStr = "";
		List<TestListStudent> studentlist = null;
		TestListStudentDao tsDao = new TestListStudentDao();

		noStr = req.getParameter("f1");

		studentlist = tsDao.filter(noStr);

		req.setAttribute("studentList", studentlist);

		req.getRequestDispatcher("test_regist.jsp").forward(req, resp);

	}

}
