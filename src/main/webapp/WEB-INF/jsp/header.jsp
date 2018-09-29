<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/9/29
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <!--导航栏-->
    <nav class="navbar-brand navbar-default" role="navigation" style="background-color: white">
        <div class="container-fluid" style="margin-left:10%">
            <div class="navbar-brand" href="/">lol论坛</div>
        </div>

        <div>
            <ul class="nav navbar-nav navbar-left">
                <li <c:if test="${tab.tab_name_en=='tech'}"> class="active" </c:if>>
                    <a href="/tab/tech">技术</a>
                </li>

                <li <c:if test="${tab.tab_name_en == 'play'}">class="active"</c:if>>
                    <a href="/tab/play">好玩</a>
                </li>

                <li <c:if test="${tab.tab_name_en == 'creative'}">class="active"</c:if>>
                    <a href="/tab/creative">创意</a></li>

                <li <c:if test="${tab.tab_name_en == 'jobs'}">class="active"</c:if>>
                    <a href="/tab/jobs">工作</a>
                </li>

                <li <c:if test="${tab.tab_name_en == 'deals'}">class="active"</c:if>>
                    <a href="/tab/deals">交易</a>
                </li>

            </ul>


            <!--如果session中的userId为空,则显示登录 注册-->
            <!--未登录-->
            <c:if test="${empty userId}">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <p class="navbar-text"><a href="/user/login.do">登录</a></p>      <!--/user/login.do-->
                    </li>
                    <li>
                        <p class="navbar-text"><a href="/user/register.do">注册</a></p>
                    </li>
                </ul>
            </c:if>


            <!--如果session中的userId不为为空,则显示首页  设置  退出-->
            <c:if test="${!empty userId}">
                <!--已登录-->
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <p class="navbar-text"><a href="/">首页</a></p>
                    </li>
                    <li>
                        <p class="navbar-text"><a href="/user/${sessionScope.username}">${sessionScope.username}</a></p>
                    </li>
                    <li>
                        <p class="navbar-text"><a href="/user/settings.do">设置</a></p>
                    </li>
                    <li>
                        <p class="navbar-text"><a href="javascript:logoutConfirm()">退出</a></p>
                    </li>
                </ul>

            </c:if>
        </div>

    </nav>
</header>
<script>
    function logoutConfirm()
    {
        var c = confirm("确定退出?")
        {
            if (c == true)
            {
                window.location.herf = "/user/logout.do";       //发出请求/logout.do
            } else
            {

            }
        }
    }
</script>
