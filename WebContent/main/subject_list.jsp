<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<c:import url="/base.jsp">

	<c:param name="title">得点管理システム</c:param>

	<c:param name="content">
<section class="me-4">
  <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生管理</h2>
  <div class="my-2 text-end px-4">
  	<a href="SubjectCreate.action">新規登録</a>
  </div>

    <table class="table table-hover">
      <tr>
        <th>科目コード</th>
        <th>科目名</th>
        <th></th>
        <th></th>

      </tr>

    <c:forEach var="subject" items="${subjects}">
      <tr>
        <td>${subject.cd}</td>
        <td>${subject.name}</td>

        <td><a href="SubjectUpdate.action?cd=${subject.cd}">変更</a></td>
        <td><a href="SubjectDelete.action?cd=${subject.cd}">削除</a></td>

      </tr>
    </c:forEach>
    </table>


</section>
</c:param>
</c:import>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
