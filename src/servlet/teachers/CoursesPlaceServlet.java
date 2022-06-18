package servlet.teachers;

import com.model.student.stuGrade;
import com.model.student.stuInfo;
import com.model.teacher.CoursesPlace;
import dao.Place.PlaceDaoImpl;
import dao.stuGrade.StuGradeDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CoursesPlaceServlet", value = "/CoursesPlace.do")
public class CoursesPlaceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "CoursesPlace");

        request.setAttribute("CoursesPlaceArrayList", null);
        request.setAttribute("CoursesScoreDistribution", null);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/teaWeb.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "CoursesPlace");

        String year = request.getParameter("TCyear");
        String courses = request.getParameter("Courses");

        ArrayList<CoursesPlace> CoursesPlaceArrayList = null;  //课程排名列表
        try {
            if(year.equals("请选择")||courses.equals("请选择"))
            {
                request.setAttribute("CoursesPlaceArrayList", null);
                request.setAttribute("CoursesScoreDistribution", null);
            }
            else
            {
                ArrayList<String> CoursesScoreDistribution = new PlaceDaoImpl().SelectCoursesScoreDistribution(courses,year);
                request.setAttribute("CoursesScoreDistribution", CoursesScoreDistribution);
                CoursesPlaceArrayList = new PlaceDaoImpl().SelectCoursesPlace(courses,year);
                request.setAttribute("CoursesPlaceArrayList", CoursesPlaceArrayList);
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
