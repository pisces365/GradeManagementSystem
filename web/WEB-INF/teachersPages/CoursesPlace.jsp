<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/7/18
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.model.student.stuGrade" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.teacher.CoursesPlace" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<CoursesPlace> CoursesPlaceArrayList =  (ArrayList<CoursesPlace>)request.getAttribute("CoursesPlaceArrayList");
    ArrayList<String> teaYearsCP =  (ArrayList<String>)request.getSession().getAttribute("teaYears");
    ArrayList<String> allCoursesCP =  (ArrayList<String>)request.getSession().getAttribute("allCourses");
%>
<script src="assets/js/echarts.min.js" rel="external nofollow"></script>
<div class="container-fluid" id="table_class" style="margin-top: 20px" >
    <h3 class="text-dark mb-4">学生课程排名概览</h3>
    <div class="card shadow">
        <div class="card-header py-3">
            <p class="text-primary m-0 font-weight-bold"></p>
        </div>
        <div class="card-body">
            <form action="CoursesPlace.do" method="post">
                <div class="row">
                    <div class="col-md-6 text-nowrap">
                        <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">
                            <label style="margin-right: 40px">数量
                                <select class="form-control form-control-sm custom-select custom-select-sm">
                                    <option value="10" selected="">10</option>
                                    <option value="25">25</option>
                                    <option value="50">50</option>
                                    <option value="100">100</option>
                                </select>&nbsp;
                            </label>
                            <label style="margin-right: 40px">学年
                                <select name="TCyear" class="form-control form-control-sm custom-select custom-select-sm">
                                    <option value="请选择" selected="selected">请选择</option>
                                    <% for(int i=0;i<teaYearsCP.size();++i)
                                    { %>
                                    <option value="<%= teaYearsCP.get(i)%>"><%= teaYearsCP.get(i)%></option>
                                    <% }%>
                                </select>&nbsp;
                            </label>
                            <label style="margin-right: 40px">课程
                                <select name="Courses" class="form-control form-control-sm custom-select custom-select-sm">
                                    <option value="请选择" selected="selected">请选择</option>
                                    <% for(int i=0;i<allCoursesCP.size();++i)
                                    { %>
                                    <option value="<%= allCoursesCP.get(i)%>"><%= allCoursesCP.get(i)%></option>
                                    <% }%>
                                </select>&nbsp;
                            </label>
                        </div>
                        <input name="operationNumber" type="hidden" value="1">
                    </div>
                    <div class="col-md-6">
                        <div class="text-md-right dataTables_filter" id="dataTable_filter">
                            <label><button type="submit" class="form-control form-control-sm">搜索</button></label>
                        </div>
                    </div>
                </div>
            </form>
            <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
                <table class="table my-0" id="dataTable">
                    <thead>
                    <tr id="form_title">
                        <th>课程编号</th>
                        <th>课程名称</th>
                        <th>成绩</th>

                        <th>学生学号</th>
                        <th>学生姓名</th>
                        <th>学生班级号</th>
                        <th>学生班级</th>
                        <th>开课学年</th>

                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if(CoursesPlaceArrayList!=null)
                        {
                            for(int i=0; i<CoursesPlaceArrayList.size(); ++i)
                            {
                                CoursesPlace coD = CoursesPlaceArrayList.get(i);

                    %>
                    <tr>
                        <td><%= coD.getCno()%></td>
                        <td><%= coD.getCname()%></td>
                        <td><%= coD.getSCscore()%></td>
                        <td><%= coD.getSno()%></td>
                        <td><%= coD.getSname()%></td>
                        <td><%= coD.getClno()%></td>
                        <td><%= coD.getClname()%></td>
                        <td><%= coD.getSCyear()%></td>
                    </tr>
                    <%      }
                    }else{
                    %>
                    <tr><td> </td></tr>
                    <%
                        }
                    %>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th>课程编号</th>
                        <th>课程名称</th>
                        <th>成绩</th>
                        <th>学生学号</th>
                        <th>学生姓名</th>
                        <th>学生班级号</th>
                        <th>学生班级</th>
                        <th>开课学年</th>
                    </tr>
                    </tfoot>
                </table>
            </div>
            <div class="row">
                <div class="col-md-6 align-self-center">
                    <p id="dataTable_info" class="dataTables_info" role="status" aria-live="polite">第1页</p>
                </div>
                <div class="col-md-6">
                    <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
                        <ul class="pagination">
                            <li class="page-item disabled"><a class="page-link" href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item"><a class="page-link" href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <% ArrayList<String> CoursesScoreDistribution = (ArrayList<String>)request.getAttribute("CoursesScoreDistribution");
        if(CoursesScoreDistribution!=null) { %>
    <h3 class="text-dark mb-4"></h3>
    <div class="row">
    <div class="col-lg-6 col-xl-7">
        <div class="card shadow mb-4">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h6 class="text-primary font-weight-bold m-0">课程成绩段分布柱状图</h6>
                <div class="dropdown no-arrow">

                    <div class="dropdown-menu shadow dropdown-menu-right animated--fade-in"
                         role="menu">
                        <p class="text-center dropdown-header">dropdown header:</p><a
                            class="dropdown-item" role="presentation" href="#">&nbsp;Action</a><a
                            class="dropdown-item" role="presentation" href="#">&nbsp;Another
                        action</a>
                        <div class="dropdown-divider"></div><a class="dropdown-item"
                                                               role="presentation" href="#">&nbsp;Something else here</a>
                    </div>
                </div>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="text-nowrap" style="max-width: 100%;">
                        <form action="showDatasPage" method="post">
                            <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">
                            </div>
                            <input type="hidden" name="tableNum" value="1">
                        </form>
                    </div>
                </div>
                <div id="stu_Histogram" class="chart-area" style="width: 100%; min-height: 400px;">

                </div>
                <script>
                    var chartDom = document.getElementById('stu_Histogram');
                    var myChart = echarts.init(chartDom);
                    var option;

                    option = {
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                            }
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        xAxis: [
                            {
                                type: 'category',
                                data: ['90-100','89-80','79-70','69-60','小于60'],
                                // data: ["123"
                                // ],
                                axisTick: {
                                    alignWithLabel: true
                                }
                            }
                        ],
                        yAxis: [
                            {
                                type: 'value'
                            }
                        ],
                        series: [
                            {
                                name: '成绩段人数',
                                type: 'bar',
                                barWidth: '60%',
                                data: [${requestScope.CoursesScoreDistribution.get(0)},
                                    ${requestScope.CoursesScoreDistribution.get(1)},
                                    ${requestScope.CoursesScoreDistribution.get(2)},
                                    ${requestScope.CoursesScoreDistribution.get(3)},
                                    ${requestScope.CoursesScoreDistribution.get(4)}]
                                // data: [123
                                // ]
                            }
                        ]
                    };

                    option && myChart.setOption(option);
                </script>
            </div>
        </div>
    </div>
    <div class="col-lg-6 col-xl-5">
        <div class="card shadow mb-4">
            <div class="card-header d-flex justify-content-between align-items-center">
                <h6 class="text-primary font-weight-bold m-0">课程成绩比例饼图</h6>
                <div class="dropdown no-arrow">

                    <div class="dropdown-menu shadow dropdown-menu-right animated--fade-in"
                         role="menu">
                        <p class="text-center dropdown-header">dropdown header:</p><a
                            class="dropdown-item" role="presentation" href="#">&nbsp;Action</a><a
                            class="dropdown-item" role="presentation" href="#">&nbsp;Another
                        action</a>
                        <div class="dropdown-divider"></div><a class="dropdown-item"
                                                               role="presentation" href="#">&nbsp;Something else here</a>
                    </div>
                </div>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-6 text-nowrap">
                        <form action="showDatasPage" method="post">
                            <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">
                            </div>
                            <input type="hidden" name="tableNum" value="2">
                        </form>
                    </div>

                </div>
                <div id="stu_PieChart" class="chart-area" style="width: 100%; min-height: 400px;">

                </div>
                <script>
                    var chartDom = document.getElementById('stu_PieChart');
                    var myChart = echarts.init(chartDom);
                    var option;

                    option = {
                        title: {
                            text: '',
                            subtext: '',
                            left: 'right'
                        },
                        tooltip: {
                            trigger: 'item'
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left',
                        },
                        color:[ 'rgb(92,123,217)','rgb(115,192,222)','rgb(145,204,117)','rgb(250,200,88)','rgb(238,102,102)'],
                        series: [
                            {
                                name: '比例',
                                type: 'pie',
                                radius: '50%',
                                data: [
                                    {value: ${requestScope.CoursesScoreDistribution.get(0)}, name: '90-100'},
                                    {value: ${requestScope.CoursesScoreDistribution.get(1)}, name: '89-80'},
                                    {value: ${requestScope.CoursesScoreDistribution.get(2)}, name: '79-70'},
                                    {value: ${requestScope.CoursesScoreDistribution.get(3)}, name: '69-60'},
                                    {value: ${requestScope.CoursesScoreDistribution.get(4)}, name: '小于60'}
                                ],
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };

                    option && myChart.setOption(option);
                </script>
            </div>
        </div>
    </div>
    </div>
    <% } %>
</div>

