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

<title>道格征信-关于我们</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=5,IE=6,IE=7,IE=8,IE=9,IE=10,IE=11" />
<link rel="bookmark"  type="image/x-icon"  href="<%=basePath%>images/favicon.ico"/>
<link rel="shortcut icon" href="<%=basePath%>images/favicon.ico">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	background: white;
}

.a1 {
	width: 100%;
	height: 748px;
	border-top: 1px solid #4BA6E7;
	text-align:center;
}

.a1_d1 {
	width: 1200px;
	margin: auto;
	padding-top: 45px;
	padding-bottom: 106px;
	height: 300px;
	text-align:left;
}

.a1_d11 {
	width: 840px;
	float: left;
	height: 100%;
	border: 0px solid #ccc;
}

.a1_d12 {
	width: 153px;
	float: right;
	border-left: 0px solid #ccc;
	color: #808080;
	text-align: center;
}

.sea2_dd1 {
	width: 100%;
	margin: auto;
	background: white;
	height: 640px;
	border: 1px solid #ccc;
	margin-bottom: 80px;
	padding-left: 1px;
}

.sea2_dd2 {
	width: 100%;
	margin: auto;
	background: white;
	height: 590px;
	display: none;
	margin-bottom: 80px;
	border: 1px solid #ccc;
	padding-left: 1px;
}

.sea2_dd3 {
	width: 100%;
	margin: auto;
	background: white;
	height: 516px;
	display: none;
	margin-bottom: 80px;
	border: 1px solid #ccc;
	padding-left: 1px;
}

.sea2_dd4 {
	width: 100%;
	margin: auto;
	background: white;
	height: 400px;
	display: none;
	margin-bottom: 80px;
	border: 1px solid #ccc;
}

.sea2_d {
	width: 780px;
	
	padding: 0px 0px 0px 0px;
	border: 0px solid #ccc;
}

.sea2_d2 {
	width: 810px;
	float: left;
	
}

.sea2_s1 {
	display: inline-block;
	padding: 0px 20px 0px 20px;
	line-height: 40px;
}

.sea2_s21 {
	display: inline-block;
	width: 21%;
	text-align: left;
	border-right: 0px solid #ccc;
	line-height: 40px;
}

.sea2_s22 {
	display: inline-block;
	width: 18%;
	text-align: center;
	border-right: 0px solid #ccc;
	line-height: 40px;
}

.sea2_s23 {
	display: inline-block;
	width: 21%;
	text-align: center;
	border-right: 0px solid #ccc;
	line-height: 40px;
}

.sea2_s24 {
	display: inline-block;
	width: 18%;
	text-align: center;
	border-right: 0px solid #ccc;
	line-height: 40px;
}

.s_u2 {
	width: 100%;
	margin-bottom: 4px;
	padding-left: 0px;
}

.s_u2 li {
	list-style: none;
	display: inline-block;
}

.s_u2 .l1 {
	width: 21%;
	text-align: left;
	border-right: 0px solid #ccc;
}

.s_u2 .l2 {
	width: 18%;
	text-align: center;
	border-right: 0px solid #ccc;
}

.s_u2 .l3 {
	width: 21%;
	text-align: center;
	border-right: 0px solid #ccc;
}

.s_u2 .l4 {
	width: 18%;
	text-align: center;
	border-right: 0px solid #ccc;
}

.s_u2 .l5 {
	width: 18%;
	text-align: center;
	border-right: 0px solid #ccc;
}

.s_u2 .l5 span {
	color: #2CA8FF;
	width: 48px;
	height: 22px;
	border: 1px solid #2CA8FF;
	display: inline-block;
	border-radius: 4px;
}

.sea2_img1 {
	
}

.sea2_u1 {
	font-size: 18px;
	color: #2CA8FF;
	font-weight: bolder;
}

.sea2_u3 {
	margin-top: 0px;
	font-size: 13px;
	color: #6E6E6E;
}

p {
	font-size: 12px;
}

.sea1_dd1 {
	width: 170px;
	height: 167px;
	border: 1px solid #ccc;
	float: left;
	background: white;
	margin-right: 10px;
	border-top: 0px;
}

.in_p1 {
	width: 100%;
	font-size: 20px;
	padding-left: 25px;
}

#ul {
	padding-left: 4px;
	padding-right: 4px;
}

.l21 {
	width: 31%;
	text-align: left;
	border-right: 0px solid #ccc;
}

.l22 {
	width: 31%;
	text-align: left;
	border-right: 0px solid #ccc;
}

