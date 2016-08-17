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

<title>道格征信-个人中心</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />  
<!-- <meta http-equiv="X-UA-Compatible"
	content="IE=5,IE=6,IE=7,IE=8,IE=9,IE=10,IE=11" /> -->
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
	border-top: 2px solid #4BA6E7;
	text-align: center;
}

.a1_d1 {
	width: 1200px;
	margin: auto;
	padding-top: 45px;
	padding-bottom: 106px;
	height: 300px;
	text-align: left;
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
	height: 400px;
	display: none;
	margin-bottom: 80px;
	border: 1px solid #ccc;
	padding-left: 1px;
}

.sea2_dd3 {
	width: 100%;
	margin: auto;
	background: white;
	height: 400px;
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
	padding-left: 1px;
}

.sea2_d {
	width: 780px;
	height: 60px;
	padding: 0px 30px 0px 0px;
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
	color: #FF5B59;
	background: url(...../../image/individual/h_95.png) no-repeat -8px -4px !important;
	background-repeat: no-repeat;
	
}

#ul li {
	list-style-type: none;
	font-size: 16px;
	height: 30px;
	line-height: 30px;
	padding-left: 35px;
	background: url(...../../image/individual/s2.png);
	background-repeat: no-repeat;
	background-position-y: 11px;
	background-position-x: 18px;
	cursor: pointer;
}

#ul li:hover {
	color: #FF5B59;
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
	text-align: center;
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
</style>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#serch").click(function() {
			$("#ul li").removeClass("add_color");
			$(this).addClass("add_color");
			$(".sea2_dd1").show();
			$(".sea2_dd2").hide();
			$(".sea2_dd3").hide();

		});
		$("#basic_information").click(function() {
			$("#ul li").removeClass("add_color");
			$(this).addClass("add_color");
			$(".sea2_dd1").hide();
			$(".sea2_dd3").hide();
			$(".sea2_dd2").show();

		});
		$("#authentication").click(function() {
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

/* #Searchresult {
	width: 300px;
	height: 100px;
	padding: 20px;
	background: #f0f3f9;
} */
.result {
	width: 100%;
}
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
			var num_entries = "${totalPage}";
			// 创建分页
			$("#Pagination").pagination(num_entries, {
				num_edge_entries : 1, //边缘页数
				num_display_entries : 4, //主体页数
				callback : pageselectCallback,
				items_per_page : 1
			//每页显示1项
			});
		}();

		function pageselectCallback(page_index, jq) {

			var personList = "${personList}";
			console.log(page_index);

			var new_content = $(
					"#hiddenresult div.result:eq(" + page_index + ")").clone();
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
				<p class="in_p1">个人中心</p>
				<ul id="ul">
					<li id="serch" class="add_color">查询记录</li>
					<li id="basic_information">基本信息</li>

				</ul>
			</div>
			<div class="a1_d11">
				<!--查询记录  -->
				<div class="sea2_dd1">
					<div
						style="height:40px;width:100%;background:#FDFDFE;border-bottom:1px solid #ccc;color:#FF8707;font-size: 20px;">
						<span class="sea2_s1">查询记录</span>
					</div>
					<div
						style="height:40px;width:810px;background:#FDFDFE;border-bottom:1px solid #ccc;padding-left: 30px;color:#919191;font-size: 14px;">
						<span class="sea2_s21">关键字</span> <span class="sea2_s22">个人/企业</span>
						<span class="sea2_s23">查询时间</span><span class="sea2_s24">级别</span>
						<span class="sea2_s24">查看详情</span>
					</div>
					<div id="Searchresult"
						style="height:473px;width:810px;padding-left: 30px;color:#919191;font-size: 14px;">
					</div>

					<div id="Pagination" class="pagination"
						style="text-align: center;margin-top: 26px;"></div>
				</div>

				<div id="hiddenresult" style="display:none;">
					<c:forEach items="${records}" var="list" varStatus="abc">
						<div class="result">
							<c:forEach items="${records}" var="list" begin="${abc.index*8}"
								end="${(abc.index+1)*8-1}">
								<div class="sea2_d">
									<div
										style="width:100%;height:50px;border-bottom:1px dashed #E9EEEF;">

										<div class="sea2_d2">

											<ul class="s_u2">
												<li class="l1">${list.keyword}</li>
												<li class="l2"><c:if test="${list.type=='1' }">个人</c:if>
													<c:if test="${list.type=='0' }">企业</c:if></li>
												<li class="l3">${list.time}</li>
											    <c:choose>
											    <c:when test="${list.rank eq '0'}">
											    <li class="l4"><span>初级</span></li>
												<li class="l5"><a href="New/more.do?keyword=${list.keyword}"><span>更多</span>
												</a></li>
											    </c:when>
											    <c:when test="${list.rank eq '1'}">
											    <li class="l4"><span>中级</span></li>
												<li class="l5"><a href="New/more.do?keyword=${list.keyword}"><span>更多</span>
												</a></li>
											    </c:when>
											    </c:choose>
												
											</ul>

										</div>
									</div>
								</div>
							</c:forEach>

						</div>
					</c:forEach>
				</div>

				<!--基本信息  -->
				<div class="sea2_dd2">
					<div
						style="height:40px;width:100%;background:#FDFDFE;border-bottom:1px solid #ccc;color:#FF8707;font-size: 20px;">
						<span class="sea2_s1">基本信息</span>
					</div>


					<div class="sea2_d">
						<div style="width:100%;height:50px;padding-left: 20px;">

							<div class="sea2_d2">

								<ul class="s_u2">
									<li class="l21">姓名：${u1.name }</li>
									<li class="l22">类别： <c:if test="${u1.usertype=='1' }">个人</c:if>
										<c:if test="${u1.usertype=='0' }">企业</c:if></li>
									<li class="l23">账号：${u1.telphone }</li>

								</ul>

							</div>
						</div>
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
