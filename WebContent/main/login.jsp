<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/base.jsp">

	<c:param name="title">得点管理システム - ログイン</c:param>

	<c:param name="content">

		<h2>ログイン</h2>
        <form action="login" method="post">
            <p>
                ログイン名 <input type="text" name="login">
            </p>
            <p>
                パスワード <input type="password" name="password">
            </p>
            <p>
                <input type="submit" value="ログイン">
            </p>
            <p>${errorMessage}</p>
         </form>

	</c:param>

</c:import>