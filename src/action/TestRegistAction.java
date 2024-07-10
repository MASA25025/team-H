//成績管理一覧画面へのaction
package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Class_Num;
import bean.Test;
import dao.ClassNumDao;
import dao.SubjectDao;
import dao.TestDao;

public class TestRegistAction {
	public String execute(
	        HttpServletRequest request, HttpServletResponse response
	    ) throws Exception {

	        HttpSession session=request.getSession();

//	        ログイン時に作成されたsessionからcdを取り出す
	        String cd = (String) session.getAttribute("cd");

//	        DAO
	        ClassNumDao dao=new ClassNumDao();
	        List<Class_Num> ClassNum=dao.Filter(cd);

//	        SubjectDAO
	        SubjectDao SJdao=new SubjectDao();
	        String Subject=SJdao.get(cd);

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
