<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/verify.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/verify.min.js"></script>

<title>登录</title>
<script type="text/javascript">
	$(function(){
		//2.点击验证码 跟新验证码
		$("#pagecode").click(function(){
			$("#pagecode").attr("src","code?"+Math.random());
		});
		//3.验证输入的验证码 是否正确
		$("#vcode").change(function(){
			$.get("checkCode","code="+this.value,function(data){
				if(data==0){
					$("#checkMsg").html("<font color='green'>OK</font>");
					$("#btn").removeAttr("disabled");
				}else{
					$("#checkMsg").html("<font color='red'>ERROR</font>");
					$("#pagecode").attr("src","code?"+Math.random());
					$("#btn").Attr("disabled",true);
				}
			})
		});
		//4.两周以内自动登录  友好提示 
		$("#autoLogin").click(function(){
			if(this.checked){
				$("#autoLoginMsg").html("公司电脑请勿勾选此项").css("color","red");
			}else{
				$("#autoLoginMsg").html("");
			}
		})
        //滑动验证码
        $('#mpanel4').pointsVerify({
            defaultNum : 6, //默认的文字数量
            checkNum : 1, //校对的文字数量
            vSpace : 5, //间隔
            imgName : [ '1.jpg', '2.jpg' ],
            imgSize : {
                width : '300px',
                height : '200px',
            },
            barSize : {
                width : '300px',
                height : '40px',
            },
            ready : function() {
            },
            success : function() {
                //......后续操作
                $("#btn").attr("disabled", false);
            },
            error : function() {
            }
        });
	})
</script>
</head>
<body>
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="${pageContext.request.contextPath }/index.jsp" target="_blank"><img src="./image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<form  method="post" action="userLogin.do" class="form center" id="userLogin.do" >
		<div class="login">
			<div class="login_center">
				<div class="login_top">
					<div class="left fl">注册</div>
					<div class="right fr">注册<a href="${pageContext.request.contextPath }/register.jsp" target="_self">立即注册</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">
						<div class="left fl">用户名:&nbsp;</div>
						<div class="right fl">
						<input class="shurukuang" type="text" name="name" id="username"  placeholder="请输入用户名/邮箱"/>
						<label id="nameMsg"></label>
						</div>
					</div>
					<div class="username">
						<div class="left fl">密&nbsp;&nbsp;&nbsp;&nbsp;码:&nbsp;</div>
						<div class="right fl">
						<input class="shurukuang" type="password" name="password"  id="pwd"  placeholder="请输入你的密码"/>	
						</div>
					</div>

						<div class="username feri-code">
							<div id="mpanel4"></div>
						</div>
					<div class="username" style="height: 203px">
						<div class="left fl">&nbsp;&nbsp;&nbsp;&nbsp;</div>
						<div class="right fl"><label id="checkMsg"></label></div>
					</div>
					<div class="username">
						<input id="autoLogin" name="auto" type="checkbox" />&nbsp;&nbsp;两周以内自动登录
						<span id="autoLoginMsg"></span>
					</div>
					<div class="login_submit">
						<input class="submit" type="submit" name="submit" value="立即登录" id="btn" disabled >
					</div>
					<span style="color:red">${msg}</span>
				</div>	
			</div>
		</div>
		</form>
		<script type="application/javascript" src="js/footer.js"></script>
	</body>
</html>