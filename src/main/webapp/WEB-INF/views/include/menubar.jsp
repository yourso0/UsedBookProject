<%@page import="com.usedbook.home.dto.BookNationDto"%>
<%@page import="com.usedbook.home.dto.BookGenreDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/menubar.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/hyperlink.css">
</head>
<body>
   <table class="main" >
  <tr >
    <td margin="10px">
      <ul class="menu">
        <li class="font" ><a href="#" >장르별</a>
          <ul class="sub-menu"><br>
          <%List<BookGenreDto> gnames = (List)session.getAttribute("genre"); 
          for(BookGenreDto gname : gnames){
          %>                 
                 <li> 
                   <a href="GenreBook?bgenre=<%=gname.getBooknum() %>"> <%=gname.getBgenre() %></a>
                 </li> <br>
                
           <%} %>
          </ul>
        </li>
       </td>
        <td>
        <ul class="menu">
        <li class="font"><a href="#">국가별</a>
          <ul class="sub-menu"><br>
          <%List<BookNationDto> nations = (List)session.getAttribute("nation"); 
            for(BookNationDto nname : nations){
          %>                 
                 <li> 
                   <a href="NationBook?nation=<%=nname.getBooknum() %>"> <%=nname.getNation() %></a>
                 </li> <br>
                
           <%} %>
            </ul>
        </li>
       </td>
        <td>
        <ul class="menu">
        <li class="font"><a href="#">게시판</a>
          <ul class="sub-menu"><br>
            <li><a href="question">
            글쓰기</a></li><br>
            <li><a href="#">글 목록</a></li><br>
          </ul>
        </li>
      </ul>
    </td>
   </tr>
</table>

</body>
</html>