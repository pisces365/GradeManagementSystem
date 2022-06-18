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
<%@ page import="com.model.teacher.AvgScoreCount" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<AvgScoreCount> AvgScoreCountArrayList =  (ArrayList<AvgScoreCount>)request.getAttribute("AvgScoreCountArrayList");
    ArrayList<String> teaYearsASC =  (ArrayList<String>)request.getSession().getAttribute("teaYears");
%>
<div class="container-fluid" id="table_class" style="margin-top: 20px" >
    <h3 class="text-dark mb-4">课程平均成绩查询</h3>
    <div class="card shadow">
        <div class="card-header py-3">
            <p class="text-primary m-0 font-weight-bold"></p>
        </div>
        <div class="card-body">
            <form action="AvgScoreCount.do" method="post">
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
                                    <% for(int i=0;i<teaYearsASC.size();++i)
                                    { %>
                                    <option value="<%= teaYearsASC.get(i)%>"><%= teaYearsASC.get(i)%></option>
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

                        <th>课程名称</th>
                        <th>开课学年</th>
                        <th>平均成绩</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if(AvgScoreCountArrayList!=null)
                        {
                            for(int i=0; i<AvgScoreCountArrayList.size(); ++i)
                            {
                                AvgScoreCount coD = AvgScoreCountArrayList.get(i);

                    %>
                    <tr>

                        <td><%= coD.getCname()%></td>
                        <td><%= coD.getYear()%></td>
                        <td><%= coD.getAveScore()%></td>
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
                        <th>课程名称</th>
                        <th>开课学年</th>
                        <th>平均成绩</th>
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

