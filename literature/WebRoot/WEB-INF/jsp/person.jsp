<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<title>literature show</title>
<link href="${pageContext.request.contextPath}/css/user.css" rel="stylesheet" type="text/css"/>
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
			<h3 style="margin: 0 0 20px 20px;">我的账户</h3>
		        <div class="set" id="setupdate">
	                <dl>
	                <s:iterator value="person_user" var="puser">
	                    <dt>账号</dt>
	                    <dd>${puser.username}</dd>
	                    <dt>姓名</dt>
	                    <s:if test="#puser.name==null">
		                    <dd>
		                    	未填写
		                    </dd>
	                    </s:if>
	                    <s:else>
	                    	<dd>
		                    	${puser.name }
		                    </dd>
	                    </s:else>
	                    <dt>手机</dt>
	                    <dd>
	                    	${puser.phone }
	                    </dd>
	                    <dt>邮箱</dt>
	                    <dd>
	                    	${puser.email }
	                    </dd>
	                    <dt>省市</dt>
	                    <dd>
	                        <s:if test="#puser.addr==null">
			                    <dd>
			                    	未填写
			                    </dd>
		                    </s:if>
		                    <s:else>
		                    	<dd>
			                    	${puser.addr }
			                    </dd>
		                    </s:else>
	                    </dd>
                    </s:iterator>
	                </dl>
	        	</div>
        	</div>
       	</div>

	<%--尾部 --%>
	<%@ include file="bottom.jsp" %>
</body>
</html>