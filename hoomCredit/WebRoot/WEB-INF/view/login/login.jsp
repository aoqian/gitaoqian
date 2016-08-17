<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>道格征信-登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="bookmark"  type="image/x-icon"  href="<%=basePath%>images/favicon.ico"/>
<link rel="shortcut icon" href="<%=basePath%>images/favicon.ico">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
::-webkit-input-placeholder { /* WebKit browsers */ 
color: white; 
} 
:-moz-placeholder { /* Mozilla Firefox 4 to 18 */ 
color: white; 
} 
::-moz-placeholder { /* Mozilla Firefox 19+ */ 
color: white;
} 
:-ms-input-placeholder { /* Internet Explorer 10+ */ 
color: white; 
} 
</style>
</head>

<body style="background-color: #48A4E6;font-family: 微软雅黑;">
	<div
		style="text-align: center;margin-top: 200px;color: white;font-family: 微软雅黑;">
		<div style="margin-top: 15px; margin-left: 45px;">
			<img src="images/login/logo.png"></img>
		</div>

		<div style="margin-top: 55px;">
			用户名 ：&nbsp;&nbsp;<input placeholder="&nbsp;&nbsp;&nbsp;&nbsp;(道格用户请用手机号登录)"
				style="color: white;font-family: 微软雅黑;border: 0px; background-color: #6CB7ED;width: 450px;height: 45px;">
		</div>
		<div style="margin-top: 15px;">
			密&nbsp;&nbsp;&nbsp;码 ：&nbsp;&nbsp;<input placeholder="&nbsp;&nbsp;&nbsp;&nbsp;(请输入密码)" type="password"
				style="color: white;font-family: 微软雅黑;border: 0px; background-color: #6CB7ED;width: 450px;height: 45px;">
		</div>
		<div style="margin-top: 35px;">
			<input
				style="color: white;font-family: 微软雅黑; border: 0px; background-color: #3AB8F8;width: 524px;height: 59px;font-weight: bolder;font-size: large;cursor:pointer;"
				type="button" value="登录">
		</div>
		<div style="margin-top: 35px; margin-left: -435px;">
			<font>忘记密码？</font><input type="hidden"
				style="border: 0px; background-color: #6CB7ED;width: 364px;height: 47px;">
		</div>
	</div>
</body>
</html>
