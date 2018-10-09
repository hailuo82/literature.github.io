<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/time.js"></script>
	</HEAD>
	
	<body>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/adminProduct_edit.action" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pid" value="<s:property value="model.pid"/>"/>
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑书籍</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="100" align="center" bgColor="#f5fafe" class="ta_01">
						书籍名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="pname" value="<s:property value="model.pname"/>"  class="bg"/>
						<input type="hidden" name="popularity" value="${model.popularity}" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属二级分类：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select name="categorySecond.csid">
						  <s:iterator value="csList" var="cs">
						   <option value="${cs.csid}" <s:if test="model.categorySecond.csid==#cs.csid">selected</s:if>>${cs.csname }</option>
						  </s:iterator> 
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						作者：
					</td>
					<td class="ta_01" bgColor="#ffffff">
					   <input type="text" name="author" value="${model.author}" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						价格：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="shop_price" value="${model.shop_price}" id="userAction_save_do_logonName" class="bg"/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						是否热门：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<select name="is_hot">
						  <option value="1" <s:if test="model.is_hot==1">selected</s:if>>是</option>
						  <option value="0" <s:if test="model.is_hot==0">selected</s:if>>否</option>
						</select>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						书籍图片：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<img name="image" src="${model.image }">
					    <input type="file" name="upload" value="${pageContext.request.contextPath}/${model.image }"/>
					
						<%--<s:file name="upload">${pageContext.request.contextPath}/${model.image }</s:file>
					--%></td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						书籍描述：
					</td>
					<td class="ta_01" bgColor="#ffffff">
					    <textarea rows="5" cols="20" name="pdesc">${model.pdesc}</textarea>
					</td>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						上架时间：
					</td>
					<td class="ta_01" bgColor="#ffffff">
					  <input id="userAction_save_do_logonName" class="bg" onmouseout="gettime1()" type="text" value="${model.pdate}" name="pdate" onfocus="HS_setDate(this)"/>
		           </td>
				</tr>								
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>