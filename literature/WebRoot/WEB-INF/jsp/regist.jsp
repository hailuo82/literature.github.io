<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>注 册</title>
	<link href="${pageContext.request.contextPath}/css/register.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lufylegend-1.8.8.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/welcome.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/regist_check.js"></script>
</head>
<body>
	<%--头部 --%>
	<%@ include file="top_nav.jsp" %>
	<%-- 动画 --%>
	<div id="legend"></div>
	
	<div class="container register">
		<div class="span24">
			<div class="wrap">
				<form id="registerForm" action="${pageContext.request.contextPath}/user_regist"  method="post" novalidate="novalidate" onsubmit="return checkForm();">
					<table>
						<tbody>
							<tr>
								<th>
									<span class="requiredField">*</span>用户名:
								</th>
								<td>
									<input type="text" id="username" name="username" class="text" maxlength="20" placeholder="用户名长度在3-12为之间" title="用户名长度在3-12为之间" value="${username}" >
									    &nbsp;<span id="u"><font color="#ccc">用户名必须是数字、字母和下划线</font></span>
									    <span style="color:red;"><s:fielderror fieldName="username"/></span>
									    
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>密&nbsp;&nbsp;码:
								</th>
								<td>
									<input type="password" id="password" name="password" class="text" placeholder="密码长度必须在6-12位之间" value="${password}" title="密码长度必须在6-12位之间" maxlength="20" autocomplete="off"/>
									   &nbsp;<span style="color:red"><s:fielderror fieldName="password"/></span>
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>确认密码:
								</th>
								<td>
									<input type="password" id="repassword" name="repassword" class="text"  maxlength="20" autocomplete="off"/>
									   &nbsp;<span id="r" style="color:red;"></span> 
								</td>
							</tr>
							<tr>
								<th>
									<span class="requiredField">*</span>E-mail:
								</th>
								<td>
									<input type="text" id="email" name="email" class="text" value="${email}" maxlength="200"/>
									  &nbsp;<span id="e" style="color:red;"><s:fielderror fieldName="email"/></span>
								</td>
							</tr>
									<tr>
										<th>
											姓名:
										</th>
										<td>
												<input type="text" name="name" class="text" value="${name}" maxlength="200"/>
										</td>
									</tr>

									<tr>
										<th>
											<span class="requiredField">*</span>电话:
										</th>
										<td>
												<input type="text" id="phone" name="phone" class="text" value="${phone}" onfocus="WdatePicker();"/>
												&nbsp;<span style="color:red;"><s:fielderror fieldName="phone"/></span>
										</td>
									</tr>
									
									<tr>
										<th>
											地址:
										</th>
										<td>
												<input type="text" name="addr" value="${addr}" class="text" maxlength="200"/>
										</td>
									</tr>
								<tr>
									<th>
										<span class="requiredField">*</span>验证码:
									</th>
									<td>
										<span class="fieldSet">
											<input type="text" id="validatecode" name="validatecode" class="text captcha" maxlength="4" autocomplete="off"/>
											<img id="validateimage" class="captchaImage" src="${pageContext.request.contextPath}/codeaction" onclick="changecode()" title="点击更换验证码"/>
										</span>
										<span style="color: red;"><s:fielderror fieldName="registcodefail"/></span>
									</td>
								</tr>
							<tr>
								<th>&nbsp;
									
								</th>
								<td>
									<input type="submit" class="submit" value="立 即 注 册"/>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	
	<%--尾部 --%>
	<%@ include file="bottom.jsp" %>
</body>
</html>

