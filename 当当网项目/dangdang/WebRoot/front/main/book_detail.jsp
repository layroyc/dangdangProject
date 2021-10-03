<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>图书详情</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/front/css/book_detail.css"/>
		<link href="${pageContext.request.contextPath }/front/css/public_footer.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		<br/>
		<div>
			<a href="${pageContext.request.contextPath }/main/findAllC"><font style='color: green;font-size:20px'><strong>回到首页</strong></font></a>
			<h1>
				图书名：${book.book_name }
			</h1>
			<hr/>
		</div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img src="${pageContext.request.contextPath }/back/img/${book.cover}" width="240px" height="340px" /></td>
				<td colspan="2">作者：${book.author }</td>
			</tr>
			<tr>
				<td colspan="2">出版社：${book.publish_company }</td>
			</tr>
			<tr>
				<td>出版时间：<fmt:formatDate value="${book.publish_time}" type="both" pattern="yyyy-MM-dd" /> </td>
				<td>字数：${book.word_number }</td>
			</tr>
			<tr>
				<td>版次：${book.edition }</td>
				<td>页数：${ book.page_number}</td>
			</tr>
			<tr>
				<td>印刷时间：<fmt:formatDate value="${book.print_time }" type="both" pattern="yyyy-MM-dd"/></td>
				<td>开本：${book.book_size }</td>
			</tr>
			<tr>
				<td>印次：${book.print_number }</td>
				<td>纸张：${book.paper_type }</td>
			</tr>
			<tr>
				<td>ISBN：${book.isbn }</td>
				<td>销量：<font color="red">${book.sales_volume}</font></td>
			</tr>
			<tr>
				<td>所属类别：<font style='color: #cc3300'><strong>${category.category }</strong>&gt;&gt;
				<c:forEach items="${category.cates}" var="c">
					${c.category }
				</c:forEach>
				</font>
				</td>
			</tr>
			<tr>
				<td colspan="2">定价：￥${book.original_price }&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥${ book.discount_price}</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥${book.original_price-book.discount_price }</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${pageContext.request.contextPath }/shop/add?id=${book.id}">
						<img src='${pageContext.request.contextPath }/front/images/buttom_goumai.gif' />
					</a>
				</td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>编辑推荐</h2>
		<p>&nbsp;&nbsp;${book.edit_recommend }</p>
		<hr style="border:1px dotted #666"/>
		<h2>内容简介</h2>
		<p>&nbsp;&nbsp;${book.prospectus }</p>
		<hr style="border:1px dotted #666"/>
		<h2>作者简介</h2>
		<p>&nbsp;&nbsp;${book.author_intro }</p>
		<hr style="border:1px dotted #666"/>
		<h2>目录</h2>
		<p>&nbsp;&nbsp;${book.catalog }</p>
		<hr style="border:1px dotted #666"/>
		<h2>媒体评论</h2>
		<p>&nbsp;&nbsp;${book.media_comment }</p>
		<hr style="border:1px dotted #666"/>
		<h2>书摘插图</h2>
		<p>&nbsp;&nbsp;</p>
		<!--页尾开始 -->
		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img src="${pageContext.request.contextPath }/front/images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
	</body>
</html>
