<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/9/28
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <title>英雄信息</title>
    <style>
        .thumbnail h3 {
            text-align: center;
        }

        .lolTitle {
            display: inline-block;
            font-size: 20px;
            background: #ccc;
            padding: 10px 15px;
            border-radius: 5px;
        }

        .page-header h1 {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="page-header">
    <h1>LOL英雄</h1>
</div>
<div class="container">
    <div class="row">
    </div>
</div>
<div class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">英雄详情</h4>
            </div>
            <div class="modal-body">
                <h1>
                    <span class="lolName">亚托克斯</span>
                    <span class="lolTitle">暗裔剑魔</span>
                </h1>
                <img src="/images/Aatrox.png" alt="">
                <p class="lolTags">tags:战士，坦克</p>
                <p class="lolInfo">远古的暗裔族群中，曾有一位举世无双的剑术大师亚托克斯，他将浴血的战场看作狂欢的乐园。</p>
                <a href="javascript:;" class="btn btn-primary btn-lg">详细攻略</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>


<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/bootstrap.js"></script>


<script>
    //向服务器发送Ajax请求查询数据


</script>


