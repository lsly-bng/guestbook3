<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>[방명록]</h1>

	<form action="/guestbook3/add" method="get">
		<table border="1" width="480px">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="4"><textarea rows="7" cols="61" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit">등록</button></td>
			</tr>
		</table>
	</form>
	<br>

	<c:forEach items="${gbList}" var="gbVo">
		<table border="1" width="480px">
			<tr>
				<td>${gbVo.no}</td>
				<td>${gbVo.name}</td>
				<td>${gbVo.regDate}</td>
				<td><a href="/guestbook3/deleteForm?no=${gbVo.no}">삭제</a></td>
			</tr>
			<tr>
				<td colspan="4">${gbVo.content}</td>
			</tr>
		</table>
		<br>
	</c:forEach>

</body>

</html>