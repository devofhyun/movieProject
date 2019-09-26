<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0">

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

<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Color CSS Styles  -->
<link rel="stylesheet" type="text/css"
	href="./assets/css/colors/red.css" media="screen" />
<title>후기게시판 상세페이지</title>
</head>


<body>
<c:set var="flag" value="${flag }"></c:set>
	<c:if test="${flag ne null and flag == 0 }">
	<script type="text/javascript">
	alert('완료되었습니다.');
	</script>
	</c:if>
	<!-- Header Section Start -->
	<div class="header">
		<%@include file="../nav2.jsp"%>

	</div>
	<!-- Header Section End -->

	<div class="page-header"
		style="background: url(./assets/img/board/queen-of-liberty-202218_1920.jpg);">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="breadcrumb-wrapper">
						<h2 class="product-title">후기게시판</h2>
						<ol class="breadcrumb">
							<li><a href="#"><i class="ti-home"></i> MOVIEP</a></li>
							<li class="current">상세페이지</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="content">
		<div class="container">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="">
					<table class="table table-borderless table-sm">

						<tr>
							<th class="col-md-4" style="text-align: center;">[${lTO.msubject }]&nbsp&nbsp&nbsp <b>${lTO.rsubject }</b></th>
							<th class="col-md-3">${lTO.uid }</th>
							<th class="col-md-3">${lTO.rdate }</th>
							<th class="col-md-2">${lTO.rhit }</th>
						</tr>
					</table>

					<div>${lTO.rcontent }</div>

				</div>
				<div class="col-md-12" style="padding-top: 30px">
					<a href="latterList.do?cpage=${param.cpage}" class="btn btn-common pull-left">목록</a> 
					<c:if test="${sid eq lTO.uid }">
					
					<a href='latterModify.do?rnum=${param.rnum}&cpage=${param.cpage}' class="btn btn-common pull-right">수정</a> 
					 </c:if>
					 <c:if test="${sid eq lTO.uid }">
					<a href="infoEdit.do?rnum=${param.rnum}&cpage=${param.cpage}" class="btn btn-common pull-right"
						id="btn-left1">삭제</a>
						</c:if>
				</div>
			</div>

		</div>
		<br>

		<div class="container">
			<div id="comments" class="col-md-10 col-md-offset-1">
				<h3>5 개의 댓글</h3>
				<ol class="comments-list">
					<li>
						<div class="media">
							<div>
								<h4 class="name">Roy Fisher</h4>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Officia possimus dignissimos eveniet aliquid optio sit sint
									fugit dolorem autem placeat nostrum deleniti nulla error,
									dolores in dolorum illum, tempore, perferendis.</p>
								<span class="comment-date">Mar 02, 2016</span> <a href="#"
									class="reply-link">Reply</a>
							</div>
						</div>
						<ul>
							<li>
								<div class="media">
									<div class="">
										<h4 class="name">Jane Smith</h4>
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit. Officia possimus dignissimos eveniet aliquid optio sit
											sint fugit dolorem autem placeat nostrum deleniti nulla
											error, dolores in dolorum illum, tempore, perferendis.</p>
										<span class="comment-date">Mar 02, 2016</span> <a href="#"
											class="reply-link">Reply</a>
									</div>
								</div>
							</li>
						</ul>
					</li>
					<li>
						<div class="media">
							<div class="">
								<h4 class="name">Nancy Watson</h4>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Officia possimus dignissimos eveniet aliquid optio sit sint
									fugit dolorem autem placeat nostrum deleniti nulla error,
									dolores in dolorum illum, tempore, perferendis.</p>
								<span class="comment-date">Mar 02, 2016</span> <a href="#"
									class="reply-link">Reply</a>
							</div>
						</div>
						<ul>
							<li>
								<div class="media">
									<div class="">
										<h4 class="name">Diane Evans</h4>
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit. Officia possimus dignissimos eveniet aliquid optio sit
											sint fugit dolorem autem placeat nostrum deleniti nulla
											error, dolores in dolorum illum, tempore, perferendis.</p>
										<span class="comment-date">Mar 02, 2016</span> <a href="#"
											class="reply-link">Reply</a>
									</div>
								</div>
							</li>
							<li>
								<div class="media">
									<div class="">
										<h4 class="name">Amy Harper</h4>
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit. Officia possimus dignissimos eveniet aliquid optio sit
											sint fugit dolorem autem placeat nostrum deleniti nulla
											error, dolores in dolorum illum, tempore, perferendis.</p>
										<span class="comment-date">Mar 02, 2016</span> <a href="#"
											class="reply-link">Reply</a>
									</div>
								</div>
							</li>
						</ul>
					</li>
				</ol>

				<div id="respond">
					<h2 class="respond-title">댓글달기</h2>
					<form action="#">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<textarea id="comment" class="form-control" name="comment"
										cols="45" rows="8" placeholder="Here goes your comment"></textarea>
								</div>
								<button type="submit" id="submit" class="btn btn-common">댓글달기</button>
							</div>
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
</html>