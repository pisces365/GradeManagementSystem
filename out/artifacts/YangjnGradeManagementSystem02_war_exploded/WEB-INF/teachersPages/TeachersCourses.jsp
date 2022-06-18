<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/7/18
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.model.student.stuGrade" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.teacher.TeachersCourses" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<TeachersCourses> TeachersCoursesArrayList =  (ArrayList<TeachersCourses>)request.getAttribute("TeachersCoursesArrayList");
%>
<div class="container-fluid" id="table_class" style="margin-top: 20px" >
    <h3 class="text-dark mb-4">教师任课查询</h3>
    <div class="card shadow">
        <div class="card-header py-3">
            <p class="text-primary m-0 font-weight-bold"></p>
        </div>
        <div class="card-body">
            <form action="TeachersCourses.do" method="post">
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

                        </div>
                        <input name="operationNumber" type="hidden" value="1">
                    </div>
                    <div class="col-md-6">
                        <div class="text-md-right dataTables_filter" id="dataTable_filter">
                        </div>
                    </div>
                </div>
            </form>
            <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
                <table class="table my-0" id="dataTable">
                    <thead>
                    <tr id="form_title">

                        <th>教师编号</th>
                        <th>教师名称</th>
                        <th>课程编号</th>
                        <th>班级名称</th>
                        <th>开课学年</th>
                        <th>课程名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if(TeachersCoursesArrayList!=null)
                        {
                            for(int i=0; i<TeachersCoursesArrayList.size(); ++i)
                            {
                                TeachersCourses coD = TeachersCoursesArrayList.get(i);

                    %>
                    <tr>

                        <td><%= coD.getTno()%></td>
                        <td><%= coD.getTname()%></td>
                        <td><%= coD.getCno()%></td>
                        <td><%= coD.getClname()%></td>
                        <td><%= coD.getTCyear()%></td>
                        <td><%= coD.getCname()%></td>
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

                        <th>教师编号</th>
                        <th>教师名称</th>
                        <th>课程编号</th>
                        <th>班级名称</th>
                        <th>开课学年</th>
                        <th>课程名称</th>
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

