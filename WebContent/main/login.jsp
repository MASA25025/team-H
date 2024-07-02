<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <title>得点管理システム - ログイン</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .login-container h2 {
            margin-bottom: 20px;
        }
        .login-container label {
            display: block;
            margin-bottom: 5px;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .login-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            border: none;
            color: white;
            border-radius: 3px;
            cursor: pointer;
        }
        .login-container input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .login-container p {
            margin: 0;
            color: red;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>ログイン</h2>
        <form action="login" method="post">
            <p>
                <label for="id">ID</label>
                <input type="text" id="id" name="id" value="admin">
            </p>
            <p>
                <label for="password">パスワード</label>
                <input type="password" id="password" name="password" value="Password@112023">
            </p>
            <p>
                <label for="chk_d_ps">
                    <input type="checkbox" name="chk_d_ps" id="chk_d_ps"> パスワードを保存する
                </label>
            </p>
            <p>
                <input type="submit" value="ログイン">
            </p>
            <p>${errorMessage}</p>
        </form>
    </div>
</body>
</html>
