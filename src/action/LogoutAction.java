package action;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends HttpServlet{

	public void get(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession();

		// ログインしている場合
		if (session.getAttribute("session_customer") != null) {
			// セッションから除去してログアウト
			session.removeAttribute("session_customer");
			// ログアウト完了ページを表示
			req.getRequestDispatcher("logout.jsp").forward(req, resp);
			return;
		}

		// ログインしていなかった場合、ログアウトエラーページを表示
		req.getRequestDispatcher("").forward(req, resp);
	

	}

}
