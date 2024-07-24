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
import dao.SubjectDao;
import dao.TestListSubjectDao;
import tool.Action;

public class TestListSubjectExecuteAction extends Action{

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
		String SubjectName = "";

		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear();
//		入学年度をInt型にし、プルダウン用にリストをつくる
		List<Integer> entYearSet = new ArrayList<>();
//		10年前から1年後までの年をリストに追加
		for (int i = year - 10; i < year + 1; i++){
			entYearSet.add(i);
		}

//        ClassNumDAO
        ClassNumDao dao=new ClassNumDao();
        List<String> ClassNum=dao.Filter(teacher.getSchool());

//        SubjectDAO
        SubjectDao SJdao=new SubjectDao();
        List<Subject> Subject =SJdao.filter(teacher.getSchool());



		try{
		entYearStr = req.getParameter("s1");
		entYear = Integer.parseInt(entYearStr);
		classNum = req.getParameter("s2");
		Subject_cd = req.getParameter("s3");

		SubjectName =TLSdao.getSubjectName(Subject_cd);

		TLsubject = TLSdao.filter(entYear, classNum, Subject_cd, school_cd);

		}catch (Exception e) {
			// TODO: handle exception
		}



//        ここでJSPで必要なものをsetAttribute
        req.setAttribute("class_num", ClassNum);
        req.setAttribute("subject", Subject);
        req.setAttribute("ent_year_set", entYearSet);


        req.setAttribute("subject_name", SubjectName);
		req.setAttribute("subjects", TLsubject);

		req.getRequestDispatcher("test_list.jsp").forward(req, resp);
	}

}
