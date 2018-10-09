<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
		<script src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
          //传递当前页和cid
          function gotopage(page){
    	       window.location.href="${pageContext.request.contextPath}/adminUser_findAll?page="+page+"";
          }
		</script>
	</head>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/author/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>作者列 表</strong>
						</td>
					</tr><%--
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addCategorySecond()">
							   &#28155;&#21152;
                            </button>

						</td>
					</tr>
					--%><tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="5px">
										序号
									</td>
									<td align="center" width="10px">
										用户名
									</td>
									<td align="center" width="20px">
										VIP管理密码
									</td>
									<td align="center" width="10px">
										真实姓名	
									</td>
									<td align="center" width="10px">
										笔名
									</td>
									<td align="center" width="10px">
										性别
									</td>
									<td align="center" width="10px">
										身份证
									</td>
									<td align="center" width="20px">
										邮箱	
									</td>
									<td align="center" width="20px">
										电话
									</td>
									<td align="center" width="20px">
										地址
									</td>
								</tr>
								<s:iterator var="author" value="list" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="5px">
												<s:property value="#status.count"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10px">
												<s:property value="#author.user.username"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="20px">
												<s:property value="#author.password"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10px">
												<s:property value="#author.authorname"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10px">
												<s:property value="#author.pen_name"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10px">
												<s:property value="#author.sex"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10px">
												<s:property value="#author.ID_card"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="20px">
												<s:property value="#author.email"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="20px">
												<s:property value="#author.phone"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="20px">
												<s:property value="#author.addr"/>
											</td>
											<%--
											<td align="center" style="HEIGHT: 22px"><!--  -->
												<a href="${pageContext.request.contextPath}/adminCategorySecond_edit.action?csid=<s:property value="#cs.csid"/>">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
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

