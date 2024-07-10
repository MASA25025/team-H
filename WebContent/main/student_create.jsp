<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">
<style>
       body {
           font-family: Arial, sans-serif;
       }
       h2 {
           color: #333;
       }
       form {
           max-width: 400px;
           margin: 0 auto;
       }
       label {
           display: block;
           margin-bottom: 5px;
           float: left;
       }
       input, select, button {
           width: 100%;
           padding: 10px;
           margin-bottom: 10px;
       }
       button {
           background-color: #333;
           color: #fff;
           border: none;
           cursor: pointer;
       }
       button:hover {
           background-color: #555;
       }
       a {
           color: #333;
           text-decoration: none;
       }
       a:hover {
           text-decoration: underline;
       }
</style>

<body>
<h2>学生情報登録</h2>
<form action="RegisterServlet" method="post">
<label for="entry_year">入学年度</label>
<select id="entry_year" name="entry_year">
<option value="2020">2020</option>
<option value="2021">2021</option>
<option value="2022">2022</option>
<option value="2023">2023</option>
<option value="2024">2024</option>
</select>
<label for="student_number">学生番号</label>
<input type="text" id="student_number" name="student_number" placeholder="学生番号を入力してください">
<label for="name">氏名</label>
<input type="text" id="name" name="name" placeholder="氏名を入力してください">
<label for="class_num">クラス</label>
<select id="class_num" name="class_num">
<option value="101">101</option>
<option value="102">102</option>
<option value="103">103</option>
<option value="104">104</option>
</select>
<button type="submit">登録して終了</button>
</form>
<a href="menu.jsp">戻る</a>
</body>
</c:param>
</c:import>