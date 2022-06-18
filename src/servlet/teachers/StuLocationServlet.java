package servlet.teachers;

import com.model.teacher.Region;
import com.model.teacher.StuLocation;
import dao.StuLocation.StuLocationDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StuLocationServlet", value = "/StuLocation.do")
public class StuLocationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "StuLocation");

        request.setAttribute("StuLocationPlaceArrayList", null);


        try
        {
            ArrayList<Region> Province = new StuLocationDaoImpl().SelectProvince();
            request.setAttribute("Province", Province);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/teaWeb.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "StuLocation");

        String p = request.getParameter("Province");
        String c = request.getParameter("City");
        String d = request.getParameter("District");
        ArrayList<StuLocation> StuLocationPlaceArrayList = null;
        try
        {
            if(!p.equals("请选择")&&!c.equals("请选择")&&!d.equals("请选择"))
            {
                StuLocationPlaceArrayList = new StuLocationDaoImpl().SelectStuLocation(p,c,d);
            }
            else if(!p.equals("请选择")&&!c.equals("请选择"))
            {
                StuLocationPlaceArrayList = new StuLocationDaoImpl().SelectStuLocation(p,c,"");
            }
            else if(!p.equals("请选择"))
            {
                StuLocationPlaceArrayList = new StuLocationDaoImpl().SelectStuLocation(p,"","");
            }

            request.setAttribute("StuLocationPlaceArrayList", StuLocationPlaceArrayList);
        }
        catch (Exception e){}

        try
        {
            ArrayList<Region> Province = new StuLocationDaoImpl().SelectProvince();
            request.setAttribute("Province", Province);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/teaWeb.jsp");
        dispatcher.forward(request,response);
    }
}
