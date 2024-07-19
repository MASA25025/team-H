package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Test;
import dao.TestDao;

public class TestRegistExecuteAction {
	public String execute(
	        HttpServletRequest request, HttpServletResponse response
	    ) throws Exception {

		List<Test> Test = new ArrayList<>();
		
		int point = Integer.parseInt(request.getParameter("point"));

		TestDao Testdao=new TestDao();
		Testdao.save(Test);

		return "test_regist.jsp";
	    }
}
