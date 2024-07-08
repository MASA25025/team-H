package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDao;

public class TestRegistAction {
	public String execute(
	        HttpServletRequest request, HttpServletResponse response
	    ) throws Exception {

	        HttpSession session=request.getSession();

	        String school_cd = (String) session.getAttribute("school_cd");

//	        DAO作成時に記入
	        TeacherDao dao=new TeacherDao();
	        Teacher teacher=dao.login(school_cd);

	        if (teacher!=null) {
	            session.setAttribute("teacher", teacher);
	            return "menu.jsp";
	        }

	        return "login.jsp";
	    }
}
