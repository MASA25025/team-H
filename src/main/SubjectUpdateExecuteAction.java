package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        // リクエストパラメータを取得
        String cd = req.getParameter("cd");
        String name = req.getParameter("name");
        String classNum = req.getParameter("class_num");

        // Subjectインスタンスの作成
        Subject subject = new Subject();
        subject.setCd(cd);
        subject.setName(name);
        subject.setSchool(teacher.getSchool());

        // SubjectDaoを使用して学生情報を保存
        SubjectDao subjectDao = new SubjectDao();
        boolean result = subjectDao.save(subject);

        if (result) {
            // 成功メッセージをリクエストに設定
            req.setAttribute("message", "科目情報が更新されました。");
            req.getRequestDispatcher("subject_update_done.jsp").forward(req, resp);
        } else {
            // エラーメッセージをリクエストに設定
            req.setAttribute("error", "科目情報の更新に失敗しました。");
        }

        // JSPページにフォワード
        req.getRequestDispatcher("subject_update_done.jsp").forward(req, resp);
    }
}