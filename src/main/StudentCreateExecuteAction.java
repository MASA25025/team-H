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

        // フラグ変数を作成
        boolean hasError = false;

        // 入学年度のチェック
        if (entYearStr == null || entYearStr.isEmpty()) {
            req.setAttribute("entYearError", "入学年度を選択してください。");
            hasError = true;
        }

        // 学生番号のチェック
        if (no == null || no.isEmpty()) {
            req.setAttribute("studentNumberError", "学生番号を入力してください。");
            hasError = true;
        }else {
            // 学生番号の重複チェック
            StudentDao studentDao = new StudentDao();
            if (studentDao.isStudentNumberDuplicate(no)) {
                req.setAttribute("studentNumberError", "学生番号が重複しています。");
                hasError = true;
            }
        }

        // 氏名のチェック
        if (name == null || name.isEmpty()) {
            req.setAttribute("nameError", "氏名を入力してください。");
            hasError = true;
        }

        // クラスのチェック
        if (classNum == null || classNum.isEmpty()) {
            req.setAttribute("classNumberError", "クラスを選択してください。");
            hasError = true;
        }

        // エラーがあれば登録ページに戻る
        if (hasError) {
            req.getRequestDispatcher("student_create.jsp").forward(req, resp);
            return;
        }

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
            req.getRequestDispatcher("student_create.jsp").forward(req, resp);
        }
    }
}
