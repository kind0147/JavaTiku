<%@page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Java试题管理系统</title>
    <style type="text/css">@import url(css/style.css);</style>
    <link rel='stylesheet' href='css/bootstrap.min.css'>

  </head>
  
  <body>
    <div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <form class="form-horizontal" action="login" method="post">
                <span class="heading">用户登录</span>
                <div class="form-group">
                    <input type="test" class="form-control" id="username" name="username" placeholder="用户名或电子邮件">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" id="password" name="password" placeholder="密　码">
                    <i class="fa fa-lock"></i>
                    <a href="#" class="fa fa-question-circle"></a>
                </div>
                <div class="form-group">
                    <div class="main-checkbox">
                        <input type="checkbox" id="remember_me" name="remember-me"/>
                        <label for="remember_me"></label>
                    </div>
                    <span class="text">Remember me</span>
                    <button type="submit" class="btn btn-default btn-lg">登录</button>
                </div>
                <div class="form-group">
            <a href="/Java-Tiku/register" class="btn btn-default btn-lg btn-block">注册</a>
            </div>
            <div class="form-group">
            <a href="#" class="btn btn-default btn-lg btn-block">找回密码</a>
            </div>
            <input name="_csrf" type="hidden" value="7ca7acb-355326-eeee" />
            </form>
        </div>
    </div>
</div>
  </body>
</html>
