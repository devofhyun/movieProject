<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0">
<title>후기 게시판</title>


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
<link rel="stylesheet" href="./assets/css/main2.css" type="text/css">
<!-- Responsive CSS Styles -->
<link rel="stylesheet" href="./assets/css/responsive.css"
	type="text/css">

<!-- Color CSS Styles  -->
<link rel="stylesheet" type="text/css"
	href="./assets/css/colors/red.css" media="screen" />



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
						<h2 class="product-title">후기 게시판</h2>
						<ol class="breadcrumb">
							<li><a href="main.do"><i class="ti-home"></i> MOVIEP</a></li>
							<li class="current">후기 게시판</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Page Header End -->


	<div id="content">
		<div class="container">
			<div class="content">
				<form method="" action="">
					<div class="row">
						<div class="col-md-3 col-xs-4">
							<div class="search-category-container1">
								<select class="dropdown-product selectpicker">
										<option selected="selected">---</option>
										<option>제목</option>
										<option>내용</option>
								</select>
							</div>
						</div>
						<div class="col-md-4 col-xs-6">
							<div class="form-group">
								<input class="form-control" type="text"
									placeholder="job title / keywords / company name">
							</div>
						</div>
						<div class="col-md-1 col-xs-1">
							<button type="button" class="btn btn-search-icon">
								<i class="ti-search"></i>
							</button>
						</div>
					</div>
				</form>
			</div>
			<div class="job-alerts-item">
				<div class="alerts-list">
					<div class="row">
						<div class="col-md-4 col-xs-3">
							<p>글번호</p>
						</div>
						<div class="col-md-4 col-xs-3">
							<p>제목</p>
						</div>
						<div class="col-md-4 col-xs-3">
							<p>날짜</p>
						</div>

					</div>
				</div>
				<div class="alerts-content">
					<div class="row">
						<a href="latterView.do">

							<div class="col-md-4 col-xs-3">
								<p>Web Designer</p>
							</div>
							<div class="col-md-4 col-xs-3">
								<p>Web Designer</p>
							</div>
							<div class="col-md-4 col-xs-3">
								<p>hongildong@email.com</p>
							</div>
						</a>

					</div>
				</div>

				<br>
			</div>
			<div class="col-md-12" style="padding: 20px">
				<a href="latterWrite.do" class="btn btn-common pull-right">등록</a>
			</div>
			<div style="text-align: center; padding-top: 50px">
				<ul class="pagination">
					<li class="active"><a href="#" class="btn btn-common"><i
							class="ti-angle-left"></i> </a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li class="active"><a href="#" class="btn btn-common">
							<i class="ti-angle-right"></i>
					</a></li>
				</ul>

			</div>
		</div>
		
	</div>



	<%@include file="../footer.jsp"%>


	<!-- Go To Top Link -->
	<a href="#" class="back-to-top"> <i class="ti-arrow-up"></i>
	</a>
	<!-- 로딩 -->
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