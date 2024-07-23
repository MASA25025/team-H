package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.Teacher;
import bean.TestListSubject;
import dao.ClassNumDao;
import dao.DAO;
import dao.SubjectDao;
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
		entYearStr = req.getParameter("s1");
		entYear = Integer.parseInt(entYearStr);
		classNum = req.getParameter("s2");
		Subject_cd = req.getParameter("s3");

		TLsubject = TLSdao.filter(entYear, classNum, Subject_cd, school_cd);

		}catch (Exception e) {
			// TODO: handle exception
		}
		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear();
//		入学年度をInt型にし、プルダウン用にリストをつくる
		List<Integer> entYearSet = new ArrayList<>();
//		10年前から1年後までの年をリストに追加
		for (int i = year - 10; i < year + 1; i++){
			entYearSet.add(i);
		}
		ClassNumDao classNumDao = new ClassNumDao();
		List<String> Pull_2 = classNumDao.Filter(teacher.getSchool());
		SubjectDao subject = new SubjectDao();
		List<Subject> Pull_3 = subject.Filter(teacher.getSchool());

		req.setAttribute("s1", entYearSet);
		req.setAttribute("s2", Pull_2);
		req.setAttribute("s3", Pull_3);

		req.setAttribute("subjects", TLsubject);

		req.getRequestDispatcher("test_list.jsp").forward(req, resp);
	}

}
