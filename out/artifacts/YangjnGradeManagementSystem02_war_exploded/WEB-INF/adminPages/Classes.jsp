<%@ page import="com.model.admin.Classes" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/7/18
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid" id="table_class" style="margin-top: 20px" >
    <h3 class="text-dark mb-4">班级表管理</h3>
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
                        <input name="pageName" type="hidden" value="Classes">
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
                        <th>班级号</th>
                        <th>班级名</th>
                        <th>专业号</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><input class="form-control" type="text" name="yjn_ClnoClasses02" ></td>
                        <td><input class="form-control" type="text" name="yjn_ClnameClasses02" ></td>
                        <td><input class="form-control" type="text" name="yjn_MnoClasses02" ></td>

                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th>班级号</th>
                        <th>班级名</th>
                        <th>专业号</th>
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
        <% ArrayList<Classes> ClassesArrayList = (ArrayList<Classes>)request.getAttribute("ClassesArrayList");
        %>
        <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
            <form action="AdminUpdateAndDelete.do" method="post" id="myForm">
                <table class="table my-0" id="dataTable">
                    <thead>
                    <tr id="form_title">
                        <th>班级编号</th>
                        <th>班级名称</th>
                        <th>所属专业编号</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if(ClassesArrayList!=null)
                        {
                            for(int i=0; i<ClassesArrayList.size(); ++i)
                            {
                                Classes coD = ClassesArrayList.get(i);

                    %>



                    <tr>
                        <input class="form-control" type="hidden" id="yjn_ClnoClasses02<%=i%>" name="yjn_ClnoClasses02<%=i%>" value="<%= coD.getYjn_Clno02()%>" readOnly="true">

                        <td ><%= coD.getYjn_Clno02()%></td>
                        <td><input class="form-control" type="text" id="yjn_ClnameClasses02<%=i%>" name="yjn_ClnameClasses02<%=i%>" value="<%= coD.getYjn_Clname02()%>"></td>
                        <td><input class="form-control" type="text" id="yjn_MnoClasses02<%=i%>" name="yjn_MnoClasses02<%=i%>" value="<%= coD.getYjn_Mno02()%>"></td>
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

                                document.getElementById("yjn_ClnoClasses02").value = document.getElementById("yjn_ClnoClasses02<%=i%>").value;
                                document.getElementById("yjn_ClnameClasses02").value = document.getElementById("yjn_ClnameClasses02<%=i%>").value;
                                document.getElementById("yjn_MnoClasses02").value = document.getElementById("yjn_MnoClasses02<%=i%>").value;

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
                        <th>班级编号</th>
                        <th>班级名称</th>
                        <th>所属专业编号</th>
                        <th>操作</th>
                    </tr>
                    </tfoot>
                </table>
                <input name="pageName" type="hidden" value="Classes">
                <input type="hidden" id="hidden" name="hidden">

                <input class="form-control" type="hidden" id="yjn_ClnoClasses02" name="yjn_ClnoClasses02"  readOnly="true">

                <input class="form-control" type="hidden" id="yjn_ClnameClasses02" name="yjn_ClnameClasses02" >
                <input class="form-control" type="hidden" id="yjn_MnoClasses02" name="yjn_MnoClasses02" >

            </form>
        </div>

    </div>
</div>