.l23 {
	width: 31%;
	text-align: left;
	border-right: 0px solid #ccc;
}

.add_color {
	color: #69B8F6;
	background: url(...../../image/our/spot.png) no-repeat -9px -3px
		!important;
	
}

#ul li {
	list-style-type: none;
	font-size: 16px;
	height: 30px;
	line-height: 30px;
	padding-left: 42px;
	background: url(...../../image/our/h.png) no-repeat -4px -3px;
	cursor: pointer;
}

#ul li:hover {
	color: #69B8F6;
}

.e_box1 {
	width: 216px;
	float: left;
	border: 0px solid #ccc;
	height: 52px;
	line-height: 52px;
	text-align: right;
}

.e_box2 {
	width: 400px;
	float: left;
	border: 0px solid #ccc;
	height: 26px;
	padding: 12px 0px;
}

.e_box3 {
	width: 200px;
	float: left;
	border: 0px solid #ccc;
	height: 52px;
	line-height: 52px;
}

.e_i1 {
	width: 100%;
	color: #A9A9A9;
	height: 27px;
	line-height: 27px;
	font-weight: bold;
	font-size: 16px;
	outline: none;
	border: 1px solid #ccc;
}

.in_1 {
	color: white;
	background: #34A6F6;
	width: 190px;
	height: 32px;
	text-align: center;
	float: left;
	line-height: 32px;
}

.in_2 {
	color: white;
	background: #A9A9A9;
	width: 190px;
	height: 32px;
	text-align: center;
	float: right;
	line-height: 32px;
}

.dd4 {
	text-align: left;
	font-family: 微软雅黑;
}

.addw {
	background-image: url(..../../image/individual/√_13.png);
	background-repeat: no-repeat;
	background-position-y: 50%;
	background-position-x: 10px;
}

.addx {
	background-image: url(..../../image/individual/×_80.png);
	background-repeat: no-repeat;
	background-position-y: 50%;
	background-position-x: 10px;
}

.h6_s2{
 float:right;
}
.h6_l1{line-height:50px;list-style-image: url(image/shape.png);padding-left: 6px; font-size: 17px;}

.pss{    font-size: 18px;
    padding-left: 20px;}
</style>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#our").click(function() {
			$("#ul li").removeClass("add_color");
			$(this).addClass("add_color");
			$(".sea2_dd1").show();
			$(".sea2_dd2").hide();
			$(".sea2_dd3").hide();

		});
		$("#hot").click(function() {
			$("#ul li").removeClass("add_color");
			$(this).addClass("add_color");
			$(".sea2_dd1").hide();
			$(".sea2_dd3").hide();
			$(".sea2_dd2").show();

		});
		$("#connect").click(function() {
			$("#ul li").removeClass("add_color");
			$(this).addClass("add_color");
			$(".sea2_dd2").hide();
			$(".sea2_dd1").hide();
			$(".sea2_dd3").show();

		});

	});
</script>



<!-- 分页 -->
<link rel="stylesheet" href="html/lib/pagination.css" />
<style type="text/css">
a {
	color: #34538b;
}


.result {
	width: 100%;
}
.our_d1{padding-left: 30px;
    padding-right: 25px;
    font-size: 18px;
    color: black;
    padding-top: 20px;
    font-family: 微软雅黑;
       
    letter-spacing: 1px;
    line-height: 27px;}
</style>
<script type="text/javascript" src="html/lib/jquery.min.js"></script>
<script type="text/javascript" src="html/lib/jquery.pagination.js"></script>
<script type="text/javascript">
	$(function() {
		//这是一个非常简单的demo实例，让列表元素分页显示
		//回调函数的作用是显示对应分页的列表项内容
		//回调函数在用户每次点击分页链接的时候执行
		//参数page_index{int整型}表示当前的索引页
		var initPagination = function() {
			//var num_entries = $("#hiddenresult div.result").length;
			var num_entries = "${totalpage}";
			// 创建分页
			$("#Pagination").pagination(num_entries, {
				num_edge_entries : 1, //边缘页数
				num_display_entries : 4, //主体页数
				callback : pageselectCallback,
				items_per_page : 1//每页显示1项
			});
		}();

		function pageselectCallback(page_index, jq) {

			
			console.log(page_index);

			var new_content = $(
					"#hiddenresult .sea2_d:eq(" + page_index + ")").clone();
			$("#Searchresult").empty().append(new_content); //装载对应分页的内容
			return false;
		}
	});
