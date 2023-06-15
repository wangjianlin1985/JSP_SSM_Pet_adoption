<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   String menuName = request.getParameter("menuName");
   String userIcon = request.getParameter("userIcon");
%>
<c:set var="menuName" value="<%=menuName %>"></c:set>
<c:set var="userIcon" value="<%=userIcon %>"></c:set>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="image/favicon.ico" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!--[if IE]>
<script> 
document.createElement("header"); 
document.createElement("footer"); 
document.createElement("nav"); 
document.createElement("article"); 
document.createElement("section"); 
</script> 
<script type="text/javascript" src="js/html5shiv.min.js"></script>
<![endif]-->
</head>

<body>
	<!--页头-->
	<div class="header" style="background: #ffffff;">
        <div class="inner">
            <a href="web/index/index"><img src="image/logo.png" width="135" height="37" style="margin-top: 18px;"></a>
        </div>
    </div>
    <div class="clearfix"></div>
    <!--首页菜单-->
	<div class="index-menu">
       <div class="menu inner">
           <ul>
            <li><a <c:if test="${menuName=='index'}">class="cur"</c:if>  href="web/index/index">首页</a></li>
            <li><a <c:if test="${menuName=='teachRes'}">class="cur"</c:if> href="web/teachRes/index">教学资源</a></li>
            <li><a <c:if test="${menuName=='refbook'}">class="cur"</c:if> href="web/refbook/list">参考读物</a></li>
       		<li><a <c:if test="${menuName=='publicCourse'}">class="cur"</c:if> href="web/publicCourse/pubicCourse">视频课程</a></li>
           </ul>
			<div class="user-info">
				<c:choose>
					<c:when test="${empty webUser}">
						<div class="btn-group">
							<a href='${menuName eq "index" ? "javascript:void(0);" : "web/index/index"}'>
								<img src="${userIcon == null or userIcon eq '' ? 'image/avater.png' : userIcon}" width="51" height="51">
							</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" style="padding: 0px; border: none;">
								<img src="${userIcon == null or userIcon eq '' ? 'image/avater.png' : userIcon}" width="51" height="51">
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="web/teacher/course/list">我的课程</a></li>
								<li><a href="404.jsp">我的消息</a></li>
								<li><a href="javascript:void(0);" onclick="logout()">退出</a></li>
							</ul>
						</div>
					</c:otherwise>
				</c:choose>
		</div>
           <div class="search" ms-controller="globalSearchsController">
               <form id= "searcher" method="post" action="web/globalSearch/index" >
                   <input id="condition" name="condition" type="text" placeholder="书名/作者/专业名称" class="s_ipt">
                   <input type="hidden" id="check_type" name="check_type" value="<%=menuName %>">
                  
                   <a href="javascript:void(0);" class="s_btn" ms-click="@globalSearchClick()">
                       <span class="glyphicon glyphicon-search"></span>
                   </a>
               </form>
           </div>
           <div class="clearfix"></div>
       </div>
   </div>
</body>

<script type="text/javascript" src="js/header.js"></script>
</html>