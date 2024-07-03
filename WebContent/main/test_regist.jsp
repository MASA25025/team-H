<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">

<div class="menu-header">
	<h2>成績管理</h2>
</div>
		<div id="form_search">
			<form action="update" method="get">

				<div id="form">
					<a class="form_elm">
					入学年度<br>
						<select name="student_id">
						</select>
					</a>
					<a class="form_elm">
					クラス<br>
						<select name="student_id">
						</select>
					</a>
					<a class="form_elm">
					科目<br>
						<select name="student_id">
						</select>
					</a>
					<a class="form_elm">
					回数<br>
						<select name="student_id">
						</select>
					</a>
				</div>

				<div id="input">
					<input type="submit" value="検索">
				</div>

			</form>
		</div>
		<style>
			#form_search{
				display:flex;
				position: relative;
				}
			#form{
				position: relative;
				display:flex;
			}
			.form_elm{
				width:  96px;
			}
			#input{
				right:0;
			}

		</style>

</c:param>

</c:import>