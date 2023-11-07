<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/custom.css" />
</head>
<style>
th{
width : 100px;
text-align : center;
}
</style>
<body>
	<%@ include file="/header.jsp" %>
	<div class="container">
		<div class="row">
			<form action="${pageContext.request.contextPath}/recruit/edit.do?num=${r.num}" method="post">
				<table class="table table-striped" style="text-align: center; border: 1px solid #ddd">
					<thead>
						<tr>
							<th style="background-color: #eee; text-align: center; "colspan="2">지원서 수정</th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<th>공고 제목</th>
							<td>
								<input type="text" class="form-control" value="${r.title}" name="title" maxlength="50" readonly>
							</td>				
						</tr>
						<tr>
						<th>성명</th>
							<td>
								<input type="text" class="form-control" value="${sessionScope.UserName}" name="name" maxlength="50" readonly>
							</td>				
						</tr>
						<tr>
						<th>성별</th>
							<td>
								<input type="text" class="form-control" value="${sessionScope.UserGender}" name="gender" maxlength="50" readonly>
							</td>				
						</tr>
						<tr>
						<th>자기소개서</th>
							<td>
								<textarea class="form-control" placeholder="자기소개서" name="content" maxlength="2048" style="height: 350px">${r.content }</textarea>
							</td>
						</tr>
						<tr>
						<th>휴대폰번호</th>
							<td>
								<input type="text" class="form-control" value="${sessionScope.userPhoneNum}" name="phonenum" maxlength="50" readonly>
							</td>				
						</tr>
						<tr>
						<th>학력사항</th>
							<td>
								<input type="text" class="form-control" value="${r.degree }" name="degree" maxlength="50">
							</td>				
						</tr>
						<tr>
						<th>경험사항</th>
							<td>
								<input type="text" class="form-control" value="${r.exp }" name="exp" maxlength="50">
							</td>				
						</tr>
						<tr>
						<th>증명사진</th>
							<td>
								<img src="/together/${r.img }" alt="사진 없음">
							</td>
						</tr>					
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right" value="수정완료">
			</form>
		</div>
	</div>
	<br><br><br><br>
	<%@ include file="/footer.jsp" %>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
