<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">
<style>
	#field{
	display: flex;
    justify-content: center;
    gap: 20px;
	margin-top: 20px;
	}

#student {
    background-color: #f8d7da;
    padding: 20px;
    border-radius: 5px;
    text-align: center;
    font-size: 1.2em;
    font-weight: bold;
    width: 200px;
    height: 100px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

#grade {
    background-color: #d4edda;
    position: relative;
    padding: 20px;
    border-radius: 5px;
    text-align: center;
    font-size: 1.2em;
    font-weight: bold;
    width: 200px;
    height: 100px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

#subject {
    background-color: #d1d8e0;
    position: relative;
    padding: 20px;
    border-radius: 5px;
    text-align: center;
    font-size: 1.2em;
    font-weight: bold;
    width: 200px;
    height: 100px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

#main-content {
    padding: 10px;
}

.menu-header {
    background-color: #e8e8e8;
    padding: 1px;
    border-radius: 3px;
}

</style>

<div id="main-content">
<div class="menu-header">
	<h2>メニュー</h2>
</div>
	<div id=field>
		<div id="student"><a href="../main/StudentList.action">学生管理</a></div>
		<div id="grade">
			<div>成績管理</div>
			<a href="../main/TestRegist.action">成績登録</a>
			<a href="../main/TestList.action">成績参照</a>
		</div>
		<div id="subject"><a href="../main/SubjectList.action">科目管理</a></div>
	</div>
</div>
</body>
</c:param>

</c:import>
