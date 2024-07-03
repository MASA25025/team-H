<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">

<div class="menu-header">
	<h2>成績管理</h2>
</div>

		<form action="update" method="get">
		
		<div class="pepepe">
		<p>
		入学年度<br>
			<select name="student_id">
			</select>
		</p>
		<p>
		クラス<br>
			<select name="student_id">
			</select>
		</p>
		<p>
		科目<br>
			<select name="student_id">
			</select>
		</p>
		<p>
		回数<br>
			<select name="student_id">
			</select>
		</p>

		<input type="submit" value="検索">
		</div>
		</form>
		
		<style>
		
		
		</style>

</c:param>

</c:import>