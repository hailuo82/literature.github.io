//数量增加
function plus(){
	var num = document.getElementById("count").value;
	num = parseInt(num)+1;
	document.getElementById("count").value= num;
	
}
//数量减少
function reduce(){
	var num = document.getElementById("count").value;
	num = parseInt(num)-1;
	if(num > 0){
		document.getElementById("count").value= num;
	}else if( num == 0){
		document.getElementById("count").value = 0;
	}
}
//加入购物车的点击事件
function saveCart(){
	document.getElementById("cartForm").submit();
}