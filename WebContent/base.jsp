<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ param.title }</title>
<style>
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
</head>
<body>

	<div id="container">
		<div id="sidebar">
			<h2>メニュー</h2>
			<h3>学生管理</h3>
			<ul>
				<li><a href="all">学生一覧</a></li>
				<li><a href="insert">学生追加</a></li>
				<li><a href="update-select">学生更新</a></li>
				<li><a href="delete">学生削除</a></li>
			</ul>
		</div>
		<div id="content">${ param.content }</div>
	</div>

</body>
</html>