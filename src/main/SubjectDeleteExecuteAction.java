package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;

public class SubjectDeleteExecuteAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
        String cd = req.getParameter("cd");
        String name = req.getParameter("name");
		SubjectDao subDao = new SubjectDao();

		Subject subject = new Subject();
		subject.setCd(cd);
		subject.setName(name);
		subject.setSchool(teacher.getSchool());

		boolean subjects = subDao.delete(subject);

		req.setAttribute("subjects", subjects);

		req.getRequestDispatcher("subject_delete.jsp").forward(req, resp);
	}
}