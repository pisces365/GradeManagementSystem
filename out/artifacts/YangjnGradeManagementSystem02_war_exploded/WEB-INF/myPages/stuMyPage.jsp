<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/31
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid" id="myPage" style="margin-top: 20px;">
    <div class="d-sm-flex justify-content-between align-items-center mb-4">
        <h3 class="text-dark mb-0">我的主页</h3>
    </div>
    <div class="row">
        <div class="col-md-6 col-xl-3 mb-4">
            <a href="/YangjnGradeManagementSystem02_war_exploded/stuGrade.do"  style="text-decoration: none;">
                <div class="card shadow border-left-primary py-2">
                    <div class="card-body">
                        <div class="row align-items-center no-gutters">
                            <div class="col mr-2">
                                <div class="text-uppercase text-primary font-weight-bold text-xs mb-1">
                                    <span>成绩查询</span></div>
                                <div class="text-dark font-weight-bold h5 mb-0"><span>查询所有成绩</span></div>
                            </div>
                            <div class="col-auto"><i class="fas fa-calendar fa-2x text-gray-300"></i></div>
                        </div>
                    </div>
                </div>
            </a>
        </div>

        <div class="col-md-6 col-xl-3 mb-4">
            <a href="/YangjnGradeManagementSystem02_war_exploded/CoursesAndCredits.do" id="QRcode_button" style="text-decoration: none;">
                <div class="card shadow border-left-success py-2">
                    <div class="card-body">
                        <div class="row align-items-center no-gutters">
                            <div class="col mr-2">
                                <div class="text-uppercase text-success font-weight-bold text-xs mb-1">
                                    <span>在修课程学分统计</span></div>
                                <div class="text-dark font-weight-bold h5 mb-0"><span>检索课程及其学分</span></div>
                            </div>
                            <div class="col-auto"><i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </a>
        </div>

        <div class="col-md-6 col-xl-3 mb-4">
            <a href="/YangjnGradeManagementSystem02_war_exploded/stuClassesCourses.do" id="fillTable_button" style="text-decoration: none;">
                <div class="card shadow border-left-primary py-2">
                    <div class="card-body">
                        <div class="row align-items-center no-gutters">
                            <div class="col mr-2">
                                <div class="text-uppercase text-primary font-weight-bold text-xs mb-1">
                                    <span>班级课程开设</span></div>
                                <div class="text-dark font-weight-bold h5 mb-0"><span>查询班级课程信息</span></div>
                            </div>
                            <div class="col-auto"><i class="fas fa-calendar fa-2x text-gray-300"></i></div>
                        </div>
                    </div>
                </div>
            </a>
        </div>

    </div>
</div>
