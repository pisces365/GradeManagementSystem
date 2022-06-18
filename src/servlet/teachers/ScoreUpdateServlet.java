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

@WebServlet(name = "ScoreUpdateServlet", value = "/ScoreUpdate.do")
public class ScoreUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "ScoreUpload");

        //----------------------------------------------
        String[] SCscore = request.getParameterValues("SCscore");
        String[] Sno = request.getParameterValues("Sno");
        String[] Cno = request.getParameterValues("Cno");
        String[] Clno = request.getParameterValues("Clno");
        String[] SCyear = request.getParameterValues("SCyear");

        for(int i=0;i<SCscore.length;++i) {
            try {
                new PlaceDaoImpl().UpdateScore(Integer.parseInt(SCscore[i]), Sno[i], Cno[i], Clno[i], SCyear[i]);
            } catch (Exception e) {
                System.out.println(e);
            }
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
