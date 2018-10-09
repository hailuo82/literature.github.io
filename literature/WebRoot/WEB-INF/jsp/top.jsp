<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/novel1.css">
<script type="text/javascript">
	function find() {
		document.getElementById("find").submit();
	}
	
	function allCategory() {
		var oall = document.getElementById("all");
		var oheadNavTop = document.getElementById("headNavTop");
		
		oheadNavTop.style.height = '60px';
		oall.onclick = function() {
			oall.style.height = '60px';
		};
		
		oall.onmouseout = function() {
			oall.style.height = '30px';
		};
		
		oheadNavTop.onmouseout = function() {
			oheadNavTop.style.height = '30px';
		};
	}
</script>

<!--顶部导航-->
<div id="topNav" class="topNav">
	<div class="pageCenter">
		<!--顶部左边区块-->
		<div id="topLeft" class="topLeft cf">
			<ul>
				<li class="authority navNormal">
					<a class="topLink" href="${pageContext.request.contextPath}/index">literature show文学·秀</a><b></b>
				</li>
			</ul>
		</div>
		<!--登录前后容器-->
		<div class="loginBox">
			<div class="login_before">
				<span class="navline"></span>
				<ul>
					<s:if test="#session.session_user == null">
						<li id="headerRegister" style="display: list-item;">
							<a class="reg" href="${pageContext.request.contextPath}/user_registUI.action">注册</a>
						</li>
						<li id="headerLogin" style="display: list-item;">
							<a class="login" href="${pageContext.request.contextPath}/user_loginUI.action">登录</a>
						</li>
					</s:if>
					<s:else>
						<li id="headerRegister" style="display: list-item;">
							<a class="reg" href="${pageContext.request.contextPath}/user_exit.action">退出</a>
						</li>
						<li id="headerLogin" style="display: list-item;">
							<a class="login" href="${pageContext.request.contextPath}/user_person.action">${sessionScope.session_user.username}</a>
						</li>
						<div class="topRight">
							<a class="user_center" href="${pageContext.request.contextPath}/user_person.action">个人中心</a>	
							<span class="navline">|</span>
							<a class="book" href="${pageContext.request.contextPath}/collect_findByUid.action?uid=${sessionScope.session_user.uid}">我的书架</a>
							<span class="navline">|</span>
							<a class="pay" href="#" >充值</a>
						</div>
			  		</s:else>
				</ul>
			</div>
		</div>
	</div>
</div>

<!-- 中间模块-->
<div class="pageCenter">
	<!-- 中间的导航栏-->
	<div class="bookheader cf">
		<div class="logo fl">
			<a href="${pageContext.request.contextPath}/index">
				<img class="logo1" alt="literature show" src="${pageContext.request.contextPath}/images/logo.jpg">
			</a>
		</div>
		<div class="titleSearch fl cf">
			<form id="form2" action="${pageContext.request.contextPath}/product_findByName.action" method="post">
				<div class="searchClass">
					<p>搜索</p>
				</div>
				<span></span>
				<input name="pname" type="text" class="clearInput" placeholder="微微一笑很倾城">
				<input type="image" class="searchBtn" onclick="find();return false;" src="${pageContext.request.contextPath}/images/searchBtn.png" />
			</form>
			<div class="hotWords">
				
				<ul>
					热词：
					<s:iterator var="hr" value="#hotrightlist.list">
						<li style="display: inline;overflow: hidden;">
							<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#hr.pid" />" target="_blank"><s:property value="#hr.pname"/></a>
						</li>
					</s:iterator>
				</ul>
			</div>
		</div>
	</div>
	
	<div id="headNavTop" class="headNavTop">
		<div class="pageCenter cf">
			<div class="headNavLeft fl" onmouseover="allCategory()">
				<ul>
					<li class="nav01" style="margin-left: 30px;">
						<a href="${pageContext.request.contextPath}/index">首页</a>
					</li>
					<li class="nav01">
						<span id="all">全部分类</span>
					</li>
					<s:iterator value="#session.cList" var="c">
			          <li class="nav01">
			          	<a href="${pageContext.request.contextPath}/product_findByCid?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a>
			          </li>
			        </s:iterator>
				</ul>
			</div>				
		</div>
	</div>
</div>
	