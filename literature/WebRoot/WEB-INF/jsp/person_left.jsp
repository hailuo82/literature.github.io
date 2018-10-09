<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/css/user.css" rel="stylesheet" type="text/css"/>


<div class="left">
    <ul id="client-nav" class="sidebar current">
        <li>
            <a id="left1" href="${pageContext.request.contextPath}/user_person.action" class="current"><i></i>我的账户</a>
        </li>
        <li>
            <a id="left2" href="${pageContext.request.contextPath}/collect_findByUid.action?uid=${sessionScope.session_user.uid}" class="current"><i></i>我的书架</a>
        </li>
        <li>
            <a id="left3" href="#" class="current"><i></i>我的足迹</a>
        </li>
        <li>
            <a id="left4" href="${pageContext.request.contextPath}/user_personSetUI.action" class="current"><i></i>个人设置</a>
        </li>
    </ul>
</div>