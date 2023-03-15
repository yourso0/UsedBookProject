<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/MembeBook.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/IMG.css">
<title>도서 사이트</title>
</head>
<body>
<%@ include file="include/header.jsp" %>
<%@ include file="include/menubar.jsp" %>
<center>
   <table>
      <center>
         <table>
            <tr>
               <td>
               <center>                  
            <table width="80%" border="0" cellspacing="0" cellpadding="10" style="text-align: center">   
             	<form  action="buyOk" method="post" >
            <tr>
            <br>
              <br> 
               <td class="Title">
                 <h2> 배송정보 </h2>
                </td>            
            </tr>               
      <tr>
     
         <td><span class="text01" ><input type="hidden" value="${memberDto.mid }" name="sid">아 이 디 : ${memberDto.mid } </span></td>                  
      </tr>   
      <tr>
         <td><span class="text01" ><input type="hidden" value="${memberDto.mname }" name="sname">이&nbsp;&nbsp;&nbsp;&nbsp;름 : ${memberDto.mname } </span></td>
      </tr>
      <tr>
               <td><span class="text01"><input type="hidden" value="${memberDto.mphone }" name="sphone">핸드폰 번호 : ${memberDto.mphone } </span></td>
        </tr>
          
        <tr>
               <td><span class="text01" ><input type="hidden" value="${memberDto.maddress }" name="saddress">집 주 소: ${memberDto.maddress }</span></td>
         </tr>
      </table>
      </center>      
      <center>
      <hr>
            <table  width="100%" border="0" cellspacing="0" cellpadding="10">
                  <tr>
                     <td rowspan="4"><img  class="img" src="${pageContext.request.contextPath }/resources/img/${Bdto.bimg}" ></td>
                     <td><span class="text01" ><input type="hidden" value="${Bdto.btitle }" name="stitle">제목 :${Bdto.btitle }</span></td>
                  </tr>
                  <tr>
                     <td><span class="text01" ><input type="hidden" value="${Bdto.bname }" name="swriter">저자: ${Bdto.bname }</span></td>
                  </tr>
                  <tr>
                     <td><span class="text01" ><input type="hidden" value="${Bdto.bgenre }" name="sgenre">장르: ${Bdto.bgenre }</span></td>
                  </tr>
                 <tr>
                     <td><span class="text01" ><input type="hidden" value="${Bdto.bprice }" name="sprice">가격: ${Bdto.bprice }원</span></td>
                  </tr>
                  <tr>
                     <td><span class="text01" ><input type="hidden" value="${Bdto.isbn }" name="sisbn">isbn: ${Bdto.isbn }</span></td>
                  </tr>

                  <tr>
                     <td><input class="Button01" type="submit" value="구매하기"> </td>
                  </tr>
                    </form>
            </table>
      </center>
   </table>
</center>            
<%@ include file="include/footer.jsp" %>

</body>
</html>