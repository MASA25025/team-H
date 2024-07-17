<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">

<style>
        body {
            font-family: Arial, sans-serif;
        }
        .login-container {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .login-container label {
            display: block;
            margin-bottom: 5px;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 90%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .login-container input[type="checkbox"] {
            margin-right: center;
        }
        .login-container button {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .login-container button:hover {
            background-color: #0056b3;
        }
    </style>

<body>
    <div class="login-container">
        <h2>ログイン</h2>
        <form action="LoginExecute.action" method="post">
            <label for="id">ID</label>
            <input type="text" id="id" name="id" value="admin">

            <label for="password">パスワード</label>
            <input type="password" id="password" name="password" value="******"><br>

            <input type="checkbox" id="showPassword">
            <label for="showPassword">パスワードを表示</label>

            <button type="submit">ログイン</button>
        </form>
    </div>
</body>
</c:param>
</c:import>