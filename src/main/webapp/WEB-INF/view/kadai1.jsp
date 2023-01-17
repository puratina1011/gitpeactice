<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="dto.kadaidto" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  
		request.setCharacterEncoding("UTF-8");
		String errorCode = request.getParameter("error");
		if(errorCode != null && errorCode.equals("1")){
			kadaidto kadai = (kadaidto)session.getAttribute("kadai_data");
	%>

	<h3>新規会員登録</h3>
	<form action="kadai1ConServlet" method="post">
			名前：<input type="text" name="name" value="<%=kadai.getName()%>"><br>
			年齢：<input type="text" name="age" value="<%=kadai.getAge()%>"><br>
			性別：<input type="radio" name="gender" value="男">男
			 	 <input type="radio" name="gender" value="女">女<br>
			電話番号：<input type="text" name="tell" value="<%=kadai.getTell()%>"><br>
			メール：<input type="text" name="email" value="<%=kadai.getMail()%>"><br>
			パスワード：<input type="password" name="password"><br>
		<input type="submit" value="登録">
	</form>
	<% 
		} else {
	 %>
	
	<form action="kadai1ConServlet" method="post">
		名前：<input type="text" name="name"><br>
		年齢：<input type="text" name="age"><br>
		性別：<input type="radio" name="gender" value="男">男
			  <input type="radio" name="gender" value="女">女<br>
		電話番号：<input type="text" name="tell"><br>
		メール：<input type="text" name="email"><br>
		パスワード：<input type="password" name="password"><br>
		<input type="submit" value="登録">
	</form>
	<% 
		}
	%>
</body>
</html>