<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/base.jsp">

	<c:param name="title">得点管理システム</c:param>

	<c:param name="content">
	<style>
	#box{border: solid 2px #000}

	#field{
	display:flex;

	}
	#field div{
	  margin: 10px;
	  width: 150px;
	  height: 50px;
	}

	</style>
	<h2>学生管理</h2>

	<div id = box>

	<form action="Student.action" method="post">
	<div id=field>
		<div><label>入学年度<br>
			<select name="f1">
				<c:forEach var="student" items="${ studentlist }">
					<option value="${ student.entYear }">${ course.entYear }コース</option>
				</c:forEach>
			</select>
		</label></div>

		<div><label>クラス<br>
			<select name="f2">
				<c:forEach var="student" items="${ studentlist }">
					<option value="${ student.no }">${ student.no }コース</option>
				</c:forEach>
			</select>
		</label></div>

		<div>
			<label>
			<input type="checkbox" name="f3" value="TRUE" />
			在学中</label>
		</div>

		<div><button type="button">絞り込み</button></div>
	</form>
	</div>
	</div>

		${count < 0 ? count : "学生情報が登録だれていません" }

		<div><c:forEach var="student" items="${ studentlist }">
			<c:if test="count(student) > 0">count(student)</c:if>
			<c:if test="count(student) <= 0">学生情報が登録されていません</c:if>
		</c:forEach> </div>

		<table>
			<tr>
				<th>入学年度</th>
				<th>学生番号</th>
				<th>氏名</th>
				<th>クラス</th>
				<th>在学中</th>
				<th></th>
			</tr>
			<c:forEach var="student" items="${ studentlist }">
				<tr>
					<td>${ student.entYear }</td>
					<td>${ student.no }</td>
					<td>${ student.name }</td>
					<td>${ student.classNum }</td>
					<td><c:if test="${ student.isAttend} = TRUE">〇</c:if>
					<c:if test="${ student.isAttend} = FALSE">×</c:if> </td>
					<td><a href=>変更</a></td>

				</tr>
			</c:forEach>
		</table>
	</c:param>
</c:import>
