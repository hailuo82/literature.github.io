<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
  <link href="${pageContext.request.contextPath}/css/nav_top.css" rel="stylesheet" type="text/css"/>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
  <script type="text/javascript">
  $(document).ready(function() {	

  	jQuery.jqsxfg51nav = function(jqsxfg51navhover) {
  		$(jqsxfg51navhover).prepend("<span></span>"); 
  		
  		$(jqsxfg51navhover).each(function() { 
  			var linkText = $(this).find("a").html(); 
  			$(this).find("span").show().html(linkText); 
  		}); 
  		
  		$(jqsxfg51navhover).hover(function() {	
  			$(this).find("span").stop().animate({ 
  				marginTop: "-40" 
  			}, 250);
  		} , function() { 
  			$(this).find("span").stop().animate({
  				marginTop: "0" 
  			}, 250);
  		});	
  	};
  	//下面是调用方法，一个页面也可以调用很多次
  	$.jqsxfg51nav("#menu2 li");
  });
   
  </script>
</head>
<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
			  <s:if test="#session.session_user == null">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/user_loginUI.action">登录</a>|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/user_registUI.action">注册</a>|
				</li>
			  </s:if>	
			  
			  <s:else>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					${sessionScope.session_user.username}|
				</li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/order_findByUid?page=1">我的订单</a>|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/user_exit.action">退出</a>|
				</li>
			  </s:else>
				<li><a>会员中心</a>|</li>
				<li><a>购物指南</a>|</li>
				<li><a>关于我们</a></li>
			</ul>
		</div>
		<div class="cart">
			<a  href="${pageContext.request.contextPath}/cart_findCart">购物车</a>
		</div>
			<div class="phone">
				客服热线:
				<strong>96008/53277764</strong>
			</div>
	</div>
	<div class="span24">
		
		<div id="menu2">
	         <ul>
		      <li><a href="${pageContext.request.contextPath}/index">首页</a></li>
		     <s:iterator value="#session.cList" var="c">
	          <li><a href="${pageContext.request.contextPath}/product_findByCid?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a></li>
	         </s:iterator>
	        </ul>
       </div>
	</div>
	
	<%-- 
	<input type="text" onkeyup="suggestion(this.value)"/>
	<span id="s"></span>
	--%>