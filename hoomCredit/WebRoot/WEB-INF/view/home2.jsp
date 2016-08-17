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

<title>道格征信-中高级查询</title>

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
	height: 340px;
	text-align: left;
}

.a1_d11 {
	padding-left: 45px;
	width: 875px;
	float: left;
	height: 100%;
	border: 0px solid #ccc;
}

.a1_d12 {
	width: 262px;
	float: left;
	height: 100%;
	border-left: 0px solid #ccc;
	color: #808080;
	text-align: center;
}

.a1_d13 {
	width: 1200px;
	margin: auto;
	text-align: left;
}

.a1_p1 {
	font-size: 38px;
	margin-top: 0px;
	color: #646363;
	font-weight: 600;
	letter-spacing: 8px;
}

.a1_s1 {
	color: #4AA6E6;
}

.a1_img1 {
	margin-top: 56px;
	margin-left: 70px;
}

.a1_img2 {
	display: inline_block;
	margin: 73px;
	margin-top: 10px;
	margin-left: 85px;
}

.h2_d1 {
	width: 680px;
	height: 100%;
	border: 0px solid #ccc;
	margin-left: 194px;
}

.h2_d11 {
	width: 600px;
	height: 60px;
	margin-bottom: 40px;
	border-radius: 5px;
	border: 1px solid #ccc;
	float: left;
}

.h2_d11 input {
	height: 60%;
	width: 94%;
	border: 0px solid #ccc;
	margin: 12px 20px;
	font-size: 21px;
	font-weight: bold;
	font-family: 微软雅黑;
	color: #D2D1D1;
	background: white;
}

.h2_d12 {
	width: 600px;
	height: 60px;
	margin-bottom: 10px;
}

.h2_d12 input {
	height: 100%;
	width: 100%;
	border: 1px solid #ccc;
	border-radius: 5px;
	color: white;
	font-size: 23px;
	font-family: 微软雅黑;
	cursor: pointer;
}

