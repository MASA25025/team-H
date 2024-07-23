package main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;
import tool.Action;

public class SubjectCreateAction extends Action{
	public void execute(
	        HttpServletRequest request, HttpServletResponse response
	    ) throws Exception {

			HttpSession session=request.getSession();
			Teacher teacher = (Teacher)session.getAttribute("user");

//	        ClassNumDAO
	        ClassNumDao dao=new ClassNumDao();
	        List<String> ClassNum=dao.Filter(teacher.getSchool());

//	        ここでJSPで必要なものをsetAttribute
	        request.setAttribute("class_num", ClassNum);

	        request.getRequestDispatcher("subject_regist.jsp").forward(request, response);
//	        科目管理一覧画面へ続く
	}
}