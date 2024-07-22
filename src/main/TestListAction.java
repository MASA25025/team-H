package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
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

			Teacher teacher = (Teacher)session.getAttribute("user");
			Student student = (Student)session.getAttribute("user");

//	        ClassNumDAO
	        ClassNumDao dao=new ClassNumDao();
	        List<String> ClassNum=dao.Filter(teacher.getSchool());

//	        SubjectDAO
	        SubjectDao SJdao=new SubjectDao();
	        List<Subject> Subject =SJdao.Filter(teacher.getSchool());

//	        ここでJSPで必要なものをsetAttribute
	        request.setAttribute("class_num", ClassNum);
	        request.setAttribute("subject", Subject);
	        request.setAttribute("student", student);

	        request.getRequestDispatcher("test_list.jsp").forward(request, response);
//	        成績管理一覧画面へ続く
	    }
}
