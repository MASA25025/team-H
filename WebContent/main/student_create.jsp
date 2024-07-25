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

            <form action="StudentCreateExecute.action" method="post">
                <label class="form-label" for="student-f1-select">入学年度</label>
                <select class="form-select" id="student-f1-select" name="ent_year">
                    <option value="">--------------------</option>
                    <c:forEach var="year" items="${ent_year_set}">
                        <option value="${year}">${year}</option>
                    </c:forEach>
                </select>
                <div class="error">
                    <c:if test="${not empty entYearError}">
                        <p>${entYearError}</p>
                    </c:if>
                </div>

                <label for="student_number">学生番号</label>
                <input type="text" id="student_number" name="no" value="${param.no}">
                <div class="error">
                    <c:if test="${not empty studentNumberError}">
                        <p>${studentNumberError}</p>
                    </c:if>
                </div>

                <label for="name">氏名</label>
                <input type="text" id="name" name="name" value="${param.name}">
                <div class="error">
                    <c:if test="${not empty nameError}">
                        <p>${nameError}</p>
                    </c:if>
                </div>

                <label class="form-label" for="student-f2-select">クラス</label>
                <select class="form-select" id="student-f2-select" name="class_num">
                    <option value="">--------------------</option>
                    <c:forEach var="num" items="${class_num_set}">
                        <option value="${num}">${num}</option>
                    </c:forEach>
                </select>
                <div class="error">
                    <c:if test="${not empty classNumberError}">
                        <p>${classNumberError}</p>
                    </c:if>
                </div>

                <button type="submit">登録して終了</button>
            </form>
            <a href="menu.jsp">戻る</a>
    </c:param>
</c:import>
