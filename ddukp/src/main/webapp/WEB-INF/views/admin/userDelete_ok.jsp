<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1.0, maximum-scale=1.0">
<title>회원 관리</title>
<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>
<script type="text/javascript">
	window.onload = function() {
<%int flag = (Integer) request.getAttribute("flag");
			if (flag == 0) {
				out.println("swal({");
				out.println("title: '회원탈퇴 성공',");
				out.println("icon: 'success',");
				out.println("button: '확인',");
				out.println("}).then(function(){");
				out.println("window.location.href='userDelete.do';");
				out.println("});");
				//out.println("location.href='userDelete.do'");
			} else if (flag == 1) {
				out.println("alert('탈퇴실패')");
				out.println("history.back()");
			}%>
	};
</script>
</head>
<body>
</body>
</html>
