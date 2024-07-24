<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/base.jsp">

<c:param name="title">得点管理システム</c:param>

<c:param name="content">


	<h1 id="menu-header">成績管理</h1>


			<form action="TestRegist.action" method="get">

				<div id="form">
					<a class="form_elm">
					入学年度<br>
						<select name="ent_year">
						<c:forEach var="year" items="${ ent_year_set }">
							<option value="${year}">${ year }</option>
						</c:forEach>
						</select>
					</a>
					<a class="form_elm">
					クラス<br>
						<select name="class_num">
						<c:forEach var="classnum" items="${ class_num }">
							<option value="${classnum}">${ classnum }</option>
						</c:forEach>
						</select>
					</a>
					<a id="subject">
					科目<br>
						<select name="subject_cd">
						<c:forEach var="subject" items="${ subject }">
							<option value="${ subject.cd }">${ subject.name }</option>
						</c:forEach>
						</select>
					</a>
					<a class="form_elm">
					回数<br>
						<select name="no">
							<option value="1">1</option>
							<option value="2">2</option>
						</select>
					</a>
					<a class="form_elm">
					<input id="search" type="submit" value="検索">
					</a>
				</div>
				</form>

				<c:choose>
<c:when test="${Test.size() > 0}">
    <div>科目 : ${Subject.name}</div>
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
    <c:forEach var="test" items="${Test}">
      <tr>
        <td>${Test.entyear}</td>
        <td>${Test.classnum}</td>
        <td>${Test.no}</td>
        <td>${Test.name}</td>
        <td><a id="point">
							<input type="text" name="point"size="30" placeholder="${Test.point}">
						</a></td>

        <td><a href="TestRegistExecute.action">登録して終了</a></td>
      </tr>
    </c:forEach>
  </c:when>
  <c:otherwise>
    <div>成績情報が存在しませんでした</div>
  </c:otherwise>
</c:choose>




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
			#form{
				border: solid 1px #C0C0C0;
				border-radius:12px;
				display:flex;
				padding:12px
			}
			.form_elm{
				font-size:large;
				height:48px;
				width:  136px;
			}
			#subject{
				height:48px;
				width:256px;
			}
			#search{
				height:36px;
				width: 72px;
				background-color:#555555;
				color:white;
				border:none 1px #555555;
				border-radius:6px;
			}


		</style>

</c:param>

</c:import>