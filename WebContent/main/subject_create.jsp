

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                margin-bottom: 0px;
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
                font-size: 0.9em;
                margin-top: 5px;
                margin-bottom: 10px;
            }
            div.left {
			    text-align: left;
			}
        </style>

            <h2>学生情報登録</h2>

            <form action="SubjectCreateExecute.action" method="post">

                <label for="cd">科目コード</label>
                <input type="text" id="cd" name="cd"  required placeholder="科目コードを入力してください">

                <label for="name">科目名</label>
                <input type="text" id="name" name="name" required placeholder="科目名を入力してください">



                <button type="submit">登録して終了</button>
            </form>
            <a href="menu.jsp">戻る</a>
    </c:param>
</c:import>
