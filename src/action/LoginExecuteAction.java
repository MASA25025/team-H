package action;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDao;

@WebServlet(urlPatterns = { "/main/login" })
public class LoginExecuteAction {
	public String execute(
	        HttpServletRequest request, HttpServletResponse response
	    ) throws Exception {

	        HttpSession session=request.getSession();

	        String id=request.getParameter("id");
	        String password=request.getParameter("password");

//	        DAO作成時に記入
	        TeacherDao dao=new TeacherDao();
	        Teacher teacher=dao.login(id, password);

	        if (teacher!=null) {
	            session.setAttribute("teacher", teacher);
	            return "menu.jsp";
	        }

	        return "login.jsp";
	    }
}

