<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/9/29
  Time: 19:02
  To change this template use File | Settings | File Templates.
  主页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="Content-Type" content="text/html;charset=utf-8">
    <meta name="keywords" content="lol forum,论坛,lol">
    <title>lol forum - 一个分享创造的爱好者社区</title>
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">

    <style>
        li {
            list-style-type: none;
        }

        html, body {
            height: 100%;
            font-size: 14px;
            color: #525252;
            font-family: NotoSansHans-Regular, AvenirNext-Regular, arial, Hiragino Sans GB, "Microsoft Yahei", "Hiragino Sans GB", "WenQuanYi Micro Hei", sans-serif;
            background: #f0f2f5;
        }

        .footer {
            background-color: #fff;
            margin-top: 22px;
            margin-bottom: 22px;
            width: 100%;
            padding-top: 22px;
            color: #8A8A8A;
            display: block;
            height: 200px;
            border: 1px;
            clear: both
        }

        .container {
            margin-right: 5%;
            margin-left: 5%;
            padding-left: 15px;
            padding-right: 15px;
            width: 40%;
            float: left;
        }

        .info {
            margin-right: 5%;
            width: 10%;
            float: left;
        }

        a {
            color: #8A8A8A;
            cursor: pointer;
        }
    </style>
</head>
<body>


<!--引入header文件-->
<%@include file="header.jsp" %>


<!--主页窗体-->
<div class="panel panel-default" id="homepage" style="width: 70%;margin:1% 2% 5% 5%;float: left;">
    <div class="panel-heading" style="background-color: white">
        <a style="margin-right: 2%">活跃</a><a style="margin-right: 2%">精华</a><a style="margin-right: 2%">最近</a>
    </div>


    <ul class="list-group" style="width: 100%">
        <c:forEach items="${topics}" var="topic">
            <li class="list-group-item">
                <div style="height: 50px">
                    <div style="float: left;width: 6%;margin-bottom: 5px">
                        <img width="50px" height="50px" src="/static${topic.user.avatar}" class="img-rounded">
                    </div>

                    <div style="width: 89%;float: left">
                        <a href="/topic/${topic.id}">${topic.title}</a><br/>
                        <div>
                            <a><span class="label label-default">${topic.tab.tab_name}</span></a>&nbsp;&nbsp;&nbsp;
                            <a href="/user/${topic.user.username}"><span><strong>${topic.user.username}</strong></span></a>&nbsp;&nbsp;
                            <small class="text-muted">${topic.formatCreateTime}</small>
                        </div>
                    </div>
                    <div style="width: 5%;float: right;text-align: center">
                        <span class="badge">${topic.totalReplies}</span>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>

<!--引入侧边栏文件-->
<%@include file="side.jsp" %>


<!--引入footer文件-->
<%@include file="footer.jsp" %>

</body>
</html>
