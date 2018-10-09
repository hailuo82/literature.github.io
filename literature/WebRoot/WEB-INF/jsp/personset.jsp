<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<title>literature show</title>
<link href="${pageContext.request.contextPath}/css/user.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/user.js"></script>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.jpg" type="image/x-icon" />  

</head>
<body>
	<%--头部 --%>
	<%@ include file="top_nav.jsp" %>
	
	<!-- 主体页面-->
	<div id="container" class="content t4 content-space content-space2">
		<%--个人中心左部 --%>
		<%@ include file="person_left.jsp" %>
	
		<div class="right">
			<h3 style="margin: 0 0 20px 20px;">个人设置</h3>
	        <ul class="space-tabbar">
	            <li><a href="#" class="current2" id="update">修改资料<s></s></a></li>
	            <li><a href="#" class="current2" id="updatepw">修改密码<s></s></a></li>
	            <li><a href="#" class="current2" id="updatephone">绑定手机<s></s></a></li>
	        </ul>
	        <div class="set" id="setupdate">
	            <form action="${pageContext.request.contextPath}/user_personSet.action" method="post">
	            		<input type="hidden" value="${sessionScope.person_user.uid }" />
		                <dl>
		                    <dt>账号</dt>
                    		<dd>${sessionScope.person_user.username}</dd>
		                    <dt>姓名</dt>
		                    <dd>
		                    	<input type="text" id="name" name="name" value="${sessionScope.person_user.name}" />
		                    </dd>
		                    <br/>
		                    <dt>邮箱</dt>
		                    <dd>
		                    	<input type="text" id="email" name="email" value="${sessionScope.person_user.email}" />
		                    </dd>
		                    <br/>
		                    <dt>省市</dt>
		                    <dd>
		                        <input type="text" id="addr" name="addr" value="${sessionScope.person_user.addr}" />
		                    </dd>
		                </dl>
	                <div class="btns">
	                    <button id="submit" class="but" type="submit">提交</button>
	                </div>
	            </form>
        	</div>
            <div class="set" id="setupdatepw">
            	<form action="${pageContext.request.contextPath}/user_personSetPassword.action" method="post" onsubmit="return checkform()">
	                <dl>
	                    <dt>账号</dt>
                    		<dd>${sessionScope.person_user.username}</dd>
	                    <dt>原密码</dt>
	                    <dd>
	                    	<input type="password" id="oldpassword" name="oldpassword" />
	                    	<span id="u"></span>
	                    </dd>
	                    <br/>
	                    <dt>新密码</dt>
	                    <dd>
	                    	<input type="password" id="newpassword" name="password" />
	                    </dd>
	                    <br/>
	                    <dt>确认密码</dt>
	                    <dd>
	                        <input type="password" id="newpassword2" name="newpassword2" />
	                    </dd>
	                </dl>
	                <div class="btns">
	                    <button id="submit" class="but" type="submit">提交</button>
	                </div>
	            </form>
            </div>
            <div class="set" id="setupdatephone">
            	<form action="${pageContext.request.contextPath}/user_personSetPhone.action" method="post" onsubmit="return checkMobile()">
	                <dl>
	                    <dt>账号</dt>
                    		<dd>${sessionScope.person_user.username}</dd>
	                    <dt>手机号</dt>
	                    <dd>
	                    	<input type="text" id="phone" name="phone" value="${sessionScope.person_user.phone}" maxlength="11" />
	                    </dd>
	                </dl>
	                <div class="btns">
	                    <button id="submit" class="but" type="submit">提交</button>
	                </div>
	            </form>
            </div>
	    </div>
	</div>
	
	
	<%--尾部 --%>
	<%@ include file="bottom.jsp" %>
</body>

<script type="text/javascript">
	function checkform(){ //验证输入的密码
		var pw=document.getElementById("oldpassword").value;
		if(pw == null||pw == "") {
			alert("原密码不能为空！");
			return false;
		}
	
		var newp=document.getElementById("newpassword").value;
		if(newp == null||newp == "") {
			alert("新密码不能为空！");
			return false;
		}
		if(newp.length<6 || newp.length>12) {
			alert("密码长度必须在6~12位之间！");
		}
	
		var newp2=document.getElementById("newpassword2").value;
		if(newp2 == null||newp2 == "") {
			alert("确认密码不能为空！");
			return false;
		}
		if(newp2.length<6 || newp2.length>12) {
			alert("密码长度必须在6~12位之间！");
		}
		if(newp != newp2){
			alert("两次输入的密码不相同，请验证后重新输入！");
			return false;
		}
	}
	
	function checkMobile(){ 
		var sMobile = document.getElementById("phone").value;
		if(sMobile == null || sMobile == "") {
			alert("请输入手机号码！");
			return false;
		}
		if(sMobile.length<11) {
			alert("手机号码输入错误！");
			return false;
		}
		if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(sMobile))){ 
			alert("手机号码输入错误！"); 
			return false; 
		} 
} 
</script>
</html>