<%@ page import="com.model.admin.TC" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/7/18
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid" id="table_class" style="margin-top: 20px" >
    <h3 class="text-dark mb-4">教师任课新增</h3>
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
                        <input name="pageName" type="hidden" value="TC">
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
                        <th>教师编号</th>
                        <th>课程号</th>
                        <th>班级号</th>
                        <th>授课学年</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input class="form-control" type="text" name="yjn_TnoTC02" ></td>
                        <td><input class="form-control" type="text" name="yjn_CnoTC02" ></td>
                        <td><input class="form-control" type="text" name="yjn_ClnoTC02" ></td>
                        <td><input class="form-control" type="text" name="yjn_TCyearTC02" ></td>

                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th>教师编号</th>
                        <th>课程号</th>
                        <th>班级号</th>
                        <th>授课学年</th>
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
        <% ArrayList<TC> TCArrayList = (ArrayList<TC>)request.getAttribute("TCArrayList"); %>
        <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
            <form action="AdminUpdateAndDelete.do" method="post" id="myForm">

                <table class="table my-0" id="dataTable">
                    <thead>
                    <tr id="form_title">
                        <th>教师编号</th>
                        <th>课程编号</th>
                        <th>授课班级编号</th>
                        <th>开课学年</th>
                        <th>操作</th>

                    </tr>
                    </thead>
                    <tbody>


                    <%
                        if(TCArrayList!=null)
                        {
                            for(int i=0; i<TCArrayList.size(); ++i)
                            {
                                TC coD = TCArrayList.get(i);

                    %>


                    <tr>
                        <input class="form-control" type="hidden" id="yjn_TnoTC02<%=i%>" name="yjn_TnoTC02<%=i%>" value="<%= coD.getYjn_Tno02()%>" readOnly="true">
                        <input class="form-control" type="hidden" id="yjn_CnoTC02<%=i%>" name="yjn_CnoTC02<%=i%>" value="<%= coD.getYjn_Cno02()%>" readOnly="true">
                        <input class="form-control" type="hidden" id="yjn_ClnoTC02<%=i%>" name="yjn_ClnoTC02<%=i%>" value="<%= coD.getYjn_Clno02()%>" readOnly="true">
                        <input class="form-control" type="hidden" id="yjn_TCyearTC02<%=i%>" name="yjn_TCyearTC02<%=i%>" value="<%= coD.getYjn_TCyear02()%>" readOnly="true">

                        <td ><%= coD.getYjn_Tno02()%></td>
                        <td ><%= coD.getYjn_Cno02()%></td>
                        <td ><%= coD.getYjn_Clno02()%></td>
                        <td ><%= coD.getYjn_TCyear02()%></td>
                        <td>
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

                                document.getElementById("yjn_TnoTC02").value = document.getElementById("yjn_TnoTC02<%=i%>").value;
                                document.getElementById("yjn_CnoTC02").value = document.getElementById("yjn_CnoTC02<%=i%>").value;
                                document.getElementById("yjn_ClnoTC02").value = document.getElementById("yjn_ClnoTC02<%=i%>").value;
                                document.getElementById("yjn_TCyearTC02").value = document.getElementById("yjn_TCyearTC02<%=i%>").value;


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
                        <th>课程编号</th>
                        <th>授课班级编号</th>
                        <th>开课学年</th>
                        <th>操作</th>
                    </tr>
                    </tfoot>
                </table>
                <input name="pageName" type="hidden" value="TC">
                <input type="hidden" id="hidden" name="hidden">

                <input class="form-control" type="hidden" id="yjn_TnoTC02" name="yjn_TnoTC02"  readOnly="true">
                <input class="form-control" type="hidden" id="yjn_CnoTC02" name="yjn_CnoTC02"  readOnly="true">
                <input class="form-control" type="hidden" id="yjn_ClnoTC02" name="yjn_ClnoTC02"  readOnly="true">
                <input class="form-control" type="hidden" id="yjn_TCyearTC02" name="yjn_TCyearTC02"  readOnly="true">

            </form>
        </div>

    </div>
</div>

