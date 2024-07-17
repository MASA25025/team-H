package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action {
	public void execute(
		HttpServletRequest req, HttpServletResponse resp
	) throws Exception {

		HttpSession session=req.getSession();

		if (session.getAttribute("teacher")!=null) {
			session.removeAttribute("teacher");
			req.getRequestDispatcher("logout.jsp").forward(req, resp);
		}

		req.getRequestDispatcher("menu.jsp").forward(req, resp);
	}
}