<%@ page import="com.model.admin.Teachers" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/7/18
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid" id="table_class" style="margin-top: 20px" >
    <h3 class="text-dark mb-4">教师表录入</h3>
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
                        <input name="pageName" type="hidden" value="Teachers">
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
                        <th>教师号</th>
                        <th>教师名</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>电话</th>
                        <th>职称</th>
                        <th>密码</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input class="form-control" type="text" name="yjn_TnoTeachers02" ></td>
                        <td><input class="form-control" type="text" name="yjn_TnameTeachers02" ></td>
                        <td><input class="form-control" type="text" name="yjn_TsexTeachers02" ></td>
                        <td><input class="form-control" type="text" name="yjn_TageTeachers02" ></td>
                        <td><input class="form-control" type="text" name="yjn_TphoneTeachers02" ></td>
                        <td><input class="form-control" type="text" name="yjn_TprofTeachers02" ></td>
                        <td><input class="form-control" type="text" name="yjn_TpasswordTeachers02" ></td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th>教师号</th>
                        <th>教师名</th>
                        <th>性别</th>
                        <th>年龄</th>
                        <th>电话</th>
                        <th>职称</th>
                        <th>密码</th>
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
        <% ArrayList<Teachers> TeachersArrayList = (ArrayList<Teachers>)request.getAttribute("TeachersArrayList"); %>
        <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
            <form action="AdminUpdateAndDelete.do" method="post" id="myForm">

                <table class="table my-0" id="dataTable">
                    <thead>
                    <tr id="form_title">
                        <th>教师编号</th>
                        <th>教师姓名</th>
                        <th>教师性别</th>
                        <th>年龄</th>
                        <th>联系方式</th>
                        <th>职称</th>
                        <th>密码</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if(TeachersArrayList!=null)
                        {
                            for(int i=0; i<TeachersArrayList.size(); ++i)
                            {
                                Teachers coD = TeachersArrayList.get(i);

                    %>


                    <tr>
                        <input class="form-control" type="hidden" id="yjn_TnoTeachers02<%=i%>" name="yjn_TnoTeachers02<%=i%>" value="<%= coD.getYjn_Tno02()%>" readOnly="true">
                        <td ><%= coD.getYjn_Tno02()%></td>
                        <td><input class="form-control" type="text" id="yjn_TnameTeachers02<%=i%>" name="yjn_TnameTeachers02<%=i%>" value="<%= coD.getYjn_Tname02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_TsexTeachers02<%=i%>" name="yjn_TsexTeachers02<%=i%>" value="<%= coD.getYjn_Tsex02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_TageTeachers02<%=i%>" name="yjn_TageTeachers02<%=i%>" value="<%= coD.getYjn_Tage02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_TphoneTeachers02<%=i%>" name="yjn_TphoneTeachers02<%=i%>" value="<%= coD.getYjn_Tphone02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_TprofTeachers02<%=i%>" name="yjn_TprofTeachers02<%=i%>" value="<%= coD.getYjn_Tprof02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_TpasswordTeachers02<%=i%>" name="yjn_TpasswordTeachers02<%=i%>" value="<%= coD.getYjn_Tpassword02()%>"></td>
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

                                document.getElementById("yjn_TnoTeachers02").value = document.getElementById("yjn_TnoTeachers02<%=i%>").value;
                                document.getElementById("yjn_TnameTeachers02").value = document.getElementById("yjn_TnameTeachers02<%=i%>").value;
                                document.getElementById("yjn_TsexTeachers02").value = document.getElementById("yjn_TsexTeachers02<%=i%>").value;
                                document.getElementById("yjn_TageTeachers02").value = document.getElementById("yjn_TageTeachers02<%=i%>").value;
                                document.getElementById("yjn_TphoneTeachers02").value = document.getElementById("yjn_TphoneTeachers02<%=i%>").value;
                                document.getElementById("yjn_TprofTeachers02").value = document.getElementById("yjn_TprofTeachers02<%=i%>").value;
                                document.getElementById("yjn_TpasswordTeachers02").value = document.getElementById("yjn_TpasswordTeachers02<%=i%>").value;


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
                        <th>教师编号</th>
                        <th>教师姓名</th>
                        <th>教师性别</th>
                        <th>年龄</th>
                        <th>联系方式</th>
                        <th>职称</th>
                        <th>密码</th>
                        <th>操作</th>
                    </tr>
                    </tfoot>
                </table>
                <input name="pageName" type="hidden" value="Teachers">
                <input type="hidden" id="hidden" name="hidden">

                <input class="form-control" type="hidden" id="yjn_TnoTeachers02" name="yjn_TnoTeachers02"  readOnly="true">
                <input class="form-control" type="hidden" id="yjn_TnameTeachers02" name="yjn_TnameTeachers02" >
                <input class="form-control" type="hidden" id="yjn_TsexTeachers02" name="yjn_TsexTeachers02" >
                <input class="form-control" type="hidden" id="yjn_TageTeachers02" name="yjn_TageTeachers02" >
                <input class="form-control" type="hidden" id="yjn_TphoneTeachers02" name="yjn_TphoneTeachers02" >
                <input class="form-control" type="hidden" id="yjn_TprofTeachers02" name="yjn_TprofTeachers02" >
                <input class="form-control" type="hidden" id="yjn_TpasswordTeachers02" name="yjn_TpasswordTeachers02" >

            </form>
        </div>

    </div>
</div>

