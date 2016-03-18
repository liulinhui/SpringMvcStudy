<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Content-Language" content="zh-CN" />
  <meta http-equiv="Content-Script-Type" content="text/javascript" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>转让页面</title>
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/otc_sell.css"/>
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/headerfooter.css"/>
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/table.css"/>
  <script type="text/javascript" src="/SpringMvcStudy/resource/js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="/SpringMvcStudy/resource/js/script.headerfooter.js"></script>
  <script type="text/javascript" src="/SpringMvcStudy/resource/js/index.js"></script>
 
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
        <a href="./otc" >首页</a><a href="./myproduct" class="active">我要转让</a><a href="./myAsset">我的账户</a>
      </div>   
			<p class="breadcrumb"><a href="">毕业设计</a><a href="">>OTC转让专区</a></p>
    </div>
  </div>
  <div id="main">
    <div class="inner">
			<div class="blank"></div>
			
				
			<div class="bill">
				<div class="header">
					<h3>您当前持有<span id="amount">123,000</span>份 &nbsp; <span id="product">君得金28天期优先级（952208）</span></h3>
				</div>
				<div class="rules">
					<div class="content">
						<h5>交易规则：</h5>
						<p>1. 君得金优先级产品最小持有份额为20万份</p>
						<p>2. 您转让后剩余的份额必须大于200,000份或者为0</p>
					</div>
				</div>
				<div class="exchange">
					<div class="content">
						<ul class="input">
							<li>
								<span>委托数量</span>
								<input name="amount" class="exchange"></input>
								<span>份</span>
								<p>转让份数至少为<span class="red">1000</span>份，且需要为1000份的倍数</p>
							</li>
							<li>
								<span>委托价格</span>
								<input name="price" class="exchange" type="number"></input>
								<div id="selup"></div>
								<div id="seldown"></div>
								<span>元/份</span>
								<p>最小报价为<span class="red">1.000</span>元/份</p>
							</li>
							<li>
								<input type="checkbox" class="hidden-input" checked="checked" />
								<span class="checkbox" ></span>
								<p class="read">我已阅读<a href="./protocol">相关协议</a>并同意开通OTC交易权限</p>
							</li>
							<li>
								<a href="./transfer_confirm"><div class="button"></div></a>
							</li>
						</ul>
						<div class="info">
							<h5>若本次转让成功</h5>
							<ul>
								<li><img src="/SpringMvcStudy/resource/images/images2/buy_icon.png"></img><p><span>2,038,000</span>元</p><p>我将获得现金</p></li>
								<li><img src="/SpringMvcStudy/resource/images/images2/sell_icon.png"></img><p><span>7.12</span>%</p><p>预计买家持有到期将获得年化收益率</p></li>
							</ul>
						</div>
						<div class="read">
						</div>
					</div>
				</div>
			</div>
	
			<div class="blank"></div>
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
