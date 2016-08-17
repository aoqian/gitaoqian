<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>道格征信-热点头条</title>
    
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
	body{text-align:center;}
	.a1{width:100%;height:auto;border-top:2px solid #4BA6E7;background:#F2F4F8;}
	.a1_d1{width:1200px;margin:auto;padding-top:40px;padding-bottom:140px;overflow: auto;text-align:left;}
	.a1_d11{padding-left: 50px;width:890px;float:left;border:0px solid #ccc;background:white;padding-right: 15px;}
	.a1_d12{width: 200px;float: left;/* height: 100%; */border-left: 0px solid #ccc;padding-left: 40px;padding-top: 30px;}
	.a1_p1{font-size: 28px;margin-top: 36px;font-weight: bold;}
	.a1_p2{color:#717171;    margin-top: -12px;margin-bottom: 20px;}
	.a1_p3{letter-spacing: 1px;line-height: 25px;}
	.a1_p4{margin-top: 36px;}
	.a1_p5{color:#717171; text-align:center;   }
	.a1_s1{color:#4AA6E6;}
	</style>

  </head>
  
  <body>
   <%@ include file="head.jsp"%>
   <div class="a1">
   <div class="a1_d1">
   <div class="a1_d11">
   <p class="a1_p1">${headline}</p>
   <p class="a1_p2">发表于 ${time}</p>
   <div><img src="image/our/HB-142.png"></img></div>
   <p class="a1_p3">${content}</p>
   <p class="a1_p4">相关公司：<span class="a1_s1">${related_company }</span></p>
   </div>
   <div class="a1_d12">
   <img src="image/two.png"></img>
   <p class="a1_p5">关注“道格”微信公众号，实时信息一手掌握</p>
   </div>
   </div>
   </div>
   <div><%@ include file="foot.jsp"%></div>
   
   
  </body>
</html>
