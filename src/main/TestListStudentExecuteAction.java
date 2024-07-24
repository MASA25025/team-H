package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.TestListStudent;
import dao.ClassNumDao;
import dao.StudentDao;
import dao.SubjectDao;
import dao.TestListStudentDao;
import tool.Action;

public class TestListStudentExecuteAction extends Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
		String noStr = "";
		List<TestListStudent> studentlist = null;
		TestListStudentDao tsDao = new TestListStudentDao();
		Student student = null;
		StudentDao sDao = new StudentDao();
		noStr = req.getParameter("f1");

		studentlist = tsDao.filter(noStr);
		student = sDao.get(noStr);

		req.setAttribute("f1", null);
		req.setAttribute("student", student);
		req.setAttribute("studentList", studentlist);

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


//      ここでJSPで必要なものをsetAttribute
        req.setAttribute("ent_year_set", entYearSet);
        req.setAttribute("class_num", ClassNum);
        req.setAttribute("subject", Subject);


		req.getRequestDispatcher("test_list.jsp").forward(req, resp);

	}

}
