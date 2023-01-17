<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.EmploymentExam" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>受験状況一覧</h3>
	
	<table border="1">
		<tr>
			<th>No.</th>
			<th>会社名</th>
			<th>受験日</th>
			<th>内容</th>
		</tr>
		
	<%
		List<EmploymentExam> list = (List<EmploymentExam>)request.getAttribute("list");
		int index = 1;
		for(EmploymentExam ee : list){
	%>
		<tr>
			<td><%=index %></td>
			<td><%=ee.getCompanyName() %></td>
			<td><%=ee.getExamDate()%></td>
			<td><%=ee.getNote() %></td>
		</tr>
	<%
		index++;
		}
	%>
	</table>
	<a href="TopServlet">戻る</a>
</body>
</html>