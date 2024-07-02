package tool;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={""})
public class FrontController extends HttpServlet{
	public void  doPost(HttpServletRequest req, HttpServletResponse resp
			)throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		try{
			String path=req.getServletPath().substring(1);
			String name=path.replace(".a", "A").replace('/', '.');

			Action action=(Action)Class.forName(name).getDeclaredConstructor().newInstance();

			String url=action.execute(req, resp);
			req.getRequestDispatcher(url).forward(req, resp);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(out);
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse reqp)throws ServletException, IOException {
		doGet(req, reqp);

	}
}
