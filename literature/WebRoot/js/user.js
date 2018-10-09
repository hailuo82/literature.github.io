window.onload = function() {

	var div1 = document.getElementById("update");
	var div2 = document.getElementById("updatepw");
	var div3 = document.getElementById("updatephone");

	var div4 = document.getElementById("setupdate");
	var div5 = document.getElementById("setupdatepw");
	var div6 = document.getElementById("setupdatephone");

	div1.setAttribute("class", "current");
	div4.style.display = "block";
	div5.style.display = "none";
	div6.style.display = "none";

	div1.onclick = function() {
		div1.setAttribute("class", "current");
		div2.setAttribute("class", "current2");
		div3.setAttribute("class", "current2");
		div4.style.display = "block";
		div5.style.display = "none";
		div6.style.display = "none";
	};
	div2.onclick = function() {
		div1.setAttribute("class", "current2");
		div2.setAttribute("class", "current");
		div3.setAttribute("class", "current2");
		div4.style.display = "none";
		div5.style.display = "block";
		div6.style.display = "none";
	};
	div3.onclick = function() {
		div1.setAttribute("class", "current2");
		div2.setAttribute("class", "current2");
		div3.setAttribute("class", "current");
		div4.style.display = "none";
		div5.style.display = "none";
		div6.style.display = "block";
	};
	
};