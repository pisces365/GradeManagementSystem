<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/30
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-Cn">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>学生成绩管理系统</title>
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
    <%--mypage.jsp--%>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="assets/fonts/fontawesome-all.min.css">

    <%--QRcode.jsp--%>
    <link rel="stylesheet" href="assets/css/Features-Boxed.css">
    <style>
        .none-input {
            pointer-events: none;
        }

        .submit-button {
            display: block;
            width: 20%;
            height: calc(1.5em + .75rem + 2px);
            margin-top: 10px;
            padding: .375rem .75rem;
            font-size: 1rem;
            font-weight: 400;
            line-height: 1.5;
            color: #495057;
            background-color: rgb(234, 245, 254);
            background-clip: padding-box;
            border: 1px solid #ced4da;
            border-radius: .25rem;
            transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
        }

        .submit-button:hover {
            background-color: rgb(205, 228, 247);
        }
    </style>
</head>


<body>
<main>
    <div id="wrapper">
        <div class="border rounded-0 shadow" id="sidebar-wrapper"
             style="background-color: rgb(234,245,254);color: rgb(255,255,255);">
            <div id="sidebar-main" class="sidebar sidebar-default sidebar-separate"
                 style="box-shadow: none; border: 0px; background-color: rgb(234,245,254);">
                <div class="sidebar-category sidebar-default"
                     style="box-shadow: none; border: 0px; border-radius: 0px; width: 248px;">
                    <div class="category-title" style="height: 64px; background-color: rgb(234,245,254);">
                            <span
                                    style="color: black; font-size: 1.25rem; line-height: 40px; padding-top: 0">📖 学生成绩管理系统</span>
                    </div>
                    <div class="category-content" style=" background-color: rgb(234,245,254);">
                        <ul id="fruits-nav" class="nav flex-column">
                            <li class="nav-item">
                                <a href="/YangjnGradeManagementSystem02_war_exploded/Admin.do?pageName=adminMyPage" class="nav-link">
                                    <b class=" " aria-hidden="true">🔵</b> 我的主页
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/YangjnGradeManagementSystem02_war_exploded/Admin.do?pageName=Majors" class="nav-link">
                                    <b class=" " aria-hidden="true">🔵</b> 专业表管理
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/YangjnGradeManagementSystem02_war_exploded/Admin.do?pageName=Classes" id="fillTable_Button" class="nav-link">
                                    <b class=" " aria-hidden="true">🔵</b> 班级表管理
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/YangjnGradeManagementSystem02_war_exploded/Admin.do?pageName=Teachers" id="QRcode_Button" class="nav-link">
                                    <b class=" " aria-hidden="true">🔵</b> 教师表管理
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/YangjnGradeManagementSystem02_war_exploded/Admin.do?pageName=Students" id="QRcode_Button" class="nav-link">
                                    <b class=" " aria-hidden="true">🔵</b> 学生表管理
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/YangjnGradeManagementSystem02_war_exploded/Admin.do?pageName=Courses" id="QRcode_Button" class="nav-link">
                                    <b class=" " aria-hidden="true">🔵</b> 课程表管理
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/YangjnGradeManagementSystem02_war_exploded/Admin.do?pageName=SC" id="QRcode_Button" class="nav-link">
                                    <b class=" " aria-hidden="true">🔵</b> 学生成绩表管理
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/YangjnGradeManagementSystem02_war_exploded/Admin.do?pageName=TC" id="QRcode_Button" class="nav-link">
                                    <b class=" " aria-hidden="true">🔵</b> 教师任课管理
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/YangjnGradeManagementSystem02_war_exploded/Admin.do?pageName=Province" id="QRcode_Button" class="nav-link">
                                    <b class=" " aria-hidden="true">🔵</b> 省表管理
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/YangjnGradeManagementSystem02_war_exploded/Admin.do?pageName=City" id="QRcode_Button" class="nav-link">
                                    <b class=" " aria-hidden="true">🔵</b> 市表管理
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="/YangjnGradeManagementSystem02_war_exploded/Admin.do?pageName=District" id="QRcode_Button" class="nav-link">
                                    <b class=" " aria-hidden="true">🔵</b> 区表管理
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="page-content-wrapper">
            <div class="container-fluid" style="padding-left: 0px;padding-right: 0px;">
                <header>
                    <nav class="navbar navbar-light navbar-expand-md border rounded-0 shadow-sm"
                         style="padding-left: 0;height: 62px;padding-right: 0px; ">
                        <div class="container-fluid"><a class="btn btn-link" role="button" id="menu-toggle"
                                                        href="#menu-toggle" style="padding-left: -13px;"><i class="fa fa-bars"
                                                                                                            style="color: rgb(0 120 215);"></i></a>
                            <div>
                                <a class="navbar-brand" style="margin-left: 13px;"></a><button
                                    data-toggle="collapse" class="navbar-toggler" data-target="#navcol-2"><span
                                    class="sr-only">Toggle navigation</span><span
                                    class="navbar-toggler-icon"></span></button>
                            </div>
                            <div class="collapse navbar-collapse" id="navcol-2">
                                <ul class="nav navbar-nav ml-auto" id="desktop-toolbar">
                                    <li class="nav-item dropdown"><a class="dropdown-toggle nav-link"
                                                                     data-toggle="dropdown" aria-expanded="false" href="#"><img
                                            class="rounded-circle" src="assets/img/user-photo.jpg" width="25px"
                                            height="25px">&nbsp;管理员<i class="fa fa-chevron-down fa-fw"></i></a>
                                        <div class="dropdown-menu" role="menu">
                                            <a class="dropdown-item" role="presentation" href="/YangjnGradeManagementSystem02_war_exploded/LogOut.do"><i
                                                    class="fa fa-power-off fa-fw"></i>退出</a>
                                        </div>
                                    </li>
                                </ul>
                                <ul class="nav navbar-nav" id="mobile-nav">
                                    <li class="nav-item" role="presentation"></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </header>
                <div class="row">
                    <div class="col-md-12">
                        <div></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">

            <%
                String pageName = (String)request.getAttribute("pageName");
                switch(pageName)
                {
                    case "adminMyPage" :
            %>
            <%@ include file="/WEB-INF/myPages/adminMyPage.jsp" %>
            <%
                    break;
                case "Majors" :
            %>
            <%@ include file="/WEB-INF/adminPages/Majors.jsp" %>
            <%
                    break;
                case "Classes" :
            %>
            <%@ include file="/WEB-INF/adminPages/Classes.jsp" %>
            <%
                    break;
                case "Teachers" :
            %>
            <%@ include file="/WEB-INF/adminPages/Teachers.jsp" %>
            <%
                        break;
                case "Students" :
            %>
            <%@ include file="/WEB-INF/adminPages/Students.jsp" %>
            <%
                        break;
                case "Courses" :
            %>
            <%@ include file="/WEB-INF/adminPages/Courses.jsp" %>
            <%
                        break;
                case "SC" :
            %>
            <%@ include file="/WEB-INF/adminPages/SC.jsp" %>
            <%
                        break;
                case "TC" :
            %>
            <%@ include file="/WEB-INF/adminPages/TC.jsp" %>
            <%
                        break;
                case "Province" :
            %>
            <%@ include file="/WEB-INF/adminPages/Province.jsp" %>
            <%
                        break;
                case "City" :
            %>
            <%@ include file="/WEB-INF/adminPages/City.jsp" %>
            <%
                        break;
                case "District" :
            %>
            <%@ include file="/WEB-INF/adminPages/District.jsp" %>
            <%
                        break;
                }
            %>
        </div>
    </div>
</main>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/Sidebar-Menu.js"></script>
</body>

</html>
