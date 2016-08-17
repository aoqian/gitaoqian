<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'head.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="edge" />  
	<!-- <meta http-equiv="X-UA-Compatible" content="IE=5,IE=6,IE=7,IE=8,IE=9,IE=10,IE=11" /> -->
	<link rel="bookmark"  type="image/x-icon"  href="images/favicon.ico"/>
	<link rel="shortcut icon" href="images/favicon.ico"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <style type="text/css">
   body{margin:0px;font-family: 微软雅黑;}
   a{color:black;text-decoration: none;}
  .home1{width:100%;height:40px;background:#F2F3F5;border-bottom: 1px solid #ccc;text-align:center;}
  .home2{width: 100%;height: 70px;background: white;padding-top: 15px;text-align:center;}
  .em1{background:url(image/ph.png);width: 20px;height: 20px;display: inline-block;position: relative;
  top: 6px;}
    .h1_s11{height: 40px;width: 250px;border-right: 0px solid #ccc;display: inline-block;
    background-image:url(image/head/person.png);    padding-left: 20px; text-align:left;
    background-repeat: no-repeat;
    background-position-y: 12px;
    }
    .h1_s2{height: 40px;width: 80px;border-right: 1px solid #ccc;display: inline-block;text-align:center;text-align: center;padding-right: 8px;margin-right: 6px;}
    .h1_s3{display: inline-block;width: 50px;height: 30px;border: 1px solid #ccc;text-align: center;position: relative;top: 3px;line-height: 34px;}
    .h1_s4{display: inline-block;width: 50px;height: 30px;border: 1px solid #ccc;text-align: center;position: relative;top: 3px;color:#FF7F23;line-height: 34px;}
    .h2_s1{display:inline-block;margin:21px;}
  </style>
  </head>
  
  <body>
   <div class="home1">
  <div style="width:1200px;margin:auto;line-height: 40px;font-family: 微软雅黑;">
  <div style="float:left;height:100%;"><span class="em1" ></span><span >客服电话：400-189-7777</span></div>
    <c:choose>
 <c:when test="${user eq null }">
   <div style="float:right;">
  
  <span class="h1_s2">新手指引</span>
   <span class="h1_s3"><a href="New/login.do">登录</a> </span>
  <span class="h1_s4" id="register"><a href="New/register.do">注册</a> </span>
  </div>
 </c:when>
 <c:otherwise>
  <div style="float:right;width:200px;">
   <span class="h1_s11"><a href="New/personal.do">个人中心: ${user.name}</a>&nbsp;&nbsp;&nbsp;<a href="New/exitUser.do">退出</a></span>
  </div>
 </c:otherwise>
 </c:choose>
  
  </div>
  </div>
  <div class="home2">
  <div style="width:1200px;margin:auto;">
  <div style="float:left;"><img src="image/dog.png"></img></div>
  <div style="float:right;">
  <a href="New/first.do"><span class="h2_s1">首页</span></a>
  <a href="New/primary.do"><span class="h2_s1">我要查询</span></a>
  <span class="h2_s1">安全保障</span>
  <a href="New/our.do"><span class="h2_s1">关于我们</span></a>
  </div>
  </div>
  </div>
  </body>
</html>
