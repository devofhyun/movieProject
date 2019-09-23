<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="logo-menu">
	<nav class="navbar navbar-default main-navigation" role="navigation"
		data-spy="affix" data-offset-top="50">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand logo" href="main.do"><img
					src="./assets/img/logo.png" alt=""></a>
			</div>
=======
    pageEncoding="UTF-8"%>

         <div class="logo-menu">
          <nav class="navbar navbar-default main-navigation" role="navigation" data-spy="affix" data-offset-top="50">
            <div class="container">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand logo" href="main.do"><img src="./assets/img/logo.png" alt=""></a>
              </div>
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
			<div class="collapse navbar-collapse" id="navbar">
				<!-- Start Navigation List -->
				<ul class="nav navbar-nav">
					<li><a href="introduceMoviep.do"> MOVIEP </a></li>
					<li><a href="movieSortList.do"> 영화 <i
							class="fa fa-angle-down"></i>
					</a>
						<ul class="dropdown">
							<li><a href="movieSortList.do"> 장르별 영화 </a></li>
							<li><a href="movieEnglishList.do"> 영어 배우기 쉬운 영화 </a></li>
						</ul></li>
					<li><a href="freeList.do"> 커뮤니티 <i
							class="fa fa-angle-down"></i>
					</a>
						<ul class="dropdown">
							<li><a href="freeList.do"> 자유 게시판 </a></li>
							<li><a href="columnList.do"> 칼럼 게시판 </a></li>
							<li><a href="latterList.do"> 후기 게시판 </a></li>
						</ul></li>
					<li><a href="infoBoard.do"> Q & A <i
							class="fa fa-angle-down"></i>
					</a>
						<ul class="dropdown">
							<li><a href="infoBoard.do"> 공지사항 </a></li>
							<li><a href="customerCenter.do"> 고객센터 </a></li>
						</ul></li>
					<li><a href="memberInfo.do"> 마이페이지 <i
							class="fa fa-angle-down"></i>
					</a>
						<ul class="dropdown">
							<li><a href="memberInfo.do"> 나의 정보 </a></li>
							<li><a href="memberScrap.do"> 스크랩 목록 </a></li>
							<li><a href="memberWrite.do">내가 글 쓴 목록</a></li>
							<li><a href="changePwd.do">비밀번호 변경</a></li>
=======
              <div class="collapse navbar-collapse" id="navbar">              
                 <!-- Start Navigation List -->
                <ul class="nav navbar-nav">
                  <li>
                    <a href="introduceMoviep.do">
                    MOVIEP
                    </a>
                  </li>
                  <li>
                    <a href="movieSortList.do">
                    영화 <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown">
                      <li>
                        <a href="movieSortList.do">
                        장르별 영화
                        </a>
                      </li>
                      <li>
                        <a href="movieEnglishList.do">
                        영어 배우기 쉬운 영화
                        </a>
                      </li>
                    </ul>
                  </li>
                  <li>
                    <a href="freeList.do">
                    커뮤니티 <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown">
                      <li>
                        <a href="freeList.do">
                        자유 게시판
                        </a>
                      </li>
                      <li>
                        <a href="columnList.do">
                        칼럼 게시판
                        </a>
                      </li>
                      <li>
                        <a href="latterList.do">
                        후기 게시판
                        </a>
                      </li>
                    </ul>
                  </li>
                  <li>
                    <a href="infoBoard.do">
                    Q & A <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown">
                      <li>
                        <a href="infoBoard.do">
                        공지사항
                        </a>
                      </li>
                      <li>
                        <a href="customerCenter.do">
                        고객센터
                        </a>
                      </li>
                    </ul>
                  </li>
                  <li>
                    <a href="memberInfo.do">
                    마이페이지 <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown">
                      <li>
                        <a href="memberInfo.do">
                        나의 정보
                        </a>
                      </li>
                      <li>
                        <a href="memberScrap.do">
                        스크랩 목록
                        </a>
                      </li>
                      <li><a href="memberWrite.do">내가 글 쓴 목록</a></li>
                      <li><a href="changePwd.do">비밀번호 변경</a></li>
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
						</ul></li>
					<li><a href="userDelete.do"> 관리자페이지 <i
							class="fa fa-angle-down"></i>
					</a>
						<ul class="dropdown">
							<li><a href="userDelete.do"> 회원 관리 </a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right float-right">
					<c:if test="${empty sid }">
						<li class="right"><a href="login.do"><i class="ti-lock"></i>
								로그인</a></li>
					</c:if>
					<c:if test="${!empty sid }">
						<li class="right"><a href="logout_ok.do"><i
								class="ti-lock"></i>로그아웃</a></li>
					</c:if>
				</ul>
			</div>
		</div>
		<!-- Mobile Menu Start -->
		<ul class="wpb-mobile-menu">
			<li><a href="introduceMoviep.do">MOVIEP</a></li>
			<li><a href="movieSortList.do">영화</a>
				<ul>
					<li><a href="movieSortList.do">장르별 영화</a></li>
					<li><a href="movieEnglishList.do">영어 배우기 쉬운 영화</a></li>
				</ul></li>
			<li><a href="freeList.do">커뮤니티</a>
				<ul>
					<li><a href="freeList.do">자유 게시판</a></li>
					<li><a href="columnList.do">칼럼 게시판</a></li>
					<li><a href="latterList.do">후기 게시판</a></li>
				</ul></li>
			<li><a href="infoBoard.do">Q & A</a>
				<ul>
					<li><a href="infoBoard.do">공지사항</a></li>
					<li><a href="customerCenter.do">고객센터</a></li>
				</ul></li>
			<li><a href="memberInfo.do">마이페이지</a>
				<ul>
					<li><a href="memberInfo.do">나의 정보</a></li>
					<li><a href="memberScrap.do">스크랩 목록</a></li>
					<li><a href="memberWrite.do">내가 글 쓴 목록</a></li>
				</ul></li>
			<li><a href="userDelete.do">관리자페이지</a>
				<ul>
					<li><a href="userDelete.do">회원 관리</a></li>
				</ul></li>
			<li class="btn-m"><a href="login.do"><i class="ti-lock"></i>
					로그인</a></li>
		</ul>
		<!-- Mobile Menu End -->
	</nav>
