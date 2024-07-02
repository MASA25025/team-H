package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDAO;

public class LoginExecuteAction {
	public String execute(
	        HttpServletRequest request, HttpServletResponse response
	    ) throws Exception {

	        HttpSession session=request.getSession();

	        String login=request.getParameter("login");
	        String password=request.getParameter("password");

//	        DAO作成時に記入
	        TeacherDAO dao=new TeacherDAO();
	        Teacher teacher=dao.login(login, password);

	        if (teacher!=null) {
	            session.setAttribute("teacher", teacher);
	            return "menu.jsp";
	        }

	        return "login.jsp";
	    }
}

