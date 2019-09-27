<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0">
<title>후기게시판 글쓰기</title>

<script src="./resources/jquery-3.4.1.js"></script>
<script src="./resources/jquery-3.4.1.min.js"></script>
<script src="./resources/ckeditor/ckeditor.js"></script>
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


<script type="text/javascript">
	$(document)
			.ready(
					function() {
						/* $("#bbb").on('click',function(){
							alert('dd');
						}) */
						/* var mlist=["엑시트","스파이더맨","변산","조선명탐정","토이스토리"];
						$("#msearch").autocomplete({
							source:mlist,
							select:function(event,ui){
								console.log(ui.item);
							},
							focus:function(event,ui){
								return false;
							}
						}) */
						/* 		$("#bbb").on('click',function(){
						 $.ajax({
						 type : 'get',
						 url:"movieList.do",
						 dataType:"json",
						 success:function(data){
						 alert(data);
						
						 },
						 error : function(
						 request,
						 status, error) {
						
						 alert("code:"
						 + request.status
						 + "\n"
						 + "message:"
						 + request.responseText
						 + "\n"
						 + "error:"
						 + error); 
						 }
						 })
						 }); */
						$("#freewrite")
								.on(
										'click',
										function() {
											if ($('#rcategory').val() == 'non') {
												alert('영화장르를 선택해주세요.');
												return false;
											}
											if ($('input[name=msubject]').val() == '') {
												alert('영화제목을 입력해주세요.');
												return false;
											}
											if ($('input[name=rsubject]').val() == '') {
												alert('제목을 입력해주세요.');
												return false;
											}
											var textarea = CKEDITOR.instances.leditor
													.getData();
											if (textarea
													.replace(
															/<(\/)?([a-zA-Z]*)(\s[a-zA-Z]*=[^>]*)?(\s)*(\/)?>/ig,
															"") == '') {
												alert('내용을 입력해주세요.');
												return false;
											}

										});
						 

					});
</script>
</head>
<body>
	<c:set var="flag" value="${flag }"></c:set>
	<c:if test="${flag ne null and flag == 1 }">
		<script type="text/javascript">
			alert('오류가 발생했습니다. 다시 입력해주세요.');
		</script>
	</c:if>
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
					<form action="latterWriteOk.do" method="post" name="fw">
						<div class="col-md-3 form-group is-empty">
							<label for="moviegenre">카테고리</label> <select id="ctgname"
								name="ctgname" class="form-control">
								<option selected="selected" value="non">선택해주세요</option>
								<option value="후기">후기</option>
								<option value="질문">질문</option>
							</select>
						</div>

						<div class="col-md-9 form-group is-empty">
							<label for="moviegenre">영화제목</label><i class="fa fa-search"
								style="margin-top: 23px; margin-left: 15px;"></i> <input
								type="text" class="form-control" placeholder="입력해주세요"
								id="msubject" name="msubject">
						</div>
						<div class="col-md-12 form-group">
							<label for="moviegenre">제목</label> <input type="text"
								class="form-control" placeholder="제목" id="rsubject"
								name="rsubject">
						</div>
						<div class="col-md-12 form-group">
							<label for="moviegenre">내용</label>

							<textarea name="leditor" id="leditor" rows="10" cols="10"
								class="form-control" style='width: 100%; min-width: 160px;'></textarea>

						</div>
						<div class="col-md-12">
							<input type="file" class="" id="">
						</div>

						<div class="col-md-12" style="padding-top: 30px">
							<a href="freeList.do?cpage=${param.cpage}"
								class="btn btn-common pull-left">목록</a> <input type="submit"
								id="freewrite" class="btn btn-common pull-right" value="등록" />

						</div>
						<button type="button"  id="bbb" class="btn btn-warning">하이</button>
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
	<script type="text/javascript">
	 
		CKEDITOR.replace('leditor', {
			
			filebrowserImageUploadUrl : 'fileupload.do'
		});
		
		 CKEDITOR.on('dialogDefinition', function( ev ){
	            var dialogName = ev.data.name;
	            var dialogDefinition = ev.data.definition;
	          
	            switch (dialogName) {
	                case 'image': //Image Properties dialog
	                    //dialogDefinition.removeContents('info');
	                    dialogDefinition.removeContents('Link');
	                    dialogDefinition.removeContents('advanced');
	                    break;
	            }
	        });
		
		
	</script>
</body>

</html>