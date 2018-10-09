<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<title>literature show</title>
<link href="${pageContext.request.contextPath}/css/user.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/collect.js"></script>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.jpg" type="image/x-icon" />  
<script type="text/javascript">
	var msg=${requestScope.msg};
	if(msg!=""){
		alert(msg);
	}
</script>
</head>
<body>
	<%--头部 --%>
	<%@ include file="top_nav.jsp" %>
	
	<!-- 主体页面-->
	<div id="container" class="content t4 content-space content-space2">
		<%--个人中心左部 --%>
		<%@ include file="person_left.jsp" %>
	
		<div class="right">
		        <s:actionmessage/>
			<div class="space-titlebar">
				<h2>当前书架收藏 <span style="color: red;">${sessionScope.collectcount }</span> 本</h2>
	        </div>
	        <ul class="space-tabbar">
	            <li><a id="newread" href="#">最近阅读<s></s></a></li>
	            <li><a id="mycollection" href="#">我的书架<s></s></a></li>
	        </ul>
	        <s:if test="#session.collectcount == 0">
	        	<h4>&nbsp;收藏夹为空，快去收藏喜欢的书籍吧！</h4>
	        </s:if>
	        <s:else>
		        <table class="book-table pt-a-hover" style="border: 1px solid #ccc;height: 300px; width: 700px;">
		            <thead>
			            <tr>
			                <th width="5%"></th>
			                <th width="15%">作品名</th>
			                <th width="15%">最新更新章节</th>
			                <th width="10%">收藏时间</th>
			                <th width="10%">书签</th>
			                <th width="6%">更新</th>
			                <th width="6%">删除</th>
			                <th width="4%"></th>
			            </tr>
		            </thead>
	            	<tbody>
	                	<tr>
		                    <td class="pt-center"></td>
		                    <td><a href="${pageContext.request.contextPath}/product_findByPid?pid=${pid}" target="_blank">${sessionScope.collectlist[0].pname }</a></td>
		                    <td><a href="#" target="_blank">暂无最新章节</a></td>
		                    <td class="c-9">${sessionScope.collectlist[0].collecttime }</td>
	                        <td class="bookmark-table c-9">无</td>
	                        <td class="bookmark-table c-9">无</td>
	                        <td class="bookmark-table c-9">
	                        	<a href="${pageContext.request.contextPath}/collect_delete.action?ucid=${sessionScope.collectlist[0].ucid}&uid=${sessionScope.session_user.uid}">删除</a>
	                        </td>
						</tr>
	                	<tr>
		                    <td class="pt-center"></td>
		                    <td><a href="${pageContext.request.contextPath}/product_findByPid?pid=${pid}" target="_blank">${sessionScope.collectlist[1].pname }</a></td>
		                    <td><a href="#" target="_blank">暂无最新章节</a></td>
		                    <td class="c-9">${sessionScope.collectlist[1].collecttime }</td>
	                        <td class="bookmark-table c-9">无</td>
	                        <td class="bookmark-table c-9">无</td>
	                        <td class="bookmark-table c-9">
	                        	<a href="${pageContext.request.contextPath}/collect_delete.action?ucid=${sessionScope.collectlist[1].ucid}&uid=${sessionScope.session_user.uid}">删除</a>
	                        </td>
						</tr>
	                	<tr>
		                    <td class="pt-center"></td>
		                    <td><a href="${pageContext.request.contextPath}/product_findByPid?pid=${pid}" target="_blank">${sessionScope.collectlist[2].pname }</a></td>
		                    <td><a href="#" target="_blank">暂无最新章节</a></td>
		                    <td class="c-9">${sessionScope.collectlist[2].collecttime }</td>
	                        <td class="bookmark-table c-9">无</td>
	                        <td class="bookmark-table c-9">无</td>
	                        <td class="bookmark-table c-9">
	                        	<a href="${pageContext.request.contextPath}/collect_delete.action?ucid=${sessionScope.collectlist[2].ucid}&uid=${sessionScope.session_user.uid}">删除</a>
	                        </td>
						</tr>
	                	<tr>
		                    <td class="pt-center"></td>
		                    <td><a href="${pageContext.request.contextPath}/product_findByPid?pid=${pid}" target="_blank">${sessionScope.collectlist[3].pname }</a></td>
		                    <td><a href="#" target="_blank">暂无最新章节</a></td>
		                    <td class="c-9">${sessionScope.collectlist[3].collecttime }</td>
	                        <td class="bookmark-table c-9">无</td>
	                        <td class="bookmark-table c-9">无</td>
	                        <td class="bookmark-table c-9">
	                        	<a href="${pageContext.request.contextPath}/collect_delete.action?ucid=${sessionScope.collectlist[3].ucid}&uid=${sessionScope.session_user.uid}">删除</a>
	                        </td>
						</tr>
	                	<tr>
		                    <td class="pt-center"></td>
		                    <td><a href="${pageContext.request.contextPath}/product_findByPid?pid=${pid}" target="_blank">${sessionScope.collectlist[4].pname }</a></td>
		                    <td><a href="#" target="_blank">暂无最新章节</a></td>
		                    <td class="c-9">${sessionScope.collectlist[4].collecttime }</td>
	                        <td class="bookmark-table c-9">无</td>
	                        <td class="bookmark-table c-9">无</td>
	                        <td class="bookmark-table c-9">
	                        	<a href="${pageContext.request.contextPath}/collect_delete.action?ucid=${sessionScope.collectlist[4].ucid}&uid=${sessionScope.session_user.uid}">删除</a>
	                        </td>
						</tr>
					</tbody>
	        	</table>
	        </s:else>
		</div>
	</div>
	
	
	<%--尾部 --%>
	<%@ include file="bottom.jsp" %>
</body>
</html>