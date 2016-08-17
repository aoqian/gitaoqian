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

<title>道格征信-企业注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible"
	content="IE=5,IE=6,IE=7,IE=8,IE=9,IE=10,IE=11" />
<link rel="bookmark"  type="image/x-icon"  href="<%=basePath%>images/favicon.ico"/>
<link rel="shortcut icon" href="<%=basePath%>images/favicon.ico">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	text-align: center;
	background: #66B5ED;
	font-family: 方正兰亭黑体;
}

.e_div1 {
	width: 1200px;
	margin: auto;
	text-align: center;
	margin-top: 150px;
	margin-bottom: 70px;
}

.e_div2 {
	width: 1200px;
	margin: auto;
	color: white;
}

.e_box1 {
	width: 370px;
	float: left;
	border: 0px solid #ccc;
	height: 58px;
	line-height: 58px;
	text-align: right;
	font-weight: bold;
}

.e_box2 {
	width: 520px;
	float: left;
	border: 0px solid #ccc;
	height: 70px;
}

.e_box3 {
	width: 310px;
	float: left;
	border: 0px solid #ccc;
	height: 58px;
	line-height: 58px;
}

.e_box4 {
	width: 590px;
	height: 70px;
	margin: auto;
}

.e_p1 {
	width: 590px;
	margin: auto;
	font-weight: bold;
}

.e_box3 span {
	line-height: 58px;
	padding-left: 10px;
	color: red;
}

.e_i1 {
	width: 100%;
	border: 0px;
	color: #eaeaea;
	background: #76BDEF;
	height: 58px;
	padding: 12px 12px;;
	line-height: 58px;
	font-weight: bold;
	font-size: 16px;
	outline: none;
	border-radius: 6px;
}

.e_i3 {
	width: 65%;
	border: 0px;
	color: #eaeaea;
	background: #76BDEF;
	height: 58px;
	padding: 12px 12px;;
	line-height: 58px;
	font-weight: bold;
	font-size: 16px;
	outline: none;
	border-radius: 6px;
	float: left;
}

.e_i4 {
	width: 33%;
	border: 0px;
	color: #eaeaea;
	background: #3AB8F8;
	height: 58px;
	line-height: 58px;
	font-weight: bold;
	font-size: 16px;
	outline: none;
	border-radius: 6px;
	float: left;
	margin-left: 2%;
	font-family: 微软雅黑;
	cursor: pointer;
}

.e_i2 {
	width: 100%;
	border: 0px;
	background: #3AB8F8;
	height: 58px;
	border-radius: 6px;
	color: #eaeaea;
	font-size: 19px;
	font-weight: bold;
}

.e_i5 {
	width: 100%;
	height: 68px;
	border: 1px solid #23AEF4;
	background: #3AB8F8;
	border-radius: 6px;
	margin-top: 20px;
	margin-bottom: 10px;
	font-size: 34px;
	font-weight: bold;
	color: #eaeaea;
	font-family: 微软雅黑;
	cursor: pointer;
}

::-webkit-input-placeholder { /* WebKit browsers */
	color: #eaeaea;
}

:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
	color: #eaeaea;
}

::-moz-placeholder { /* Mozilla Firefox 19+ */
	color: #eaeaea;
}

:-ms-input-placeholder { /* Internet Explorer 10+ */
	color: #eaeaea;
}

.file {
	position: relative;
	display: inline-block;
	background: #3AB8F8;
	border-radius: 4px;
	overflow: hidden;
	color: white;
	text-decoration: none;
	text-indent: 0;
	line-height: 58px;
	width: 100%;
	height: 58px;
	text-align: center;
	font-size: 19px;
	font-weight: bold;
	border-radius: 6px;
}

.file input {
	position: absolute;
	font-size: 100px;
	right: 0;
	top: 0;
	opacity: 0;
}

.file:hover {
	background: #AADFFD;
	border-color: #78C3F3;
	color: #004974;
	text-decoration: none;
}

input:-webkit-autofill {
	background-color: #76BDEF;
}

