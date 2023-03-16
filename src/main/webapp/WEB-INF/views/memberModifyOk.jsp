<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/title.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/content.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/join.js"></script>
<title>회원 정보 수정 성공</title>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<center>
				<table width="80%" border="0" cellspacing="0" cellpadding="10">
					<tr class="contentbox">
						<td class="content">
							<center>						
							<table border="0" cellspacing="0" cellpadding="10">
									<tr>
										<td colspan="2" align="center"><span class="content_text01">회원 정보 수정 완료</span></td>
									</tr>
									<tr>
										<td><span class="content_text01">아 이 디 : </span></td>
										<td>${memberDto.mid }</td>
									</tr>									
									<tr>
										<td><span class="content_text01">비밀번호 : </span></td>
										<td>${memberDto.mpw }</td>
									</tr>
									<tr>
										<td><span class="content_text01">이&nbsp;&nbsp;&nbsp;&nbsp;름 : </span></td>
										<td>${memberDto.mname }</td>
									</tr>
									<tr>
										<td><span class="content_text01">이 메 일 : </span></td>
										<td>${memberDto.memail }</td>
									</tr>
									<tr>
										<td><span class="content_text01">주소 : </span></td>
										<td>${memberDto.maddress }</td>
									</tr>
									
									<tr>
										<td colspan="2">
											<input class="button_type01" type="button" value="정보수정" onclick="script:window.location='memberModify'">&nbsp;&nbsp;
											<input class="button_type01" type="button" value="홈으로" onclick="script:window.location='index'">
										</td>
									</tr>
														
							</table>
							</center>							
						</td>						
					</tr>
					
				</table>
				</center>			
	
	<%@ include file="include/footer.jsp" %>
</body>
</html>