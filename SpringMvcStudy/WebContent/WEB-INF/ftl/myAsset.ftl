<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>我的资产</title>
<link rel="shortcut icon"
	href="/SpringMvcStudy/resource/images/images2/No_Smoking.ico"
	type="image/x-icon">
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/otc_sell.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/myAsset-css-table.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/headerfooter.css" />
	<link rel="stylesheet" type="text/css" media="screen"
		href="/SpringMvcStudy/resource/css/myAsset.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/table.css" />
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/script.headerfooter.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/index.js"></script>
</head>

<body>
	<div class="header-top">
		<div class="h-inner">
			<div class="tel">
				毕业设计：<em>基于SpringMvc的理财产品转让系统设计</em>
			</div>
			<div class="links">
				<#if !reg??> <a id="login" href="./account_Login"
					style="display: black">登录/注册</a> </#if> <#if reg??> <a id="reg"
					href="./logout" class="${reg!''}" style="display: black">注销：【${reg!"测试" }】</a>
				</#if> <a href="./myOrder">我的订单</a>
			</div>
		</div>
	</div>
	<div class="header-con">
		<div class="h-inner">
			<a href="./otc" id="logo"><img
				src="/SpringMvcStudy/resource/images/images2/logo.jpg"></a>
			<div class="h-search">
				<input type="text" id="s-input" placeholder="名称/代码" /> <a href=""
					id="s-btn" title="搜索">搜索</a>
				<div id="s-result">
					<ul>
						<li><a href="">我想理财马上开户</a></li>
						<li><a href="">我想理财马上开户</a></li>
						<li><a href="">我想理财马上开户</a></li>
					</ul>
				</div>
			</div>
			<div class="nav">
				<a href="./otc">首页</a><a href="./myproduct">我要转让</a><a
					href="./myAsset" class="active">我的账户</a>
			</div>
			<p class="breadcrumb">
				<a href="">毕业设计</a><a href="">>OTC转让专区</a>
			</p>
		</div>
	</div>
	<div id="main">
		<div class="inner">
			<div class="blank"></div>
			<div class="bill">
				<div class="header user-info" style="height: 45px">
					<a><h3>当前账户信息:</h3></a>
				</div>
				<div id="table" style="-moz-user-select: -moz-none;"
					onselectstart="return false;">
					<table id="travel">
						<thead>
							<tr>
								<th scope="col">用户名</th>
								<th scope="col">用户账号</th>
								<th scope="col">可用资金</th>
								<th scope="col">注册日期</th>
								<th scope="col">充值</th>
							</tr>
						</thead>
						<tbody>
							<#if user??>
							<tr>
								<td>${user.user_name!'---'}</td>
								<td>${user.user_code!'---'}</td>
								<td>${user.user_asset!'---'}￥</td>
								<td>${user.reg_time!'---'}</td>
								<td><a href="./AccountRecharge"><img
										src="/SpringMvcStudy/resource/images/images2/recharge.png" /></a></td>
							</tr>
							</#if>
						</tbody>
					</table>
				</div>
				<div class="header xianshi" style="height: 50px">
					<a href="javascript:void(0);"><h3>您当前拥有的产品:<span>123<span>件</span></span></h3></a>
				</div>
				<div class="display"
					style="display: black; -moz-user-select: -moz-none;"
					onselectstart="return false;">
					<div  style="float: left; padding-top: 100px; padding-left: 30px;">
						<a class="imgLeft" href="javascript:void(0)" style="backgroung-color:#000079"><img
							src="/SpringMvcStudy/resource/images/mfrL.jpg" /></a>
					</div>
					<ul class="pricing_table">
						<li class="price_block" style="">
							<h3>S1232</h3>
							<div class="price">
								<div class="price_figure">
									<span class="price_number">主题宝号</span>
								</div>
							</div>
							<ul class="features">
								<li>876586份</li>
								<li>Unlimited Clients</li>
								<li>Unlimited Projects</li>

							</ul>
							<div class="footer">
								<a href="#" class="action_button">Buy Now</a>
							</div>
						</li>
						<li class="price_block">
							<h3>S1232</h3>
							<div class="price">
								<div class="price_figure">
									<span class="price_number">主题宝一号</span>
								</div>
							</div>
							<ul class="features">
								<li>876586份</li>
								<li>Unlimited Clients</li>
								<li>Unlimited Projects</li>

							</ul>
							<div class="footer">
								<a href="#" class="action_button">Buy Now</a>
							</div>
						</li>
						<li class="price_block">
							<h3>S1232</h3>
							<div class="price">
								<div class="price_figure">
									<span class="price_number">主题宝一号</span>
								</div>
							</div>
							<ul class="features">
								<li>876586份</li>
								<li>Unlimited Clients</li>
								<li>Unlimited Projects</li>

							</ul>
							<div class="footer">
								<a href="#" class="action_button">Buy Now</a>
							</div>
						</li>
						<li class="price_block">
							<h3>S1232</h3>
							<div class="price">
								<div class="price_figure">
									<span class="price_number">主题宝一号</span>
								</div>
							</div>
							<ul class="features">
								<li>876586份</li>
								<li>Unlimited Clients</li>
								<li>Unlimited Projects</li>

							</ul>
							<div class="footer">
								<a href="#" class="action_button">Buy Now</a>
							</div>
						</li>
					</ul>
					<div style="float: right; padding-top: 100px; padding-right: 30px">
						<a class="imgRight" href="javascript:void(0)"><img
							src="/SpringMvcStudy/resource/images/mfrR.jpg" /></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('.xianshi').toggle(function() {
				$('.display').hide();
			}, function() {
				$('.display').show();
			});
		});
	</script>
	<div id="footer-nf">
		<div class="f-inner">
			<div class="logos">
				<a target="_blank" href="http://www.csrc.gov.cn"><img
					src="/SpringMvcStudy/resource/images/images/f_logos_1.png"></a> <a
					target="_blank" href="http://www.sac.net.cn"><img
					src="/SpringMvcStudy/resource/images/images/f_logos_2.png"></a> <a
					target="_blank"
					href="http://www.gtja.com/portal/channel/yyzz.jhtml"><img
					src="/SpringMvcStudy/resource/images/images/f_logos_3.png"></a> <a
					target="_blank"
					href="https://ss.cnnic.cn/verifyseal.dll?sn=2010051900100001113"><img
					src="/SpringMvcStudy/resource/images/images/f_logos_4.png"></a> <a
					target="_blank"
					href="https://seal.verisign.com/splash?form_file=fdf/splash.fdf&dn=TRADE.GTJA.COM&lang=zh_cn"><img
					src="/SpringMvcStudy/resource/images/images/f_logos_5.png"></a> <a
					target="_blank"
					href="http://www.miitbeian.gov.cn/publish/query/indexFirst.action"><img
					src="/SpringMvcStudy/resource/images/images/f_logos_6.png"></a>
			</div>
			<p class="copyright">哈哈哈哈 copyright © 2016 苗灿 大孙子</p>
		</div>
	</div>
</body>
</html>