.addw {
	background-image: url(..../../image/enter/√-2.png);
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
	//企业名
	function test1() {
		var ph = $("#name").val();
		var phm = /^[\u4E00-\u9FA5A-Za-z0-9]{5,40}$/;
		if (!phm.test(ph)) {
			$("#name").val("");
			$("#en1").removeClass("addw");
			$("#en1").addClass("addx");
			return false;
		} else {
			$("#en1").removeClass("addx");
			$("#en1").addClass("addw");
			return true;
		}
	}
	//手机号码
	function test2() {
		phnumber = $("#telphone").val();
		var phs = /^[1][3578][0-9]{9}$/;
		if (!phs.test(phnumber)) {

			$("#telphone").val("");
			$("#en2").removeClass("addw");
			$("#en2").addClass("addx");
			return false;
		} else {
			telone();
			return true;
		}

	}

	var InterValObj; //timer变量，控制时间
	var 
	curCount = 180;

	//验证码
	//发送验证码   
	function send2() {
		var phnumber = $("#telphone").val();
		var yanzs = $("#yanzs").val();
		if (yanzs = "获取验证码") {
			curCount = 180;
		}

		$.ajax({
			type : "POST",
			url : "sslc/Verphone.do", // 访问路径
			data : {
				"phones" : phnumber
			// 参数
			},
			success : function(msg) {
				SetRemainTime();

			}
		});

		InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次

	}

	function SetRemainTime() {

		if (curCount == 0) {
			window.clearInterval(InterValObj);//停止计时器
			$("#yanzs").removeAttr("disabled");//启用按钮
			$("#yanzs").val("获取验证码");
			code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效    
		} else {
			curCount--;
			$("#yanzs").attr("disabled", "disabled");
			$("#yanzs").val(curCount + "秒");
		}
	}

	//
	function setout2() {
		$(function() {
			var btn = $("#yanzs");
			var count = 180;
			var resend = setInterval(function() {
				count--;
				if (count > 0) {
					btn.attr("disabled", "disabled");
					btn.val(count + "秒");
					$.cookie("captcha", count, {
						path : '/',
						expires : (1 / 86400) * count
					});
				} else {
					clearInterval(resend);
					btn.val("获取验证码").attr('disabled style');
					btn.removeAttr("disabled");
				}
			}, 1000);
		});
	}
	// 验证码判断
	function test3() {

		var ssid = $("#verify").val();
		var reg = /^[0-9]{6}$/;

		if (!reg.test(ssid)) {
			$("#verify").val("");
			$("#en3").removeClass("addw");
			$("#en3").addClass("addx");
			return false;
		} else {
			$("#en3").removeClass("addx");
			$("#en3").addClass("addw");
			return true;
		}

	}
	//密码
	function test4() {

		var ssid = $("#code").val();
		var reg = /^[0-9A-Za-z]{6,16}$/;

		if (!reg.test(ssid)) {
			$("#code").val("");
			$("#en4").removeClass("addw");
			$("#en4").addClass("addx");
			return false;
		} else {
			$("#en4").removeClass("addx");
			$("#en4").addClass("addw");
			return true;
		}
	}

	//确认密码
	function test5() {
		var ssid = $("#code").val();
		var codes = $("#codes").val();
		var reg = /^[0-9A-Za-z]{6,16}$/;
		if (!reg.test(codes)) {
			$("#en5").removeClass("addw");
			$("#en5").addClass("addx");
			$("#codes").val("");
			return false;
		} else {
			if (ssid == codes) {
				$("#en5").removeClass("addx");
				$("#en5").addClass("addw");
				return true;
			} else {
				$("#en5").removeClass("addw");
				$("#en5").addClass("addx");
				$("#codes").val("");
				$("#codes").attr('placeholder', '此密码与原密码不匹配');
				return false;
			}

		}

	}

	function telone() {
		//alert("-----------进入");
		var phnumber = $("#telphone").val();
		$.ajax({
			type : "POST",
			url : "New/tel.do", // 访问路径
			data : {
				"telphone" : phnumber
			// 参数
			},
			success : function(msg) {
				//alert(msg);
				if (msg != 0) {
					$("#telphone").val("此号码已被注册");
					$("#en2").removeClass("addw");
					$("#en2").addClass("addx");
				} else {
					$("#en2").removeClass("addx");
					$("#en2").addClass("addw");
				}
			}
		});
	}
	//营业执照编号
	/* function test5(){
	  
		var ssid = $("#license").val();
		var reg = /^[0-9]{15}$/;
		
	 if(!reg.test(ssid)){
	
		 return false;
		}else {
	 
			return true;
		}
	}
	 */
	//协议
	function test6() {

		if ($('#agree').is(':checked')) {
			//alert("++++++");

			return true;

		} else {

			return false;
		}
	}
	//下一步
	function onenext() {
		var phnumber = $("#telphone").val();
		var ssid = $("#verify").val();
		var name = $("#name").val();
		var codes = $("#codes").val();

		if (test1() && test2() && test3() && test4() && test6()) {

			$.ajax({
				type : "POST",
				url : "sslc/smscode.do", // 访问路径
				data : {
					"phones" : phnumber,
					"ssid" : ssid,
					//企业名称
					"name" : name,
					//密码
					"codes" : codes
				},
				success : function(result) {
					//alert(result);
					if (result == 0) {

						//  alert("--------------");
						$("#form2").submit();

					} else {
						$("#verify").val("验证码不正确");
						$("#en3").removeClass("addw");
						$("#en3").addClass("addx");

					}

				}

			});

		}

	}
</script>
</head>

<body>
	<div class="e_div1">
		<img src="image/e_register/dog.png"></img>
	</div>
	<div class="e_div2">
		<form action="New/register_e.do" autocomplete="off" id="form2"
			method="post">
			<div>
				<div class="e_box1">企业名称：</div>
				<div class="e_box2">
					<input id="name" name="name" class="e_i1" type="text"
						placeholder="（由5~40位字符组成）" onblur="test1()" maxlength="40">
				</div>
				<div class="e_box3" id="en1"></div>
			</div>
			<div>
				<div class="e_box1">手机号：</div>
				<div class="e_box2">
					<input id="telphone" name="telphone" class="e_i1" type="text"
						placeholder="（由11位数字组成）" onblur="test2()"
						onkeyup="this.value=this.value.replace(/[^0-9\.]/,'')"
						maxlength="11">
				</div>
				<div class="e_box3" id="en2"></div>
			</div>
			<div>
				<div class="e_box1">验证码：</div>
				<div class="e_box2">
					<input class="e_i3" id="verify" type="text" placeholder="（由6位数字组成）"
						onblur="test3()"
						onkeyup="this.value=this.value.replace(/[^0-9\.]/,'')"
						maxlength="6"> <input class="e_i4" type="button"
						value="获取验证码" onClick="send2()" id="yanzs">
				</div>
				<div class="e_box3" id="en3"></div>
			</div>
			<div>
				<div class="e_box1">密码：</div>
				<div class="e_box2">
					<input id="code" name="code" class="e_i1" type="password"
						placeholder="（由6~16个字母或数字组成）" onblur="test4()"
						onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" maxlength="16">
				</div>
				<div class="e_box3" id="en4"></div>
			</div>
			<div>
				<div class="e_box1">确认密码：</div>
				<div class="e_box2">
					<input id="codes" class="e_i1" type="password"
						placeholder="（由6~16个字母或数字组成）" onblur="test5()"
						onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" maxlength="16">
				</div>
				<div class="e_box3" id="en5"></div>
			</div>
			<!-- <div>
 <div class="e_box1">营业执照编号：</div>
 <div class="e_box2"><input id="license" class="e_i1" type="text" placeholder="（营业执照编号）" onblur="test5()"></div>
 <div class="e_box3"><span style="display:none;" id="s_license">营业执照编号有误，请重新输入</span></div>
</div>
<div>
 <div class="e_box1">上传营业执照：</div>
 <div class="e_box2">
 <a href="javascript:;" class="file">
    <input type="file" name="" id="">点击这里上传图片
</a>
 
 </div>
 <div class="e_box3"></div>
</div> -->

			<div>
				<div class="e_box1"></div>
				<div class="e_box2" style="margin-top: 21px;">

					<input type="checkbox" name="agree" id="agree" /> <label
						for="agreement" style="font-weight:bold;">您已阅读并接受《道格-企业版用户服协议》</label>
				</div>
				<div class="e_box3"></div>
			</div>
			<div>

				<div class="e_box4">
					<input class="e_i5" type="button" value="注册" onclick="onenext()">
					<p class="e_p1">
						<a>&lt; 已有账号，返回登录</a>
					</p>
				</div>

			</div>
		</form>

	</div>

</body>
</html>
