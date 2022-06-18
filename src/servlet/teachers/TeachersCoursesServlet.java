package servlet.teachers;

import com.model.teacher.CoursesPlace;
import com.model.teacher.TeaInfo;
import com.model.teacher.TeachersCourses;
import dao.Place.PlaceDaoImpl;
import dao.TeachersCourse.TeachersCourseDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TeachersCoursesServlet", value = "/TeachersCourses.do")
public class TeachersCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "TeachersCourses");

        String Tname = ((TeaInfo)request.getSession().getAttribute("teaInfomation")).getTname();
        ArrayList<TeachersCourses> TeachersCoursesArrayList = null;
        try
        {
            TeachersCoursesArrayList = new TeachersCourseDaoImpl().SelectTeachersCourses(Tname);
        }
        catch(Exception e){
            System.out.println(e);
        }
        request.setAttribute("TeachersCoursesArrayList", TeachersCoursesArrayList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/teaWeb.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
