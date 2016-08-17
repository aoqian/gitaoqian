<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>道格征信-个人信用信息概要</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5,IE=6,IE=7,IE=8,IE=9,IE=10,IE=11" />
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	background: #F2F2F2;
}

.home3 {
	width: 100%;
	height: 400px;
	background: #52ADED;
}

.h3_s1 {
	color: white;
	padding: 12px;
}

.h3_d1 {
	text-align: center;
	width: 100%;
	font-size: 36px;
	color: white;
	height: 140px;
	line-height: 140px;
}

.h3_i1 {
	height: 50px;
	width: 90%;
	background: #52ADED;
	border: 2px solid #AED2EC;
	float: left;
	padding-left: 3px;
	margin-bottom: 0px;
	font-size: 20px;
}

.h3_i2 {
	height: 50px;
	width: 8%;
	background: #52ADED;
	border: 2px solid #AED2EC;
	background: url(image/search.png);
	float: left;
	background-repeat: no-repeat;
	background-size: 85% 80%;
	background-position-x: 42%;
	background-position-y: 75%;
}

.h3_s2 {
	display: inline-block;
	margin: 7px;
}

.sch_btn {
	float: left;
	width: 50px;
	height: 48px;
	background: #52ADED;
	background: url(image/search.png);
	border: 2px solid #AED2EC;
	background-repeat: no-repeat;
	background-size: 85% 80%;
	background-position-x: 42%;
	background-position-y: 75%;
}

.sch_inbox {
	display: block;
	width: 530px;
	height: 44px;
	border: 2px solid #AED2EC;
	background: #52ADED;
	position: relative;
	float: left;
}

.sch_inbox input {
	width: 524px;
	height: 36px;
	line-height: 36px;
	font-size: 20px;
	padding-left: 5px;
	margin-top: 4px;
	border: 0 none;
	background: #52ADED;
	color: white;
	outline: none;
}

.sea2 {
	width: 100%;
	text-align:center;
}

.sea2_dd {
	width: 1200px;
	margin: auto;
	background: white;
	height: 800px;
	margin-top: 40px;
	margin-bottom: 80px;
	text-align:left;
}

.sea2_d {
	width: 1140px;
	height: 120px;
	padding: 10px 30px 10px 30px;
	border: 0px solid #ccc;
}

.sea2_d1 {
	width: 80px;
	float: left;
	padding-top: 21px;
}

.sea2_d2 {
	width: 1060px;
	float: left;
}

.sea2_s1 {
	display: inline-block;
	padding: 0px 20px 0px 20px;
	line-height: 40px;
}

.sea2_s21 {
	display: inline-block;
	width: 400px;
	text-align: left;
	border-right: 0px solid #ccc;
	line-height: 40px;
}

.sea2_s22 {
	display: inline-block;
	width: 400px;
	text-align: center;
	border-right: 0px solid #ccc;
	line-height: 40px;
}

.sea2_s23 {
	display: inline-block;
	width: 350px;
	text-align: right;
	border-right: 0px solid #ccc;
	line-height: 40px;
}




em{ font-style: normal; font-weight: bold;color:black;}
.sea2_dd1{
    height: 50px;
    width: 1200px;
   
    border-bottom: 0px solid #ccc;
    /* color: #2CA8FF; */
    font-size: 20px;
    text-align: center;
    line-height: 60px;
    font-weight: bold;}
.detail_d1{     
    width: 100%;
    height: 45px;
    background: #69B8F6;
    text-align: center;
    line-height: 45px;
    font-size: 22px;
    color: white;
    font-weight: 500;
    font-family: 微软雅黑;}
.detail_d2{    padding: 20px 40px 40px 40px;
    font-size: 18px;}
</style>
</head>

<body>
	<%@ include file="head.jsp"%>

	<div class="sea2">

		<div class="sea2_dd">
			<div class="sea2_dd1">
				个人信用信息概要
			</div>
		    <c:forEach items="${list}" var="br">
		     <div style="height:30px;width:1160px;border-bottom:0px solid #ccc;padding-left: 20px;padding-right: 20px;color:#919191;font-size: 14px;">
				<span class="sea2_s21"><em>立案号：</em>${br.Anno}</span> <span class="sea2_s22"><em>立案时间：</em>${br.Liandate }</span>
				<span class="sea2_s23"><em>数据创建时间：</em>${br.Createdate }</span> 
			</div>
		 	<div
				style="height:30px;width:1180px;border-bottom:0px solid #ccc;padding-left: 20px;padding-bottom:10px;color:#919191;font-size: 14px;">
				<span class="sea2_s21"><em>姓名：</em>${br.Name }</span> <span class="sea2_s22"><em>证件类型：</em>身份证</span>
				<span class="sea2_s23"><em>证件号码：${br.Orgno }</em></span> 
			</div> 
        
       			<div class="sea2_d">
				<div style="width:100%;   border: 1px solid #ccc;">
		        <c:choose>
		        <c:when test="${br.Cate=='失信人' }"><div class="detail_d1">失信报告</div>	</c:when>
		        <c:when test="${br.Cate=='被执行人' }"><div class="detail_d1">被执行报告</div></c:when>
		        </c:choose>		
				
				<div class="detail_d2">${br.Yiwu }</div>	
				</div>
			</div>
		    </c:forEach>
	
      
     

		</div>
	</div>

	<%@ include file="foot.jsp"%>
</body>
</html>
