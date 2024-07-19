package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.TeacherDao;
import tool.Action;

public class LoginExecuteAction extends Action{
	public void execute(
	        HttpServletRequest req, HttpServletResponse resp
	    ) throws Exception {

	        HttpSession session=req.getSession();

	        String id=req.getParameter("id");
	        String password=req.getParameter("password");

//	        DAO作成時に記入
	        TeacherDao dao=new TeacherDao();
	        Teacher teacher=dao.login(id, password);

	        if (teacher!=null) {
	            session.setAttribute("teacher", teacher);
	            resp.sendRedirect("Menu.action");
	        }

	        req.getRequestDispatcher("login.jsp").forward(req, resp);
	    }
}

