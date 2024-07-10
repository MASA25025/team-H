package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Class_Num;
import dao.ClassNumDao;
import tool.Action;

public class StudentCreateAction extends Action{
	public String execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();

//        DAO作成時に記入
        ClassNumDao dao=new ClassNumDao();
        List<Class_Num> ClassNum=dao.all();

        request.setAttribute("class_num", ClassNum);

        return "student_create.jsp";
	}

}