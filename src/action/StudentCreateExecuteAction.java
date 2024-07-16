package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

@WebServlet("/StudentCreateExecuteAction")
public class StudentCreateExecuteAction extends Action {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // フォームパラメータを取得
        String entryYear = request.getParameter("entryYear");
        String studentNumber = request.getParameter("studentNumber");
        String name = request.getParameter("name");
        // エラーメッセージを保持するリスト
        List<String> errors = new ArrayList<>();

        // 入学年の検証
        if (entryYear == null || entryYear.isEmpty()) {
            errors.add("入学年度を選択してください");
        }

        // 学生番号の検証
        if (studentNumber == null || studentNumber.isEmpty()) {
            errors.add("学生番号を入力してください");
        } else if (isDuplicateStudentNumber(studentNumber)) {
            errors.add("学生番号が重複しています");
        }

        // 氏名の検証
        if (name == null || name.isEmpty()) {
            errors.add("氏名を入力してください");
        }

        // エラーがあるかどうかを確認
        if (!errors.isEmpty()) {
            // エラーをリクエスト属性として設定し、JSPページにフォワード
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("/studentRegister.jsp").forward(request, response);
        } else {
            // 登録処理を実行（例：データベースに学生を保存）
            // ...
            // 成功ページにリダイレクト
            response.sendRedirect("student_create_done.jsp");
        }
    }

    // 学生番号の重複をチェックするメソッド
    private boolean isDuplicateStudentNumber(String studentNumber) {
        boolean isDuplicate = false;

        // データベース接続情報
        String jdbcUrl = "jdbc:h2:tcp://localhost/~/javasd";
        String sql = "sa";

        try (Connection conn = DriverManager.getConnection(jdbcUrl);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentNumber);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    isDuplicate = (count > 0);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDuplicate;
    }

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

	}


}
