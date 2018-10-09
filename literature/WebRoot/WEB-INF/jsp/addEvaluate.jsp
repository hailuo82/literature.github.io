<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>评价页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/evaluate.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/tit.ico" type="image/x-icon" />
    <script type="text/javascript">
       function check1(){
    	   document.getElementById("alert_content").innerHTML = "亲，谢谢你给的好评哦！";
       }
       function check2(){
    	   document.getElementById("alert_content").innerHTML = "亲，给个好评吧！";
       }
       function check3(){
    	   document.getElementById("alert_content").innerHTML = "亲，你真的要狠心给差评吗？";
       }
       function checknull(){
    	   var con = document.getElementById("con").value;
    	   if(con == "" || con == null){
    		   alert("亲，你还没写评价内容呢");
    		   return false;
    	   }

       }
    </script>
    
  </head>
  
 <body>
 <div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="${pageContext.request.contextPath}/index">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo2.gif" alt="seven商城"/>
			</a>
		</div>
	</div>
	<div class="span9">
		<div class="headerAd">
			<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
		</div>	
   </div>
   
   <%@ include file="menu.jsp" %>
	
</div>	
<form action="${pageContext.request.contextPath}/evaluate_saveEval" method="post" onsubmit="return checknull();">
<%--商品的pid --%>
<input type="hidden" name="itemid" value='<s:property value="itemid"/>'/><%--传递订单项 --%>
<input type="hidden" name="product.pid" value='<s:property value="product.pid"/>'/><%--传递评价对应的商品，以便于保存 --%>
<input type="hidden" name="pid" value='<s:property value="product.pid"/>'/><%--传递商品的id，用于查找订单项 --%>
<div class="evaluate">
	<div class="evaluate_top">
		<div class="evaluate_top_left">
		评价商品
		</div>
		<div class="evaluate_top_right">
			<div class="evaluate_top_right_top">
				卖家：&nbsp;<font style="color: #5691CD;">Seven商城</font>&nbsp;&nbsp;&nbsp;
			</div>
			<div class="evaluate_top_right_end"></div>
		</div>
	</div>
	<div class="evaluate_end">
		<div class="evaluate_end_left">
			<span><img width="130px" height="140px" src="${pageContext.request.contextPath}/<s:property value="product.image"/>"></span>
			<span class="pname"><s:property value="product.pname"/></span>
		</div>
		<div class="evaluate_end_right">
			<div class="evaluate_end_right_top">
				<input id="radio1" type="radio" name="title" onclick="check1()" value="好评"><img width="25px" height="25px" src="${pageContext.request.contextPath}/images/good_eval.png">&nbsp;&nbsp;
				<input id="radio2" type="radio" name="title" onclick="check2()" value="中评"><img width="25px" height="25px" src="${pageContext.request.contextPath}/images/mid_eval.png">&nbsp;&nbsp;
				<input id="radio3" type="radio" name="title" onclick="check3()" value="差评"><img width="25px" height="25px" src="${pageContext.request.contextPath}/images/bad_eval.png">&nbsp;&nbsp;
				<span id="alert_content" style="margin-left:50px;"></span>
			</div>
			<div class="evaluate_end_right_mid">
				<textarea id="con" rows="8" cols="88" name="content"></textarea>
			</div>
			<div class="evaluate_end_right_end">
			 <input type="submit" class="button gray" value="立即评价"/>
			</div>
		</div>
	</div>
</div>
</form>
  <%@ include file="bottom.jsp" %>
 </body>
  </body>
</html>
