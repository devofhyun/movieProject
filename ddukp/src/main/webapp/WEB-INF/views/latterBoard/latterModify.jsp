<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0">
<title>후기게시판 글쓰기</title>


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
<link rel="stylesheet" type="text/css"
	href="./assets/css/lboard/lwrite.css" media="screen" />
</head>
<body>
	<!-- Header Section Start -->
	<div class="header">
		<%@include file="../nav2.jsp"%>

	</div>
	<div class="page-header"
		style="background: url(./assets/img/board/lboard3.JPG);">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="breadcrumb-wrapper">
						<h2 class="product-title">후기게시판</h2>
						<ol class="breadcrumb">
							<li><a href="#"><i class="ti-home"></i> MOVIEP</a></li>
							<li class="current">글수정</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="content">
		<div class="container">
			<div class="row">
				<div class="col-md-9 col-md-offset-2">
					<div class="page-ads box">
						<form action="" class="form-ad">

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="moviegenre">장르</label> <select id="genre"
											class="form-control">
											<option selected="selected">선택해주세요</option>
											<option>액션</option>
											<option>로맨스</option>
											<option>공포/스릴러</option>
											<option>코미디</option>
											<option>판타지</option>
											<option>SF</option>
										</select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="moviegenre">영화제목</label> <i class="fa fa-search"
											style="margin-top: 23px;"></i><input class="form-control" type="email"
											placeholder="입력해주세요" id="msearch" />
									</div>
								</div>
							</div>
							<!-- <div class="form-group is-empty">
								<div class="row">
									<div class="col-md-6 ">
										<label for="moviegenre">닉네임</label> <input type="text"
											class="form-control" placeholder="닉네임">
									</div>
									<div class="col-md-6">
										<label for="moviegenre">비밀번호</label> <input type="password"
											class="form-control" placeholder="비밀번호">
									</div>
								</div>
							</div>

							<div class="form-group is-empty">
								<label for="moviegenre">제목</label> <input type="text"
									class="form-control" placeholder="제목">
							</div> -->
							<div class="form-group">
								<label for="moviegenre">내용</label>

								<textarea name="leditor" id="leditor" rows="10" cols="10"
									class="form-control" style='width: 100%; min-width: 160px;'></textarea>

							</div>
							<div class="form-group">
								<label for="moviegenre">파일첨부</label> <input type="file"
									class="form-control" id="exampleFormControlFile1">

							</div>
						</form>

					</div>
					<span id="lwrite"><input type="submit" value="수정"
						class="btn btn-primary "></span> <span><button
						type="button" class="btn btn-primary" onclick="location.href='latterList.do'">취소</button></span>
				</div>
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp"%>
	<!-- Main JS  -->
	<script type="text/javascript" src="./assets/js/jquery-min.js"></script>
	<script type="text/javascript" src="./assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./assets/js/material.min.js"></script>
	<script type="text/javascript" src="./assets/js/material-kit.js"></script>
	<script type="text/javascript" src="./assets/js/jquery.parallax.js"></script>
	<script type="text/javascript" src="./assets/js/owl.carousel.min.js"></script>
	<script type="text/javascript" src="./assets/js/jquery.slicknav.js"></script>
	<script type="text/javascript" src="./assets/js/main.js"></script>
	<script type="text/javascript"src="./assets/js/jquery.counterup.min.js"></script>
	<script type="text/javascript" src="./assets/js/waypoints.min.js"></script>
	<script type="text/javascript" src="./assets/js/jasny-bootstrap.min.js"></script>
	<script type="text/javascript"src="./assets/js/bootstrap-select.min.js"></script>
	<script type="text/javascript" src="./assets/js/form-validator.min.js"></script>
	<script type="text/javascript" src="./assets/js/contact-form-script.js"></script>
	<script type="text/javascript"src="./assets/js/jquery.themepunch.revolution.min.js"></script>
	<script type="text/javascript"src="./assets/js/jquery.themepunch.tools.min.js"></script>
</body>

</html>