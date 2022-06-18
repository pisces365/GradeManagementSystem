<%@ page import="com.model.student.stuGrade" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/31
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<stuGrade> stuGradeArrayList =  (ArrayList<stuGrade>)request.getAttribute("stuGradeArrayList");
    ArrayList<String> stuYears =  (ArrayList<String>)request.getSession().getAttribute("stuYears");
    ArrayList<String> CreditsAndScores =  (ArrayList<String>)request.getSession().getAttribute("CreditsAndScores");
%>
<div class="container-fluid" id="table_class" style="margin-top: 20px" >
    <h3 class="text-dark mb-4">学生成绩查询</h3>
    <div class="row">
        <div class="col-md-6 col-xl-3 mb-4">
            <div class="card shadow border-left-primary py-2">
                <div class="card-body">
                    <div class="row align-items-center no-gutters">
                        <div class="col mr-2">
                            <div class="text-uppercase text-primary font-weight-bold text-xs mb-1">
                                <span>当前总学分</span></div>
                            <div class="text-dark font-weight-bold h5 mb-0"><span>${requestScope.CreditsAndScores.get(0)}</span></div>
                        </div>
                        <div class="col-auto"><i class="fas fa-calendar fa-2x text-gray-300"></i></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col-xl-3 mb-4">
            <div class="card shadow border-left-success py-2">
                <div class="card-body">
                    <div class="row align-items-center no-gutters">
                        <div class="col mr-2">
                            <div class="text-uppercase text-success font-weight-bold text-xs mb-1">
                                <span>当前平均绩点</span></div>
                            <div class="text-dark font-weight-bold h5 mb-0"><span>${requestScope.CreditsAndScores.get(1)} GPA</span></div>
                        </div>
                        <div class="col-auto"><i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="card shadow">
        <div class="card-header py-3">
            <p class="text-primary m-0 font-weight-bold"></p>
        </div>

        <div class="card-body">
            <form action="stuGrade.do" method="post">
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
                            <select name="SCyear" class="form-control form-control-sm custom-select custom-select-sm">
                                <option value="请选择" selected="selected">请选择</option>
                                <% for(int i=0;i<stuYears.size();++i)
                                { %>
                                <option value="<%= stuYears.get(i)%>"><%= stuYears.get(i)%></option>
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
                        <th>班级</th>
                        <th>成绩</th>
                        <th>开课学年</th>
                        <th>课程名称</th>
                        <th>课程学分</th>
                        <th>考核方式</th>
                        <th>开设学期</th>
                        <th>课程学时</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if(stuGradeArrayList!=null)
                        {
                            for(int i=0; i<stuGradeArrayList.size(); ++i)
                            {
                                stuGrade coD = stuGradeArrayList.get(i);
                            if(coD.getSCscore()<60){
                    %>
                    <tr style="background-color: rgba(255,0,0,0.1);">
                    <% }else{ %>
                    <tr>
                    <% } %>
                        <td><%= coD.getCno()%></td>
                        <td><%= coD.getClname()%></td>
                        <td><%= coD.getSCscore()%></td>
                        <td><%= coD.getSCyear()%></td>
                        <td><%= coD.getCname()%></td>
                        <td><%= coD.getCcredit()%></td>
                        <td><%= coD.getCevaluation()%></td>
                        <td><%= coD.getCterm()%></td>
                        <td><%= coD.getCperiod()%></td>
                    </tr>
                    <%      }
                    }else{
                    %>
                        <tr><td>无查询结果</td></tr>
                    <%
                        }
                    %>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th>课程编号</th>
                        <th>班级</th>
                        <th>成绩</th>
                        <th>开课学年</th>
                        <th>课程名称</th>
                        <th>课程学分</th>
                        <th>考核方式</th>
                        <th>开设学期</th>
                        <th>课程学时</th>
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
</div>
