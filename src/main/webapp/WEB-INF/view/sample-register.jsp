<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String error = request.getParameter("error");
		if(error != null){
			
	%>
		<p style="color:red">登録に失敗しました。</p>
		<h3>受験企業登録</h3>
		<form action="RegisterCompanyExecuteServlet" method="post">
			企業名：<input type="text" name="company" value="<%=request.getParameter("company") %>"><br>
			受験日：<input type="date" name="date" " value="<%=request.getParameter("date") %>"><br>
			内容：<br>
			<textarea name="note" rows="10" cols="50" placeholder="内容を入力"><%=request.getParameter("note") %></textarea><br>
			<input type="submit" value="登録">
		
		</form>
	<%	
		} else {
	%>
	<h3>受験企業登録</h3>
	<form action="RegisterCompanyExecuteServlet" method="post">
		企業名：<input type="text" name="company"><br>
		受験日：<input type="date" name="date"><br>
		内容：<br>
		<textarea name="note" rows="10" cols="50" placeholder="内容を入力"></textarea><br>
		<input type="submit" value="登録">
	
	</form>
	<% } %>
	<a href="TopServlet">戻る</a>
	
</body>
</html>