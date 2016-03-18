<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8">
<title>注册页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS -->
  <link rel="shortcut icon" href="/SpringMvcStudy/resource/images/images2/No_Smoking.ico" type="image/x-icon">

<link rel="stylesheet"
	href="/SpringMvcStudy/resource/assets/css/reset.css">
<link rel="stylesheet"
	href="/SpringMvcStudy/resource/assets/css/style.css">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
</head>
<body>
	<div class="page-container">
		<h1>注册新用户</h1>
		<form action="account_Reg" method="post">
			<input type="text" name="user_name" class="username"
				placeholder="用户名"> <input type="text" name="user_code"
				class="usercode" placeholder="账号"> <input type="password"
				name="user_password" class="password" placeholder="密码">
			<div class="warning">
				<button type="submit" id="submit" class="submit">注册</button>
			</div>
			<div class="error">
				<span>+</span>
			</div>
		</form>

	</div>
	<!-- Javascript -->
	<script src="/SpringMvcStudy/resource/assets/js/jquery-1.8.2.min.js"></script>
	<script
		src="/SpringMvcStudy/resource/assets/js/supersized.3.2.7.min.js"></script>
	<script src="/SpringMvcStudy/resource/assets/js/supersized-init.js"></script>
	<script src="/SpringMvcStudy/resource/assets/js/scripts.js"></script>
</body>
</html>


