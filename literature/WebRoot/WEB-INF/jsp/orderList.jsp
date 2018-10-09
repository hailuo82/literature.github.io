<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<title>我的订单页面</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>
  <script type="text/javascript">
       //传递当前页
       function gotopage(page){
    	   window.location.href="${pageContext.request.contextPath}/order_findByUid?page="+page+"";
       }
  </script>
 <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/tit.ico" type="image/x-icon" />
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
<div class="container cart">

		<div class="span24">
		
			<div class="step step1">
				<ul>
					<li  class="current"></li>
					<li style="line-height:60px; font-size:15px; font-weight:bold;">我的订单</li>
				</ul>
			</div>
		    
				<table>
				 <s:iterator value="list" var="o">
					<tbody>	
					<tr>
					  <th colspan="6">
					              订单编号：${o.oid}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					             订单状态:
					    <s:if test="#o.state == 1">
					       <a href="${pageContext.request.contextPath}/order_findByOid?oid=${o.oid}"><font color="red">付款</font></a>
					    </s:if>  
					    <s:if test="#o.state == 2">已经付款</s:if>  
					    <s:if test="#o.state == 3">
					      <a href="${pageContext.request.contextPath}/order_editOrder?oid=${o.oid}"><font color="red"> 确认收货</font></a>
					    </s:if>  
					    <s:if test="#o.state == 4">交易完成</s:if>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单时间：${o.ordertime}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					         订单总计:${o.total}
					  </th>
					</tr>
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>评价</th>
					</tr>
					  <s:iterator value="#o.orderItems" var="orderItems">
						<tr>
							<td width="60">
								<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#orderItems.product.pid"/>">
								  <img src="${pageContext.request.contextPath}/<s:property value="#orderItems.product.image"/>"/>
								</a>
							</td>
							<td>
								<a target="_blank"><s:property value="#orderItems.product.pname"/></a>
							</td>
							<td>
								<s:property value="#orderItems.product.shop_price"/>
							</td>
							<td class="quantity" width="60">
							    <s:property value="#orderItems.count"/>
							</td>
							<td width="140">
								<span class="subtotal">￥<s:property value="#orderItems.subtotal"/></span>
							</td>
							<td width="60">
                               <span class="subtotal">
								   <s:if test="#orderItems.osatate == 1">
								        <a href="${pageContext.request.contextPath}/evaluate_findByPid?pid=<s:property value="#orderItems.product.pid"/>&itemid=<s:property value="#orderItems.itemid"/>">去评价</a>  
								   </s:if>
								   <s:elseif test="#orderItems.osatate == 3">评价成功</s:elseif>
								   <s:else>暂无操作</s:else>
								</span>
							</td>
						</tr>
					</s:iterator>
				  </tbody>
				</s:iterator>
			</table>
			<%--显示分页 --%>
			<div class="pagination">
			  <span style="color:#666;">第${page}页/共${pageCount}页</span>
				    <s:if test="page != 1">
				        <%--跳转到首页 --%>
						<a href="javascript:gotopage(1)" class="firstPage">&nbsp;</a>
						
						<%--上一页 --%>
						<a href="javascript:gotopage(${page}-1)" class="previousPage">&nbsp;</a>
				   </s:if>	  
				  <s:iterator var="num" begin="%{beginIndex}" end="%{endIndex}">
					<s:if test="#num == page">
					   <span class="currentPage">${num}</span>
					</s:if>
					<s:else>
					   <a href="javascript:gotopage(${num})">${num}</a>
					</s:else>
				  </s:iterator>
				    <s:if test="page != pageCount">
					<%--下一页 --%>
					<a href="javascript:gotopage(${page}+1)" class="nextPage">&nbsp;</a>
					
					<%--跳转到尾页 --%>  
					<a href="javascript:gotopage(${pageCount})"class="lastPage">&nbsp;</a>
				   </s:if>
			
			</div>
		</div>
		
	</div>
  <%@ include file="bottom.jsp" %>

 </body>
</html>


