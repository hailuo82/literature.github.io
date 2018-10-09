window.onload = function() {

	var newread = document.getElementById("newread");
	var collection = document.getElementById("mycollection");

	collection.setAttribute("class", "current");

	collection.onclick = function() {
		collection.setAttribute("class", "current");
		newread.setAttribute("class", "current2");
	};

	newread.onclick = function() {
		collection.setAttribute("class", "current2");
		newread.setAttribute("class", "current");
	};
	
};