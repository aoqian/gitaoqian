<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

<title>查看框</title>

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

</head>

<body style="margin:0px;padding:0px;font-family: 微软雅黑;">
	<%@include file="head.jsp"%>
	<div style="width:100%;height:888px;border-top:2px solid #69B8F6;">
		<div
			style="width:1200px;height:600px;/* border:1px solid red; */margin:0px auto;">
			<div style="width:70%;height:100%;float:left;">
				<div style="width:40%;height:100%;float:left;"></div>
				<div style="width:60%;height:100%;float:left;">
					<div
						style="width:100%;height:60px;border:1px solid #D9D9D9;margin-top:35px;border-radius:10px;">
						<div style="width:20%;height:100%;float:left;">
							<span
								style="font-family: 微软雅黑;font-size: 20px;color: #D9D9D9;display: block;margin-top: 15px;margin-left: 15px;">公司名称</span>
						</div>
						<div style="width:80%;height:100%;float:left;">
							<input type="text" name="asd"
								style="width:100%;height:100%;border:0px;border-radius: 10px;" />
						</div>
					</div>
					<div
						style="width:100%;height:60px;border:1px solid #D9D9D9;margin-top:35px;border-radius:10px;">
						<div style="width:20%;height:100%;float:left;">
							<span
								style="font-family: 微软雅黑;font-size: 20px;color: #D9D9D9;display: block;margin-top: 15px;margin-left: 15px;">注册号码</span>
						</div>
						<div style="width:80%;height:100%;float:left;">
							<input type="text" name="asd"
								style="width:100%;height:100%;border:0px;border-radius: 10px;" />
						</div>
					</div>
					<div
						style="width:100%;height:60px;border:1px solid #D9D9D9;margin-top:35px;border-radius:10px;">
						<div style="width:20%;height:100%;float:left;">
							<span
								style="font-family: 微软雅黑;font-size: 20px;color: #D9D9D9;display: block;margin-top: 15px;margin-left: 15px;">法人姓名</span>
						</div>
						<div style="width:80%;height:100%;float:left;">
							<input type="text" name="asd"
								style="width:100%;height:100%;border:0px;border-radius: 10px;" />
						</div>
					</div>
					<div
						style="width:100%;height:60px;border:1px solid #D9D9D9;margin-top:35px;border-radius:10px;">
						<div style="width: 28%;height:100%;float:left;">
							<span
								style="font-family: 微软雅黑;font-size: 20px;color: #D9D9D9;display: block;margin-top: 15px;margin-left: 15px;">法人身份证号</span>
						</div>
						<div style="width: 69%;height:100%;float:left;">
							<input type="text" name="asd"
								style="width:104%;height:100%;border:0px;border-radius: 10px;" />
						</div>
					</div>
					<div
						style="width:100%;height:60px;border:1px solid #D9D9D9;margin-top:35px;border-radius:10px;background-color: #69B8F6;font-family: 微软雅黑;color: white;font-size: 20px;text-align: center;line-height: 60px;cursor:pointer;">查询</div>
					<div
						style="width:100%;height:60px;border:1px solid #D9D9D9;margin-top:15px;border-radius:10px;background-color: #BFBBBB;font-family: 微软雅黑;color: white;font-size: 20px;text-align: center;line-height: 60px;cursor:pointer;">取消</div>
				</div>
			</div>
			<div style="width:30%;height:100%;float:left;">
				<img src="images/querybox/erweima.png"
					style="margin-top: 46px;width: 280px;height: 353px;float: right;"></img>
			</div>
		</div>
		<div style="height: 230px;width: 100%;">
			<div style="height: 85%;width: 1200px;margin: auto;">
				<div style="width: 20%;height:100%;float:left;"></div>
				<img src="images/querybox/z-5.png"></img><img
					style="margin-left: 183px;" src="images/querybox/z-6.png"></img><img
					style="margin-left: 118px;" src="images/querybox/z-7.png"></img>
			</div>
		</div>
		<div style="height: 40px;width: 100%;">
			<div style="height: 100%;width: 1275px;margin: auto;">
				<img src="images/querybox/tel.png" style="float: right;"></img>
			</div>
		</div>
	</div>
	<%@include file="foot.jsp"%>
</body>
</html>
