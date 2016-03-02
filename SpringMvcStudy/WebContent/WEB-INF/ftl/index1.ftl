<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Content-Language" content="zh-CN" />
  <meta http-equiv="Content-Script-Type" content="text/javascript" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>国泰君安</title>
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/index.css"/>
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/headerfooter.css"/>
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/table.css"/>
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/banner.css"/>
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/bottom.css"/>
    <script type="text/javascript" src="/SpringMvcStudy/resource/js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="/SpringMvcStudy/resource/js/script.headerfooter.js"></script>
  <script type="text/javascript" src="/SpringMvcStudy/resource/js/index.js"></script>
 </head>
<body>
  <div class="header-top">
    <div class="h-inner">
     <div class="tel">毕业设计：<em>基于SpringMvc的理财产品转让系统设计</em></div>
      <div class="links">
        <a id="login" href="./account_Login">登录</a>
        <a id="reg" href="./account_Reg">注册</a>
        <a href="">我的订单</a>
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
        <a href="" class="active">首页</a><a href="./sell">我要借款</a><a href="">我的账户</a>
      </div>   
			<p class="breadcrumb"><a href="">毕业设计</a><a href="">>OTC转让专区</a></p>
    </div>
  </div>
  <div id="main">
    <div class="inner">
      <div class="banner">
				<div class="banner-center">
          <img class="banner-images" src="/SpringMvcStudy/resource/images/images/banner.jpg" />
					
				</div>
				      </div>
      <div class="pro-table">
				<div class="title">
					<h4 class="title">转让专区</h4>
				</div>
        <table>
          <thead>
            <tr>
              <th style="width:40px;"></th>
              <th class="name">产品名称</th>
							<th class="id">原预期年化<br>收益率</th>
							<th class="rate">买入后参考 &nbsp;&nbsp; <br>年化收益率<a href="javascript:void(0)"><img class="filter" src="/SpringMvcStudy/resource/images/images2/filter_down_square.png"></img></a></th>
              <th class="period">剩余期限<a href="javascript:void(0)"><img class="filter" src="/SpringMvcStudy/resource/images/images2/filter_down_square.png"></img></a></th>    
              <th class="period">转让份额<a href="javascript:void(0)"><img class="filter" src="/SpringMvcStudy/resource/images/images2/filter_down_square.png"></img></a></th>    
							<th class="amount">转让金额/元<a href="javascript:void(0)"><img class="filter" src="/SpringMvcStudy/resource/images/images2/filter_down_square.png"></img></a></th>
              <th class="risk">风险<a href="javascript:void(0)"><img class="filter" src="/SpringMvcStudy/resource/images/images2/filter_down_square.png"></img></a></th>
              <th class="start">发布时间</th>
              <th class="status">购买状态</th>
              <th style="width:40px;"></th>
            </tr>
          </thead>
          <tbody id="otc">
            <tr>
              <td></td>
							<td class="name"><img class="trans" src="/SpringMvcStudy/resource/images/images2/trans.png"></img>${product_name!" 君得金优先级182天期"}<p>(代码：15688)</p></td>
              <td class="id">6.65%</td>
							<td class="rate">5,73<span class="per">%</span></td>
              <td class="period">61天</td>
              <td class="amount">13,799,000</td>
              <td class="amount">13,799,000</td>
              <td class="risk">低</td>
              <td class="start">2015/01/08</td>
							<td class="status"><a href="./buy"><img src="/SpringMvcStudy/resource/images/images2/cancel_button.png"></img></a></td>
              <td></td>
            </tr>
            <tr>
              <td></td>
              <td class="name"><img class="trans" src="/SpringMvcStudy/resource/images/images2/trans.png">不长的君柜宝二号<p>(代码：15688)</p></td>
              <td class="id">6.65%</td>
	      <td class="rate">5,73<span class="per">%</span></td>
              <td class="period">61天</td>
              <td class="amount">13,799,000</td>
              <td class="amount">13,799,000</td>
              <td class="risk">低</td>
              <td class="start">2015/01/08</td>
							<td class="status"><a href=""><img src="/SpringMvcStudy/resource/images/images2/buy_button.png"></img></a></td>
              <td></td>
            </tr>
           
            <tr>
              <td></td>
              <td class="name"><img class="trans" src="/SpringMvcStudy/resource/images/images2/trans.png">君柜宝二号<p>(代码：15688)</p></td>
              <td class="id">6.65%</td>
	      <td class="rate">5,73<span class="per">%</span></td>
              <td class="period">61天</td>
              <td class="amount">13,799,000</td>
              <td class="amount">13,799,000</td>
              <td class="risk">低</td>
              <td class="start">2015/01/08</td>
              <td class="status"><img src="/SpringMvcStudy/resource/images/images2/sellout_button.png"></img></td>
              <td></td>
            </tr>
           

          </tbody>
        </table>
      </div>
			<!--<div class="scroll" ><img src="/SpringMvcStudy/resource/images/images2/scrolldown.gif"></img></div> -->
			<a style=" text-align:center;">加载更多</a>
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
