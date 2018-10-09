<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
          //传递当前页和cid
          function gotopage(page){
    	       window.location.href="${pageContext.request.contextPath}/adminOrder_findByState.action?page="+page+"";
          }
		</script>
	</head>
	<body>
		<br>
		<form id="Form1" name="Form1"  method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" colspan="2" align="center" bgColor="#afd1f3">
							<strong>订单列 表</strong>
						</td>
					</tr>
					<%--
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addproduct()">
							   &#28155;&#21152;
                            </button>

						</td>
					</tr>
					--%>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="25">
										订单序号
									</td>
									<td align="center" width="10">
										总计
									</td>
									<td align="center" width="20">
										订单时间
									</td>
									<td width="10" align="center">
										订单状态
									</td>
									<td width="10" align="center">
										用户名
									</td>
									<td width="10" align="center">
										联系电话
									</td>
									<%--
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										删除
									</td>
								    --%>
								  </tr>
								<s:iterator var="o" value="list" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="25">
												<s:property value="#o.oid"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10">
												<s:property value="#o.total"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="20">
												<s:property value="#o.ordertime"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10">
												<s:if test="#o.state==1">为付款</s:if>
												<s:if test="#o.state==2">已付款</s:if>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10">
                                                <s:property value="#o.name"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10">
                                                <s:property value="#o.phone"/>
											</td>
											<%--
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/adminProduct_edit.action?pid=<s:property value="#p.pid"/>">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/adminProduct_delete.action?pid=<s:property value="#p.pid"/>">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										--%>
										 </tr>
									</s:iterator>	
							</table>
						</td>
					</tr>
				</TBODY>
			</table>
		<%--========================显示分页=================================== --%>
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
		</form>
		
	</body>
</HTML>

