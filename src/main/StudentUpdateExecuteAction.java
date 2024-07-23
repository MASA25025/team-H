package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        // リクエストパラメータを取得
        String no = req.getParameter("no");
        String name = req.getParameter("name");
        String entYearStr = req.getParameter("ent_year");
        String classNum = req.getParameter("class_num");
        String isAttendStr = req.getParameter("is_attend");
        int entYear = Integer.parseInt(entYearStr);
        boolean isAttend = Boolean.parseBoolean(isAttendStr);

        System.out.print("変更"+no);
        System.out.print("変更"+name);
        System.out.print("変更"+entYear);
        System.out.print("変更"+classNum);
        System.out.print("変更"+isAttend);


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
            req.setAttribute("message", "学生情報が更新されました。");
            req.getRequestDispatcher("student_update_done.jsp").forward(req, resp);
        } else {
            // エラーメッセージをリクエストに設定
            req.setAttribute("error", "学生情報の更新に失敗しました。");
        }

        // JSPページにフォワード
        req.getRequestDispatcher("student_update_done.jsp").forward(req, resp);
    }
}
