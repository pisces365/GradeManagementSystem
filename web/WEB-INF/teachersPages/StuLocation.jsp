<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/7/18
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.model.teacher.ClassesPlace" %>
<%@ page import="com.model.teacher.StuLocation" %>
<%@ page import="com.model.teacher.Region" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<StuLocation> StuLocationPlaceArrayList =  (ArrayList<StuLocation>)request.getAttribute("StuLocationPlaceArrayList");
    ArrayList<Region> Province =  (ArrayList<Region>)request.getAttribute("Province");
%>
<div class="container-fluid" id="table_class" style="margin-top: 20px" >
    <h3 class="text-dark mb-4">学生地区统计</h3>
    <div class="card shadow">
        <div class="card-header py-3">
            <p class="text-primary m-0 font-weight-bold"></p>
        </div>
        <div class="card-body">
            <form action="StuLocation.do" method="post">
                <div class="row">
                    <div class="col-md-8 text-nowrap">
                        <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">
                            <label style="margin-right: 40px">数量
                                <select class="form-control form-control-sm custom-select custom-select-sm">
                                    <option value="10" selected="">10</option>
                                    <option value="25">25</option>
                                    <option value="50">50</option>
                                    <option value="100">100</option>
                                </select>&nbsp;
                            </label>
                            <label style="margin-right: 40px">省
                                <select id="Province" name="Province" class="form-control form-control-sm custom-select custom-select-sm" onchange="refeshClassesListProvince();">
                                    <option value="请选择" selected="selected">请选择</option>
                                    <% for(int i=0;i<Province.size();++i)
                                    { %>
                                    <option value="<%= Province.get(i).getNum()%>"><%= Province.get(i).getName()%></option>
                                    <% }%>
                                </select>&nbsp;
                            </label>
                            <label style="margin-right: 40px">市
                                <select id="City" name="City" class="form-control form-control-sm custom-select custom-select-sm" onchange="refeshClassesListDistrict();">
                                    <option value="请选择" selected="selected">请选择</option>

                                </select>&nbsp;
                            </label>
                            <script>
                                var xmlHttp;
                                function createXMLHttpRequestProvince()
                                {
                                    if(window.XMLHttpRequest)
                                    {
                                        xmlHttp = new XMLHttpRequest();
                                    }
                                    else
                                    {
                                        xmlHttp = new ActiveXObject("Microsoft.XMLHttp");
                                    }
                                }
                                function refeshClassesListProvince()
                                {
                                    var Province = document.getElementById("Province").value;
                                    if(Province == "请选择")
                                    {
                                        //清空Classes列表
                                        clearNameListProvince();
                                        return;
                                    }
                                    var url = "StuLocationOptionUpdate.do?Province="+Province;
                                    createXMLHttpRequestProvince();
                                    xmlHttp.onreadystatechange = handleStateChangeProvince;
                                    xmlHttp.open("GET",url,true);
                                    xmlHttp.send(null);
                                }
                                function handleStateChangeProvince()
                                {
                                    if(xmlHttp.readyState == 4)
                                    {
                                        if(xmlHttp.status == 200)
                                        {
                                            //清空Classes列表
                                            clearNameListProvince();
                                            //获取并添加
                                            var CityItem = document.getElementById("City");
                                            var CityNum = xmlHttp.responseXML.getElementsByTagName("CityNum");
                                            console.log(CityNum);
                                            var CityName = xmlHttp.responseXML.getElementsByTagName("CityName");
                                            var option = null;
                                            for(var i=0;i<CityNum.length;i++)
                                            {
                                                option = document.createElement("option");
                                                option.appendChild(document.createTextNode(CityName[i].firstChild.nodeValue));
                                                option.value = CityNum[i].firstChild.nodeValue;
                                                CityItem.appendChild(option);
                                            }
                                        }
                                    }
                                }
                                function clearNameListProvince()
                                {
                                    var CityItem = document.getElementById("City");
                                    while (CityItem.childNodes.length > 2)
                                    {
                                        CityItem.removeChild(CityItem.childNodes[CityItem.childNodes.length-1]);
                                    }
                                }
                            </script>
                            <label style="margin-right: 40px">区
                                <select id="District" name="District" class="form-control form-control-sm custom-select custom-select-sm">
                                    <option value="请选择" selected="selected">请选择</option>

                                </select>&nbsp;
                            </label>
                            <script>
                                var xmlHttp;
                                function createXMLHttpRequestDistrict()
                                {
                                    if(window.XMLHttpRequest)
                                    {
                                        xmlHttp = new XMLHttpRequest();
                                    }
                                    else
                                    {
                                        xmlHttp = new ActiveXObject("Microsoft.XMLHttp");
                                    }
                                }
                                function refeshClassesListDistrict()
                                {
                                    var City = document.getElementById("City").value;
                                    if(City == "请选择")
                                    {
                                        //清空Classes列表
                                        clearNameListDistrict();
                                        return;
                                    }
                                    var url = "StuLocationOptionUpdate.do?City="+City;
                                    createXMLHttpRequestDistrict();
                                    xmlHttp.onreadystatechange = handleStateChangeDistrict;
                                    xmlHttp.open("GET",url,true);
                                    xmlHttp.send(null);
                                }
                                function handleStateChangeDistrict()
                                {
                                    if(xmlHttp.readyState == 4)
                                    {
                                        if(xmlHttp.status == 200)
                                        {
                                            //清空Classes列表
                                            clearNameListDistrict();
                                            //获取并添加
                                            var DistrictItem = document.getElementById("District");
                                            var DistrictNum = xmlHttp.responseXML.getElementsByTagName("DistrictNum");
                                            var DistrictName = xmlHttp.responseXML.getElementsByTagName("DistrictName");
                                            var option = null;
                                            for(var i=0;i<DistrictNum.length;i++)
                                            {
                                                option = document.createElement("option");
                                                option.appendChild(document.createTextNode(DistrictName[i].firstChild.nodeValue));
                                                option.value = DistrictNum[i].firstChild.nodeValue;
                                                DistrictItem.appendChild(option);
                                            }
                                        }
                                    }
                                }
                                function clearNameListDistrict()
                                {
                                    var DistrictItem = document.getElementById("District");
                                    while (DistrictItem.childNodes.length > 2)
                                    {
                                        DistrictItem.removeChild(DistrictItem.childNodes[DistrictItem.childNodes.length-1]);
                                    }
                                }
                            </script>
                        </div>
                        <input name="operationNumber" type="hidden" value="1">
                    </div>
                    <div class="col-md-4">
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
                        <th>学生学号</th>
                        <th>学生姓名</th>
                        <th>省</th>
                        <th>市</th>
                        <th>区</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if(StuLocationPlaceArrayList!=null)
                        {
                            for(int i=0; i<StuLocationPlaceArrayList.size(); ++i)
                            {
                                StuLocation coD = StuLocationPlaceArrayList.get(i);

                    %>
                    <tr>
                        <td><%= coD.getSno()%></td>
                        <td><%= coD.getSname()%></td>
                        <td><%= coD.getPname()%></td>
                        <td><%= coD.getCiname()%></td>
                        <td><%= coD.getDname()%></td>

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
                        <th>省</th>
                        <th>市</th>
                        <th>区</th>
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


