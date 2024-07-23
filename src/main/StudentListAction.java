package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import	java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import tool.Action;

public class StudentListAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		String entYearStr="";
		String classNum = "";
		String isAttendStr = "";
		int entYear = 0;
		boolean isAttend= false;
		List<Student> students = null;
		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear();
		StudentDao sDao = new StudentDao();
		ClassNumDao classNumDao = new ClassNumDao();
		Map<String, String> errors = new HashMap<>();

		entYearStr = req.getParameter("f1");
		classNum = req.getParameter("f2");
		isAttendStr = req.getParameter("f3");

		if (entYearStr != null){
			entYear = Integer.parseInt(entYearStr);
		}
		req.setAttribute("f1", entYear);
		req.setAttribute("f2", classNum);
//		在学フラグの判定
		if(isAttendStr !=null){
			isAttend = true;
			req.setAttribute("f3", isAttendStr);
		}

//		ログインユーザーの学校コードをもとにクラス番号の一覧を取得
		List<String> list = classNumDao.Filter(teacher.getSchool());

		if(entYear != 0 && !classNum.equals("0")){
//			入学年度とクラス番号を指定
			students = sDao.filter(teacher.getSchool(), entYear, classNum, isAttend);
		}else if (entYear != 0 && classNum.equals("0")) {
//			入学年度のみ指定
			students = sDao.filter(teacher.getSchool(), entYear, isAttend);
		}else if (entYear ==0 && classNum ==null || entYear ==0&& classNum.equals("0")) {
//			指定なしの場合
//			学生情報を全取得
			students = sDao.filter(teacher.getSchool(), isAttend);
		}else {
			errors.put("f1", "クラスを指定する場合は入学年度も指定してください");
			req.setAttribute("errors", errors);
//			学生情報を全取得
			students = sDao.filter(teacher.getSchool(), isAttend);
		}

//		入学年度をInt型にし、プルダウン用にリストをつくる
		List<Integer> entYearSet = new ArrayList<>();
//		10年前から1年後までの年をリストに追加
		for (int i = year - 10; i < year + 1; i++){
			entYearSet.add(i);
		}

//		リクエストに学生リストとデータをセット
		req.setAttribute("students", students);
		req.setAttribute("class_num_set", list);
		req.setAttribute("ent_year_set", entYearSet);

//		jspへフォワード
		req.getRequestDispatcher("student_list.jsp").forward(req, resp);
	}

}
