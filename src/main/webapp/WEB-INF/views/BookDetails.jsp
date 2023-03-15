<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/title.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/content.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/IMG.css">
<meta charset="UTF-8">
<title>도서 사이트</title>
</head>
<body>
<%@ include file="include/header.jsp" %>
<%@ include file="include/menubar.jsp" %>
<center>
   <table  width="35%" border="0" cellspacing="0" cellpadding="10">
      <tr>
         <td rowspan="4"><img src="${pageContext.request.contextPath }/resources/img/${Bdto.bimg}" class="img3"></td><td>제목 :${Bdto.btitle }   </td>
      </tr>
      <tr>
         <td>저자: ${Bdto.bname }</td>
      </tr>
    
     <tr>
         <td>가격: ${Bdto.bprice }원</td>
      </tr>
      <tr>
         <td><input class="button_type01" type="button" value="구매하기" onclick="script:window.location='BuyBook?btitle=${Bdto.btitle }'"> </td>
      </tr>
      <tr>
         <td colspan="2" >
         <h2>책소개</h2>
         <hr>
         <br>
         ${Bdto.bstory }
         </td>
      </tr>
   </table>
</center>
<%@ include file="include/footer.jsp" %>

</body>
</html>