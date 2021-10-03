<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		//图片放大镜 ||绑定鼠标移出事件
		$(".imagess").mouseover(function(event){
			var bigImage = $("<img id='bimg' src='"+$(this).attr("src")+"'/>");
			//给图片设置样式
			$(bigImage).css({
				"top":event.pageY+5, //鼠标坐标偏移
				"left":event.pageX+10, 
				"width":"this.width*1.5",
				"height":"this.height*1.5",
				"position":"absolute", //绝对定位
				"border":"3px solid green",
				"border-radius":"10ox 10px 10px 10px",
				"display":"none",
			});
			//将图片放到body中
			$("body").append(bigImage);
			//动画效果展示
			$(bigImage).show(2000);
		}).mouseout(function(){
			//鼠标移除事件||删除
			$("#bimg").remove();
		}).mousemove(function(event){
			$("#bimg").css({
				"top":event.pageY+5, //鼠标坐标偏移
				"left":event.pageX+10, 
				"width":"this.width*1.5",
				"height":"this.height*1.5",
				"position":"absolute", //绝对定位
				"border":"3px solid green",
				"border-radius":"30ox 30px 30px 30px",
			});
		
		});
	});
</script>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<!--编辑推荐图书开始-->
		<c:forEach items="${books }" var="b">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='${pageContext.request.contextPath }/main/selectOneB?id=${b.id}' target='_blank'>
					<img class="imagess" src="${pageContext.request.contextPath }/back/img/${b.cover}" width=70 border=0 /> 
				</a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href='${pageContext.request.contextPath }/main/selectOneB?id=${b.id}' target='_blank' title='书名'>${b.book_name }</a>
				</h3>
				<h4>
					作者：${b.author }
					<br />
					出版社：${b.publish_company }&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：<fmt:formatDate value="${b.print_time }" type="both" pattern="yyyy-MM-dd"/>
				</h4>
				<h5>
					简介:${b.prospectus }
				</h5>
				<h6>
					定价：${b.original_price}&nbsp;&nbsp;
					当当价：${b.discount_price}
					销量：<font color="red">${b.sales_volume}</font>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		</c:forEach>
		<!--编辑推荐图书结束-->
	</div>
</div>
