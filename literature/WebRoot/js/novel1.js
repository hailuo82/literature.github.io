window.onload = function(){
	var div1=document.getElementById("zjml");
	var div2=document.getElementById("pl active");
	var div3=document.getElementById("chapter_list");
	var div4=document.getElementById("comments_area");

	div1.onclick=function(){
		div3.style.display="block";
		div4.style.display="none";
	};
	div2.onclick=function(){
		div3.style.display="none";
		div4.style.display="block";
	};
};


	

