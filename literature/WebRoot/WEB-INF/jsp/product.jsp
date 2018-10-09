<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<title>literature show</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/novel1.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/novel1.js"></script>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.jpg" type="image/x-icon" />  

</head>
<body>
	<%--头部 --%>
	<%@ include file="top.jsp" %>
	
	<div class="layout">
		<div class="bookinfo">
			<div class="bookBox">
				<a name="readurl" href="#">
					<img width="230" height="300" src="${pageContext.request.contextPath}/${model.image}" />
				</a>
			</div>
			<div class="book_info">
				<h1>
					${model.pname}
				</h1>

				<!--作品简介 -->
				<dl>
					<dt>作者：</dt>
						<dd class="w_au">
							${model.author}
						</dd>
					<dt>类型：</dt>
						<dd class="w_aut">
							<a href="#">${model.pid}</a>
						</dd>
					<dt>人气：</dt>
						<dd class="w_auth">${model.popularity}</dd>
					<dt>价格：</dt>
						<dd class="w_auth">${model.shop_price}</dd>
				</dl>
				<dl>
					<dd id="bookIntro" class="book_intro">${model.pdesc}</dd>
				</dl>
				<div class="book_btn">
					<a name="readurl" class="active" href="#">点击阅读</a>
					<s:if test="#session.session_user == null">
						<a class="collect" href="${pageContext.request.contextPath}/user_loginUI.action">收 藏</a>
					</s:if>
					<s:else>
						<a class="collect" href="${pageContext.request.contextPath}/collect_add.action?uid=${sessionScope.session_user.uid}&pid=${model.pid}">收 藏</a>
					</s:else>
          		</div>
			</div>	
        </div>

		<!-- 章节和评论上面空格-->
		<div class="thenews"></div>

		<!-- 章节和评论-->
		<div class="readtab">
        	<div class="read_tab">
        		<ul id="introTab">
        			<li id="zjml" class="zjml" data-listid="chapterListContainer">章节目录</li>
        			<li id="pl active" class="pl active" data-listid="commentListContainer">评论
                    	<span class="f12 fn"></span>
                	</li>
            	</ul>
        	</div>

        	<!-- 章节-->
        	<div id="chapter_list" class="chapter_list" style="display: block;">
        		<div id="chapterList">
        			<div>
        				<ol>
        					<li>
        						<a href="#" title="章节：第1章">1.&nbsp;第1章</a>
        					</li>
        					<li class="pr10">
        						<a href="#" title="章节：第2章 ">2.&nbsp;第2章</a>
        					</li>
        					<li>
        						<a href="#" title="章节：第3章">3.&nbsp;第3章</a>
        					</li>
        					<li class="pr10">
        						<a href="#" title="章节：第4章 ">4.&nbsp;第4章</a>
        					</li>
        					<li>
        						<a href="#" title="章节：第5章">5.&nbsp;第5章</a>
        					</li>
        					<li class="pr10">
        						<a href="#" title="章节：第6章">6.&nbsp;第6章</a>
        					</li>
        					<li>
        						<a href="#" title="章节：第7章 ">7.&nbsp;第7章</a>
        					</li>
        					<li class="pr10">
        						<a href="#" title="章节：第8章">8.&nbsp;第8章</a>
        					</li>
        					<li>
        						<a href="#" title="章节：第9章">9.&nbsp;第9章</a>
        					</li>
        				</ol>
        			</div>
        		</div>
        	</div>

        	<!-- 评论-->
        	<div id="comments_area" class="comments_area" style="display: none;">
        		<div class="comment_form">
        			<textarea class="textarea_normal"></textarea>
        			<div class="textarea_sub">
        				<a class="comment_btn" href="/">发表评论</a>
        			</div>
        		</div>
        		<div class="comments_tab">
        			<a class="comments_tab_act" href="/">全部评论</a>
        		</div>
        		<div class="commentList">
        			<ul class="comments">
        				<li class="comment"></li>
        				<li class="comment"></li>
        				<li class="comment"></li>
        				<li class="comment"></li>
        			</ul>
        		</div>
			</div>
        </div>
	</div>
	
	
	<%--尾部 --%>
	<%@ include file="bottom.jsp" %>
</body>
</html>