package main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Test;
import dao.TestDao;
import tool.Action;

public class TestRegistExecuteAction extends Action{
	public void execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {

	int point = Integer.parseInt(request.getParameter("point"));

	Test Test = new Test();
    Test.setPoint(point);

	List<Test> test = new ArrayList<>();
	if (test != null && !test.isEmpty()) {
		test.add(Test); // リストにデータを追加
    }

	TestDao Testdao=new TestDao();
	Testdao.save(test);

	request.getRequestDispatcher("test_regist_done.jsp").forward(request, response);
}
}
