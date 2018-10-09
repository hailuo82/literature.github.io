<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>登录</title>

<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css" />
<link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
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
			
			<form id="loginForm" action="${pageContext.request.contextPath}/user_login" onsubmit="return check();" method="post">
				<%--传用户的状态 ,通过ajax获取--%>
				<input type="hidden" name="state" id="state"/>
				<table>
					<tbody>
						<tr>
							<th>
									用户名:
							</th>
							<td>
								<input type="text" id="username" onblur="getState()"  name="username" class="text" maxlength="20"/>
								<span id="u" style="color:red;font-weight:bold;"></span>
							</td>
						</tr>
						<tr>
							<th>
								密&nbsp;&nbsp;码:
							</th>
							<td>
								<input type="password" id="password" name="password"  class="text" maxlength="20" autocomplete="off"/>
								<span id="p" style="color:red; font-weight:bold;"></span>
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
									<span id="c" style="color:red;font-weight:bold;"><s:fielderror fieldName="logincodefail"/></span>
								</td>
							</tr>
						<tr>
							<th>&nbsp;
								
							</th>
							<td>
								<label>
									<a href="${pageContext.request.contextPath}/user_registUI.action">立即注册</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/user_forgetUI.action">找回密码</a>
								</label>
							</td>
						</tr>
						<tr>
							<th>&nbsp;
								
							</th>
							<td>
								<input type="submit" class="submit" value="登 录"/>
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