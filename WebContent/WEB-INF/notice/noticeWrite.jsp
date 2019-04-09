<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>구매 내역</title>
<meta charset="UTF-8">

<jsp:include page="../partial/config.jsp"></jsp:include>
</head>
<body>
	<div class="container div-margin-bottom">
		<jsp:include page="../partial/nav.jsp"></jsp:include>

		<div class="table-responsive">
			<h3>공지 사항</h3>
			<form action="${pageContext.request.contextPath}/main.do" method="post">
				<input type="hidden" name="action" value="registerNotice">
				<table class="table table-hover table-bordered">
					<thead class="thead-light">
						<tr>
							<th>제목</th>
							<th><input type="text" name="title" style="width: 100%"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>내용</td>
							<td><textarea name="contents" style="width: 100%; height: 600px"></textarea></td>
						</tr>
					</tbody>
				</table>
				<div style="width: 100%; text-align:center"><input type="submit" value="등록"></div>
			</form>
		</div>
	</div>
</body>
</html>