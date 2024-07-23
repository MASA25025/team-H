package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentCreateExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        // リクエストパラメータを取得
        String no = req.getParameter("no");
        String name = req.getParameter("name");
        String entYearStr = req.getParameter("ent_year");
        String classNum = req.getParameter("class_num");
        int entYear = Integer.parseInt(entYearStr);
        boolean isAttend = true;


        // Studentインスタンスの作成
        Student student = new Student();
        student.setNo(no);
        student.setName(name);
        student.setEntYear(entYear);
        student.setClassNum(classNum);
        student.setAttend(isAttend);
        student.setSchool(teacher.getSchool());

        // StudentDaoを使用して学生情報を保存
        StudentDao studentDao = new StudentDao();
        boolean result = studentDao.save(student);

        if (result) {
            // 成功メッセージをリクエストに設定
            req.setAttribute("message", "学生情報が登録されました。");
            req.getRequestDispatcher("student_create_done.jsp").forward(req, resp);
        } else {
            // エラーメッセージをリクエストに設定
            req.setAttribute("error", "学生情報の登録に失敗しました。");
        }

        // JSPページにフォワード
        req.getRequestDispatcher("student_create_done.jsp").forward(req, resp);
    }
}
