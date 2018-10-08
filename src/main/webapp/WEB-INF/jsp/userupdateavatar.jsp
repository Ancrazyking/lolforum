<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/10/4
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <title>LOL &gt;头像上传</title>
</head>
<body>
<!-- 引入header文件 -->
<%@ include file="header.jsp" %>

<div style="width: 70%;margin:1% 2% 1% 5%;float: left;">
    <div class="panel panel-default" id="main" style="">
        <div class="panel-heading" style="background-color: white">
            <a href="/">LOL</a> &gt; 设置 &gt;头像上传
        </div>

        <div class="panel-body">
            <!--用户上传头像-->
            <form action="/user/settings/avatar/update" enctype="multipart/form-data" method="post"
                  class="form-horizontal" role="form">
                <div style="margin-left: 17%">
                    <img width="60px" height="60px" src="/static/${user.avatar}" class="img-rounded">
                    <input type="file" name="avatar" accept="image/png,image/jpeg,image/jpg"><!--接收的文件类型-->
                    <br/>
                    <input class="btn btn-default" type="submit" value="上传头像">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 引入侧边栏文件 -->
<%@ include file="side.jsp" %>

<!-- 引入footer文件 -->
<%@ include file="footer.jsp" %>

</body>