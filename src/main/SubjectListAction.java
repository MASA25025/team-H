package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDao;
import dao.SubjectDao;

public class SubjectListAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");

		String cd = "";
		String name="";
		String classNum = "";
		List<Subject> subjects = null;
		SubjectDao subDao = new SubjectDao();
		ClassNumDao classNumDao = new ClassNumDao();
		Map<String, String> errors = new HashMap<>();

		cd = req.getParameter("f1");
		name = req.getParameter("f2");
		classNum = req.getParameter("f3");
//		ログインユーザーの学校コードをもとにクラス番号の一覧を取得
		List<String> list = classNumDao.Filter(teacher.getSchool());

//		科目情報を全取得
		subjects = subDao.filter(teacher.getSchool());

		List<Integer> subjectset = new ArrayList<>();
//		登録されている科目をリストに追加
		for (int i = 1; i != 0; i++){
			subjectset.add(i);
		}

		req.setAttribute("cd", cd);
		req.setAttribute("name", name);
//		req.setAttribute("class_num_set", list);

//		jspへフォワード
		req.getRequestDispatcher("subject_list.jsp").forward(req, resp);
	}
}