</div>
=======
                    </ul>
                  </li>
                  <li>
                    <a href="userDelete.do">
                    관리자페이지 <i class="fa fa-angle-down"></i>
                    </a>
                    <ul class="dropdown">
                      <li>
                        <a href="userDelete.do">
                        회원 관리
                        </a>
                      </li>
                    </ul>
                  </li>                    
                </ul>
                <ul class="nav navbar-nav navbar-right float-right">
                  <li class="right"><a href="login.do"><i class="ti-lock"></i>  로그인</a></li>
                </ul>
              </div>
            </div>
            <!-- Mobile Menu Start -->
            <ul class="wpb-mobile-menu">
              <li>
                <a href="introduceMoviep.do">MOVIEP</a>                      
              </li>
              <li>
                <a href="movieSortList.do">영화</a>
                <ul>
                  <li><a href="movieSortList.do">장르별 영화</a></li>
                  <li><a href="movieEnglishList.do">영어 배우기 쉬운 영화</a></li>
                </ul>
              </li>
              <li>
                <a href="freeList.do">커뮤니티</a>
                <ul>
                  <li><a href="freeList.do">자유 게시판</a></li>
                  <li><a href="columnList.do">칼럼 게시판</a></li>
                  <li><a href="latterList.do">후기 게시판</a></li>
                </ul>
              </li>
              <li>
                <a href="infoBoard.do">Q & A</a>
                <ul>
                  <li><a href="infoBoard.do">공지사항</a></li>
                  <li><a href="customerCenter.do">고객센터</a></li>
                </ul>
              </li> 
              <li>
                <a href="memberInfo.do">마이페이지</a>
                <ul>
                  <li><a href="memberInfo.do">나의 정보</a></li>
                  <li><a href="memberScrap.do">스크랩 목록</a></li>
                  <li><a href="memberWrite.do">내가 글 쓴 목록</a></li>
                </ul>
              </li> 
              <li>
                <a href="userDelete.do">관리자페이지</a>
                <ul>
                  <li><a href="userDelete.do">회원 관리</a></li>
                </ul>
              </li>                 
              <li class="btn-m"><a href="login.do"><i class="ti-lock"></i>  로그인</a></li>          
            </ul>
            <!-- Mobile Menu End --> 
          </nav>
        </div>
>>>>>>> refs/remotes/origin/master
