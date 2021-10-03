<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8" import="java.util.*" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录 - 当当网</title>
<link href="${path}/back/css/login.css" rel="stylesheet" type="text/css" />
<link href="${path}/back/css/pop_cheat.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.msg{ font-size: 13px; }
    .onError{ color: red; }
    .onSuccess{ color: green; }
</style>
<script type="text/javascript" src="${path}/back/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
//验证用户名
function validUsername(){
	// 获取用户输入内容
	var val = document.getElementById('username').value;
	// 开始判断
	if(val.length<3){//如果输入长度小于3位则视为不正确
		// 提示错误
		var p=$('#tishi'); //获取到p标签
		p.text('用户名输入错误，不能小于3位字符'); //赋值p文字
		return false;
	}else{
		// 输入正确
		var p=$('#tishi');
		p.empty();//正确的话清除上一次提示内容
		return true;
	}
}
// 验证密码
function validPwd(){
	// 获取用户输入内容
	var val = document.getElementById('password').value;
	// 获取提示图片标签对象
	if(val.length>=6){
		// 输入正确
		var p=$('#tishi2');
		p.empty();//正确的话清除上一次提示内容
		return true;
	}else{
		// 提示错误
		var p=$('#tishi2'); //获取到p标签
		p.text('密码输入错误，不能小于6位字符'); //赋值p文字
		return false;
	}
} 

/* // 验证验证码
function validCode(){
	// 获取用户输入内容
	var val = document.getElementById('imgcode').value;
	// 获取提示图片标签对象
	if(val!=null){
		// 输入正确
		var p=$('#tishi3');
		p.empty();//正确的话清除上一次提示内容
		return true;
	}else{
		// 提示错误
		var p=$('#tishi3'); //获取到p标签
		p.text('验证码输入错误，不能为空'); //赋值p文字
		return false;
	}
}  */
//提交表单验证
function submits(){
	var b1 = validUsername();
	var b2 = validPwd();
//	var b3 = validCode();
	var str=[b1,b2];
	var flag=true;
	for(idx in str){
		if(!str[idx]){
			flag=false;
		}
	}
	return flag;
}
//验证码图片更新
function changeImage(){
	//获取图片对象
	var img=$('#imgVcode');
	console.log(img);
	
	//更换图片路径
	img.prop('src','${path}/admin/YanZhengMa?d='+Math.random());
} 

</script>
</head>
<body>
	<div class="head">
		<a href="http://www.dangdang.com"> <img src="${path}/back/images/signin_logo.png" /></a>
		<div class="improve">
			<img src="${path}/back/images/bz.jpg" width="178" height="61" />
		</div>
	</div>

	<div class="login_bg" style="width:960px; margin:0 auto;">
		<img src="http://a.dangdang.com/api/data/cpx/img/38930001/1" style="display: none;">
		<div id="J_cheatProofTop" class="new_tip">
			<div id="component_2747856"></div>
			<div>为保障账户安全，请勿设置与邮箱及其他网站相同的账户登录密码或支付密码，<a href="javascript:;">谨防诈骗</a>！</div>
		</div>
		<div class="set_area clearfix">
			<div class="wrap clearfix">
				<div id="J_loginDiv">
					<form action="/dangdang/admin/LoginAction" method="post" onsubmit="return submits()">
						<span style="color:red;font-size: 21px;margin-left: 45px;">${message}</span>
						<div id="J_loginCoreWrap" class="infro">
							<div class="username" id="username_div">
								<span></span> <input class="user" id="username" name="username"  type="text" onblur="validUsername()"/>
											  <p id="tishi" style="color:red;"></p>
							</div>
							<br /><br />

							<div class="password" id="password_div">
								<span></span> <input class="pass" id="password" name="password" type="password"  onblur="validPwd()"/>
							 				  <p id="tishi2" style="color:red;"></p>
							</div>
							<br /> <br />
							<div id="J_captchVcodeWrap" style="" class="Captcha">
								<div class="code" style="width:100px;">
									<input type="text" name="code" id="imgcode" onblur="validCode()"/>
								    <!--  <p id="tishi3" style="color:red;"></p>  -->
								</div>
								<div class="Captcha-operate">
									<div class="Captcha-imageConatiner">
										<a class="code_pic" id="vcodeImgWrap" name="change_code_img" href="javascript:void(0);">
											<img id="imgVcode" src="<c:url value='/admin/YanZhengMa'/>" onClick="changeImage()" class="Ucc_captcha Captcha-image">
										</a>
										<a id="vcodeImgBtn" name="change_code_link" class="code_picww" href="javaScript:changeImage()"><p style="color:green;font-size:15px;">想换张图吗？点我点我~</p></a> 
										<span id="spn_vcode_ok" class="icon_yes pin_i" style="display: none;"></span> 
										<span id="J_tipVcode" class="cue warn"></span>
									</div>
								</div>
							</div>
							<br /> <br />

							<p class="btn">
								<input id="submitLoginBtn" type="submit" value="登&nbsp;录" />
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>