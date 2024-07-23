<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">


	<h1 id="menu-header">成績参照</h1>
			<form action="" method="get">
			<div id ="form_all">
				<div class="form1">
					<a class="form_title">科目情報</a>

					<a class="form_elm">
					入学年度<br>
						<select name="s1">
						</select>
					</a>
					<a class="form_elm">
					クラス<br>
						<select name="s2">
						</select>
					</a>
					<a id="subject">
					科目<br>
						<select name="s3" >
						</select>
					</a>
					<a class="form_elm">
					<input id="search" type="submit" value="検索">
					</a>
				</div>
			</div>
			</form>

				<div class="ppp"><hr></div>

			<form action ="TestListStudentExecute.action" method="post">
			<div class ="form2">
					<a class="form_title">学生情報</a>
					<a id="subject">
						学生番号<br>
						<input type="text" name="f1"size="30" placeholder="学生番号を入力してください">
						</a>
						<a class="form_elm">
						<input id="search" type="submit" value="検索">
						</a>
			</div>
			</form>
		<p>科目情報を選択または学生情報を入力して
			検索ボタンをクリックしてください</p>


<c:choose>
  <c:when test="${studentList.size() > 0}">
    <div>氏名：${student.name}(${student.no}) </div>
    <table class="table table-hover">
      <tr>
        <th>科目</th>
        <th>科目コード</th>
        <th>回数</th>
        <th>得点</th>
      </tr>

    <c:forEach var="stuTestList" items="${studentList}">
      <tr>
        <td>${stuTestList.subjectName}</td>
        <td>${stuTestList.subjectCd}</td>
        <td>${stuTestList.num}</td>
        <td>${stuTestList.point}</td>
      </tr>
    </c:forEach>
    </table>
    </c:when>

  <c:otherwise>
    <div>成績情報が存在しませんでした</div>
  </c:otherwise>
</c:choose>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>




		<style>
			#menu-header{
				font-size:x-large;
				border:none 1px #CCCCCC;
				border-radius:12px;
				background-color:#EEEEEE;
				height:36px;
				padding:10px;
				Vertical-align: middle
			}
			.form1{
				display:flex;
				padding:12px
			}
			.ppp{
				margin:0 auto;
				widht:100;
				height:100;
				padding-right: 20px;
    			padding-left: 20px;
			}
			.form2{
				border-radius:12px;
				display:flex;
				padding:12px
			}
			.form_title{
				border-radius:12px;
				display:flex;
				padding:12px
			}
			#form_all{
				border: solid 1px #C0C0C0;
			}
			.form_elm{
				font-size:large;
				height:48px;
				width:  136px;
			}
			#subject{
				height:48px;
				width:264px;
			}
			#search{
				height:36px;
				width: 72px;
				background-color:#555555;
				color:white;
				border:none 1px #555555;
				border-radius:6px;
			}
			p {
				font-size:13px;
				text-align:left;
				color:#00bfff;
			}


		</style>

</c:param>

</c:import>