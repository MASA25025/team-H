<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">

<style>
       body {
           font-family: Arial, sans-serif;
           display: flex;
           flex-direction: column;
           align-items: center;
           justify-content: left;
           height: 100vh;
           margin: 0;
           background-color: #f7f7f7;
       }
       .container {
           width: 400px;
           text-align: center;
       }
       .container-surface{
       	   width: 200px;
           text-align: center;
       }
       h2 {
           font-size: 24px;
           margin-bottom: 20px;
       }
       form {
           background-color: #fff;
           padding: 20px;
           box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
           border-radius: 5px;
       }
       .form-title {
           font-size: 18px;
           margin-bottom: 10px;
       }
       input[type="text"], input[type="password"] {
           width: 100%;
           padding: 10px;
           margin: 10px -10px;
           border: 1px solid #ccc;
           border-radius: 5px;
       }
       button {
           width: 100%;
           padding: 10px;
           background-color: #007bff;
           color: white;
           border: none;
           border-radius: 5px;
           cursor: pointer;
       }
       button:hover {
           background-color: #0056b3;
       }
       label {
           display: flex;
           align-items: center;
           justify-content: center;
           font-size: 14px;
           margin-bottom: 20px;
       }
       label input {
           margin-right: 5px;
       }
       footer {
           text-align: center;
           margin-top: 20px;
       }
</style>

<div class="container">
<form action="Login.action" method="post">
<div class="form-title">ログイン</div>
<input type="text" id="id" name="id" value="admin" placeholder="ID"><br>
<input type="password" id="password" name="password" value="password" placeholder="パスワード"><br>
<label>
<input type="checkbox" id="chk_d_ps" name="chk_d_ps"> パスワードを表示
</label><br>
<button type="submit" id="login" name="login">ログイン</button>
</form>
</div>

</c:param>

</c:import>