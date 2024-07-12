package tool;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"*.action"})
public class FrontController extends HttpServlet{
	public void  doGet(HttpServletRequest req, HttpServletResponse resp
			)throws ServletException, IOException {

		try{
			String path=req.getServletPath().substring(1);
			String name=path.replace(".a", "A").replace('/', '.');

			Action action=(Action)Class.forName(name).getDeclaredConstructor().newInstance();

			action.execute(req, resp);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse reqp)throws ServletException, IOException {
		doGet(req, reqp);

	}
}
