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

<title>道格征信-登录</title>

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
body {
    text-align:center;
	background: #66B5ED;
	font-family: 微软雅黑;
}
.e_div1{    width: 1200px;
    margin: auto;
    text-align: center;
    margin-top: 150px;margin-bottom:70px;}
.e_div2{width:1200px;margin:auto;color:white;}
.e_box1{width:370px;float:left;border:0px solid #ccc;height:58px;line-height:58px;text-align: right;font-weight: bold;}
.e_box2{width:520px;float:left;border:0px solid #ccc;height:70px;}
.e_box3{width:310px;float:left;border:0px solid #ccc;height:58px;line-height:58px;}
.e_box4{width:590px;height:70px;margin:auto;text-align:left;}
.e_p1{width:590px;margin:auto;font-weight: bold;}
.e_i1{    width: 100%;
    border: 0px;
    color: white;
    background: #76BDEF;
    height: 58px;
    padding: 12px 12px;;
   
    font-weight: bold;
    font-size: 16px;
    outline: none;
    border-radius: 6px;
    font-family: 微软雅黑;}
.e_i3{    width: 65%;
    border: 0px;
    color: white;
    background: #76BDEF;
    height: 58px;
    padding: 12px 12px;;
    line-height: 58px;
    font-weight: bold;
    font-size: 16px;
    outline: none;
    border-radius: 6px;
    float: left;
    font-family: 微软雅黑;}
    
.e_i4{
    width: 33%;
    border: 0px;
    color: white;
    background: #3AB8F8;
    height: 58px;
    
    line-height: 58px;
    font-weight: bold;
    font-size: 16px;
    outline: none;
    border-radius: 6px;
    float: left;
    margin-left:2%;
    font-family: 微软雅黑;}
.e_i2{    width: 100%;
    border: 0px;
    
    background:#3AB8F8 ;
    height: 58px;
    border-radius: 6px;
    color: white;
    font-size: 19px;
    font-weight: bold;
    font-family: 微软雅黑;}
.e_i5{    width: 100%;
    height: 68px;
    border: 1px solid #23AEF4;
    background:#3AB8F8;
    border-radius: 6px;
    margin-top: 20px;
    margin-bottom: 10px;
    font-size: 34px;
    font-weight: bold;
    color:white;
    font-family: 微软雅黑;
    cursor: pointer;
    }

::-webkit-input-placeholder { /* WebKit browsers */ 
color: white; 
} 
:-moz-placeholder { /* Mozilla Firefox 4 to 18 */ 
color: white; 
} 
::-moz-placeholder { /* Mozilla Firefox 19+ */ 
color: white;
} 
:-ms-input-placeholder { /* Internet Explorer 10+ */ 
color: white; 
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
.e_box3 span{ 
    line-height: 58px;
    padding-left: 10px;
    color: red;}
.addw{background-image:url(..../../image/enter/√-2.png);    background-repeat: no-repeat;
    background-position-y: 50%;
    background-position-x: 10px;}
.addx{background-image:url(..../../image/individual/×_80.png);    background-repeat: no-repeat;
    background-position-y: 50%;
    background-position-x: 10px;}

</style>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">

   //手机号码
   function test2() {
		 phnumber = $("#telphone").val();
		var phs =  /^[1][3578][0-9]{9}$/;
		if (!phs.test(phnumber)) {
			
			$("#en1").removeClass("addw");
		    $("#en1").addClass("addx");
			return false;
		} else {
			$("#en1").removeClass("addx");
		    $("#en1").addClass("addw");
			
			return true;
		}

	}
   //验证码
   
	
   //密码
   function test4(){
     
		var ssid = $("#code").val();
		var reg = /^[0-9A-Za-z]{6,16}$/;
		
	 if(!reg.test(ssid)){
	 $("#en2").removeClass("addw");
     $("#en2").addClass("addx");
		
		 return false;
		}else {
		 $("#en2").removeClass("addx");
		 $("#en2").addClass("addw");
			return true;
		}
   }
   
  
  
  
   //下一步
   function onenext(){
      
       
     if(test2() && test4()){
        // alert("------2--------");
		    
		 $("#form2").submit();
					   }
						
    }
</script>
</head>

<body>
<div class="e_div1">
<img src="image/e_register/dog.png"></img>
</div>
<div class="e_div2">
<form action="New/enter.do" autocomplete="off" id="form2" method="post">

 <div>
 <div class="e_box1">账&nbsp;&nbsp;&nbsp;号：</div>
 <div class="e_box2"><input id="telphone" name="telphone" class="e_i1" type="text" placeholder="（请用手机号登录）" onblur="test2()"
 onkeyup="this.value=this.value.replace(/[^0-9\.]/,'')"  maxlength="11"></div>
 <div class="e_box3" id="en1"></div>
</div>

 <div>
 <div class="e_box1">密&nbsp;&nbsp;&nbsp;码：</div>
 <div class="e_box2">
 <input id="code" class="e_i1" type="password" name="code" placeholder="（请输入密码）" onblur="test4()"
  onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" maxlength="16"></div>
 <div class="e_box3" id="en2"></div>
</div>



<div>
  <div style="text-align:center;">
  <div class="e_box4">
 <input class="e_i5" type="button" value="登录" onclick="onenext()">
 <p class="e_p1"><a style="float: left">忘记密码吗？</a><a href="New/register.do" style="float: right;color: white;text-decoration: none;">注册帐号</a></p>
 </div>
  </div>
 
 
</div>
</form>

</div>

</body>
</html>
