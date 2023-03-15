<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/title.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/content.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/board.js"></script>
<title>** Gyojin's Profile **</title>
</head>
<body>	
	<%@ include file="include/header.jsp" %>
	
				<center>
				<table width="80%" border="0" cellspacing="0" cellpadding="10">
					<tr class="contentbox">
						<td class="content">
							<center>						
							<table border="0" cellspacing="0" cellpadding="10">
								<form action="questionModifyOk" method="post" name="board_frm">
									<input type="hidden" value="${qdto.qnum }" name="qnum">
									<tr>
										<td><span class="content_text01">아 이 디 : </span></td>
										<td><input class="input_type01" type="text" name="qid" value="${qdto.qid }" readonly="readonly"></td>
									</tr>
									<tr>
										<td><span class="content_text01">글 쓴 이 : </span></td>
										<td><input class="input_type01" type="text" name="qname" value="${qdto.qname }"></td>
									</tr>
									<tr>
										<td><span class="content_text01">질문내용 : </span></td>
										<td><textarea class="textarea_type01" rows="5" cols="30" name="qcontent">${qdto.qcontent}</textarea></td>
									</tr>									
									<tr>
										<td><span class="content_text01">이 메 일 : </span></td>
										<td><input class="input_type01" type="text" name="qemail" value="${qdto.qemail }"></td>
									</tr>
									<tr>
										<td><span class="content_text01">등 록 일 : </span></td>
										<td><input class="input_type01" type="text" name="qdate" value="${qdto.qdate }" readonly="readonly"></td>
									</tr>
									<tr>
										<td colspan="2">
										
										<input class="button_type01" type="submit" value="수정완료">&nbsp;&nbsp;										
										<input class="button_type01" type="button" value="삭제" onclick="script:window.location='questionDelete?qnum=${qdto.qnum}'">
										<input class="button_type01" type="button" value="글목록" onclick="script:window.location='list'">										
										
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