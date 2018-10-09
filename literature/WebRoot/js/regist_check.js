	//注册表单的非空校验
	function checkForm() {
		var username = document.getElementById("username").value;
	
		if (username == null || username == "") {
			alert("用户名不能为空");
			return false;
		}
	
		var password = document.getElementById("password").value;
		if (password == null || password == "") {
			alert("密码不能为空");
			return false;
		}
	
		var repassword = document.getElementById("repassword").value;
		if (repassword == null || repassword == "") {
			alert("确认密码不能为空");
			return false;
		}
		if (repassword != password) {
			alert("两次密码输入不一致");
			return false;
		}
	
		var email = document.getElementById("email").value;
		if (email == null || email == "") {
			alert("邮箱不能为空");
			return false;
		}
		var phone = document.getElementById("phone").value;
		if (phone == null || phone == "") {
			alert("电话不能为空");
			return false;
		}
		var validatecode = document.getElementById("validatecode").value;
		if (validatecode == null || validatecode == "") {
			alert("验证码不能为空");
			return false;
		}
	}
	
	// ajax校验用户名是否存在
	function checkUserName() {
		var username = document.getElementById("username").value;// 获取用户名
		// 1.获取异步交互对象
		var xmlhttp = createXMLHttpRequest();
		// 2.设置监听
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("u").innerHTML = xmlhttp.responseText;// 显示从数据库中查找的信息
			}
		};
		// 3.打开连接(为了避免浏览器的缓存，需要加一个时间参数)
		xmlhttp.open("GET","${pageContext.request.contextPath}/user_findByUsername?a="+ new Date().getTime()+"&username="+username+"", true);
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
	//切换验证码
	function changecode(){
		var img = document.getElementById("validateimage");
		img.src = "${pageContext.request.contextPath}/codeaction.action?a="+new Date().getTime();
	}
	
	
	
	
	
	
	
	