<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">


	<h1 id="menu-header">成績参照</h1>


			<form action="update" method="get">
			<div id ="form_all">
				<div class="form1">
					<a class="form_title">科目情報</a>

					<a class="form_elm">
					入学年度<br>
						<select name="ent_year">
						</select>
					</a>
					<a class="form_elm">
					クラス<br>
						<select name="class_num">
						</select>
					</a>
					<a id="subject">
					科目<br>
						<select name="subject_name">
						</select>
					</a>
					<a class="form_elm">
					<input id="search" type="submit" value="検索">
					</a>
				</div>
				<div class="ppp"><hr></div>
				<div class ="form2">
					<a class="form_title">学生情報</a>
					<a id="subject">
						学生番号<br>
							<input type="text" name="no"size="30" placeholder="学生番号を入力してください">
						</a>
						<a class="form_elm">
						<input id="search" type="submit" value="検索">
						</a>
				</div>
			</div>
			</form>
		<p>科目情報を選択または学生情報を入力して
			検索ボタンをクリックしてください</p>
			
			
		<c:choose>
  <c:when test="${students.size() > 0}">
    <div>検索結果 : ${students.size()}件</div>
    <table class="table table-hover">
      <tr>
        <th>入学年度</th>
        <th>クラス</th>
        <th>学生番号</th>
        <th>氏名</th>
        <th>点数</th>

        <th></th>
        <th></th>
      </tr>
    </table>
    <c:forEach var="student" items="${students}">
      <tr>
        <td>${student.entYear}</td>
        <td>${student.classNum}</td>
        <td>${student.no}</td>
        <td>${student.name}</td>
        <td class="text-center">
          <%-- 在学フラグがたっている場合「○」 それ以外は「×」を表示 --%>
          <c:choose>
            <c:when test="${student.isAttend()}">
              <a id="point">
						点数<br>
							<input type="text" name="point"size="30" placeholder="学生番号を入力してください">
						</a>
            </c:when>
            <c:otherwise>
              <a id="point">
						点数<br>
							<input type="text" name="point"size="30" placeholder="学生番号を入力してください">
						</a>
            </c:otherwise>
          </c:choose>
        </td>
        <td><a href="TestRegistExecute.action">登録して終了</a></td>
      </tr>
    </c:forEach>
  </c:when>
  <c:otherwise>
    <div>成績情報が存在しませんでした</div>
  </c:otherwise>
</c:choose>

</section>
</c:param>
</c:import>

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