<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/10/3
  Time: 15:08
  To change this template use File | Settings | File Templates.
  登录用户创建主题页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <title>创作新主题 &gt;LOL</title>
</head>
<body>
<!-- 引入header文件 -->
<%@ include file="header.jsp" %>

<div style="width: 70%;margin:1% 2% 1% 5%;float:left;">
    <div class="panel panel-default" id="main" style="">
        <div class="panel-heading" style="background-color: white">
            <a href="/">LOL</a> &gt;创作新主题
        </div>

        <div class="panel-body">
            <form action="/topic/add" method="post" id="newTopicForm">
                <div class="form-group">
                    <label for="title">主题标题</label>
                    <!--title-->
                    <input type="text" class="form-control" id="title" name="title" placeholder=
                            "请输入主题标题,如果标题能够表达完整内容则正文可以为空" required="required">
                </div>

                <div class="form-group">
                    <label for="content">正文</label>
                    <!--content-->
                    <textarea class="form-control" rows="10" id="content" name="content"></textarea>
                </div>


                <div class="form-group">
                    <label for="tab">板块</label><br/>
                    <div class="col-sm-10" style="width: 40%">
                        <!--tab-->
                        <select class="form-control" id="tab" name="tab">
                            <c:forEach items="${tabs}" var="tab">
                                <option value="${tab.id}">${tab.tab_name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <br/>
                <input type="submit" class="btn btn-default btn-sm" value="发布主题">
            </form>
        </div>
    </div>
</div>


<div class="panel panel-default" id="sidebar2" style="width: 20%;margin:1% 2% 1% 0%;float: right">
    <div class="panel-heading" style="background-color: white;text-align: center">
        发帖提示
    </div>
    <ul class="list-group" style="width: 100%">
        <li class="list-group-item">
            <h5>主题标题</h5>
            <p>
                请在标题中描述内容要点。如果一件事情在标题的长度内就已经可以说清楚，那就没有必要写正文了。
            </p>
        </li>
        <li class="list-group-item">
            <h5>正文</h5>
            <p>
                请清楚地表达所要说明的内容。
            </p>
        </li>
    </ul>
</div>


<div class="panel panel-default" id="sidebar1" style="width: 20%;margin:1% 2% 1% 0%;float:right">
    <div class="panel-heading" style="background-color: white;text-align: center">
        社区指导原则
    </div>
    <ul class="list-group" style="width: 100%">
        <li class="list-group-item">
            <h5>尊重原创</h5>
            <p>
                请不要发布任何盗版下载链接，包括软件、音乐、电影等等，我们尊重原创。
            </p>
        </li>

        <li class="list-group-item">
            <h5>友好互助</h5>
            <p>
                保持对陌生人的友善，勿涉及政治敏感话题，拒绝种族歧视。
            </p>
        </li>
    </ul>
</div>


<!-- 引入footer文件 -->
<%@ include file="footer.jsp" %>

<script>
    //表单校验
    function submitValidate(flag)
    {
        return flag;
    }

    $("#newTopicForm").submit(function () {
        if ($("#title").val() == '')
        {
            alert("请填写标题!");
            return submitValidate(false);
        } else
        {
            var subConfirm = confirm("确定发表该主题吗?");
            if (subConfirm == true)
            {

            } else
            {
                return submitValidate(false);
            }
        }
    });

</script>


</body>
</html>
