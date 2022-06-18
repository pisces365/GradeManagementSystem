<%@ page import="com.model.admin.Students" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/7/18
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid" id="table_class" style="margin-top: 20px" >
    <h3 class="text-dark mb-4">学生表管理</h3>
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
                        <input name="pageName" type="hidden" value="Students">
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
                        <th>学号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>已修学分</th>
                        <th>生源地编号</th>
                        <th>密码</th>
                        <th>班级号</th>
                        <th>当前绩点</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input class="form-control" type="text" name="yjn_SnoStudents02" ></td>
                        <td><input class="form-control" type="text" name="yjn_SnameStudents02" ></td>
                        <td><input class="form-control" type="text" name="yjn_SsexStudents02" ></td>
                        <td><input class="form-control" type="text" name="yjn_SageStudents02" ></td>
                        <td><input class="form-control" type="text" name="yjn_ScreditsStudents02" ></td>
                        <td><input class="form-control" type="text" name="yjn_SlocationStudents02" ></td>
                        <td><input class="form-control" type="text" name="yjn_SpasswordStudents02" ></td>
                        <td><input class="form-control" type="text" name="yjn_ClnoStudents02" ></td>
                        <td><input class="form-control" type="text" name="yjn_SscoreStudents02" ></td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>已修学分</th>
                        <th>生源地编号</th>
                        <th>密码</th>
                        <th>班级号</th>
                        <th>当前绩点</th>
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
        <% ArrayList<Students> StudentsArrayList = (ArrayList<Students>)request.getAttribute("StudentsArrayList"); %>
        <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
            <form action="AdminUpdateAndDelete.do" method="post" id="myForm">

                <table class="table my-0" id="dataTable">
                    <thead>
                    <tr id="form_title">
                        <th>学生学号</th>
                        <th>学生姓名</th>
                        <th>学生性别</th>
                        <th>年龄</th>
                        <th>已修学分</th>
                        <th>生源地编号</th>
                        <th>密码</th>
                        <th>班级号</th>
                        <th>绩点</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <%
                        if(StudentsArrayList!=null)
                        {
                            for(int i=0; i<StudentsArrayList.size(); ++i)
                            {
                                Students coD = StudentsArrayList.get(i);

                    %>


                    <tr>
                        <input class="form-control" type="hidden" id="yjn_SnoStudents02<%=i%>" name="yjn_SnoStudents02<%=i%>" value="<%= coD.getYjn_Sno02()%>" readOnly="true">
                        <td ><%= coD.getYjn_Sno02()%></td>
                        <td><input class="form-control" type="text" id="yjn_SnameStudents02<%=i%>" name="yjn_SnameStudents02<%=i%>" value="<%= coD.getYjn_Sname02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_SsexStudents02<%=i%>" name="yjn_SsexStudents02<%=i%>" value="<%= coD.getYjn_Ssex02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_SageStudents02<%=i%>" name="yjn_SageStudents02<%=i%>" value="<%= coD.getYjn_Sage02()%>"></td>
                        <td><input readOnly="true" class="form-control" type="text" id="yjn_ScreditsStudents02<%=i%>" name="yjn_ScreditsStudents02<%=i%>" value="<%= coD.getYjn_Scredits02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_SlocationStudents02<%=i%>" name="yjn_SlocationStudents02<%=i%>" value="<%= coD.getYjn_Slocation02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_SpasswordStudents02<%=i%>" name="yjn_SpasswordStudents02<%=i%>" value="<%= coD.getYjn_Spassword02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_ClnoStudents02<%=i%>" name="yjn_ClnoStudents02<%=i%>" value="<%= coD.getYjn_Clno02()%>"></td>
                        <td><input readOnly="true" class="form-control" type="text" id="yjn_SscoreStudents02<%=i%>" name="yjn_SscoreStudents02<%=i%>" value="<%= coD.getYjn_Sscore02()%>"></td>
                        <td>
                            <label><input onclick="return submitFun<%=i%>('edit');" type="button" class="form-control form-control-sm" value="更新"></label>
                            <label><input onclick="return submitFun<%=i%>('del');" type="button" class="form-control form-control-sm" value="删除"></label>
                        </td>
                        <script>
                            function submitFun<%=i%>(act)
                            {
                                if(confirm('确定要提交吗？') === false)
                                {
                                    return false;
                                }
                                document.getElementById("hidden").value = act;

                                document.getElementById("yjn_SnoStudents02").value = document.getElementById("yjn_SnoStudents02<%=i%>").value;
                                document.getElementById("yjn_SnameStudents02").value = document.getElementById("yjn_SnameStudents02<%=i%>").value;
                                document.getElementById("yjn_SageStudents02").value = document.getElementById("yjn_SageStudents02<%=i%>").value;
                                document.getElementById("yjn_ScreditsStudents02").value = document.getElementById("yjn_ScreditsStudents02<%=i%>").value;
                                document.getElementById("yjn_SlocationStudents02").value = document.getElementById("yjn_SlocationStudents02<%=i%>").value;
                                document.getElementById("yjn_SpasswordStudents02").value = document.getElementById("yjn_SpasswordStudents02<%=i%>").value;
                                document.getElementById("yjn_SsexStudents02").value = document.getElementById("yjn_SsexStudents02<%=i%>").value;
                                document.getElementById("yjn_ClnoStudents02").value = document.getElementById("yjn_ClnoStudents02<%=i%>").value;
                                document.getElementById("yjn_SscoreStudents02").value = document.getElementById("yjn_SscoreStudents02<%=i%>").value;


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
                        <th>学生学号</th>
                        <th>学生姓名</th>
                        <th>学生性别</th>
                        <th>年龄</th>
                        <th>已修学分</th>
                        <th>生源地编号</th>
                        <th>密码</th>
                        <th>班级号</th>
                        <th>绩点</th>
                        <th>操作</th>
                    </tr>
                    </tfoot>
                </table>
                <input name="pageName" type="hidden" value="Students">
                <input type="hidden" id="hidden" name="hidden">


                <input class="form-control" type="hidden" id="yjn_SnoStudents02" name="yjn_SnoStudents02"  readOnly="true">
                <input class="form-control" type="hidden" id="yjn_SnameStudents02" name="yjn_SnameStudents02" >
                <input class="form-control" type="hidden" id="yjn_SsexStudents02" name="yjn_SsexStudents02" >
                <input class="form-control" type="hidden" id="yjn_SageStudents02" name="yjn_SageStudents02" >
                <input class="form-control" type="hidden" id="yjn_ScreditsStudents02" name="yjn_ScreditsStudents02" >
                <input class="form-control" type="hidden" id="yjn_SlocationStudents02" name="yjn_SlocationStudents02" >
                <input class="form-control" type="hidden" id="yjn_SpasswordStudents02" name="yjn_SpasswordStudents02" >
                <input class="form-control" type="hidden" id="yjn_ClnoStudents02" name="yjn_ClnoStudents02" >
                <input class="form-control" type="hidden" id="yjn_SscoreStudents02" name="yjn_SscoreStudents02" >

            </form>
        </div>

    </div>
</div>

