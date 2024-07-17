package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class LoginAction extends Action {
	public void execute(
			HttpServletRequest req,HttpServletResponse resp) throws Exception{

		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}
