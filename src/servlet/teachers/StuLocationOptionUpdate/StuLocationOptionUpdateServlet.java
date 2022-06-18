package servlet.teachers.StuLocationOptionUpdate;

import com.model.teacher.Region;
import dao.MajorsAndClassesSelect.MajorsAndClassesSelectDaoImpl;
import dao.StuLocation.StuLocationDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StuLocationOptionUpdateServlet", value = "/StuLocationOptionUpdate.do")
public class StuLocationOptionUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String province = request.getParameter("Province");
        String city = request.getParameter("City");

        if(city!=null)
        {
            ArrayList<Region> districts = null;
            try
            {
                districts = new StuLocationDaoImpl().SelectDistrict(city);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            StringBuffer results = new StringBuffer("<Districts>");
            for(int i=0;i<districts.size();++i)
            {
                results.append("<DistrictNum>");
                results.append(districts.get(i).getNum());
                results.append("</DistrictNum>");
                results.append("<DistrictName>");
                results.append(districts.get(i).getName());
                results.append("</DistrictName>");
            }
            results.append("</Districts>");
            response.setContentType("text/xml;charset=UTF-8");
            response.getWriter().println(results.toString());
        }
        else
        {
            ArrayList<Region> cities = null;
            try
            {
                cities = new StuLocationDaoImpl().SelectCity(province);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            StringBuffer results = new StringBuffer("<Cities>");
            for(int i=0;i<cities.size();++i)
            {
                results.append("<CityNum>");
                results.append(cities.get(i).getNum());
                results.append("</CityNum>");
                results.append("<CityName>");
                results.append(cities.get(i).getName());
                results.append("</CityName>");
            }
            results.append("</Cities>");
            response.setContentType("text/xml;charset=UTF-8");
            response.getWriter().println(results.toString());
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
