<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>找回密码</title>

<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css" />
<link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/forget.js"></script>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/tit.ico" type="image/x-icon" />
</head>
<body>
	<%--头部 --%>
	<%@ include file="top_nav.jsp" %>

<div>
	<div class="wrap">
		<div class="main">
        	<%--显示错误信息 --%>
			<font style="color:red;text-align:center;"><b><s:fielderror fieldName="login_fail"/></b></font>
			<font style="color:red;text-align:center;"><b><s:actionerror /></b></font>
			<span style="color:red;font-weight:bold;text-align:center;"><s:fielderror fieldName="msg"/></span>
			
			<form id="loginForm" action="${pageContext.request.contextPath}/user_forget.action" onsubmit="return check();" method="post" novalidate="novalidate" >
				<table style="margin-top: 100px;">
					<tbody>
						 <tr>
							<th>
									用户名:
							</th>
							<td>
								<input type="text" id="username" name="username" value="${username }" class="text" maxlength="20"/>
								<span id="u"></span>
							</td>
						</tr>
						<tr>
							<th>
									邮箱:
							</th>
							<td>
								<input type="text" id="email" name="email" value="${email }" class="text" maxlength="20"/>
								<span id="e"></span>
							</td>
						</tr>
						<tr>
							<th>
								验证码:
							</th>
							<td>
								<span class="fieldSet">
									<input type="text" id="validatecode" name="validatecode" class="text captcha" maxlength="4" autocomplete="off"/>
									<img id="validateimage" class="captchaImage" src="${pageContext.request.contextPath}/codeaction" onclick="changecode()" title="点击更换验证码"/>
								</span>
								<span id="c" style="color:red;font-weight:bold;"><s:fielderror fieldName="forgetcodefail"/></span>
							</td>
						</tr>
						<tr>
							<th>&nbsp;</th>
							<td>
								<input type="submit" class="submit" value="下一步"/>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
			<div id="particles-js"></div>
		
			<script src="js/particles.js"></script>
			<script src="js/app.js"></script>
        </div>
	</div>
</div>
	
<%--尾部 --%>
<%@ include file="bottom.jsp" %>
</body>
</html>