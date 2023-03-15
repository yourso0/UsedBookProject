<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/title.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/content.css">
<title>로그인</title>
</head>
<body>
<%@ include file="include/header.jsp" %>	
<center>
<table width="80%" border="0" cellspacing="0" cellpadding="10">
	<tr class="contentbox">
		<td class="content">
			<center>						
			<table border="0" cellspacing="0" cellpadding="10">
				<form action="loginOk" method="post">
					<tr>
						<td><span class="content_text01">아 이 디 : </span></td>
						<td><input class="input_type01" type="text" name="mid"></td>
					</tr>
					<tr>
						<td><span class="content_text01">비밀번호 : </span></td>
						<td><input class="input_type01" type="password" name="mpw"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input class="button_type01" type="submit" value="로그인">&nbsp;&nbsp;
							<input class="button_type01" type="button" value="회원가입" onclick="script:window.location='join'">
						</td>
					</tr>
				</form>							
			</table>
			</center>							
		</td>						
	</tr>
</table>
</center>			
<%@ include file="include/footer.jsp" %>
</body>
</html>