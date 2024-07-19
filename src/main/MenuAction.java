package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class MenuAction extends Action {
	public void execute(
			HttpServletRequest req,HttpServletResponse resp
	) throws Exception{

		req.getRequestDispatcher("menu.jsp").forward(req, resp);
	}
}
