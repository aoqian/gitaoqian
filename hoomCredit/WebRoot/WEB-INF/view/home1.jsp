<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<html>
<head>
<base href="<%=basePath%>">

<title>道格征信</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="X-UA-Compatible"
	content="IE=5,IE=6,IE=7,IE=8,IE=9,IE=10,IE=11" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="bookmark"  type="image/x-icon"  href="<%=basePath%>images/favicon.ico"/>
<link rel="shortcut icon" href="<%=basePath%>images/favicon.ico">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.home3 {
	width: 100%;
	height: 400px;
	background: #52ADED;
	text-align: center;
}

.home4 {
	width: 100%;
	height: 175px;
	background: white;
	text-align: center;
}

.home5 {
	width: 100%;
	height: 350px;
	background: #F2F4F8;
	padding-top: 40px;
	text-align: center;
}

.home6 {
	width: 100%;
	height: 480px;
	background: white;
	padding-top: 40px;
	text-align: center;
}

.h3_s1 {
	color: white;
	padding: 12px;
	display: inline-block;
	cursor: pointer;
}

.h3_s11 {
	padding-top: 12px;
	padding-bottom: 12px;
	display: inline-block;
	cursor: pointer;
}

.h3_d1 {
	text-align: center;
	width: 100%;
	font-size: 36px;
	color: white;
	height: 166px;
	line-height: 200px;
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
	cursor: pointer;
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

.h4_d41 {
	float: left;
}

.h5_d1 {
	background: #C6F4FF;
	text-align: center;
	width: 32%;
	float: left;
	padding-top: 30px;
	height: 290px;
	overflow: hidden;
}

.p1 .ig1 {
	padding-left: 141px;
}

.p1 .ig2 {
	padding-left: 119px;
}

.p1 .ig3 {
	padding-left: 109px;
}

.h5_p1 {
	font-size: 14px;
	margin: 0px;
}

.h5_p2 {
	font-size: 18px;
	margin-top: 10px;
	margin-bottom: 10px;
	position: relative;
	top: -100px;
}

.h5_p4 {
	position: relative;
	top: -109px;
	width: 201px;
	height: 50px;
	margin: auto;
	background: #69B8F6;
	border-radius: 10px;
	line-height: 50px;
	font-size: 20px;
	border: 1px solid white;
	cursor: pointer;
}

.h5_p3 {
	font-size: 24px;
	margin: 0px;
	margin-bottom: 3px;
}

.h6_l1 {
	line-height: 40px;
	list-style-image: url(image/shape.png);
}

.h6_s1 {
	float: left;
	padding-left: 15px;
}

.h6_s2 {
	float: right;
	padding-right: 15px;
}

.h6_m1 {
	margin-top: 20px;
	float: right;
}

.h5_d1:hover {
	color: white;
	background: #52ADED;
}

.add_back1 {
	background-image: url(..../../image/home/back1.png);
	background-repeat: no-repeat;
	background-position-y: 9px;
}

.add_back2 {
	background-image: url(..../../image/home/back2.png);
	background-repeat: no-repeat;
}

.h6_s2 {
	float: right;
	padding-right: 20px;
}
</style>

<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#pp").click(function() {
			$("#ee").removeClass("add_back2");
			$(this).addClass("add_back1");
			$("#bdfm1").attr("action", "New/primary.do");
			$("#register").attr("href", "New/register.do");
		});
		$("#ee").click(function() {
			$("#pp").removeClass("add_back1");
			$(this).addClass("add_back2");
			$("#bdfm1").attr("action", "New/primarys.do");
			$("#register").attr("href", "New/registers.do");
		});
	});
</script>
</head>

