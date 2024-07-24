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
                <h2>学生情報変更</h2>
            </div>
            <form action="StudentUpdateExecute.action" method="post">
                <div class="form-group">
                    <label>入学年度
                        <input type="text" name="ent_year" value="${students.getEntYear()}" maxlength="4" readonly="readonly">
                    </label>
                </div>
                <div class="form-group">
                    <label>学生番号
                        <input type="text" name="no" value="${students.no}" maxlength="10" readonly="readonly">
                    </label>
                </div>
                <div class="form-group">
                    <label>氏名
                        <input type="text" name="name" value="${students.name}" maxlength="30">
                    </label>
                </div>
                <div class="form-group">
                    <label>クラス
                        <select name="class_num">
                            <option value="0"></option>
                            <c:forEach var="num" items="${class_num_set}">
                                <option value="${num}" <c:if test="${num ==students.getClassNum()}">selected</c:if>>${num}</option>
                            </c:forEach>
                        </select>
                    </label>
                </div>
                    <label>在学中
						<input type="checkbox" name="is_attend" value="t" <c:if test="${!empty students.isAttend()}">checked</c:if> />
					</label>

                <div class="form-actions">
                    <button type="submit">変更</button>
                    <a href="#">戻る</a>
                </div>
            </form>
        </div>
    </c:param>
</c:import>
