<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet"  type="text/css"   href="css/index.css" />
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  </head>
  
  <body>
  <jsp:include page="WEB-INF/jsp/view/header.jsp"></jsp:include>
<div id="content">
  <div id="content_left">
 	<c:forEach items="${productList }" var="product">
 		<div id="left_img"><a href="product/${product.pid }/selectById"><img src="${product.img }" /></a>
  		<div id="left_img_cover"><a href="product/${product.pid }/selectById">${product.name }惊爆价:￥${product.price }</a></div>
    </div>
 	</c:forEach>
  </div><!--end.content_left-->
</div><!--end.content-->
  </body>
</html>
