package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import dao.StudentDao;
import tool.Action;

public class StudentListAction extends Action {
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();

		String entYear = request.getParameter("entYear");
		if (entYear == null) {entYear = "";}

		String classNum = request.getParameter("classNum");
		if (classNum == null) {classNum = "";}

		String isAttend = request.getParameter("isAttend");
		if (isAttend == null) {isAttend = "";}


		List<Student> studentlist = new StudentDao().filter(null, entYear, classNum, isAttend);

		session.setAttribute("studentlist", studentlist);

		return "student_list.jsp";

	}
}
