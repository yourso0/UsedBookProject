<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/hyperlink.css">
<title>header</title>
</head>
<body>
  <%
      String sessionId = (String) session.getAttribute("memberId");   
   %>
   <table width="100%" border="0" cellspacing="0" cellpadding="0" >
      <tr class="headline01">
      <td class="main">
         <a href="index"><img src="${pageContext.request.contextPath }/resources/img/imgMain1.png"></a>
      </td>
         <td width="5%" class="menu01">
          <%
            if(sessionId != null) {
         %>
            <a href="profile">내 정보</a>
         <%
            } 
          %>
          </td>
         <td width="5%" class="menu01">

         <%
            if(sessionId == null) {
         %>
            <a href="login">LOGIN</a>
         <%
            } else {   
         %>
            <a href="logout">LOGOUT</a>
            
         <% 
            } 
         %>
         </td>
         
         <td width="5%" class="menu01">
         <%
            if(sessionId == null) {
         %>
            <a href="join">JOIN</a>
         <%
            } else {   
         %>
            <a href="memberModify">회원정보 수정</a>
         <% 
            } 
         %>   
         </td>
       
        
         </td>
         <td class="menu01"><a href="question">문의하기</a></td>
         <td width="2%">&nbsp;</td>   
      </tr>
    
         </tr>
   </table>
   <hr>
</body>
</html>