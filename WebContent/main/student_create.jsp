<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>得点管理システム</title>
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
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h2>学生情報登録</h2>
    <%
        String entryYear = request.getParameter("entry_year");
        String studentNumber = request.getParameter("student_number");
        String name = request.getParameter("name");
        String classNum = request.getParameter("class_num");

        String errorMessageEnrollmentYear = null;
        String errorMessageStudentId = null;
        String errorMessageName = null;

        if (request.getMethod().equalsIgnoreCase("POST")) {
            boolean hasError = false;

            if (entryYear == null || entryYear.trim().isEmpty()) {
                errorMessageEnrollmentYear = "入学年度を選択してください";
                hasError = true;
            }

            if (studentNumber == null || studentNumber.trim().isEmpty()) {
                errorMessageStudentId = "学生番号を入力してください";
                hasError = true;
            }

            if (name == null || name.trim().isEmpty()) {
                errorMessageName = "氏名を入力してください";
                hasError = true;
            }

            if (!hasError) {
                // 登録処理を行う（ここでデータベースに保存などの処理を追加）
                out.println("<p>登録が成功しました！</p>");
            }
        }
    %>
    <form action="student_registration.jsp" method="post">
        <label for="entry_year">入学年度</label>
        <select id="entry_year" name="entry_year">
            <option value="">選択してください</option>
            <option value="2020" <%= "2020".equals(entryYear) ? "selected" : "" %>>2020</option>
            <option value="2021" <%= "2021".equals(entryYear) ? "selected" : "" %>>2021</option>
            <option value="2022" <%= "2022".equals(entryYear) ? "selected" : "" %>>2022</option>
            <option value="2023" <%= "2023".equals(entryYear) ? "selected" : "" %>>2023</option>
            <option value="2024" <%= "2024".equals(entryYear) ? "selected" : "" %>>2024</option>
        </select>
        <c:if test="${not empty errorMessageEnrollmentYear}">
            <span class="error"><%= errorMessageEnrollmentYear %></span>
        </c:if>

        <label for="student_number">学生番号</label>
        <input type="text" id="student_number" name="student_number" placeholder="学生番号を入力してください" value="<%= studentNumber != null ? studentNumber : "" %>">
        <c:if test="${not empty errorMessageStudentId}">
            <span class="error"><%= errorMessageStudentId %></span>
        </c:if>

        <label for="name">氏名</label>
        <input type="text" id="name" name="name" placeholder="氏名を入力してください" value="<%= name != null ? name : "" %>">
        <c:if test="${not empty errorMessageName}">
            <span class="error"><%= errorMessageName %></span>
        </c:if>

        <label for="class_num">クラス</label>
        <select name="class_num">
            <option value="">選択してください</option>
            <!-- クラスのオプションを動的に生成する場合 -->
            <c:forEach var="classnum" items="${class_num}">
                <option value="${classnum.class_num}" <%= classnum.class_num.equals(classNum) ? "selected" : "" %>>${classnum.class_num}</option>
            </c:forEach>
        </select>

        <button type="submit">登録して終了</button>
    </form>
    <a href="menu.jsp">戻る</a>
</body>
</html>
