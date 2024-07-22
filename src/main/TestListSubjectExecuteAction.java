package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Teacher;
import bean.TestListSubject;
import dao.DAO;
import dao.TestListSubjectDao;

public class TestListSubjectExecuteAction extends DAO{

	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		List<TestListSubject> TLsubject = null;
		TestListSubjectDao TLSdao = new TestListSubjectDao();
		School school = teacher.getSchool();
		String school_cd = school.getCd();
		String entYearStr = "";
		int	entYear =0;
		String classNum = "";
		String Subject_cd = "";

		try{
		entYearStr = req.getParameter("f1");
		entYear = Integer.parseInt(entYearStr);
		classNum = req.getParameter("f2");
		Subject_cd = req.getParameter("f3");

		TLsubject = TLSdao.filter(entYear, classNum, Subject_cd, school_cd);

		}catch (Exception e) {
			// TODO: handle exception
		}

		req.setAttribute("subjects", TLsubject);

		req.getRequestDispatcher("test_list.jsp").forward(req, resp);
	}

}
