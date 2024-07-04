<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">


	<h1 id="menu-header">成績管理</h1>

	<div id="message">
		登録が完了しました
	</div>
	<div id="link">
		<a href="">戻る</a>
		<a href="">成績参照へ</a>
	</div>
	<style>
	#menu-header{
	font-size:x-large;
	border:none 1px #CCCCCC;
	border-radius:12px;
	background-color:#EEEEEE;
	height:36px;
	padding:10px;
	Vertical-align: middle
	}
	#message{
	border:none 1px #CCCCCC;
	border-radius:6px;
	background-color:#3CB371;
	font-size:smaller;
	padding:6px;
	heght:36px;
	text-align:center;
	}
</style>

</c:param>



</c:import>