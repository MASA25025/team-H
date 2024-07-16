//成績管理一覧画面へのaction
package action;

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

public class TestRegistAction {
	public String execute(
	        HttpServletRequest request, HttpServletResponse response
	    ) throws Exception {

			HttpSession session=request.getSession();

			Teacher teacher = (Teacher)session.getAttribute("user");

//	        ClassNumDAO
	        ClassNumDao dao=new ClassNumDao();
	        List<String> ClassNum=dao.Filter(teacher.getSchool());

//	        SubjectDAO
	        SubjectDao SJdao=new SubjectDao();
	        List<Subject> Subject =SJdao.Filter(teacher.getSchool());

//	        ここでJSPで必要なものをsetAttribute
	        request.setAttribute("class_num", ClassNum);
	        request.setAttribute("subject", Subject);

//	        成績管理一覧画面へ続く
	        return "test_regist.jsp";
	    }

	protected String doPost(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

				int ent_year = Integer.parseInt(request.getParameter("ent_year"));
				String class_num = request.getParameter("class_num");
				String subject_name = request.getParameter("subject_name");
				int sub_cou = Integer.parseInt(request.getParameter("sub_cou"));

				TestDao Testdao=new TestDao();
				List<Test> Test=Testdao.filter(ent_year,class_num,subject_name,sub_cou);

				request.setAttribute("Test", Test);

				return "test_regist.jsp";
	}
}
