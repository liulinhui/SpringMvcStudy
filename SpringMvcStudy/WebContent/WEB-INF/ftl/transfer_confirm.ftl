<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Content-Language" content="zh-CN" />
  <meta http-equiv="Content-Script-Type" content="text/javascript" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>国泰君安</title>
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/confirm.css"/>
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/headerfooter.css"/>
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/table.css"/>
  <script type="text/javascript" src="/SpringMvcStudy/resource/js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="/SpringMvcStudy/resource/js/script.headerfooter.js"></script>
  <script type="text/javascript" src="/SpringMvcStudy/resource/js/index.js"></script>
  <!--[if lte IE 9]>
    <script type="text/javascript" src="/SpringMvcStudy/resource/js/jquery.placeholder.js"></script>
      <script type="text/javascript">
        $(function(){
          $('input, textarea').placeholder();
        })
      </script>
  <![endif]-->
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
     <div class="tel">毕业设计：<em>基于SpringMvc的理财产品转让系统设计</em></div>
      <div class="links">
        <#if !reg??>      
        <a id="login" href="./account_Login" style="display:black">登录/注册</a> 
        </#if>  
        <#if reg??>         
        <a id="reg" href="./logout" class="${reg!''}" style="display:black">注销：【${reg!"测试" }】</a>
        </#if>              
        <a href="./myOrder">我的订单</a>
      </div>     
    </div>
  </div>
  <div class="header-con">
    <div class="h-inner">
      <a href="./otc" id="logo"><img src="/SpringMvcStudy/resource/images/images2/logo.jpg"></a>
      <div class="h-search">
        <input type="text" id="s-input" placeholder="名称/代码"/>
        <a href="" id="s-btn" title="搜索">搜索</a>
        <div id="s-result">
          <ul>
            <li><a href="">我想理财马上开户</a></li>
            <li><a href="">我想理财马上开户</a></li>
            <li><a href="">我想理财马上开户</a></li>
          </ul>
        </div>
      </div>    
      <div class="nav">
        <a href="./otc" class="active">首页</a><a href="./myproduct">我要转让</a><a href="./myAsset">我的账户</a>
      </div>   
			<p class="breadcrumb"><a href="">毕业设计</a><a href="">>OTC转让专区</a></p>
    </div>
  </div>
  <div id="main">
    <div class="inner">
			<div class="blank" id="head"></div>
			<div class="confirm">
				<img src="/SpringMvcStudy/resource/images/images2/check_icon.png" id="check"></img>
				<h3>您的转让产品发布成功</h3>
				<div class="note">
					<span>返回</span>
					<a href="./otc" class="excg"></a>
					<span>或者查看</span>
					<a href="./myOrder" class="order"><img src="/SpringMvcStudy/resource/images/images2/order_button.png"></img></a>
				</div>
			</div>
			<div class="blank" id="foot"></div>
    </div>
  </div>
 
 <div id="footer-nf">
    <div class="f-inner">
    
      <div class="logos">
        <a target="_blank" href="http://www.csrc.gov.cn"><img src="/SpringMvcStudy/resource/images/images/f_logos_1.png"></a>
        <a target="_blank" href="http://www.sac.net.cn"><img src="/SpringMvcStudy/resource/images/images/f_logos_2.png"></a>
        <a target="_blank" href="http://www.gtja.com/portal/channel/yyzz.jhtml"><img src="/SpringMvcStudy/resource/images/images/f_logos_3.png"></a>
        <a target="_blank" href="https://ss.cnnic.cn/verifyseal.dll?sn=2010051900100001113"><img src="/SpringMvcStudy/resource/images/images/f_logos_4.png"></a>
        <a target="_blank" href="https://seal.verisign.com/splash?form_file=fdf/splash.fdf&dn=TRADE.GTJA.COM&lang=zh_cn"><img src="/SpringMvcStudy/resource/images/images/f_logos_5.png"></a>
        <a target="_blank" href="http://www.miitbeian.gov.cn/publish/query/indexFirst.action"><img src="/SpringMvcStudy/resource/images/images/f_logos_6.png"></a>
      </div>
      <p class="copyright">哈哈哈哈 copyright  © 2016 苗灿 大孙子</p>
    </div>
  </div>
</body>
</html>
