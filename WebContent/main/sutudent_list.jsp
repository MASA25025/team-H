<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">


	<h1 id="menu-header">成績管理</h1>

			<div style="height:26px;">
				<a  id="new_stu" href="student_create.jsp">新規登録</a>
			</div>

			<form action="update" method="get">

				<div id="form">
					<a class="form_elm">
					入学年度<br>
						<select name="ent_year">
						</select>
					</a>
					<a class="form_elm">
					クラス<br>
						<select name="class_num">
						</select>
					</a>
					<a class="div_input">
						<input type="checkbox" name="is_there">在学中
					</a>
					<a class="div_input">
					<input id="search" type="submit" value="絞込み">
					</a>
				</div>
				</form>
			<div id="result">検索結果：{{}}件

			</div>
		<style>
			#menu-header{
				font-size:x-large;
				border:none 1px #CCCCCC;
				border-radius:12px;
				background-color:#EEEEEE;
				height:36px;
				padding:8px;
				Vertical-align: middle
			}
			#new_stu{
				display: flex;
 				justify-content: flex-end;

			}
			#form{
				border: solid 1px #C0C0C0;
				border-radius:12px;
				display:flex;
				padding:12px
			}
			.form_elm{
				font-size:large;
				height:48px;
				width:  280px;
			}
			.div_input{
				width:160px;
			}
			#subject{
				height:48px;
				width:256px;
			}
			#search{
				height:36px;
				width: 72px;
				background-color:#555555;
				color:white;
				border:none 1px #555555;
				border-radius:6px;
			}


		</style>

</c:param>

</c:import>