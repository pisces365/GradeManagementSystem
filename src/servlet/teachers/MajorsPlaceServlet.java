package servlet.teachers;

import com.model.teacher.CoursesPlace;
import com.model.teacher.MajorPlace;
import dao.Place.PlaceDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MajorsPlaceServlet", value = "/MajorsPlace.do")
public class MajorsPlaceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "MajorsPlace");

        request.setAttribute("MajorsPlaceArrayList", null);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/teaWeb.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "MajorsPlace");

        String major = request.getParameter("Majors");

        ArrayList<MajorPlace> MajorsPlaceArrayList = null;  //课程排名列表
        try {
            if(major.equals("请选择"))
            {
                request.setAttribute("MajorsPlaceArrayList", null);
            }
            else
            {
                MajorsPlaceArrayList = new PlaceDaoImpl().SelectMajorPlace(major);
                request.setAttribute("MajorsPlaceArrayList", MajorsPlaceArrayList);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/teaWeb.jsp");
        dispatcher.forward(request,response);
    }
}
