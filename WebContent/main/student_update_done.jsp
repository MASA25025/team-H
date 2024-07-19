<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">


	<h1 id="menu-header">学生情報変更</h1>

	<div id="message">
		変更が完了しました
	</div>
	<div id="link">
		<a href="" class="link">戻る</a>
		<a href="" class="link" style="left:96px;">学生一覧</a>
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
	#link{
		position: relative;
		height:144px;
		padding:12px;
		display:flex;
	}
	.link{
		position:absolute;
		bottom:0;
		padding-right: 48px;
	}
</style>

</c:param>



</c:import>