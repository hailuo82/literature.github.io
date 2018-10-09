<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>

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
								<a class="user_center" href="${pageContext.request.contextPath}/user_person.action">
									个人中心
								</a>	
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
