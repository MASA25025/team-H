<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>


<style>
	#header{
		background-color: #CCFFFF;
    	padding: 8px;
    	text-align: center;
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
<head>
	<title>${ param.title }</title>
	<meta charset="UTF-8">
</head>


<body>
	<div id="header">
	<h1     style="font-size: 24px, color: #333;">得点管理システム</h1>
	</div>
	<div id="container">
		<div id="sidebar">
		<nav>
			<ul>
				<li><a href="">メニュー</a></li>
				<li><a href="">学生管理</a></li>
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