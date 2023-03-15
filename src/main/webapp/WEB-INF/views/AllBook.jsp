<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/AllBook.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/IMG.css">
<meta charset="UTF-8">
<title>전체 도서</title>
</head>
<body>
	<%@ include file="include/header.jsp" %>	
	<%@ include file="include/menubar.jsp" %>
	<center>
		<table class="MainTable">
				<br>
				<h2>전체 도서 목록</h2>
				<br>
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

				
		</table>
	</center>
	
	<%@ include file="include/footer.jsp" %>
	

</body>
</html>