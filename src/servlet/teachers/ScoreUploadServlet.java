package servlet.teachers;

import com.model.teacher.CoursesPlace;
import com.model.teacher.TeaInfo;
import dao.Place.PlaceDaoImpl;
import dao.TeachersCourse.TeachersCourseDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ScoreUploadServlet", value = "/ScoreUpload.do")
public class ScoreUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "ScoreUpload");

        request.setAttribute("CoursesPlaceArrayList", null);
        String Tname = ((TeaInfo)request.getSession().getAttribute("teaInfomation")).getTname();
        try
        {
            ArrayList<String> teachersCourses = new TeachersCourseDaoImpl().SelectTeachersCoursesAsOption(Tname);
            request.setAttribute("teachersCourses", teachersCourses);
        }
        catch (Exception e)
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

        request.setAttribute("pageName", "ScoreUpload");

        //----------------------------------------------
        String tCourses = (String)request.getParameter("teachersClasses");
        String[] split = tCourses.split("——");
        try
        {
            ArrayList<CoursesPlace> CoursesPlaceArrayList = new PlaceDaoImpl().select_Courses_score_to_upload(split[0],split[1], split[2]);
            request.setAttribute("CoursesPlaceArrayList", CoursesPlaceArrayList);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        //----------------------------------------------



        String Tname = ((TeaInfo)request.getSession().getAttribute("teaInfomation")).getTname();
        try
        {
            ArrayList<String> teachersCourses = new TeachersCourseDaoImpl().SelectTeachersCoursesAsOption(Tname);
            request.setAttribute("teachersCourses", teachersCourses);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/teaWeb.jsp");
        dispatcher.forward(request,response);
    }
}