.wai {
	width: 100%;
	margin-bottom: 40px;
	height: 62px;
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


<style type="text/css">
/* html,body {
	height: 100%;
	margin: 0px;
	font-size: 12px;
} */
.mydiv1 {
	background-color: #FFFFFF;
	border: ;
	text-align: center;
	line-height: 40px;
	font-size: 12px;
	font-weight: bold;
	z-index: 999;
	width: 0px;
	height: 54px;
	left: 46.5%;
	top: 38%;
	margin-left: -150px !important; /*FF IE7 该值为本身宽的一半 */
	margin-top: -60px !important; /*FF IE7 该值为本身高的一半*/
	margin-top: 0px;
	position: fixed !important; /* FF IE7*/
	position: absolute; /*IE6*/
	_top: expression(eval(document.compatMode &&     
		                                  
		                                  
                                                     
		                                 document.compatMode ==          
		                          
		
		  
		     
		           
                       
                                                            
		    'CSS1Compat')?      
		
		 
		   
		       
		               
		                              
      
            documentElement.scrollTop+      
		                                  
		                                  (document.documentElement.clientHeight-this.offsetHeight
		)/2:                                     
		                                                                  
		                                            /*IE6*/            
		                                
		 
		      
		                    
            document.body.scrollTop+  
		                                    
		                                    (document.body.clientHeight-
		this.clientHeight )/2 ); /*IE5 IE5.5*/
}

.mydiv2 {
	background-color: #FFFFFF;
	border: ;
	text-align: center;
	line-height: 40px;
	font-size: 12px;
	font-weight: bold;
	z-index: 999;
	width: 470px;
	height: 450px;
	left: 45%;
	top: 30%;
	-webkit-border-radius: 11px;
	border-radius: 11px;
	margin-left: -150px !important; /*FF IE7 该值为本身宽的一半 */
	margin-top: -60px !important; /*FF IE7 该值为本身高的一半*/
	margin-top: 0px;
	position: fixed !important; /* FF IE7*/
	position: absolute; /*IE6*/
	_top: expression(eval(document.compatMode &&     
		                                  
		                                  
                                                     
		                                 document.compatMode ==          
		                          
		
		  
		     
		           
                       
                                                            
		    'CSS1Compat')?      
		
		 
		   
		       
		               
		                              
      
            documentElement.scrollTop+      
		                                  
		                                  (document.documentElement.clientHeight-this.offsetHeight
		)/2:                                     
		                                                                  
		                                            /*IE6*/            
		                                
		 
		      
		                    
            document.body.scrollTop+  
		                                    
		                                    (document.body.clientHeight-
		this.clientHeight )/2 ); /*IE5 IE5.5*/
}

.mydiv3 {
	background-color: #FFFFFF;
	border: ;
	text-align: center;
	line-height: 40px;
	font-size: 12px;
	font-weight: bold;
	z-index: 999;
	width: 460px;
	height: 200px;
	left: 45%;
	top: 35%;
	-webkit-border-radius: 11px;
	border-radius: 11px;
	margin-left: -150px !important; /*FF IE7 该值为本身宽的一半 */
	margin-top: -60px !important; /*FF IE7 该值为本身高的一半*/
	margin-top: 0px;
	position: fixed !important; /* FF IE7*/
	position: absolute; /*IE6*/
	_top: expression(eval(document.compatMode &&     
		                                  
		                                  
                                                     
		                                 document.compatMode ==          
		                          
		
		  
		     
		           
                       
                                                            
		    'CSS1Compat')?      
		
		 
		   
		       
		               
		                              
      
            documentElement.scrollTop+      
		                                  
		                                  (document.documentElement.clientHeight-this.offsetHeight
		)/2:                                     
		                                                                  
		                                            /*IE6*/            
		                                
		 
		      
		                    
            document.body.scrollTop+  
		                                    
		                                    (document.body.clientHeight-
		this.clientHeight )/2 ); /*IE5 IE5.5*/
}

.bg1,.popIframe1 {
	background-color: #666;
	display: none;
	width: 100%;
	height: 100%;
	left: 0;
	top: 0; /*FF IE7*/
	filter: alpha(opacity =                                            
		                                                         
		                                              50);
	/*IE*/
	opacity: 0.5; /*FF*/
	z-index: 1;
	position: fixed !important; /*FF IE7*/
	position: absolute; /*IE6*/
	_top: expression(eval(document.compatMode &&     
		                                  
		                                  
                                                     
		                                 document.compatMode ==          
		                          
		
		  
		     
		           
                       
                                                            
		    'CSS1Compat')?      
		
		 
		   
		       
		               
		                              
      
            documentElement.scrollTop+      
		                                  
		                                  (document.documentElement.clientHeight-this.offsetHeight
		)/2:                                     
		                                                                  
		                                            /*IE6*/            
		                                
		 
		      
		                    
            document.body.scrollTop+  
		                                    
		                                    (document.body.clientHeight-
		this.clientHeight )/2 );
}

.bg2,.popIframe2 {
	background-color: #666;
	display: none;
	width: 100%;
	height: 100%;
	left: 0;
	top: 0; /*FF IE7*/
	filter: alpha(opacity =                                            
		                                                         
		                                              50);
	/*IE*/
	opacity: 0.5; /*FF*/
	z-index: 1;
	position: fixed !important; /*FF IE7*/
	position: absolute; /*IE6*/
	_top: expression(eval(document.compatMode &&     
		                                  
		                                  
                                                     
		                                 document.compatMode ==          
		                          
		
		  
		     
		           
                       
                                                            
		    'CSS1Compat')?      
		
		 
		   
		       
		               
		                              
      
            documentElement.scrollTop+      
		                                  
		                                  (document.documentElement.clientHeight-this.offsetHeight
		)/2:                                     
		                                                                  
		                                            /*IE6*/            
		                                
		 
		      
		                    
            document.body.scrollTop+  
		                                    
		                                    (document.body.clientHeight-
		this.clientHeight )/2 );
}

.bg3,.popIframe3 {
	background-color: #666;
	display: none;
	width: 100%;
	height: 100%;
	left: 0;
	top: 0; /*FF IE7*/
	filter: alpha(opacity =                                            
		                                                         
		                                              50);
	/*IE*/
	opacity: 0.5; /*FF*/
	z-index: 1;
	position: fixed !important; /*FF IE7*/
	position: absolute; /*IE6*/
	_top: expression(eval(document.compatMode &&     
		                                  
		                                  
                                                     
		                                 document.compatMode ==          
		                          
		
		  
		     
		           
                       
                                                            
		    'CSS1Compat')?      
		
		 
		   
		       
		               
		                              
      
            documentElement.scrollTop+      
		                                  
		                                  (document.documentElement.clientHeight-this.offsetHeight
		)/2:                                     
		                                                                  
		                                            /*IE6*/            
		                                
		 
		      
		                    
            document.body.scrollTop+  
		                                    
		                                    (document.body.clientHeight-
		this.clientHeight )/2 );
}

.popIframe1 {
	filter: alpha(opacity =                                            
		                                                         
		                                              0);
	/*IE*/
	opacity: 0; /*FF*/
}
</style>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#cancel").click(function() {
			$("#name").val("");
			$("#iden").val("");
			$("#phonenum").val("");
			$("#nameverify").removeClass("addx");
			$("#nameverify").removeClass("addw");
			$("#idenverify").removeClass("addx");
			$("#idenverify").removeClass("addw");
			$("#phonenumverify").removeClass("addx");
			$("#phonenumverify").removeClass("addw");
		});
	});
