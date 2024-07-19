<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<title>${ param.title }</title>
	<meta charset="UTF-8">
</head>

<style>
	#header{
		background-color: #D9E5FF;
    	padding-top: 12px;
    	padding-bottom: 12px;
    	padding-right: 48px;
    	padding-left: 48px;
		position: relative;
		display:flex;
	}
	#head_li{
		padding:8px;
		display: flex;
		position: absolute;
	    bottom: 0;
		right:48px;
		margin:5px;

	}
	#container{
		width: 100%;
		height: 600px;
		display: flex;
		flex-direction: row;
	}
	#sidebar{
  		box-sizing: border-box;
		width: 15%;
		padding-left: 1rem;
		border-right: solid 1px black;
	}
	#content{
  		box-sizing: border-box;
		width: 85%;
		padding-top: 1rem;
		padding-left: 2rem;
	}
</style>

<body>
	<div id="header">
	<h1 style="font-size: 16px, color: #333;">得点管理システム</h1>
		<div id="head_li">
			<a style="margin-right:8px;">${ user.name }様</a>
			<a style="margin-right:8px;" href="LogoutAction">ログアウト</a>
		</div>
	</div>
	<div id="container">
		<div id="sidebar">
		<nav>
			<ul>
				<li><a href="/Student_Manager/main/menu.jsp">メニュー</a></li>
				<li><a href="/Student_Manager/main/student_list.jsp">学生管理</a></li>
				<li>成績管理
				<ul>
					<li><a href="">成績登録</a></li>
					<li><a href="">成績参照</a></li>
				</ul>
				</li>
				<li><a href="">科目管理</a></li>
			</ul>
		</nav>
		</div>
		<div id="content">${ param.content }</div>
	</div>
</body>

<footer style="text-align: center; background-color: #EEEEEE";>@2023TIC<br>大原学園</footer>
</html>