<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">

<style>
.logout-container {
    background-color: #e8e8e8;
    padding: 1px;
    height: 50px;
    display: flex;
    align-items: center;
    border: 1px solid #ccc;
}
.logout-label {
    background-color: #d4edda;
    padding: 1px;
    height: 25px;
    display: flex;
    align-items: center;
    border: 1px solid #ccc;
    justify-content: center;
}

</style>
</head>
<body>
	<div class="logout-container">
		<h2>ログアウト</h2>
	</div>
	<br>
	<div class="logout-label">
		<label>
			<p>ログアウトしました。</p>
		</label>
	</div>
		<a href=".">ログイン</a>
</body>
</c:param>
</c:import>
