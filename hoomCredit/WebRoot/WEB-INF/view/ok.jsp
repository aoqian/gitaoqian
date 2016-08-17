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
    
    <title>道格征信-查询结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="bookmark"  type="image/x-icon"  href="<%=basePath%>images/favicon.ico"/>
	<link rel="shortcut icon" href="<%=basePath%>images/favicon.ico"/>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	.a1{width:100%;height:748px;border-top:0px solid #4BA6E7;text-align:center;}
	.a1_d1{width:1200px;margin:auto;padding-top:45px;height:406px;text-align:left;}
	.a1_d11{padding-left: 45px;width:875px;float:left;height:60%;border:0px solid #ccc;}
	.a1_d12{width: 262px;float: left;height: 100%;border-left: 0px solid #ccc;color:#808080;text-align:center;}
	.a1_d13{width: 1200px;margin: auto;text-align:left;}
	.a1_p1{font-size: 38px;margin-top: 0px;color:#646363;font-weight: 600;letter-spacing: 8px;}
	
	.a1_s1{color:#4AA6E6;}
	.a1_d111{height:100%;float:left;width: 300px;}
	.a1_d112{height:100%;float:left;margin-top: 85px;width: 540px;text-align: center;margin-left: -80px;}
	.a1_img1{margin-top:56px;margin-left: 70px;}
	.a1_img2{display:inline_block;margin: 73px;margin-top: 10px;margin-left: 85px;}
	</style>

  </head>
  
  <body>
   <%@ include file="head.jsp"%>
   <div class="a1">
   <div class="a1_d1">
   <div class="a1_d11">
   <div class="a1_d111"><img class="a1_img1" src="image/person.png"></img></div>
   <div class="a1_d112">
   <p class="a1_p1">温馨提示：查询结果</p>
   <p class="a1_p1">1-3个工作日后公布</p>
   <p class="a1_p1">请耐心等候</p>
   </div>

   </div>
   <div class="a1_d12">
   <img src="image/two.png" style="width:250px;"></img>
   <p class="a1_p5">关注“道格”微信公众号,</p>
   <p class="a1_p5">实时信息一手掌握</p>
   </div>
   
   </div>
   <div class="a1_d13">
   <img src="image/1.png" class="a1_img2"></img>
   <img src="image/2.png" class="a1_img2"></img>
   <img src="image/3.png" class="a1_img2"></img>
  </div>
   </div>
   <div style="text-align:center;">
   <div style="width:1200px;margin:auto;text-align:right;height: 60px;"><img src="image/tel.png"></img></div>
   </div>
   
   <%@ include file="foot.jsp"%>
  </body>
</html>
