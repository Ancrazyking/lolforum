<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/9/29
  Time: 19:02
  To change this template use File | Settings | File Templates.
  话题详情页面
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <title>${topic.title} - LOL </title>
</head>
<body>
<!-- 引入header文件 -->
<%@ include file="header.jsp" %>
<div style="width: 70%;margin:1% 2% 1% 5%;float: left;">
    <div class="panel panel-default" id="main" style="">
        <div class="panel-heading" style="background-color: white">
            <div>
                <div class="panel-heading" style="background-color: white">
                    <a href="/">LOL</a> &gt; 主题
                </div>
                <h3>${topic.title}</h3><br/>
                <div>
                    <a href="/member/${topic.user.username}"><span><strong>${topic.user.username}</strong></span></a>&nbsp;&nbsp;
                    <small class="text-muted">${topic.formatCreateTime}&nbsp;&nbsp;&nbsp;</small>&nbsp;&nbsp;
                    <small class="text-muted">${topic.click}次点击</small>
                </div>
            </div>

            <div style="float: right;margin-top: -100px">
                <img width="50px" height="50px" src="/static/${topic.user.avatar}" class="img-rounded">
            </div>
        </div>

        <ul class="list-group" style="width: 100%">
            <li class="list-group-item">
                ${topic.content}
            </li>
        </ul>
    </div>



    <c:if test="${!empty replies}">
        <div class="panel panel-default" id="main" style="">
            <div class="panel-heading" style="background-color: white">
        <span>
                ${fn:length(replies)} 回复  | 直到 <c:forEach items="${replies}" var="reply" varStatus="status">

            <c:if test="${status.last}">
                ${reply.formatCreateTime}
            </c:if>
        </c:forEach>
    </span>
            </div>

            <ul class="list-group" style="width: 100%">
                <!-- 遍历评论 -->
                <c:forEach items="${replies}" var="reply">
                    <li class="list-group-item">
                        <div style="height: 50px">
                            <div style="float: left;width: 6%;margin-bottom: 5px">
                                <img width="50px" height="50px" src="/static/${reply.user.avatar} " class="img-rounded">
                            </div>
                            <div style="width: 89%;float: left">
                                <a href="/member/${reply.user.username}"><strong>${reply.user.username}</strong></a>&nbsp;&nbsp;
                                <small class="text-muted">${reply.formatCreateTime}</small>
                                <br/>
                                <div>
                                    <p>${reply.content}</p>
                                </div>
                            </div>
                        </div>
                    </li>
                </c:forEach>

            </ul>
        </div>
    </c:if>

    <c:if test="${!empty user}">

        <div class="panel panel-default" id="main" style="">
            <div class="panel-heading" style="background-color: white">
                添加一条新回复
            </div>
            <div class="panel-body">
                <div class="form-group">
                    <form action="/reply/add" method="post">
                        <input type="hidden" name="topicId" value="${topic.id}">
                        <input type="hidden" name="replyUserId" value="${user.id}">
                        <textarea class="form-control" rows="3" name="content" required="required"></textarea><br/>
                        <input type="submit" class="btn btn-default btn-sm" value="回复">
                    </form>
                </div>

            </div>
        </div>
    </c:if>

</div>
<!-- 引入侧边栏文件 -->
<%@ include file="side.jsp" %>

<!-- 引入footer文件 -->
<%@ include file="footer.jsp" %>

</body>
</html>