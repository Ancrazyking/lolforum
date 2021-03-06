<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/9/29
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册 - LOL论坛</title>
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
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

<!-- 引入header文件 -->
<%@ include file="header.jsp" %>

<div class="panel panel-default" id="register" style="width: 55%;margin-left: 10%;margin-top: 5%;margin-bottom: 5%">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">注册</h3>
    </div>
    <div class="panel-body">
        <!--用户注册提交表单-->
        <form action="/user/register.do" method="post" id="registerForm" class="form-horizontal" role="form"
              style="margin-left: 5%">

            <div class="form-group">
                <label class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10" style="width: 40%">
                    <input type="text" class="form-control" id="username" name="username" required="required">
                    <p class="form-control-static">请使用字母a-z或数字0-9</p>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10" style="width: 40%;">
                    <input type="password" class="form-control" id="password" required="required">
                </div>
            </div>

            <div class="form-control">
                <label class="col-sm-2 control-label">电子邮件</label>
                <div class="col-sm-10" style="width: 40%;">
                    <input type="email" class="form-control" id="email" name="email" required="required">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">国际电话区号</label>
                <div class="col-sm-10" style="width: 40%;">
                    <select class="form-control" id="areaCode" name="areaCode">
                        <option value="86">+86</option>
                        <option value="85">+85</option>
                        <option value="84">+84</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">手机号</label>
                <div class="col-sm-10" style="width: 40%;">
                    <input type="tel" class="form-group" id="tel" name="tel" required="required">
                </div>
            </div>

            <!--提交按钮-->
            <input type="submit" class="btn btn-default" id="registerBtn" style="margin-left: 17%">

        </form>
    </div>

</div>


<!-- 引入footer文件 -->
<%@ include file="footer.jsp" %>

<script>
    //表单验证的脚本
    function submitValidate(flag)
    {
        return flag;
    }

    $("#registerBtn").submit(function () {
        if ($("#username").val() == '' || $("#password").val() == '' || $("#email").val() == '' || $("#tel").val() == '')
        {
            alert("请将注册信息填写完整!");
            return submitValidate(false);
        } else
        {

        }
    });
</script>

</body>
</html>
