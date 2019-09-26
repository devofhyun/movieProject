<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0">
<title>회원가입</title>

<script src="./resources/jquery-3.4.1.js"></script>
<script src="./resources/jquery-3.4.1.min.js"></script>  

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="./assets/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="./assets/css/jasny-bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="./assets/css/bootstrap-select.min.css"
	type="text/css">
<!-- Material CSS -->
<link rel="stylesheet" href="./assets/css/material-kit.css"
	type="text/css">
<!-- Font Awesome CSS -->
<link rel="stylesheet" href="./assets/fonts/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="./assets/fonts/themify-icons.css">

<!-- Animate CSS -->
<link rel="stylesheet" href="./assets/extras/animate.css"
	type="text/css">
<!-- Owl Carousel -->
<link rel="stylesheet" href="./assets/extras/owl.carousel.css"
	type="text/css">
<link rel="stylesheet" href="./assets/extras/owl.theme.css"
	type="text/css">
<!-- Rev Slider CSS -->
<link rel="stylesheet" href="./assets/extras/settings.css"
	type="text/css">
<!-- Slicknav js -->
<link rel="stylesheet" href="./assets/css/slicknav.css" type="text/css">
<!-- Main Styles -->
<link rel="stylesheet" href="./assets/css/main.css" type="text/css">
<!-- Responsive CSS Styles -->
<link rel="stylesheet" href="./assets/css/responsive.css"
	type="text/css">

<!-- Color CSS Styles  -->
<link rel="stylesheet" type="text/css"
	href="./assets/css/colors/red.css" media="screen" />

<script type="text/javascript">
	$(document).ready(function () {

		/* 이메일 인증코드 어떻게 할지 생각하기! */
		var mailcode;
		$("#email-code").hide();
		$("#send-email-code").on('click',function(){
			var email = $('input[name=email]').val();
			if (email == '') {
				alert('이메일을 입력해주세요.');
				return false;
			} else {
				$.ajax({
					type :'get',
					url:"sendMail.do",
					data:"email=" + email,
					success:function(code){
						mailcode = code;
						alert("인증코드가 메일에 전송되었습니다. \n확인하여 인증코드를 적어주시기 바랍니다.");
						$("#email-code").show();
				    	$("#send-email-code").attr("mailcheck", "done");
						
					},
					error : function() {
						alert("인증코드 전송에 실패하였습니다."); 
					}
				})
			}
		});
		
		/* 비밀번호, 비밀번호 확인 비교 과정 */
		$("#pwd-check-same").hide();
		$("input").keyup(function(){
			if($('input[name=pwd]').val() == $('input[name=pwd-check]').val()) {
	            $("#pwd-check-same").hide();
	            $("#register").removeAttr("disabled");
			} else {
	            $("#pwd-check-same").show();
	            $("#register").attr("disabled", "disabled");
			}
		});
		
		$("#register").on('click',function(){
			if ($('input[name=id]').val() == '') {
				alert('아이디를 입력해주세요.');
				return false;
			}
			if ($('input[name=name]').val() == '') {
				alert('이름을 입력해주세요.');
				return false;
			}
			if ($('input[name=email]').val() == '') {
				alert('이메일을 입력해주세요.');
				return false;
			}
			if ($('input[name=pwd]').val() == '') {
				alert('비밀번호를 입력해주세요.');
				return false;
			}
			if ($('input[name=pwd-check]').val() == '') {
				alert('비밀번호 확인을 입력해주세요.');
				return false;
			}
			if ($('#send-email-code').attr('mailcheck') == null) {
				alert('이메일 인증해주시기 바랍니다.');
				return false;
			}
			/* 이메일 인증 코드 확인 과정 */
			if ($("#email-code").val() == '') {
				alert('인증 코드를 입력해주세요.');
				return false;
			} else if ($("#email-code").val() != mailcode) {
				alert('인증 코드가 다릅니다.');
				return false;
			} 
		});
	});
</script>