</script>
<script type="text/javascript">
	//参数校验
	// 验证中文名称
	function isChinaName() {
		var name = $("#name").val();
		var pattern = /^[\u4E00-\u9FA5]{1,6}$/;
		var par = pattern.test(name);

		if (par == true) {
			$("#nameverify").removeClass("addx");
			$("#nameverify").addClass("addw");
		} else {
			$("#nameverify").removeClass("addw");
			$("#nameverify").addClass("addx");
		}
		return par;
	}

	// 验证身份证 
	function isCardNo() {

		var card = $("#iden").val();
		var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
		var par = pattern.test(card);

		if (par == true) {
			$("#idenverify").removeClass("addx");
			$("#idenverify").addClass("addw");
		} else {
			$("#idenverify").removeClass("addw");
			$("#idenverify").addClass("addx");
		}
		return par;
	}

	// 验证手机号
	function isPhoneNo() {
		var phone = $("#phonenum").val();
		var pattern = /^1[34578]\d{9}$/;
		var par = pattern.test(phone);

		if (par == true) {
			$("#phonenumverify").removeClass("addx");
			$("#phonenumverify").addClass("addw");
		} else {
			$("#phonenumverify").removeClass("addw");
			$("#phonenumverify").addClass("addx");
		}
		return par;
	}

	function sbm() {
		/* var name = isChinaName();
		console.log(name);
		isPhoneNo();
		isCardNo(); */

		if (isChinaName() && isCardNo() && isPhoneNo()) {
			
			$("#moreSearch").submit();
			//showDiv1();
		}
		showDiv1();

	}

	function showDiv1() {

		document.getElementById('popDiv1').style.display = 'block';
		document.getElementById('bg1').style.display = 'block';
		document.getElementById('popIframe1').style.display = 'block';

	}
	function closeDiv1() {
		document.getElementById('popDiv1').style.display = 'none';
		document.getElementById('bg1').style.display = 'none';
		document.getElementById('popIframe1').style.display = 'none';
	}
</script>
</head>

<body>
	<div id="popDiv1" class="mydiv1"
		style="display:none;box-shadow: 0px 1px 15px 0px;">
		<img src="images/04loading.gif" style="width: 300px;"></img>
	</div>
	<div id="bg1" class="bg1" style="display:none;z-index: 99;"></div>
	<%@ include file="head.jsp"%>
	<div class="a1">
		<div class="a1_d1">
			<div class="a1_d11">
				<form action="first/moreSearch.do" id="moreSearch">
					<div class="h2_d1">
						<div class="wai">
							<div class="h2_d11">
								<input type="text" name="name" id="name" required
									value="请输入被查人姓名" onblur="isChinaName()" placeholder="请输入被查人姓名">
								<!-- <img src="image/individual/√_13.png"></img> -->
							</div>
							<div id="nameverify"
								style="width: 45px;float: left; border: 0px solid #ccc; height: 58px;line-height: 58px;"></div>
						</div>
						<div class="wai">
							<div class="h2_d11">
								<input type="text" name="iden" id="iden" required
									placeholder="请输入被查人身份证号码" onblur="isCardNo()">
							</div>
							<div id="idenverify"
								style="width: 45px;float: left; border: 0px solid #ccc; height: 58px;line-height: 58px;"></div>
						</div>
						<div class="wai">
							<div class="h2_d11">
								<input type="text" name="phonenum" id="phonenum" required
									placeholder="请输入被查人手机号" onblur="isPhoneNo()">
							</div>
							<div id="phonenumverify"
								style="width: 45px;float: left; border: 0px solid #ccc; height: 58px;line-height: 58px;"></div>
						</div>
						<div class="h2_d12">
							<input style="background:#69B8F6;" type="button" value="查询"
								onclick="sbm()">
						</div>
						<div class="h2_d12">
							<input style="background:#BFBBBB;" type="button" id="cancel"
								value="取消">
						</div>
					</div>
				</form>
			</div>
			<div class="a1_d12">
				<img src="image/two.png" style="width:250px;"></img>
				<p class="a1_p5">关注“道格”微信公众号,</p>
				<p class="a1_p5">实时信息一手掌握</p>
			</div>

		</div>
		<div class="a1_d13">
			<img src="image/1.png" class="a1_img2"></img> <img src="image/2.png"
				class="a1_img2"></img> <img src="image/3.png" class="a1_img2"></img>
		</div>
	</div>


	<%@ include file="foot.jsp"%>
</body>
</html>
