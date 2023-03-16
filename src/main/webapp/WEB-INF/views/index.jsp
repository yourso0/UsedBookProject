<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/title.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/IMG.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/AllBook.css">
<title>중고 도서사이트</title>
</head>
<body>
	<%@ include file="include/header.jsp" %>	
	<%@ include file="include/menubar.jsp" %>
	<center>
	<table width="80%" border="0" cellspacing="0" cellpadding="20" class="">
		<br>
		<br>
		<br>
		<br>
		<tr>
			<td><span class="title01">새로 올라온 책</span> <span class="title02 ">TOP6</span></td>		
		</tr>	
	</table>
		<hr class="line01" >
	<table  width="80%" border="0" cellspacing="0" cellpadding="10" class="MainTable">

	<c:forEach items="${book}" var="books" varStatus="loop">      
    <c:if test="${loop.index lt 6}">
        <td>
            <a href="BookDetails?btitle=${books.btitle}">
                <img src="${pageContext.request.contextPath }/resources/img/${books.bimg}" class="img2">
                <br>
                ${books.btitle}
                <br>
                ${books.bname }            
            </a>              
        </td>
    </c:if>
</c:forEach>
          
			
			</tr>
		</tr>
	</table>
		<br><br><br><br><br><br>
	<table  width="80%" border="0" cellspacing="0" cellpadding="10" >
		<tr>
			<td class="titleA01">
			<span class="title01">전체 책</span><span class="title02 "> All</span>			
			<tr>
	</table>
		<hr class="line01">
	<table  width="80%" border="0" cellspacing="0" cellpadding="10" class="MainTable">
		<%int count=0;
				
				%>
				<c:forEach items="${book}" var="books">      
         <%if(count==0){ %>
         <tr>
         <%} %>
            
             <td>
               <a href="BookDetails?btitle=${books.btitle}">
                  <img src="${pageContext.request.contextPath }/resources/img/${books.bimg}" class="img">
                 
                  <br>
                  ${books.btitle}
                  <br>
                  ${books.bname }    
                  <br><br><br><br><br><br>  
                </a>
                
             </td>
             
             <%count++; %>
             <%if(count==4) {
             count=0;%>
          </tr>
     		<%} %>
          
          </c:forEach>
		</tr>
	</table>
	</center>
	</table>
	<center>
	<%@ include file="include/footer.jsp" %>
</body>
</html>