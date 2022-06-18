package servlet.students;

import com.model.student.stuCourses;
import com.model.student.stuGrade;
import com.model.student.stuInfo;
import dao.stuCourses.StuCoursesDaoImpl;
import dao.stuGrade.StuGradeDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CoursesAndCreditsServlet", value = "/CoursesAndCredits.do")
public class CoursesAndCreditsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "CoursesAndCredits");

        ArrayList<stuCourses> stuCoursesArrayList = null;  //学生成绩列表
        try {
            stuInfo stuInfomation = (stuInfo)request.getSession().getAttribute("stuInfomation");
            stuCoursesArrayList = new StuCoursesDaoImpl().select_students_courses_and_credits(stuInfomation.getSno());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        request.setAttribute("stuCoursesArrayList", stuCoursesArrayList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/stuWeb.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "CoursesAndCredits");

        String year = request.getParameter("SCyear");
        ArrayList<stuCourses> stuCoursesArrayList = null;  //学生成绩列表
        try {
            stuInfo stuInfomation = (stuInfo)request.getSession().getAttribute("stuInfomation");
            if(year.equals("请选择"))
            {
                stuCoursesArrayList = new StuCoursesDaoImpl().select_students_courses_and_credits(stuInfomation.getSno());
            }
            else
            {
                stuCoursesArrayList = new StuCoursesDaoImpl().select_students_courses_and_credits_by_year(stuInfomation.getSno(),year);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        request.setAttribute("stuCoursesArrayList", stuCoursesArrayList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/stuWeb.jsp");
        dispatcher.forward(request,response);
    }
}
