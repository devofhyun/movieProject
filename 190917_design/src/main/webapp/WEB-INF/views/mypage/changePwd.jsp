<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
   content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0">
<title>비밀번호 변경</title>


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
                  <h2 class="product-title">비밀번호 변경</h2>
                  <ol class="breadcrumb">
                     <li><a href="main.do"><i class="ti-home"></i> MOVIEP</a></li>
                     <li class="current">비밀번호 변경</li>
                  </ol>
               </div>
            </div>
         </div>
      </div>
   </div>
   <!-- Page Header End -->
   <section id="content">
      <div class="container">
         <div class="row">
            <div class="col-md-6 col-md-offset-3">
               <div class="">
                  <form class="form-ad">

                     <div class="form-group">
                        <label class="control-label">현재 비밀번호</label>
                        <input type="password" class="form-control" placeholder="비밀번호">
                     </div>
                     <div class="form-group"> 
                        <label class="control-label">새로운 비밀번호 </label>
                        <input type="password" class="form-control" placeholder="새 비밀번호">                     
                     </div>                     
                     
                     
                     <div>   
                     <div class="form-group">
                        <label class="control-label">새로운 비밀번호 확인 </label>
                        <input type="password" class="form-control" placeholder="새 비밀번호 확인">                     
                     </div>      
                     <div>                                       
                     <a href="changePwd.do" class="btn btn-common pull-right">변경하기<a>
                     </div><br/>                     
                     
                  </form>
               </div>
            </div>
         </div>
      </div>
   </section>



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