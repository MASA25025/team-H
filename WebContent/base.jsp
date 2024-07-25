<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<title>${ param.title }</title>
	<meta charset="UTF-8">
</head>

<style>
	body{
		min-height: 100vh;
  		position: relative;
  		width: 100%;
 		height: 100%;
	}
	#push{
		height: 0;
	}
	footer{
		text-align: center;
		background-color: #EEEEEE;
		width: 100%;
	}
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
		height: 92%;
		display: flex;
		flex-direction: row;
	}
	#sidebar{
  		box-sizing: border-box;
		width: 28%;
		height :100%;
		padding-left: 1rem;

	}
	#content{
  		box-sizing: border-box;
		padding-top: 1rem;
		padding-left: 2rem;
		height : 90%;
		width: 78%;
		border-left: solid 1px black;
	}
	#list{
		width 100%;
	}
	ul{
		list-style: none;
	}
	li{
		font-size:large;
	}
</style>

<body>
	<div id="header">
	<h1 style="font-size: 16px, color: #333;">得点管理システム</h1>
	<c:if test="${!empty user.name }">
		<div id="head_li">
			<a style="margin-right:8px;">${ user.name }様</a>
			<a style="margin-right:8px;" href="Logout.action">ログアウト</a>
		</div>
	</c:if>
	</div>
	<div id="container">
		<c:if test="${!empty user.name }">
		<div id="sidebar">
		<div id="list">
			<ul>
				<li><a href="../main/menu.jsp">メニュー</a></li>
				<li><a href="../main/StudentList.action">学生管理</a></li>
				<li>成績管理
				<ul>
					<li><a href="../main/TestRegist.action">成績登録</a></li>
					<li><a href="../main/TestList.action">成績参照</a></li>
				</ul>
				</li>
				<li><a href="../main/SubjectList.action">科目管理</a></li>
			</ul>
		</div>
		</div>
		</c:if>
		<div id="content">${ param.content }</div>
	</div>
	<div id="push"></div>
</body>

<footer>@2023TIC<br>大原学園</footer>
</html>