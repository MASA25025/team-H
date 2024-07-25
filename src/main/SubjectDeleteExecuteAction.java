package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action {
	public void execute(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher)session.getAttribute("user");
        String cd = req.getParameter("cd");
        String name = req.getParameter("name");

        System.out.print(teacher);
        System.out.print(cd);
        System.out.print(name);

		SubjectDao subDao = new SubjectDao();

		Subject subject = new Subject();
		subject.setCd(cd);
		subject.setName(name);
		subject.setSchool(teacher.getSchool());

		boolean subjects = subDao.delete(subject);


        if (subjects) {
            // 成功メッセージをリクエストに設定
            req.setAttribute("message", "科目情報が更新されました。");
            req.getRequestDispatcher("subject_delete_done.jsp").forward(req, resp);
        } else {
            // エラーメッセージをリクエストに設定
            req.setAttribute("error", "科目情報の更新に失敗しました。");
        }
	}
}