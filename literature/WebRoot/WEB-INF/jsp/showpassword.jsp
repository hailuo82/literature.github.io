<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showpassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
   <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/tit.ico" type="image/x-icon" />
  </head>
  
  <body>
  <%--
    <s:if test="#request.password != null">
                       用户名:${username}<br/>
                       密码:${password}
    </s:if>
    <s:else>
       <font style="color: red;"><s:fielderror fieldName="msg"/></font>
    </s:else>
  --%>
  
  <div id="divcontent">
	<table width="850px" border="0" cellspacing="0">
	  <tr>
	    <td style="padding:30px; text-align:center"><table width="60%" border="0" cellspacing="0" style="margin-top:70px">
	      <tr>
	        <td style="width:98"><img src="${pageContext.request.contextPath}/images/IconTexto_WebDev_009.jpg" width="128" height="128" /></td>
	        <td style="padding-top:30px">
	        <font style="font-weight:bold; color:#FF0000">
		       <s:if test="#request.password == null">
		        <s:fielderror/>
		       </s:if>
	        </font>
	        <br/>
	        <br/>
	        <s:else>
	                                 用户名:${username}&nbsp;&nbsp; 密码:${password}
	        </s:else>
	         </td>
	      </tr>
	    </table>
	    <h1>&nbsp;</h1></td>
	    </tr>
	</table>
   </div>
  </body>
</html>
