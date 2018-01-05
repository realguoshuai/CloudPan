<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示页</title>
</head>
<body>
	    <div class="user">
	        <a href="#"><%=request.getAttribute("getId") %></a>
	        <a href="#" >退出</a>
	    </div>
</body>
</html>