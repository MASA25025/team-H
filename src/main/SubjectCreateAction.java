package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;
import tool.Action;

public class SubjectCreateAction extends Action{
	public void execute(
	        HttpServletRequest req, HttpServletResponse resp
	    ) throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		ClassNumDao classNumDao = new ClassNumDao();

		List<String> list = classNumDao.Filter(teacher.getSchool());

		System.out.print(teacher);

		req.setAttribute("class_num_set", list);


	     req.getRequestDispatcher("subject_create.jsp").forward(req, resp);
	}

}