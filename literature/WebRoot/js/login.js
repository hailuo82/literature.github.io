//这里主要是获取用户的state(状态)
function getState(){
	var username = document.getElementById("username").value;
	// 1.获取异步交互对象
	var xmlhttp = createXMLHttpRequest();
	// 2.设置监听
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			if(xmlhttp.responseText == 1){
				document.getElementById("state").value = xmlhttp.responseText;
				//return;
			}
			//document.getElementById("u").innerHTML = xmlhttp.responseText;
		}
	};
	// 3.打开连接(为了避免浏览器的缓存，需要加一个时间参数)
	xmlhttp.open("GET","${pageContext.request.contextPath}/user_getState?a="+ new Date().getTime()+"&username="+username+"", true);
	// 4.发送请求
	xmlhttp.send(null);
}

// 创建XMLHttpRequest对象
function createXMLHttpRequest() {
	try {
		return new XMLHttpRequest();
	} catch (e) {
		try {
			return new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				return new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("你用什么浏览器呢？");
				throw e;
			}
		}
	}
};

//登录表单的非空校验
function check(){
	var username = document.getElementById("username").value;
	if(username == null || username ==""){
		alert("用户名不能为空");
		return false;
	}
	var password = document.getElementById("password").value;
	if(password == null || password ==""){
		alert("密码不能为空");
		return false;
	}
	var validatecode = document.getElementById("validatecode").value;
	if(validatecode == null || validatecode ==""){
		alert("验证码不能为空");
		return false;
	}
}

//切换验证码
function changecode(){
	var img = document.getElementById("validateimage");
	img.src = "${pageContext.request.contextPath}/codeaction?a="+new Date().getTime();
}




