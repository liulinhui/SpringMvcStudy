$(document).ready(function(){

	//Toggle chat table
	$(".chat-table tbody").hide();
  $("span#showhide").click(function(){
		$(".chat-table tbody").toggle();
  });

	//Filter by ascending or descending order
  $("img.filter").click(function(){
		$('img.filter').each(function(){
			if ($(this).attr('src')=='/SpringMvcStudy/resource/images/images2/filter_down_active.png') {
				$(this).attr('src','/SpringMvcStudy/resource/images/images2/filter_down_square.png');
			}	else if($(this).attr('src')=='/SpringMvcStudy/resource/images/images2/filter_up_active.png') {
				$(this).attr('src','/SpringMvcStudy/resource/images/images2/filter_up_square.png');
			}
		});
		$(this).attr('src',$(this).attr('src')=='/SpringMvcStudy/resource/images/images2/filter_down_square.png'||$(this).attr('src')=='/SpringMvcStudy/resource/images/images2/filter_down_active.png'?'/SpringMvcStudy/resource/images/images2/filter_up_active.png':'/SpringMvcStudy/resource/images/images2/filter_down_active.png');
	});

	$('div#selup').click(function(){
		var price = parseInt($('input[name=price]').val()) || 0;
		$('input[name=price]').attr('value', price +1);
	});

	$('div#seldown').click(function(){
		var price = parseInt($('input[name=price]').val()) || 0;
		$('input[name=price]').attr('value', price -1);
	});

	//hover table
	$('table tbody#otc tr').mouseover(function(){
		$(this).addClass('bg');
	});
	$('table tbody#otc tr').mouseout(function(){
		$(this).removeClass('bg');
	});

	//scroll to bottom and show more list
	 $(window).scroll(function() {  
      if ($(this).scrollTop() + $(window).height() + 20 >= $(document).height() && $(this).scrollTop() > 20) {  
				var content = ' <tr> <td></td>	<td class="name"><img class="trans" src="/SpringMvcStudy/resource/images/images2/trans.png"></img>君得金优先级182天期<p>(代码：15688)</p></td> <td class="id">6.65%</td><td class="rate">5,73<span class="per">%</span></td><td class="period">61天</td> <td class="amount">13,799,000</td><td class="amount">13,799,000</td> <td class="risk">低</td> <td class="start">2015/01/08</td><td class="status"><a href=""><img src="/SpringMvcStudy/resource/images/images2/cancel_button.png"></img></a></td></tr>';
				$('tbody#otc').append(content);
      }  
  });  

	//dropdown list in buy confirm page
	$('div#dropdown').hide();
	$('div#dropdown').css('left', $('span#first').position().left);
	$('span#dropdown,span#first').mouseover(function(){
		$('div#dropdown').css('left', $('span#first').position().left);
		$('div#dropdown').slideDown();
	});
	$('div.blank').mouseleave(function(){
		$('div#dropdown').hide();
	});
	$('div#dropdown ul li').click(function(){
		$('span#first').html($(this).text());
	});

	// close mask
	$('div#widget img#close').click(function(){
		$('div.mask').hide();
		$('div#widget').hide();
	});

});
