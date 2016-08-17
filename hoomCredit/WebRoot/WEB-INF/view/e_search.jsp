<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<title>道格征信-初级企业查询</title>

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
   
	background: #F2F2F2;
}
form{padding-top: 40px;}

.home3 {
	width: 100%;
	height: 96px;
	
	    margin-top: 20px;
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
	border: 2px solid #DDDDDD;
	background-repeat: no-repeat;
	background-size: 85% 80%;
	background-position-x: 42%;
	background-position-y: 75%;
	cursor: pointer;
}

.sch_inbox {
	display: block;
	width: 530px;
	height: 44px;
	border: 2px solid #DDDDDD;
    background: white;
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
	background: white;
	
	outline: none;
}

.sea2 {
	width: 100%;
}

.sea2_dd {
	width: 1200px;
	margin: auto;
	background: white;
	height: 800px;
	margin-top: 80px;
	margin-bottom: 80px;
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
	width: 510px;
	text-align: left;
	border-right: 0px solid #ccc;
	line-height: 40px;
}

.sea2_s22 {
	display: inline-block;
	width: 320px;
	text-align: center;
	border-right: 0px solid #ccc;
	line-height: 40px;
}

.sea2_s23 {
	display: inline-block;
	width: 330px;
	text-align: center;
	border-right: 0px solid #ccc;
	line-height: 40px;
}

.sea2_s24 {
	display: inline-block;
	width: 180px;
	text-align: center;
	border-right: 0px solid #ccc;
	line-height: 40px;
}

.s_u2 {
	width: 100%;
	margin-bottom: 4px;
}

.s_u2 li {
	list-style: none;
	display: inline-block;
}

.s_u2 .l1 {
	width: 380px;
	text-align: left;
	border-right: 0px solid #ccc;
}

.s_u2 .l2 {
	width: 320px;
	text-align: center;
	border-right: 0px solid #ccc;
}

.s_u2 .l3 {
	width: 330px;
	text-align: center;
	border-right: 0px solid #ccc;
}

.s_u2 .l4 {
	width: 180px;
	text-align: center;
	border-right: 0px solid #ccc;
}

.s_u2 .l4 span {
	color: #2CA8FF;
	width: 90px;
	height: 22px;
	border: 1px solid #2CA8FF;
	display: inline-block;
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

.sea2_u1 a {
	color: #2CA8FF;
	text-decoration: none;
}

.sea2_u1 a:hover {
	color: blue;
}
.result{width:100%;}
</style>




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

.cate {
    display:block;
    padding: 7px 16px 5px;
    float: left;
    border-right: 1px solid #eaeaea;
    border-bottom: 2px solid #fafafa;
    color: #666;
    font-size: 14px;}
.active {
    font-weight: bold;
    background-color: #fff;
    border-bottom: 2px solid #177bbb;
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
	<%@ include file="head.jsp"%>
	<div class="home3">
		<div style="width:1200px;margin:auto;height:100%;background: white;">
			<div style="width:610px;    margin-left: 30px;border:0px solid #ccc;height:100%;">
				
			
				<div style="height:50px;">
					<!-- form -->
					<div class="sch_form">
						<form id="bdfm" action="New/primarys.do">
							<span class="sch_inbox" id="J_schInbox"> <input
								type="text" name="word" id="" value="${keyword }" /> </span> <input
								class="sch_btn" type="submit" value=" " id="j_search_sbm">
						</form>
					</div>
				</div>
			</div>

		</div>
				<div style="width:1200px;margin:auto;height:40px;text-align:left;background: #F2F5FE;">
		<a href="New/primary.do" class="cate " id="pp">个人</a >
		<a href="New/primarys.do" class="cate active" id="cc">企业</a>
		<!-- <a class="cate">专利</a>
		<a class="cate">商标</a>
		<a class="cate">产品品牌</a>
		<a class="cate">联系方式</a>
		<a class="cate">高管</a> -->
		</div>
	</div>
	<div class="sea2">

		<div class="sea2_dd">
			<div
				style="height:40px;width:1200px;background:#FDFDFE;border-bottom:1px solid #ccc;color:#2CA8FF;font-size: 20px;">
				<span class="sea2_s1">企业</span>
			</div>
			<div
				style="height:40px;width:1180px;background:#FDFDFE;border-bottom:1px solid #ccc;padding-left: 20px;color:#919191;font-size: 14px;">
				<span class="sea2_s21">企业全称</span> <span class="sea2_s22">法人姓名</span> <span
					class="sea2_s23">成立日期</span> 
			</div>

			<div id="Searchresult"  style="margin-left:30px;"></div>

			<div id="hiddenresult" style="display:none;">
				<c:forEach items="${companyList}" var="list" varStatus="abc">


					<div class="result">
						<c:forEach items="${companyList}" var="list" begin="${abc.index*5}"
							end="${(abc.index+1)*5-1}">


							<%-- <c:set var="jishu" value="0" /> --%>
							<div
								style="width:100%;height:130px;border-bottom:1px dashed #E9EEEF;">
								<div class="sea2_d1">
									<img src="image/tu.png" class="sea2_img1"></img>
								</div>
								<div class="sea2_d2">
									<ul class="sea2_u1">
										${list.name}
									</ul>
									<ul class="s_u2">
										<li class="l1">注册号：${list.no}</li>
										<li class="l2">${list.operName}</li>
										<li class="l3">${fn:substring(list.startDate,0,10)}</li>
										
										</li>
									</ul>
									<ul class="sea2_u3">状态：${list.status }
									</ul>
								</div>
							</div>

						</c:forEach>

					</div>
				</c:forEach>
			</div>
			<div id="Pagination" class="pagination"
				style="text-align: center;margin-top: 26px;"></div>
		</div>
	</div>

	<%@ include file="foot.jsp"%>
</body>
</html>
