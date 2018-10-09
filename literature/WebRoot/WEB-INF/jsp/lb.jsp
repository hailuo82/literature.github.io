<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 代码 开始 -->
  <div id="playBox">
    <div class="pre"></div>
    <div class="next"></div>
    <div class="smalltitle">
      <ul>
        <li class="thistitle"></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
      </ul>
    </div>
    <ul class="oUlplay">
       <li><a href="${pageContext.request.contextPath}/product_findByCid?cid=2&page=1"><img src="${pageContext.request.contextPath}/images/book2.jpg"/></a></li>
       <li><a href="${pageContext.request.contextPath}/product_findByCid?cid=1&page=1"><img src="${pageContext.request.contextPath}/images/book3.jpg"/></a></li>
       <li><a href="${pageContext.request.contextPath}/product_findByCid?cid=3&page=1"><img src="${pageContext.request.contextPath}/images/book12.jpg"/></a></li>
       <li><a href="${pageContext.request.contextPath}/product_findByCid?cid=18&page=1"><img src="${pageContext.request.contextPath}/images/book1.jpg"/></a></li>
       <li><a href="${pageContext.request.contextPath}/product_findByCid?cid=17&page=1"><img src="${pageContext.request.contextPath}/images/book14.jpg"/></a></li>
       <li><a href="${pageContext.request.contextPath}/product_findByCid?cid=21&page=1"><img src="${pageContext.request.contextPath}/images/book13.jpg"/></a></li>
    </ul>
  </div>
<!-- 代码 结束 -->