</script>
</head>

<body>
	<%@ include file="p_head.jsp"%>
	<div class="a1">
		<div class="a1_d1">
			<div class="sea1_dd1">
				<p class="in_p1">关于我们</p>
				<ul id="ul">
					<li id="our" class="add_color">关于我们</li>
					<li id="hot">热点头条</li>
					<li id="connect">联系我们</li>

				</ul>
			</div>
			<div class="a1_d11">
				<!--关于我们  -->
				<div class="sea2_dd1">
					<div
						style="height:40px;width:100%;background:#FDFDFE;border-bottom:1px solid #ccc;color:#FF8707;font-size: 20px;">
						<span class="sea2_s1">关于我们</span>
					</div>
					
					<div 
						style="height:473px;width:840px;background:#FDFDFE;/* border-bottom:1px solid #ccc; */color:#919191;font-size: 14px;">
					<img src="image/our/room.png" style="width:100%;"></img>
					<div class="our_d1">红上公司是一家集企业海内外 IPO、上海股权交易中心 EPO、新三板挂牌、股权投资、全球资产配置、家族财富管理、国内及海外保险、海外移民、海外投资等综合财富管理，企业及个人借款咨询服务与交易促成、助农、助学、助残等公益理财，信用评估与管理、大数据整合等互联网金融信息服务于一体的综合性金融服务企业。 集团总部位于上海浦东陆家嘴金融信息产业基地，目前已创建红上研究院、鸾大资本、红上财富、红上至信、红上金融、Family Office等子品牌，累计资产管理规模已达百亿人民币。公司分支机构已覆盖上海、杭州、南京、南通、西安、苏州、宁波、成都、深圳、北京、广州、厦门、福州、南宁、石家庄、合肥、无锡、昆山、济南、兰州、重庆、郑州、呼和浩特、长春、西宁、宝鸡、汉中、安康等五十多个省市自治区，海外已建立新加坡、香港、纽约等分支机构。 红上公司采用国际先进的风险管理及财富管理体系，依托大数据挖掘技术，在互联网及移动互联网领域不断创新，为大众富裕阶层及小微企业主提供优质的综合财富管理与普惠金融服务。</div>
					
					</div>
		
				
				</div>

			

				<!--热点头条 -->
				<div class="sea2_dd2" id="hotNews">
					<div  id="new1"
						style="height:40px;width:100%;background:#FDFDFE;border-bottom:1px solid #ccc;color:#FF8707;font-size: 20px;">
						<span class="sea2_s1">热点头条</span>
					</div>
					<div id="Searchresult"
						style="height:454px;width:810px;padding-left: 12px;color:#919191;font-size: 14px;">
					</div>
		
					<div id="Pagination" class="pagination"
						style="text-align: center;margin-top: 26px;"></div>
						  <div id="hiddenresult" style="display:none;">
                    <c:forEach items="${list}" var="ms" varStatus="abc">
                    <div class="sea2_d">
					 <c:forEach items="${list}" var="ms" begin="${abc.index*7}"  end="${(abc.index+1)*7-1}">
						<div style="width:100%;height:50px;padding-left: 20px;">
						
						  <ul style="margin-left: -27px;text-align:left;border:0px solid red;">
						  
						 
						   <li class="h6_l1"><a href="New/hot_detail.do?id=${ms.id}">${ms.headline}</a><span class="h6_s2">18时1分钟前</span></li>
						 
						  </ul>

						
						</div>
						</c:forEach>
					</div>
                    </c:forEach>
					</div>
				</div>
                  
                  <!--等待验证  -->
			<div class="sea2_dd3">
					<div
				style="height:40px;width:100%;background:#FDFDFE;border-bottom:1px solid #ccc;color:#FF8707;font-size: 20px;">
				<span class="sea2_s1">联系我们</span> 
			</div>
			<div class="dd4">
			<%@ include file="map.jsp"%>
			<p class="pss">公司地址：陕西省西安市碑林区南门-美莎酒店13层</p>
			<p class="pss">联系电话：029-62917910</p>
			</div>

      
       
		</div>


			


			</div>
			<div class="a1_d12">
				<img src="image/two.png" style="width:153px;margin-top: 25px;"></img>
				<p class="a1_p5">关注“道格”微信公众号,</p>
				<p class="a1_p5">实时信息一手掌握</p>
			</div>

		</div>
         </div>
	
	<%@ include file="foot.jsp"%>
</body>
</html>
