<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <nav class="navbar navbar-default" role="navigation" style="background-color: white">
        <div class="container-fluid" style="margin-left: 10%">
            <div class="navbar-header">
                <a class="navbar-brand" href="/">LOL</a>
            </div>
            <div>

                <!--向左对齐-->
                <ul class="nav navbar-nav navbar-left">
                    <li>
                        <a href="/lol/heroInfo">英雄介绍</a>
                    </li>
                    <li <c:if test="${tab.tab_name_en == 'tech'}">
                        class="active" </c:if>><a href="/tab/tech">技术</a>
                    </li>
                    <li <c:if test="${tab.tab_name_en == 'play'}">class="active"
                    </c:if>><a href="/tab/play">好玩</a></li>
                    <li <c:if test="${tab.tab_name_en == 'creative'}">class="active"
                    </c:if>><a href="/tab/creative">创意</a></li>
                    <li <c:if test="${tab.tab_name_en== 'jobs'}">class="active"
                    </c:if>><a href="/tab/jobs">工作</a></li>
                    <li <c:if test="${tab.tab_name_en == 'deals'}">class="active"
                    </c:if>><a href="/tab/deals">交易</a></li>

                </ul>

                <c:if test="${empty userId}">
                    <!--未登陆-->
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <p class="navbar-text"><a href="/login">登录</a></p>
                        </li>
                        <li>
                            <p class="navbar-text"><a href="/register">注册</a></p>
                        </li>
                    </ul>
                </c:if>
                <c:if test="${!empty userId}">
                    <!--已登陆-->
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <p class="navbar-text"><a href="/">首页</a></p>
                        </li>
                        <li>
                            <p class="navbar-text"><a
                                    href="/member/${sessionScope.username}">${sessionScope.username}</a></p>
                        </li>
                        <li>
                            <p class="navbar-text"><a href="/settings">设置</a></p>
                        </li>
                        <li>
                            <p class="navbar-text"><a href="javascript:signout_confirm();">退出</a></p>
                        </li>
                    </ul>
                </c:if>
            </div>
        </div>
    </nav>


</header>
<!--脚本用于确认用户是否退出-->
<script>
    function signout_confirm()
    {
        var r = confirm("确定退出?")
        if (r == true)
        {
            window.location.href = "/user/logout";
        }
        else
        {

        }
    }
</script>