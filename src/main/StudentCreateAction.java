package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;
import tool.Action;

public class StudentCreateAction extends Action{
	public void execute(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear();
		ClassNumDao classNumDao = new ClassNumDao();

        ClassNumDao dao=new ClassNumDao();
//        List<String> ClassNum=dao.Filter(teacher.getSchool());
        List<String> list = classNumDao.Filter(teacher.getSchool());

//		入学年度をInt型にし、プルダウン用にリストをつくる
		List<Integer> entYearSet = new ArrayList<>();
//		10年前から1年後までの年をリストに追加
		for (int i = year - 10; i < year + 1; i++){
			entYearSet.add(i);
		}
		req.setAttribute("class_num_set", list);
		req.setAttribute("ent_year_set", entYearSet);
		req.getRequestDispatcher("student_create.jsp").forward(req, resp);

	}

}