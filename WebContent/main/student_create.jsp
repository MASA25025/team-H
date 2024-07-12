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
            <form id="registrationForm" action="RegisterServlet" method="post" onsubmit="return validateForm()">
                <label for="entry_year">入学年度</label>
                <select id="entry_year" name="entry_year">
                    <option value="">選択してください</option>
                    <option value="2020">2020</option>
                    <option value="2021">2021</option>
                    <option value="2022">2022</option>
                    <option value="2023">2023</option>
                    <option value="2024">2024</option>
                </select>
                <div id="entryYearError" class="error"></div>

                <label for="student_number">学生番号</label>
                <input type="text" id="student_number" name="student_number" required placeholder="学生番号を入力してください">
                <div id="studentNumberError" class="error"></div>

                <label for="name">氏名</label>
                <input type="text" id="name" name="name" required placeholder="氏名を入力してください">
                <div id="nameError" class="error"></div>

                <label for="class_num">クラス</label>
                <select name="class_num">
                    <c:forEach var="classnum" items="${class_num}">
                        <option value="${classnum.class_num}">${classnum.class_num}</option>
                    </c:forEach>
                </select>
                <button type="submit">登録して終了</button>
            </form>
            <a href="menu.jsp">戻る</a>

            <script>
                function validateForm() {
                    let isValid = true;

                    const entryYear = document.getElementById("entry_year").value;
                    const studentNumber = document.getElementById("student_number").value;
                    const name = document.getElementById("name").value;

                    document.getElementById("entryYearError").innerText = "";
                    document.getElementById("studentNumberError").innerText = "";
                    document.getElementById("nameError").innerText = "";

                    if (entryYear === "") {
                        document.getElementById("entryYearError").innerText = "入学年度を選択してください";
                        isValid = false;
                    }

                    if (studentNumber === "") {
                        document.getElementById("studentNumberError").innerText = "学生番号を入力してください";
                        isValid = false;
                    }

                    if (name === "") {
                        document.getElementById("nameError").innerText = "氏名を入力してください";
                        isValid = false;
                    }

                    // 学生番号の重複チェック
                    if (isValid) {
                        const xhr = new XMLHttpRequest();
                        xhr.open("POST", "CheckDuplicateServlet", false); // 同期リクエストで処理するためfalseを指定
                        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                        xhr.onreadystatechange = function() {
                            if (xhr.readyState === 4 && xhr.status === 200) {
                                const response = xhr.responseText;
                                if (response.trim() === "duplicate") {
                                    document.getElementById("studentNumberError").innerText = "この学生番号は既に登録されています";
                                    isValid = false;
                                }
                            }
                        };
                        const params = "student_number=" + encodeURIComponent(studentNumber);
                        xhr.send(params);
                    }

                    return isValid;
                }
            </script>
        </body>
    </c:param>
</c:import>
