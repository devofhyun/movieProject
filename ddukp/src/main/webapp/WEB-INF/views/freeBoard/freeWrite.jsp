<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0">
<script type="text/javascript" src="./resources/jquery-3.4.1.js"></script>
<script src="./resources/ckeditor/ckeditor.js"></script>

<!-- editor -->
<script type="text/javascript"
	src="./editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.9.0.min.js"></script>

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
<link rel="stylesheet" type="text/css"
	href="./assets/css/lboard/fwrite.css" media="screen" />
<title>자유게시판 글쓰기</title>
<script type="text/javascript">
				
</script>
</head>
<body>
	<div class="header">
		<%@include file="../nav2.jsp"%>

	</div>
	<div class="page-header"
		style="background: url(./assets/img/board/queen-of-liberty-202218_1920.jpg);">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="breadcrumb-wrapper">
						<h2 class="product-title">자유게시판</h2>
						<ol class="breadcrumb">
							<li><a href="#"><i class="ti-home"></i> MOVIEP</a></li>
							<li class="current">글쓰기</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div id="content">
		<div class="container">
			<div class="">
				<div class="">
					<form action="write_ok.do" method="post" name="fw">
						<div class="col-md-3 form-group is-empty">
							<label for="moviegenre">카테고리</label> <select id="category"
								class="form-control">
								<option selected="selected">선택해주세요</option>
								<option>일상</option>
								<option>유머</option>
								<option>이슈</option>
								<option>연애</option>
								<option>기타</option>
							</select>
						</div>

						<div class="col-md-9 form-group is-empty">
							<label for="moviegenre">제목</label> <input type="text"
								class="form-control" placeholder="제목" id="subject">
						</div>
						<div class="col-md-12 form-group">
							<label for="moviegenre">내용</label>

							<textarea name="leditor" id="leditor" rows="10" cols="10"
								class="form-control" style='width: 100%; min-width: 160px;'></textarea>
							<script type="text/javascript">
								CKEDITOR.replace('leditor');
							</script>
						</div>
						<div class="col-md-12">
							<input type="file" class="" id="">
						</div>
						<div class="col-md-12" style="padding-top: 30px">
							<a href="freeList.do" class="btn btn-common pull-left">목록</a> <a
								href="freeList.do" class="btn btn-common pull-right">등록</a>
						</div>
					</form>

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
<script type="text/javascript">
	$(document).ready(function() {
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "leditor",
			sSkinURI : "./editor/SmartEditor2Skin.html",
			fCreator : "createSEditor2"
		});

	});
</script>
</html>