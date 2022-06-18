<%@ page import="com.model.admin.Courses" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/7/18
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid" id="table_class" style="margin-top: 20px" >
    <h3 class="text-dark mb-4">课程表管理</h3>
    <div class="card shadow">
        <div class="card-header py-3">
            <p class="text-primary m-0 font-weight-bold">录入</p>
        </div>
        <form action="Admin.do" method="post">
        <div class="card-body">

                <div class="row">
                    <div class="col-md-6 text-nowrap">
                        <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">

                        </div>
                        <input name="pageName" type="hidden" value="Courses">
                    </div>
                    <div class="col-md-6">
                        <div class="text-md-right dataTables_filter" id="dataTable_filter">
                            <label><button onclick="return confirm('确定要提交吗？');" type="submit" class="form-control form-control-sm">提交</button></label>
                        </div>
                    </div>
                </div>

            <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
                <table class="table my-0" id="dataTable">
                    <thead>
                    <tr id="form_title">
                        <th>课程号</th>
                        <th>班级号</th>
                        <th>课程名</th>
                        <th>课程学分</th>
                        <th>考核方式</th>
                        <th>开设学期</th>
                        <th>课程学时</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input class="form-control" type="text" name="yjn_CnoCourses02" ></td>
                        <td><input class="form-control" type="text" name="yjn_ClnoCourses02" ></td>
                        <td><input class="form-control" type="text" name="yjn_CnameCourses02" ></td>
                        <td><input class="form-control" type="text" name="yjn_CcreditCourses02" ></td>
                        <td><input class="form-control" type="text" name="yjn_CevaluationCourses02" ></td>
                        <td><input class="form-control" type="text" name="yjn_CtermCourses02" ></td>
                        <td><input class="form-control" type="text" name="yjn_CperiodCourses02" ></td>

                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th>课程号</th>
                        <th>班级号</th>
                        <th>课程名</th>
                        <th>课程学分</th>
                        <th>考核方式</th>
                        <th>开设学期</th>
                        <th>课程学时</th>
                    </tr>
                    </tfoot>
                </table>
            </div>
            <div class="row">

            </div>
        </div>
        </form>


    </div>
    <h3 class="text-dark mb-4"></h3>
    <div class="card shadow">
        <div class="card-header py-3">
            <p class="text-primary m-0 font-weight-bold">更新</p>
        </div>
        <% ArrayList<Courses> CoursesArrayList = (ArrayList<Courses>)request.getAttribute("CoursesArrayList");
        %>
        <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
            <form action="AdminUpdateAndDelete.do" method="post" id="myForm">

                <table class="table my-0" id="dataTable">
                    <thead>
                    <tr id="form_title">
                        <th>课程号</th>
                        <th>班级号</th>
                        <th>课程名</th>
                        <th>课程学分</th>
                        <th>考核方式</th>
                        <th>开设学期</th>
                        <th>课程学时</th>
                        <th>操作</th>

                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if(CoursesArrayList!=null)
                        {
                            for(int i=0; i<CoursesArrayList.size(); ++i)
                            {
                                Courses coD = CoursesArrayList.get(i);

                    %>


                    <tr>
                        <input class="form-control" type="hidden" id="yjn_CnoCourses02<%=i%>" name="yjn_CnoCourses02<%=i%>" value="<%= coD.getYjn_Cno02()%>" readOnly="true">
                        <input class="form-control" type="hidden" id="yjn_ClnoCourses02<%=i%>" name="yjn_ClnoCourses02<%=i%>" value="<%= coD.getYjn_Clno02()%>" readOnly="true">

                        <td ><%= coD.getYjn_Cno02()%></td>
                        <td ><%= coD.getYjn_Clno02()%></td>
                        <td><input class="form-control" type="text" id="yjn_CnameCourses02<%=i%>" name="yjn_CnameCourses02<%=i%>" value="<%= coD.getYjn_Cname02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_CcreditCourses02<%=i%>" name="yjn_CcreditCourses02<%=i%>" value="<%= coD.getYjn_Ccredit02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_CevaluationCourses02<%=i%>" name="yjn_CevaluationCourses02<%=i%>" value="<%= coD.getYjn_Cevaluation02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_CtermCourses02<%=i%>" name="yjn_CtermCourses02<%=i%>" value="<%= coD.getYjn_Cterm02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_CperiodCourses02<%=i%>" name="yjn_CperiodCourses02<%=i%>" value="<%= coD.getYjn_Cperiod02()%>"></td>
                        <td>
                            <label><input onclick="return submitFun<%=i%>('edit');" type="button" class="form-control form-control-sm" value="更新"></label>
                        </td>
                        <script>
                            function submitFun<%=i%>(act)
                            {
                                if(confirm('确定要提交吗？') === false)
                                {
                                    return false;
                                }
                                document.getElementById("hidden").value = act;

                                document.getElementById("yjn_CnoCourses02").value = document.getElementById("yjn_CnoCourses02<%=i%>").value;
                                document.getElementById("yjn_ClnoCourses02").value = document.getElementById("yjn_ClnoCourses02<%=i%>").value;
                                document.getElementById("yjn_CnameCourses02").value = document.getElementById("yjn_CnameCourses02<%=i%>").value;
                                document.getElementById("yjn_CcreditCourses02").value = document.getElementById("yjn_CcreditCourses02<%=i%>").value;
                                document.getElementById("yjn_CevaluationCourses02").value = document.getElementById("yjn_CevaluationCourses02<%=i%>").value;
                                document.getElementById("yjn_CtermCourses02").value = document.getElementById("yjn_CtermCourses02<%=i%>").value;
                                document.getElementById("yjn_CperiodCourses02").value = document.getElementById("yjn_CperiodCourses02<%=i%>").value;


                                document.getElementById("myForm").submit();
                                return true;
                            }
                        </script>
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
                        <th>课程号</th>
                        <th>班级号</th>
                        <th>课程名</th>
                        <th>课程学分</th>
                        <th>考核方式</th>
                        <th>开设学期</th>
                        <th>课程学时</th>
                        <th>操作</th>
                    </tr>
                    </tfoot>
                </table>
                <input name="pageName" type="hidden" value="Courses">
                <input type="hidden" id="hidden" name="hidden">

                <input class="form-control" type="hidden" id="yjn_CnoCourses02" name="yjn_CnoCourses02"  readOnly="true">
                <input class="form-control" type="hidden" id="yjn_ClnoCourses02" name="yjn_ClnoCourses02"  readOnly="true">
                <input class="form-control" type="hidden" id="yjn_CnameCourses02" name="yjn_CnameCourses02" >
                <input class="form-control" type="hidden" id="yjn_CcreditCourses02" name="yjn_CcreditCourses02" >
                <input class="form-control" type="hidden" id="yjn_CevaluationCourses02" name="yjn_CevaluationCourses02">
                <input class="form-control" type="hidden" id="yjn_CtermCourses02" name="yjn_CtermCourses02" >
                <input class="form-control" type="hidden" id="yjn_CperiodCourses02" name="yjn_CperiodCourses02" >

            </form>
        </div>

    </div>
</div>