</head>
<body>
	<!-- Header Section Start -->
	<div class="header">
		<%@include file="../nav2.jsp"%>

	</div>
	<!-- Header Section End -->

	<!-- Page Header Start -->
	<div class="page-header"
		style="background: url(./assets/img/banner1.jpg);">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="breadcrumb-wrapper">
						<h2 class="product-title">회원가입</h2>
						<ol class="breadcrumb">
							<li><a href="main.do"><i class="ti-home"></i>  MOVIEP</a></li>
							<li class="current">회원가입</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Page Header End -->

	<div id="content" class="my-account">
		<div class="container">
			<div class="row">
				<div
					class="col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-6 cd-user-modal">
					<div class="my-account-form">
						<ul class="cd-switcher">
							<li><a href="login.do">로그인</a></li>
							<li><a class="selected" href="register.do">회원가입</a></li>
						</ul>

						<div id="cd-signup" class="is-selected">
							<div class="page-login-form register">
								<form action="register_ok.do" method="post" name="fw" class="login-form">
									<div class="form-group">
										<div class="input-icon">
											<i class="ti-user"></i> <input type="text" id="id"
												class="form-control" name="id" placeholder="아이디">
										</div>
									</div>
									<div class="form-group">
										<div class="input-icon">
											<i class="ti-user"></i> <input type="text" id="name"
												class="form-control" name="name" placeholder="이름">
										</div>
									</div>
									<div class="form-group">
										<div class="input-icon">
											<i class="ti-email"></i> <input type="text" id="sender-email"
												class="form-control" name="email" placeholder="이메일">
											<a class="btn btn-common1 email-btn" id="send-email-code">인증 보내기</a>
										</div>
									</div>
									<div class="form-group">
										<div class="input-icon">
											<i class="ti-lock"></i> <input type="text" id="email-code"
												class="form-control" name="email-code" placeholder="메일로 받은 인증코드을 적으세요">
										</div>
									</div>
									<div class="form-group">
										<div class="input-icon">
											<i class="ti-lock"></i> <input type="password"
												class="form-control" name="pwd" placeholder="비밀번호">
										</div>
									</div>
									<div class="form-group">
										<div class="input-icon">
											<i class="ti-lock"></i> <input type="password"
												class="form-control" name="pwd-check" placeholder="비밀번호 확인">
										</div>
									</div>
									<div id="pwd-check-same" style="color:red">비밀번호가 일치하지 않습니다.<br/><br/></div>
									<div class="form-group">
										<div class="input-icon">
											<i class="ti-id-badge"></i> <input type="text"
												class="form-control" name="birth" placeholder="생년월일  (선택)">
										</div>
									</div>									
									<div class="form-group">
										<div class="input-icon">
											<i class="ti-id-badge"></i> <input type="text"
												class="form-control" name="phone" placeholder="전화번호 (선택)">
										</div>
									</div>									
									<input type="submit" id="register" class="btn btn-common log-btn" value="회원가입 하기" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp"%>


	<!-- Go To Top Link -->
	<a href="#" class="back-to-top"> <i class="ti-arrow-up"></i>
	</a>

	<div id="loading">
		<div id="loading-center">
			<div id="loading-center-absolute">
				<div class="object" id="object_one"></div>
				<div class="object" id="object_two"></div>
				<div class="object" id="object_three"></div>
				<div class="object" id="object_four"></div>
				<div class="object" id="object_five"></div>
				<div class="object" id="object_six"></div>
				<div class="object" id="object_seven"></div>
				<div class="object" id="object_eight"></div>
			</div>
		</div>
	</div>
	<!-- Main JS  -->
	<script type="text/javascript" src="./assets/js/jquery-min.js"></script>
	<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./assets/js/material.min.js"></script>
	<script type="text/javascript" src="./assets/js/material-kit.js"></script>
	<script type="text/javascript" src="./assets/js/jquery.parallax.js"></script>
	<script type="text/javascript" src="./assets/js/owl.carousel.min.js"></script>
	<script type="text/javascript" src="./assets/js/jquery.slicknav.js"></script>
	<script type="text/javascript" src="./assets/js/main.js"></script>
	<script type="text/javascript"
		src="./assets/js/jquery.counterup.min.js"></script>
	<script type="text/javascript" src="./assets/js/waypoints.min.js"></script>
	<script type="text/javascript" src="./assets/js/jasny-bootstrap.min.js"></script>
	<script type="text/javascript"
		src="./assets/js/bootstrap-select.min.js"></script>
	<script type="text/javascript" src="./assets/js/form-validator.min.js"></script>
	<script type="text/javascript" src="./assets/js/contact-form-script.js"></script>
	<script type="text/javascript"
		src="./assets/js/jquery.themepunch.revolution.min.js"></script>
	<script type="text/javascript"
		src="./assets/js/jquery.themepunch.tools.min.js"></script>
</body>
</html>