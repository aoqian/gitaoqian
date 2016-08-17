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
	.a1{width:100%;height:720px;border-top:2px solid #4BA6E7;}
	.a1_d1{width:1200px;margin:auto;padding-top:70px;padding-bottom:180px;height:526px;}
	.a1_d11{padding-left: 45px;width:842px;float:left;height:100%;border:0px solid #ccc;}
	.a1_d12{width: 200px;float: left;height: 100%;border-left: 1px solid #ccc;padding-left: 33px;padding-right:33px;margin-left: 45px;}
	.a1_p1{font-size: 27px;margin-top: 10px;}
	.a1_p2{color:#717171;    margin-top: -12px;margin-bottom: 20px;}
	.a1_p3{letter-spacing: 1px;line-height: 25px;}
	.a1_p4{margin-top: 72px;}
	.a1_p5{color:#717171; text-align:center;   }
	.a1_s1{color:#4AA6E6;}
	</style>

  </head>
  
  <body>
   <%@ include file="head.jsp"%>
   <div class="a1">
   <div class="a1_d1">
   <div class="a1_d11">
   <p class="a1_p1">阿里云最新估值高达390亿美元 成为马云帝国第三增长极</p>
   <p class="a1_p2">发表于 6时56分钟前</p>
   <p class="a1_p3">日前，阿里集团旗下的阿里云业务，被国际知名投行进行了单独估值已高达390亿美元，约合人民币2500亿元。而截至7月1日，阿里集团的市值约为2028亿美元，换言之，阿里云，
   在不计阿里溢价变动情况下，阿里云的估值已占阿里集团的20%。<br>研究报告指出，阿里巴巴的电商平台和关联公司蚂蚁金服都在7年到10年内形成规模和盈利，今年成立满7年的阿里云，也
   已经达到盈利点，预计地未来的三年内保持高速的营收增幅。<br>据预测，到2019财年年底，阿里云在中国市场份额将达到58%。成为继电商、支付之后的第三个增长极。在国际市场上，阿里
   云与亚马逊AWS的营收差距也将不断缩小。分析报告预计，阿里云在未来三年将保持89%以上的复合年增长率，2020财年营收达到580亿元人民币，到2022财年营收达到1200亿人民币（约185亿美元），
   由此与亚马逊的收入差距由5年缩短至3.5年。<br>公开信息显示， 阿里云成立于2009年，是最早开拓云计算市场的中国云服务商之一，并在今年年初才正式推出大数据一站式平台数加。阿里云相关负责人
   对记者表示，目前在国内市场已远远甩开第二名。对此，有分析人士指出，未来三年阿里集团的股价，将很大程度上取决于阿里云的表现。
   </p>
   <p class="a1_p4">相关公司：<span class="a1_s1">阿里云</span></p>
   </div>
   <div class="a1_d12">
   <img src="image/two.png"></img>
   <p class="a1_p5">关注“道格”微信公众号，实时信息一手掌握</p>
   </div>
   </div>
   </div>
   
   <%@ include file="foot.jsp"%>
  </body>
</html>
