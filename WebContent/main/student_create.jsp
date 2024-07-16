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
                font-size: 0.9em;
                margin-bottom: 10px;
            }
        </style>

        <body>
            <h2>学生情報登録</h2>
            <form id="registrationForm" action="StudentCreateExecuteAction" method="post" onsubmit="return validateForm()">
                <label class="form-label" for="student-f1-select">入学年度</label>
        			<select class="form-select" id="student-f1-select" name="ent_year">
          			<option value="0">--------------------</option>
			          <c:forEach var="year" items="${ent_year_set}">
			            <%-- 現在のyearと選択されていたf1が一致していた場合selectedを追記 --%>
			            <option value="${year}" <c:if test="${year==ent_year}">selected</c:if>>${year}</option>
			          </c:forEach>
        			</select>
                <div id="entryYearError" class="error"></div>

                <label for="student_number">学生番号</label>
                <input type="text" id="student_number" name="studentNumber" required placeholder="学生番号を入力してください">
                <div id="studentNumberError" class="error"></div>

                <label for="name">氏名</label>
                <input type="text" id="name" name="name" required placeholder="氏名を入力してください">
                <div id="nameError" class="error"></div>

                <label for="class_num">クラス</label>
                <select name="classNumber">
                    <c:forEach var="classnum" items="${class_num}">
                        <option value="${classnum.class_num}">${classnum.class_num}</option>
                    </c:forEach>
                </select>
                <button type="submit">登録して終了</button>
            </form>
            <a href="menu.jsp">戻る</a>

            <!-- エラーメッセージを表示 -->
            <c:if test="${not empty errors}">
                <div class="error">
                    <ul>
                        <c:forEach var="error" items="${errors}">
                            <li>${error}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>
        </body>
    </c:param>
</c:import>
