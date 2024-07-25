<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/base.jsp">
    <c:param name="title">得点管理システム</c:param>
    <c:param name="content">

        <style>
            .form-container {
                max-width: 600px;
                margin: 0 auto;
                padding: 20px;
                background-color: white;
            }
            .form-title{
            background-color: #f9f9f9;
            }
            .form-container h2 {
                text-align: center;
                margin-bottom: 20px;
            }
            .form-group {
                margin-bottom: 15px;
            }
            .form-group label {
                display: block;
                margin-bottom: 5px;
            }
            .form-group input,
            .form-group select {
                width: 100%;
                padding: 8px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            .form-actions {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .form-actions button,
            .form-actions a {
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                text-decoration: none;
                text-align: center;
                background-color: #007bff;
                color: #fff;
            }
            .form-actions a {
                background-color: #6c757d;
            }
            .form-actions button:hover,
            .form-actions a:hover {
                opacity: 0.8;
            }
        </style>

        <div class="form-container">
            <div class="form-title">
                <h2>科目情報削除</h2>
            </div>
            <form action="SubjectDeleteExecute.action" method="post">
                <div class="form-group">
                    <p>「${subject.name}」を削除してもよろしいですか</p>
                </div>


                <div class="form-actions">
                    <button type="submit">変更</button>
                    <a href="#">戻る</a>
                </div>
            </form>
        </div>
    </c:param>
</c:import>
