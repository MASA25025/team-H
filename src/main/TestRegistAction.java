//成績管理一覧画面へのaction ほぼ完成
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
import bean.Test;
import dao.ClassNumDao;
import dao.StudentDao;
import dao.SubjectDao;
import dao.TestDao;
import tool.Action;

public class TestRegistAction extends Action{
	public void execute(
	        HttpServletRequest request, HttpServletResponse response
	    ) throws Exception {
		System.out.println("TestRegistAction実行");

			HttpSession session=request.getSession();
			Teacher teacher = (Teacher)session.getAttribute("user");

			boolean isAttend= true;
			String ent_year="";
			String class_num = "";
			String subject = "";
			String st_num = "";
			int num = 0;
			int entYear = 0;
			LocalDate todaysDate = LocalDate.now();
			int year = todaysDate.getYear();
			List<Test> test = null;
			List<Subject> subjects = null;
			Subject subjectss = null;
			List<Student> students = null;
			System.out.println("定義完了");

			ent_year = request.getParameter("ent_year");
			class_num = request.getParameter("class_num");
			subject = request.getParameter("subject_cd");
			st_num = request.getParameter("no");
			System.out.println("get完了");
			System.out.println("ent_year：" + ent_year);
			System.out.println("class_num：" + class_num);
			System.out.println("subject：" + subject);
			System.out.println("st_num：" + st_num);

			if (ent_year != null){
				entYear=Integer.parseInt(ent_year);
			}

			if (st_num != null){
				num = Integer.parseInt(request.getParameter("no"));
			}


			request.setAttribute("entyear",entYear );
			request.setAttribute("class_num",class_num );
			request.setAttribute("subject_cd",subject );
			request.setAttribute("no",num );


			System.out.print(subject);



//			入学年度をInt型にし、プルダウン用にリストをつくる
			List<Integer> ent_yearSet = new ArrayList<>();
//			10年前から1年後までの年をリストに追加
			for (int i = year - 10; i < year + 1; i++){
				ent_yearSet.add(i);
			}
			System.out.print(ent_yearSet);

//	        ClassNumDAO
	        ClassNumDao dao=new ClassNumDao();
	        List<String> ClassNum=dao.Filter(teacher.getSchool());
	        System.out.print(ClassNum);

//	        SubjectDAO
	        SubjectDao SJdao=new SubjectDao();
	        if (subject == null){
		        subjects =SJdao.filter(teacher.getSchool());
		        System.out.print(subjects);


	        }else{

		        subjectss =SJdao.get(subject,teacher.getSchool());

				TestDao Testdao=new TestDao();
				test=Testdao.filter(entYear,class_num,subjectss,num,teacher.getSchool());

				if (test == null){

					StudentDao sDao = new StudentDao();

					if(entYear != 0 && !class_num.equals("0")){
//						入学年度とクラス番号を指定
						students = sDao.filter(teacher.getSchool(), entYear, class_num, isAttend);
					}else if (entYear != 0 && class_num.equals("0")) {
//						入学年度のみ指定
						students = sDao.filter(teacher.getSchool(), entYear, isAttend);
					}else if (entYear ==0 && class_num ==null || entYear ==0&& class_num.equals("0")) {
//						指定なしの場合
//						学生情報を全取得
						students = sDao.filter(teacher.getSchool(), isAttend);
				}
	        }

//	        ここでJSPで必要なものをsetAttribute
	        request.setAttribute("class_num", ClassNum);
	        request.setAttribute("subject", subjects);
	        request.setAttribute("ent_year_set", ent_yearSet);


			request.setAttribute("Test", test);
			request.setAttribute("Subject", subjectss);
			request.setAttribute("students", students);
			request.setAttribute("entyear", ent_year);

			request.getRequestDispatcher("test_regist.jsp").forward(request, response);
//	        成績管理一覧画面へ続く
	}
	}
}
