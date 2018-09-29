<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/9/29
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
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
<footer class="footer">
    <div class="container">
        我们是高品质的开发者社区,致力于为开发这提供一个分享创造、结识伙伴、协同互助的平台。
        我们是高品质的开发者社区,致力于为开发这提供一个分享创造、结识伙伴、协同互助的平台。
        我们是高品质的开发者社区,致力于为开发这提供一个分享创造、结识伙伴、协同互助的平台。
        我们是高品质的开发者社区,致力于为开发这提供一个分享创造、结识伙伴、协同互助的平台。
        我们是高品质的开发者社区,致力于为开发这提供一个分享创造、结识伙伴、协同互助的平台。
        我们是高品质的开发者社区,致力于为开发这提供一个分享创造、结识伙伴、协同互助的平台。
        我们是高品质的开发者社区,致力于为开发这提供一个分享创造、结识伙伴、协同互助的平台。
        我们是高品质的开发者社区,致力于为开发这提供一个分享创造、结识伙伴、协同互助的平台。
        我们是高品质的开发者社区,致力于为开发这提供一个分享创造、结识伙伴、协同互助的平台。
        我们是高品质的开发者社区,致力于为开发这提供一个分享创造、结识伙伴、协同互助的平台。
    </div>
    <div class="info">
        <p style="text-align:center;font-size:16px;">统计信息</p>
        <ul>
            <li style="text-align: center">会员数:${usersNum}</li>
            <li style="text-align: center">话题数:${topicsNum}</li>
        </ul>
    </div>
    <div class="info">
        <p style="text-align:center;font-size: 16px ">友情链接</p>
        <ul>
            <li style="text-align: center">
                <a href="https://github.com/" style="text-decoration: none;">Gitub</a>
            </li>
            <li style="text-align: center">
                <a href="https://gitee.com/" style="text-decoration: none">Gitee</a>
            </li>
            <li style="text-align: center">
                <a href="https://segmentfault.com/" style="text-decoration: none">Segmentfault</a>
            </li>
        </ul>
    </div>
    <div class="info">
        <p style="text-align: center;font-size: 16px;">其他信息</p>
        <ul>
            <li style="text-align: center">
                <a href="https://github.com/Ancrazyking" style="text-decoration: none">关于本站</a>
            </li>
            <li style="text-align: center">
                <a href="https://github.com/Ancrazyking" style="text-decoration: none">联系我们</a>
            </li>
        </ul>
    </div>

</footer>
</body>