<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/title.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/content.css">
<title>프로필</title>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<center>
   <table>
      <center>
         <table>
            <tr>
               <td>
               <center>                  
            <table width="0%" border="0" cellspacing="0" cellpadding="10" style="text-align: center;">   
            <tr>
            <br>
              <br> 
               <td class="Title">
                 <h1 style="text-align: center;">회원정보창</h1> 
               </td>            
            </tr>               
      <tr>
         <td><span class="text01"><h3>아 이 디 : ${memberDto.mid }</h3> </span></td>                  
      </tr>   
      <tr>
         <td><span class="text01"><h3>이&nbsp;&nbsp;&nbsp;&nbsp;름 : ${memberDto.mname }</h3> </span></td>
      </tr>
      <tr>
               <td><span class="text01"><h3>핸드폰 번호 : ${memberDto.mphone }</h3> </span></td>
        </tr>
         <tr>
               <td><span class="text01"><h3>이 메 일: ${memberDto.memail }</h3> </span></td>
        </tr>
          
        <tr>
               <td><span class="text01"><h3>집 주 소: ${memberDto.maddress }</h3></span></td>
         </tr>
          <tr>
               <td><input class="button_type01" type="button" value="정보수정" onclick="script:window.location='memberModify'"></td>
         </tr>
      </table>
      </center>     
      <center>
      <hr>
      		<h1>구매한 책 목록</h1>
      <table style="border: 1px;">
      
     	 	<c:forEach items="${buyDto}" var="buyDto">      

     	 	<tr>
     	 	
           <td><span class="text01"><input type="hidden" value="${buyDto.stitle }" name="stitle"><h3>[책제목: <a href="">${buyDto.stitle }]</h3></a></span></td>
           <td><span class="text01"><input type="hidden" value="${buyDto.sprice }" name="sprice"><h3>[가 격: ${buyDto.sprice }원]</h3></span></td>
                <td><span class="text01"><input type="hidden" value="${buyDto.sname }" name="sname"><h3>[이 름: ${buyDto.sname }]</h3></span></td>
              <td><span class="text01"><input type="hidden" value="${buyDto.saddress }" name="saddress"><h3>[배송지: ${buyDto.saddress }]</h3></span></td>
                  <td><span class="text01"><input type="hidden" value="${buyDto.snum }" name="snum"></span></td>
             <td> <input  class="button_type01" type="button" value="구매취소" onclick="script:window.location='buydelete?snum=${buyDto.snum}'"></td>
            
           </tr>
           
                    
         
         
          
          </c:forEach>
     
      
      </table>
      
      </center>
    
   </table>
</center>            
      	<%@ include file="include/footer.jsp" %>
</body>
</html>