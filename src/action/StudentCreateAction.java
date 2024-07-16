package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Class_Num;
import dao.ClassNumDao;
import tool.Action;

public class StudentCreateAction extends Action{
	public void execute(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		HttpSession session = req.getSession();

//        DAO作成時に記入
        ClassNumDao dao=new ClassNumDao();
        List<Class_Num> ClassNum=dao.all();

        req.setAttribute("class_num", ClassNum);

		req.getRequestDispatcher("sutudent_create.jsp").forward(req, resp);
	}

}