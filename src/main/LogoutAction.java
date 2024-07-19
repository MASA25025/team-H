package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action {
	public void execute(
		HttpServletRequest req, HttpServletResponse resp
	) throws Exception {

		HttpSession session=req.getSession();

		if (session.getAttribute("user")!=null) {
			session.removeAttribute("user");
			req.getRequestDispatcher("logout.jsp").forward(req, resp);
		}

		req.getRequestDispatcher("logout.jsp").forward(req, resp);
	}
}