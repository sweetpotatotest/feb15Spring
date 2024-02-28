<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Trinity Company - MMMMail</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="shortcut icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="apple-touch-icon" sizes="57x57"
	href="assets/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60"
	href="assets/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="assets/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="assets/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="assets/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144"
	href="assets/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="assets/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180"
	href="assets/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"
	href="assets/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="assets/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="assets/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="assets/favicon-16x16.png">
<link rel="manifest" href="assets/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
	integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">
        const Toast = Swal.mixin({
            toast: true,
            position: 'center-center',
            showConfirmButton: false,
            timer: 3000,
            timerProgressBar: true,
            didOpen: (toast) => {
              toast.onmouseenter = Swal.stopTimer;
              toast.onmouseleave = Swal.resumeTimer;
            }
          });
       	</script>
</head>
<body id="page-top">
	<!-- Navigation-->
	<%@ include file="menu.jsp"%>

	<!-- 메일 보내기 -->
	<section class="page-section bg-light" id="mail">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-8 text-center">
					<h2 class="text-center mt-0">이메일 보내기</h2>
					<hr class="divider my-4">
					<div class="row justify-content-center">
						<div class="col-lg-6">
							<form action="/mail" method="post">
								<div class="form-group">
									<label for="email">받는 사람</label> <input type="email"
										class="form-control" id="email" name="email"
										placeholder="이메일 주소를 입력하세요" required>
								</div>
								<div class="form-group">
									<label for="title">제목</label> <input type="text"
										class="form-control" id="title" name="title"
										placeholder="제목을 입력하세요" required>
								</div>
								<div class="form-group">
									<label for="content">본문</label>
									<textarea class="form-control" id="content" name="content"
										rows="5" placeholder="내용을 입력하세요" required></textarea>
								</div>
								<button type="submit" class="btn btn-primary">보내기</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
