<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>literature show</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/lbstyle.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lb.js"></script>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.jpg" type="image/x-icon" />  
</head>

<body>
	<%--头部 --%>
	<%@ include file="top.jsp" %>

	<%--图片轮播 --%>
	<%@ include file="lb.jsp" %>
				  
		<!-- 频道推荐板块-->
		<!-- 最热作品 -->
		<div class="channelWrap mb20 cf">
			<div class="leftBox fl">
				<div class="channelTitle cf">
					<div class="recLink fr">
						<ul>
							<s:iterator var="hr" value="#hotrightlist.list">
								<li style="display: inline;overflow: hidden;">
									<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#hr.pid" />" target="_blank"><s:property value="#hr.pname"/></a>
									<span class="navline">|</span>
								</li>
							</s:iterator>
						</ul>
					</div>
					<h3>最热作品</h3>
				</div>
				<div class="recBookWrap cf">
					<div class="bigBook fl">
						<ul style="display: block;">
						   <s:iterator var="hot" value="#hotlist.list">
						   	<li>
						   		<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#hot.pid" />" target="_blank">
						   			<img src="${pageContext.request.contextPath}/<s:property value="#hot.image" />" style="display: block;" />
									<h4>
										《<s:property value="#hot.pname"/>》
									</h4>
						   		</a>
						   		
								<p><s:property value="#hot.pdesc"/></p>
	                        </li>
	                       </s:iterator>
						</ul>
					</div>
					<div class="otherBook fl">
						<ul>
						   <s:iterator var="secondhot" value="#secondhotlist.list">
						   	<li>
						   		<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#secondhot.pid" />" target="_blank">
						   			<img width="62" height="78" src="${pageContext.request.contextPath}/<s:property value="#secondhot.image" />" style="display: block;" />
						   		</a>
								<div class="otherBookInfo fl">
									<h4>
										<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#secondhot.pid" />" target="_blank">
											《<s:property value="#secondhot.pname"/>》
										</a>
									</h4>
						   			<p>作者：<s:property value="#secondhot.author"/></p>
									<p class="intro"><s:property value="#secondhot.pdesc"/></p>
								</div>
	                        </li>
	                       </s:iterator>
						</ul>
					</div>
				</div>
			</div>
			<div class="rightBox fr">
				<div class="threeTabBox tabSwitch">
					<p>男频排行榜</p>
				</div>
				<!-- 排行列表-->
				<div class="rankListWrap">
					<ul class="rankList rankHover numList tabList">
						<s:iterator var="man" value="#manlist.list" status="status">
						   	<li>
						   		<em><s:property value="#man.popularity" /></em>
								<span class="num3"><s:property value="#status.count" /></span>
						   		<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#man.pid" />" target="_blank">
						   			<s:property value="#man.pname"/>
						   		</a>
	                        </li>
	                	</s:iterator>
					</ul>
				</div>
			</div>
		</div>
		<!-- 最新作品 -->
		<div class="channelWrap mb20 cf">
			<div class="leftBox fl">
				<div class="channelTitle cf">
					<div class="recLink fr">
						<ul>
							<s:iterator var="nr" value="#nrightlist.list">
								<li style="display: inline;overflow: hidden;">
									<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#nr.pid" />" target="_blank"><s:property value="#nr.pname"/></a>
									<span class="navline">|</span>
								</li>
							</s:iterator>
						</ul>
					</div>
					<h3>最新作品</h3>
				</div>
				<div class="recBookWrap cf">
					<div class="bigBook fl">
						<ul style="display: block;">
						   <s:iterator var="n" value="#nList.list">
						   	<li>
						   		<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#n.pid" />" target="_blank">
						   			<img src="${pageContext.request.contextPath}/<s:property value="#n.image" />" style="display: block;" />
									<h4>
										《<s:property value="#n.pname"/>》
									</h4>
						   		</a>
						   		
								<p><s:property value="#n.pdesc"/></p>
	                        </li>
	                       </s:iterator>
						</ul>
					</div>
					<div class="otherBook fl">
						<ul>
						   <s:iterator var="nsecondhot" value="#nsecondlist.list">
						   	<li>
						   		<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#nsecondhot.pid" />" target="_blank">
						   			<img width="62" height="78" src="${pageContext.request.contextPath}/<s:property value="#nsecondhot.image" />" style="display: block;" />
						   		</a>
								<div class="otherBookInfo fl">
									<h4>
										<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#nsecondhot.pid" />" target="_blank">
											《<s:property value="#nsecondhot.pname"/>》
										</a>
									</h4>
						   			<p>作者：<s:property value="#nsecondhot.author"/></p>
									<p class="intro"><s:property value="#nsecondhot.pdesc"/></p>
								</div>
	                        </li>
	                       </s:iterator>
						</ul>
					</div>
				</div>
			</div>
			<div class="rightBox fr">
				<div class="threeTabBox tabSwitch">
					<p>女频排行榜</p>
				</div>
				<!-- 排行列表-->
				<div class="rankListWrap">
					<ul class="rankList rankHover numList tabList">
						<s:iterator var="woman" value="#womanlist.list" status="status">
						   	<li>
						   		<em><s:property value="#woman.popularity" /></em>
								<span class="num3"><s:property value="#status.count" /></span>
						   		<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#woman.pid" />" target="_blank">
						   			<s:property value="#woman.pname"/>
						   		</a>
	                        </li>
	                	</s:iterator>
					</ul>
				</div>
			</div>
		</div>
	
	<%--尾部 --%>
	<%@ include file="bottom.jsp" %>
</body>
</html>