<body>
	<%@ include file="head.jsp"%>

	<div class="home3">
		<div style="width:1200px;margin:auto;height:100%;">
			<div
				style="width:610px;margin:auto;border:0px solid #ccc;height:100%;">
				<div class="h3_d1">全面的企业信息查询平台</div>
				<div style="color:white;padding-bottom: 26px;">
					<span class="h3_s1 add_back1" id="pp">个人</span><span class="h3_s11">|</span>
					<span class="h3_s1" id="ee">企业名</span><span class="h3_s11">|</span>
					<span class="h3_s1">专利</span><span class="h3_s11">|</span> <span
						class="h3_s1">商标</span><span class="h3_s11">|</span> <span
						class="h3_s1">产品品牌</span><span class="h3_s11">|</span> <span
						class="h3_s1">联系方式</span><span class="h3_s11">|</span> <span
						class="h3_s1">高管</span>
				</div>
				<div style="height:50px;">
					<!-- form -->
					<div class="sch_form">
						<form id="bdfm1" action="New/primary.do">
							<span class="sch_inbox" id="J_schInbox"> <input
								type="text" name="word" id="" /> </span> <input class="sch_btn"
								type="submit" value=" " id="j_search_sbm">
						</form>
					</div>
					<!-- form end -->
				</div>
				<div style="width:400px;margin:auto;color:white;padding-top: 45px;">

				</div>
			</div>

		</div>
	</div>
	<div class="home4">
		<div style="width:1200px;margin:auto;border:0px solid #ccc;text-align:center;">
			<div
				style="width:100%;padding-top:30px;padding-bottom:30px;margin:auto;">
				<div>
					<div class="h4_d41">

						<img src="<%=basePath%>image/gongshang.png" style="margin-left:65px;"></img>

					</div>

				</div>
				<div>
					<div class="h4_d41">
						<img src="<%=basePath%>image/major.png" style="margin-right:30px;"></img>
					</div>

				</div>
				<div>
					<div class="h4_d41">
						<img src="<%=basePath%>image/brand.png"></img>
					</div>

				</div>
				<div>
					<div class="h4_d41">
						<img src="<%=basePath%>image/select.png"></img>
					</div>

				</div>
			</div>

		</div>
	</div>
	<div class="home5">
		<div style="width:1200px;margin:auto;text-align:center;">
			<div class="h5_d1">



				<div class="p1">
					<img src="image/home/1.png" class="ig1"></img>
				</div>
				<a href="New/primary.do"><p id="primary" class="h5_p4">初级查询</p>
				</a>
				<p class="h5_p2">免费查询&nbsp;一键生成</p>
			</div>
			<div class="h5_d1" style="margin-left: 2%;margin-right: 2%;">



				<div class="p1">
					<img src="image/home/2.png" class="ig2"></img>
				</div>
				<a
					href="<c:if test="${empty user}"><%=basePath%>New/login.do</c:if><c:if test="${not empty user}"><%=basePath%>New/intermediate.do</c:if>"><p
						id="inter" class="h5_p4">中级查询</p> </a>
				<p class="h5_p2">15元/次&nbsp;&nbsp;3-5个工作日生成</p>
			</div>
			<div class="h5_d1">


				<div class="p1">
					<img src="image/home/3.png" class="ig3"></img>
				</div>
				<a href="New/senior.do"><p id="senior" class="h5_p4">高级查询</p> </a>
				<p class="h5_p2">30元/次&nbsp;&nbsp;5-8个工作日生成</p>
			</div>
		</div>
	</div>
	<div class="home6">
		<div
			style="width:1200px;margin:auto;border:1px solid #ccc;height: 70%;">
			<div style="width:100%;background:#FDFDFD;">
				<div
					style="width:100%;height:40px;line-height:40px;text-align:center;color:#959595;border-bottom:1px solid #ccc;margin-bottom: 12px;">
					<span class="h6_s1">热点头条</span><span class="h6_s2">更多</span>
				</div>
				<div
					style="width:20px;height:256px;float:left;border-right:1px solid #ccc;margin-top: 6px;"></div>
				<div style="width:95%;float:left;">
					<ul
						style="margin-left: -27px;text-align:left;border:0px solid red;">

						<c:forEach items="${list}" var="l">
							<li class="h6_l1"><a href="New/hot_detail.do?id=${l.id}">${l.headline}</a><span
								class="h6_s2">${l.time}</span></li>
						</c:forEach>
					</ul>


				</div>
			</div>

		</div>
		<%--  <div style="width:1200px;margin:auto;"><img class="h6_m1" src="<%=basePath%>image/tel.png"></img></div> --%>
	</div>

	<%@ include file="foot.jsp"%>

</body>
</html>
