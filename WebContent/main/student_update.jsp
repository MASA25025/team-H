<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">

	<h2>学生情報変更</h2>

	<form action= method="post">
	<div>
		<label>入学年度
			<input value="${studens.ent_year}" readonly="readonly">
		</label>
	</div>
	<div>
		<label>学生番号
			<input value="${studenst.no}" readonly="readonly">
		</label>
	</div>
	<div>
			<label>氏名
			<input type="text" name="neme" value="${students.name}" maxlength="30">
		</label>
	</div>
	<div>
		<label>クラス
		<select name="class_num">
			<option value="${num}">-------</option>
			<c:forEach var="num" items="${class_num_set}" ></c:forEach>
				<option value="${num}" <c:if test="${num==class_num}">selected</c:if>>${year}</option>
		</select>
		</label>
	</div>
	<div>
		<label>在学中
			<input type="checkbox" name="si_attend" <c:if test="${!empty si_attend}">checked</c:if> />
		</label>
	</div>
	<div>
		<button>変更</button>
	</div>

		<a href="">戻る</a>
	</form>

</c:param>

</c:import>
