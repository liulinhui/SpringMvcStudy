//弹出隐藏层
function ShowDiv(){
	$('#MyDiv').show();
	$('#Myfade').show();
	$('#Myfade').height($(document).height());
};
//关闭弹出层
function CloseDiv(show_div,bg_div)
{
	$('#MyDiv').hide();
	$('#Myfade').hide();

};
