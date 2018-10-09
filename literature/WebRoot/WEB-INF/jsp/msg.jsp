<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息页</title>
<style type="text/css">
#divcontent_table{
	margin-left: 350px;
}
</style>
</head>
<body>
	<%--头部 --%>
	<%@ include file="top.jsp" %>
		
	<div id="divcontent">
	<table id="divcontent_table" width="850px" align="center" border="0" cellspacing="0">
	  <tr>
	    <td style="padding:30px; text-align:center"><table width="60%" border="0" cellspacing="0" style="margin-top:70px">
	      <tr>
	        <td style="width:98"><img src="${pageContext.request.contextPath}/images/IconTexto_WebDev_009.jpg" width="128" height="128" /></td>
	        <td style="padding-top:30px"><font style="font-weight:bold; color:#FF0000">
		        <s:actionmessage/>
		        <s:actionerror/>
		        <s:fielderror/>
	        </font>
	        <br />
	            <br />
	          <a href="${ pageContext.request.contextPath }/index.action">首页</a>
	          <a href="${ pageContext.request.contextPath }/user_registUI.action">注册</a>
	          <a href="${ pageContext.request.contextPath }/user_loginUI.action">登录</a>
	          <font style="color:green;">${msg}</font>
	         </td>
	      </tr>
	    </table>
	    <h1>&nbsp;</h1></td>
	    </tr>
	</table>
	</div>
	
	<%@ include file="bottom.jsp" %>
</body>
</html>