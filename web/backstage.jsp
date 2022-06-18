<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/30
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html style="height: 553px;">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>学生成绩管理系统后台</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/Bootstrap-4---Table-Fixed-Header.css">
    <link rel="stylesheet" href="assets/css/Footer-Basic.css">
    <link rel="stylesheet" href="assets/css/Footer-Clean.css">
    <link rel="stylesheet" href="assets/css/Formulario-Farmacia.css">
    <link rel="stylesheet" href="assets/css/Navbar---App-Toolbar--LG--MD---Mobile-Nav--SM--XS-1.css">
    <link rel="stylesheet" href="assets/css/Navbar---App-Toolbar--LG--MD---Mobile-Nav--SM--XS.css">
    <link rel="stylesheet" href="assets/css/Navigation-Clean.css">
    <link rel="stylesheet" href="assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="assets/css/Sidebar-1-1.css">
    <link rel="stylesheet" href="assets/css/Sidebar-1.css">
    <link rel="stylesheet" href="assets/css/Sidebar-Menu-1.css">
    <link rel="stylesheet" href="assets/css/Sidebar-Menu.css">
    <link rel="stylesheet" href="assets/css/styles.css">
</head>

<body style="height: 373px;">
<nav class="navbar navbar-light navbar-expand-md navigation-clean">
    <div class="container"><a class="navbar-brand" href="index.jsp">📖 学生成绩管理系统<br></a>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"></li>
            </ul>
        </div>
    </div>
</nav>
<div class="register-photo" style="height: 643px;background-position: center;background-color: rgb(132,175,211);padding-top: 12px;padding-bottom: 69px;">
    <div class="form-container" style="margin-top: 109px;width: 460px;">
        <form method="post" action="LogIn.do" style="width: 460px;">
            <h2 class="text-center"><strong>后台管理中心</strong></h2>
            <div class="form-group"><select class="form-control" name="person-type">
                    <option value="管理员" selected="">管理员</option>
                </select>
            </div>
            <div class="form-group"><input class="form-control" type="text" name="name" placeholder="姓名"></div>
            <div class="form-group"><input class="form-control" type="text" name="number" placeholder="账号"></div>
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="密码"></div>
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="background-color: rgb(17,206,218);">登录</button></div>
        </form>
    </div>
</div>
<div class="footer-basic" style="padding-top: 13px;height: 95px;">
    <footer style="height: 59px;">
        <p class="copyright" style="height: 37px;"><br>Copyright&nbsp;© 2021 学生成绩管理系统&nbsp; 版权所有</p>
    </footer>
</div>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/Sidebar-Menu.js"></script>
</body>

</html>
