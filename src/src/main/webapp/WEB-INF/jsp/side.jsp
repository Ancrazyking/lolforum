<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/9/29
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--未登录-->
<c:if test="${empty userId}">
    <div class="panel panel-default" id="sidebar2" style="width: 20%;margin: 1% 2% 1% 0%;float: right">
        <div class="panel-heading" style="background-color: white;text-align: center">
            <blockquote>
                <h2>lol论坛</h2>
                <small>分享lol技术的论坛</small>
            </blockquote>
        </div>
        <ul class="list-group" style="width: 100%">
            <li class="list-group-item">
                <a href="/login" class="btn btn-primary btn-block">登录</a>   <!--跳转到登录页面-->
                <a href="/register" class="btn btn-default btn-block">注册</a> <!--跳转到注册页面-->
            </li>
        </ul>
    </div>
</c:if>

<!--已登录-->
<c:if test="${!empty userId}">

    <div class="panel panel-default" id="sidebar2" style="width: 20%;margin:1% 2% 1% 0%;float: right">
        <div class="panel-heading" style="background-color: white;text-align: center">
            <a href="/user/${user.username}">${user.username}</a>
        </div>
        <ul class="list-group" style="width: 100%">
            <li class="list-group-item"><a href="/new">创作新主题</a></li><!--创作新主题-->
            <li class="list-group-item"><a href="">0条未读提醒</a></li>
            <li class="list-group-item"><a href="">积分:${user.credit}</a></li>
        </ul>
    </div>

</c:if>


<!--热议主题-->
<div class="panel panel-default" id="sidebar1" style="width: 20%;margin: 1% 2% 1% 0%;float: right">
    <div class="panel-heading" style="background-color: white;text-align: center">
        热议主题
    </div>
    <ul class="list-group" style="width: 100%;">
        <c:forEach items="${hotestTopics}" var="hotestTopic">
            <li class="list-group-item"><a href="/topic/${hotestTopic.id}">${hotestTopic.title}</a></li>
            <!--发起一个话题请求-->
        </c:forEach>
    </ul>
</div>











