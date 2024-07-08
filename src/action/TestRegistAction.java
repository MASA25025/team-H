package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Class_Num;
import dao.ClassNumDao;

public class TestRegistAction {
	public String execute(
	        HttpServletRequest request, HttpServletResponse response
	    ) throws Exception {

	        HttpSession session=request.getSession();

	        String cd = (String) session.getAttribute("cd");

//	        DAO作成時に記入
	        ClassNumDao dao=new ClassNumDao();
	        List<Class_Num> ClassNum=dao.Filter(cd);

	        request.setAttribute("class_num", ClassNum);

	        return "login.jsp";
	    }
}
