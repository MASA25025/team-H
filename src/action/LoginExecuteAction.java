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
	 
	        TeacherDAO dao=new TeacherDAO();
	        Teacher customer=dao.search(login, password);
	        
	        if (customer!=null) {
	            session.setAttribute("customer", customer);
	            return "login-out.jsp";
	        }
	        
	        return "login-error.jsp";
	    }
}

