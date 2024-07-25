package main;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		String cd = req.getParameter("cd");
		Subject subjects = null;
		SubjectDao subDao = new SubjectDao();

		subjects = subDao.get(cd, teacher.getSchool());

		req.setAttribute("subjects", subjects);

		req.getRequestDispatcher("subject_delete.jsp").forward(req, resp);
	}
}
