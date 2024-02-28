<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Trinity Company - Home</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/favicon.ico" />
        <link rel="apple-touch-icon" sizes="57x57" href="assets/apple-icon-57x57.png">
		<link rel="apple-touch-icon" sizes="60x60" href="assets/apple-icon-60x60.png">
		<link rel="apple-touch-icon" sizes="72x72" href="assets/apple-icon-72x72.png">
		<link rel="apple-touch-icon" sizes="76x76" href="assets/apple-icon-76x76.png">
		<link rel="apple-touch-icon" sizes="114x114" href="assets/apple-icon-114x114.png">
		<link rel="apple-touch-icon" sizes="120x120" href="assets/apple-icon-120x120.png">
		<link rel="apple-touch-icon" sizes="144x144" href="assets/apple-icon-144x144.png">
		<link rel="apple-touch-icon" sizes="152x152" href="assets/apple-icon-152x152.png">
		<link rel="apple-touch-icon" sizes="180x180" href="assets/apple-icon-180x180.png">
		<link rel="icon" type="image/png" sizes="192x192"  href="assets/android-icon-192x192.png">
		<link rel="icon" type="image/png" sizes="32x32" href="assets/favicon-32x32.png">
		<link rel="icon" type="image/png" sizes="96x96" href="assets/favicon-96x96.png">
		<link rel="icon" type="image/png" sizes="16x16" href="assets/favicon-16x16.png">
		<link rel="manifest" href="assets/manifest.json">
		<meta name="msapplication-TileColor" content="#ffffff">
		<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
		<meta name="theme-color" content="#ffffff">
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <%@ include file="menu.jsp" %>
        
        <!-- Services-->
        <section class="page-section mt-5" id="login">
		    <div class="container mt-5">
		        <div class="row justify-content-center">
		            <div class="col-md-5">
		                <div class="card shadow-lg border-0 rounded-lg mt-5">
		                    <div class="card-body">
		                        <h3 class="text-center font-weight-bold mb-4">로그인</h3>
		                        <form action="./login" method="post">
		                            <div class="form-group mb-2">
		                                <label for="id">아이디</label>
		                                <input type="text" class="form-control mt-2" name="id" id="id" required>
		                            </div>
		                            <div class="form-group mb-2">
		                                <label for="pw">비밀번호</label>
		                                <input type="password" class="form-control mt-1" name="pw" id="pw" required>
		                            </div>
		                            <div class="d-flex justify-content-between align-items-center">
		                                <button type="reset" class="btn btn-secondary">초기화</button>
		                                <button type="submit" class="btn btn-info">로그인</button>
			                        <a href="./join" class="col-2 btn btn-secondary" style="font-size: smaller;">회원가입</a>
		                            </div>
		                        </form>
		                    </div>
		                </div>
		            </div>
		        </div>
	    	</div>
	</section>

        
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
        
        <!-- 파라미터로 오는 error가 있다면 에러 화면에 출력하기 -->
        <c:if test="${param.error ne null}">
			<script type="text/javascript">
				Swal.fire("error", "잘못된 접근입니다.", "error");
			</script>        
        </c:if>
        <c:if test="${param.login ne null }">
        	<script type="text/javascript">
				Swal.fire("로그인 실패", "올바른 아이디와 비밀번호를 입력하세요", "error");
			</script>
        </c:if>
        <c:if test="${param.count ne null }">
        	<script type="text/javascript">
        		let count = ${param.count};
        		if (count < 5) {
					Swal.fire("로그인 정보를 확인하세요", count + "번 시도했습니다", "warning");
				} else {
	        		Swal.fire("로그인 불가", "해당 ID는 잠금처리 되었습니다. 관리자에게 문의하세요", "warning");
				}
        	</script>
        </c:if>
    </body>
</html>
