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
<title>컬럼게시판 글수정</title>

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
	
	$(document).ready(function () {
		
		$("#freewrite").on('click',function(){

			if ($('input[name=msubject]').val() == '') {
				alert('영화제목을 입력해주세요.');
				return false;
			}
			if ($('input[name=csubject]').val() == '') {
				alert('제목을 입력해주세요.');
				return false;
			}
			var textarea=CKEDITOR.instances.ceditor.getData();
			 if (textarea.replace(/<(\/)?([a-zA-Z]*)(\s[a-zA-Z]*=[^>]*)?(\s)*(\/)?>/ig, "") == '') {
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
					<form action="columnModifyOk.do" method="post" name="fw" >
					<input type="hidden" name="cpage" value="${param.cpage}" />
					<input type="hidden" name="cnum" value="${param.cnum}" />
		
						<div class="col-md-12 form-group is-empty">
							<label for="moviegenre">영화제목</label><i class="fa fa-search"
								style="margin-top: 23px; margin-left: 15px;"></i> <input
								type="text" class="form-control" value="${cTO.msubject}"
								id="msubject" name="msubject">
						</div>
						<div class="col-md-12 form-group">
							<label for="moviegenre">제목</label> <input type="text"
								class="form-control" value="${cTO.csubject}" id="csubject" name="csubject">
						</div>
						<div class="col-md-12 form-group">
							<label for="moviegenre">내용</label>

							<textarea name="ceditor" id="leditor" rows="10" cols="10"
								class="form-control" style='width: 100%; min-width: 160px;'>${cTO.ccontent}</textarea>
					
						</div>
	
						
						<div class="col-md-12" style="padding-top: 30px">
							<a href="cloumnList.do?cpage=${param.cpage}" class="btn btn-common pull-left">목록</a>
							<input type="submit" id="freewrite"  class="btn btn-common pull-right" value="수정" /> 
						
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
			<script type="text/javascript">
	 
		CKEDITOR.replace('ceditor', {
			
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
</body>

</html>