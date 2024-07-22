package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDao;
import dao.SubjectDao;
import tool.Action;

public class TestListAction extends Action{
	public void execute(
	        HttpServletRequest request, HttpServletResponse response
	    ) throws Exception {

			HttpSession session=request.getSession();
			String entYearStr="";
			LocalDate todaysDate = LocalDate.now();
			int year = todaysDate.getYear();

			Teacher teacher = (Teacher)session.getAttribute("user");

//			入学年度をInt型にし、プルダウン用にリストをつくる
			List<Integer> entYearSet = new ArrayList<>();
//			10年前から1年後までの年をリストに追加
			for (int i = year - 10; i < year + 1; i++){
				entYearSet.add(i);
			}

//	        ClassNumDAO
	        ClassNumDao dao=new ClassNumDao();
	        List<String> ClassNum=dao.Filter(teacher.getSchool());


//	        SubjectDAO
	        SubjectDao SJdao=new SubjectDao();
	        List<Subject> Subject =SJdao.Filter(teacher.getSchool());
	        System.out.print("エラー確認" + Subject);

//	        ここでJSPで必要なものをsetAttribute
	        request.setAttribute("class_num", ClassNum);
	        request.setAttribute("subject", Subject);
	        request.setAttribute("ent_year_set", entYearSet);

	        request.getRequestDispatcher("test_list.jsp").forward(request, response);
//	        成績管理一覧画面へ続く
	    }
}
