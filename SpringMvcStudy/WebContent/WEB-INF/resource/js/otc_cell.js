$(document).ready(function() { 
	var account_flag="false";
	var price_flag="false";
	var permission;
	$('#exchange_account').keyup(function(){
		var exchange=$(this).val();
		var amount=parseInt($('#amount').text().replace(/[^0-9]/g,''));  //获取拥有份额
		var rest=amount-exchange;
		if (exchange=="") {
			$('.count_warn').hide();
			$('.count_warn1').hide();
			$('.count_warn2').hide();
		}
		if (amount<1000) {
			$('.count_warn1').show();
			price_flag="false";
			return false;
		}
		if (exchange<1000) {
			$('.count_warn').show();
			price_flag="false";
			return false;
		}
		if (rest<1000 && rest!=0) {
			$('.count_warn2').show();
			price_flag="false";
			return false;
		}
		if (exchange>=1000 && amount>=1000 && rest>1000 || rest==0) {
			$('.count_warn').hide();
			account_flag="true";
		}
	});
	$('#exchange_price').keyup(function(){
		var exchange=$(this).val();
		$(this).val(exchange.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3')); //限制两位小数
		exchange=$(this).val();
		if (exchange<1.00) {
			$('.price_warn').show();
		}
		if (exchange>=1) {
			$('.price_warn').hide();
			price_flag="true";
		}
	});
	$('.checkbox').click(function(){
		permission=$(this).attr("checked");
	});
	$('.transfer_confirm').click(function(){
		if (account_flag=="false" || price_flag=="false" || permission==null) {
			return false;
		}else{
			var id=$(this).attr("id");
			var account=$('#exchange_account').val();
			var price=$('#exchange_price').val();
			$.ajax({
				url:"./exchange",
				
			});
		}
	});
}); 