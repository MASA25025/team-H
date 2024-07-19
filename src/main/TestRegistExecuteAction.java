package main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.ClassNumDao;
import dao.SubjectDao;
import dao.TestDao;
import tool.Action;

import java.util.List;

import bean.Test;

public class TestRegistExecuteAction extends Action{
	public void execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {

	HttpSession session=request.getSession();

	Test Test = (Test)session.getAttribute("user");

	List<Test> test = new ArrayList<>();
	if (test != null && !test.isEmpty()) {
		test.add(); // リストにデータを追加
    }
}
