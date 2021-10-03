<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
  <head>
    <title>index.html</title>
	<link rel="stylesheet" href="../css/btn.css" />
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=GBK">
    <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
  </head>
  
  <body style="background-color: #f0f9fd;text-align: center">
  	<div style="text-align: center;font-size: 18px">添加商品类别</div><hr/>
  	<form action="<c:url value='/category/addcategory'/>" method="post">
  		类别名:<input class="el-input__inner" type="text" name="category.category" id="fname"/><span id="fnameMsg"></span><br/><br/>
  		<input class="button btn-p" type="submit" value="提交">&emsp;
		<div class="button btn-p"  onclick="history.go(-1);">返回上级</div>
  	</form>
    	
  </body>
</html>
