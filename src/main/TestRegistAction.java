//成績管理一覧画面へのaction ほぼ完成
package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.ClassNumDao;
import dao.SubjectDao;
import dao.TestDao;
import tool.Action;

public class TestRegistAction extends Action{
	public void execute(
	        HttpServletRequest request, HttpServletResponse response
	    ) throws Exception {

			HttpSession session=request.getSession();
			String entYearStr="";
			LocalDate todaysDate = LocalDate.now();
			int year = todaysDate.getYear();

			Teacher teacher = (Teacher)session.getAttribute("user");

			int ent_year = 0;
			String class_num = "";
			String subject = "";
			int num = 0;


			ent_year = Integer.parseInt(request.getParameter("entyear"));
			class_num = request.getParameter("class_num");
			subject = request.getParameter("subject_name");
			num = Integer.parseInt(request.getParameter("no"));



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
	        if (subject == null){
		        List<Subject> Subject =SJdao.Filter(teacher.getSchool());


	//	        ここでJSPで必要なものをsetAttribute
		        request.setAttribute("class_num", ClassNum);
		        request.setAttribute("subject", Subject);
		        request.setAttribute("ent_year_set", entYearSet);

		        request.getRequestDispatcher("test_regist.jsp").forward(request, response);
	//	        成績管理一覧画面へ続く

	        }else{

		        Subject Subject =SJdao.get(subject);

				TestDao Testdao=new TestDao();
				List<Test> Test=Testdao.filter(ent_year,class_num,Subject,num,teacher.getSchool());

				System.out.print(Test);

				request.setAttribute("Test", Test);
				request.setAttribute("Subject", Subject);
				request.setAttribute("entyear", ent_year);

				request.getRequestDispatcher("test_regist.jsp").forward(request, response);
	        }
	}
}
