<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>literature show</title>
<meta http-equiv=Content-Type content="text/html; charset=utf-8" />
<script type="text/javascript">
  //js对表单的非空校验
  function validate(){
	  var username = document.getElementById("username").value;
	  if(username == null || username == ""){
		  alert("用户名不能为空");
		  return false;
	  }
	  var password = document.getElementById("password").value;
	  if(password == null || password == ""){
		  alert("密码不能为空");
		  return false;
	  }
  }
  
  // 登陆的点击事件
  function loginAdmin(){
  	document.getElementById("loginForm").submit();
  }

</script>

<style type=text/css>
	body {
		FONT-SIZE: 12px;
		COLOR: #ffffff;
		FONT-FAMILY: 宋体
	}
	
	td {
		FONT-SIZE: 12px;
		COLOR: #ffffff;
		FONT-FAMILY: 宋体
	}
	.errorMessage {
	 	list-style:none;
	}
	
	.loginbutton {
		height: 36px;
		width: 100px;
		line-height: 36px;
		padding: 0px 4px;
		font-size: 16px;
		color: #fff;
		vertical-align: middle;
		border: 1px solid #fff;
		border-radius:5px;
		background: RGB(0, 110, 212);
		cursor:pointer;
	}
</style>

</head>
<body>
	<form id="loginForm" method="post" action="${pageContext.request.contextPath}/adminuser_login.action" target="_parent" name='theForm' onsubmit="return validate();">

		<div>

			<div>&nbsp;&nbsp;</div>
			<div>
			<font color="red" style="text-align:center;"><s:actionerror /></font>
				<table cellSpacing="0" cellPadding="0" width=900 align=center border=0>
					<tbody>
						<tr>
							<td style="HEIGHT: 105px">
								<img src="${pageContext.request.contextPath }/images/login_1.jpg" border=0 />
							</td>
						</tr>
						<tr>
							<td background="${pageContext.request.contextPath }/images/login_2.jpg" height=300>
								<table height=300 cellPadding=0 width=900 border=0>
									<tbody>
										<tr>
											<td colSpan=2 height=35></td>
										</tr>
										<tr>
											<td width=360></td>
											<td> 
												<table cellSpacing=0 cellPadding=2 border=0>
													<tbody>
														<tr>
															<td style="HEIGHT: 28px" width=80>登 录 名：</td>
															<td style="HEIGHT: 28px" width=150>
																<input id=username style="WIDTH: 130px" name=username />
															</td>
														</tr>
														<tr>
															<td style="HEIGHT: 28px">登录密码：</td>
															<td style="HEIGHT: 28px">
																<input id=password style="WIDTH: 130px" type=password name=password />
															</td>
														</tr>
														<tr>
															<td></td>
															<td>
																<input class="loginbutton" value="登录系统" type="button" onclick="loginAdmin()"/>
															</td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<img src="${pageContext.request.contextPath }/images/login_3.jpg" border=0 />
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</form>
</body>
</html>