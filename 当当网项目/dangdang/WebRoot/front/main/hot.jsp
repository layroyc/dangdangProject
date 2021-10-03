<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach items="${booksX }" var="b">
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath }/main/selectOneB?id=${b.id}" target='_blank'>
				<img class="imagess" src="${pageContext.request.contextPath }/back/img/${b.cover}" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath }/main/selectOneB?id=${b.id}" target="_blank">${b.book_name }</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：${b.original_price}
		</div>
		<div class="price">
			当当价：${b.discount_price}
		</div>
		<div class="price">
			销量：<font color="red">${b.sales_volume}</font>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>