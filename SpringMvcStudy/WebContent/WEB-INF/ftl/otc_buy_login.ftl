<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>交易页面</title>
<link rel="shortcut icon"
	href="/SpringMvcStudy/resource/images/images2/No_Smoking8.ico"
	type="image/x-icon">
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/otc_buy.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/headerfooter.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/table.css" />
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/script.headerfooter.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/index.js"></script>

	<!--[if IE 6]>
  <script src="./js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
  <script type="text/javascript">
    DD_belatedPNG.fix('#wx-qr img,#sj-qr img,#footer-nf .img-box img,#float-bar .handle,#float-bar .btn-set li.ol-im a,#float-bar .btn-set li.buy a,#float-bar .back-top a,#s-btn,#header-nf .header-top .sns a,background');
  </script>
  <![endif]-->
</head>

<body>
	<div class="header-top">
		<div class="h-inner">
			<div class="tel">
				毕业设计：<em>基于SpringMvc的理财产品转让系统设计</em>
			</div>
			<div class="links">
				<a id="login" href="./account_Login?returnUrl=/buy?product_code=${product.product_code!''}&id=${product.user_code!''}">登录/注册</a> 
			    <a href="./myOrder">我的订单</a>
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
				<a href="./otc" class="">首页</a><a href="./sell">我要转让</a><a
					href="./myAsset">我的账户</a>
			</div>
			<p class="breadcrumb">
				<a href="">毕业设计</a><a href="">>OTC转让系统</a><a href="">>君得金优先级28天期</a>
			</p>
		</div>
	</div>
	<div id="main">
		<div class="inner">
			<div class="blank"></div>
			<#if product??>
			<div class="bill">
				<div class="header">
					<img src="/SpringMvcStudy/resource/images/images2/trans.png"></img>
					<h3>
						${product.product_name!"君得金28天期优先级" }<span>代码：${product.product_code!"S32424" }</span>
					</h3>
				</div>
				<div class="info">
					<div class="rate">
						<h2>
							${product.reference_income!"11.43" }<span>%</span>
						</h2>
						<h6>参考年化收益率</h6>
						<p>
							<span>单位面值</span> 1.00元/份
						</p>
						<div class="line"></div>
					</div>
					<div class="rate">
						<h2>
							${product.limit_time!"102" }<span>天</span>
						</h2>
						<h6>剩余期限</h6>
						<p>
							<span>转让价格</span> ${product.transfer_price!"" }元/份
						</p>
						<div class="line"></div>
					</div>
					<div class="rate">
						<h2>
							<input type="text" class="fenge"/>
							<span class="fengZi">份</span>
						</h2>
						<h6 style="margin-top:47px;">转让份额</h6>
						<p>
							<span>转让日期</span>${product.public_date!"2015-05-11" }
						</p>
					</div>
					<div class="tip">
						<img src="/SpringMvcStudy/resource/images/images2/tip.png"></img>
						<h5>买家预期年化收益率=(持有期收入之和/转让价格-1)*(365/持有时间)*100%）</h5>

					</div>
				</div>
				<div class="confirm">
					<div class="amount">
						<h2>
							<a style="color:#f99325;">120,023,000</a><span>元</span>
						</h2>
						<h5>投资金额</h5>
					</div>
					<div class="warn">
						<h5>
							当前可用资金：<a
								href="./account_Login?id=${product.id!''}&returnUrl=/buy?status=${product.state!''}&id=${product.id!''}"><span
								id="text">登录</span></a>可见
						</h5>
					</div>
					<a
						href="./account_Login?id=${product.id!''}&returnUrl=/buy?status=${product.state!''}&id=${product.id!''}"><div
							class="button" id="conbuy"></div></a>
				</div>
			</div>
			</#if>
		</div>
	</div>
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
