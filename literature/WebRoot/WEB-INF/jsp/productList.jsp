<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>literature show</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>
  <script type="text/javascript">
       //传递当前页和cid
       function gotopage(page,cid){
    	   window.location.href="${pageContext.request.contextPath}/product_findByCid?page="+page+"&cid="+cid+"";
       }
  </script>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.jpg" type="image/x-icon" />  
<script>
    createSnow('', 60);
</script>
</head>
<body>
	<%--头部 --%>
	<%@ include file="top.jsp" %>
	
<div class="container productList">
		<div class="span6">
			<div class="hotProductCategory">
			    <s:iterator var="c" value="#session.clist.list">
						<dl> 
							<dt>
								<a href="${pageContext.request.contextPath}/product_findByCid?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a>
							</dt>
					        <s:iterator var="cs" value="#session.cslist.list">
								<dd>
									<a href="${pageContext.request.contextPath}/product_findByCsid?csid=<s:property value="#cs.csid"/>&page=1"><s:property value="#cs.csname"/></a>
								</dd>
							</s:iterator>
						</dl>
				</s:iterator>	
			</div>
		</div>
		<div class="span18 last">
			<div id="result" class="result table clearfix">
				<ul>
				   <s:iterator value="list">
				           <li>
								<a class="alltext" href="${pageContext.request.contextPath}/product_findByPid?pid=${pid}">
									<img src="${pageContext.request.contextPath}/${image}" width="140" height="190"  style="display:inline-block;"/>
									
									<h3 class="pname">
									    ${pname}
									</h3>
									<span class="author">
										&nbsp;作者：${author}
									</span>
									<span class="pdesc">
										${pdesc}
									</span>
								</a>
								<a name="readurl" class="read" href="${pageContext.request.contextPath}/product_findByPid?pid=${pid}">点击阅读</a>
								<s:if test="#session.session_user == null">
									<a class="collect" href="${pageContext.request.contextPath}/user_loginUI.action">收 藏</a>
								</s:if>
								<s:else>
									<a class="collect" href="${pageContext.request.contextPath}/collect_add.action?uid=${sessionScope.session_user.uid}&pid=${pid}">收 藏</a>
								</s:else>
							</li>
					</s:iterator>	
				</ul>
			</div>
				
	<%--显示分页 =====================================================================--%>			
	
	<div class="pagination">
	      <span style="color:#666;">第${page}页/共${pageCount}页</span>
	       <s:if test="page != 1">
		        <%--跳转到首页 --%>
				<a href="javascript:gotopage(1,${cid})" class="firstPage">&nbsp;</a>
				
				<%--上一页 --%>
				<a href="javascript:gotopage(${page}-1,${cid})" class="previousPage">&nbsp;</a>
		   </s:if>	  
			  <s:iterator var="num" begin="%{beginIndex}" end="%{endIndex}">
				<s:if test="#num == page">
				   <span class="currentPage">${num}</span>
				</s:if>
				<s:else>
				   <a href="javascript:gotopage(${num},${cid})">${num}</a>
				</s:else>
			  </s:iterator>
           <s:if test="page != pageCount">
			<%--下一页 --%>
			<a href="javascript:gotopage(${page}+1,${cid})" class="nextPage">&nbsp;</a>
			
			<%--跳转到尾页 --%>  
			<a href="javascript:gotopage(${pageCount},${cid})"class="lastPage">&nbsp;</a>
	      </s:if>
	  </div>
	
			
		</div>
	</div>
	<%--尾部 --%>
	<%@ include file="bottom.jsp" %>
</body>
</html>
