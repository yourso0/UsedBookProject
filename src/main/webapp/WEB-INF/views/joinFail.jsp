<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/title.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/content.css">
<title>회원 가입 실패</title>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	
				<center>
				<table width="80%" border="0" cellspacing="0" cellpadding="10">
					<tr class="contentbox">
						<td class="content">
							회원 가입이 실패하였습니다. 다시 확인해주시기 바랍니다.
							<input type="button" value="회원가입 바로가기" onclick="history.go(-1);">						
						</td>						
					</tr>							
		</table>
	</center>
	<%@ include file="include/footer.jsp" %>
</body>
</html>