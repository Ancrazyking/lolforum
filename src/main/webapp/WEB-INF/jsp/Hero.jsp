<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2018/10/2
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!--
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    -->
    <!--<meta http-equiv="X-UA-Compatible" content="ie=edge">-->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="/static/jsh/jquery-1.11.3.min.js"></script>
    <script src="/static/jsh/bootstrap.js"></script>
    <title>英雄基本信息</title>
    <style>
        .thumbnail h3 {
            text-align: center;
        }

        .hero_title {
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


    <script>
        $(function () {
            $.ajax({
                    url: "/lol/heroList",
                    //直接返回的是json对象字符串数组
                    success: function (heroObj) {
                        /*       alert(result);
                               var heroObj = JSON.parse(result);*/
                        for (var i = 0; i < heroObj.length; i++)
                        {
                            $('<div class="col-xs-6 col-md-2 list"><a href="javascript:;" class="thumbnail">' +
                                '<img src="/lol/' + heroObj[i].icon + '" alt=""><h3>' + heroObj[i].hero_name +
                                '</h3></a></div>').appendTo('.row');
                        }
                    }
                }
            );


            $('.row').on("click", 'a', function () {
                    $.ajax({
                        url: "/lol/hero",
                        data: "hero_name=" + $(this).find('h3').html(),
                        success: function (hero) {
                            console.log(hero.hero_name);
                            console.log(hero.hero_title);
                            $('.hero_name').html(hero.hero_name);
                            $('.hero_title').html(hero.hero_title);
                            $('.hero_tags').html(hero.hero_tags);
                            $('.hero_info').html(hero.hero_info);
                            $('.modal-body').find('img').attr('src', '/lol/' + hero.icon);
                            $('.modal').modal('show');
                        }
                    });

                }
            );

        });
    </script>


</head>
<body>
<div class="page-header">
    <h1>LOL英雄介绍</h1>
</div>


<!--显示每一个图片的区域-->
<div class="container">
    <div class="row">
    </div>
</div>

<!--点击每一张图片弹出的对话框-->
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
                    <span class="hero_name"></span>
                    <span class="hero_title"></span>
                </h1>
                <img src="" alt="">
                <p class="hero_tags"></p>
                <p class="hero_info"></p>
                <a href="javascript:;" class="btn btn-primary btn-lg">详细攻略</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>