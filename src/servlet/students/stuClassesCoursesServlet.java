package servlet.students;

import com.model.student.stuCourses;
import com.model.student.stuInfo;
import dao.stuCourses.StuCoursesDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "stuClassesCoursesServlet", value = "/stuClassesCourses.do")
public class stuClassesCoursesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "stuClassesCourses");
        request.setAttribute("method", "get");

        request.setAttribute("stuClassesCoursesArrayList", null);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/stuWeb.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "stuClassesCourses");
        request.setAttribute("method", "post");

        String year = request.getParameter("SCyear");
        ArrayList<stuCourses> stuClassesCoursesArrayList = null;  //学生成绩列表
        try {
            stuInfo stuInfomation = (stuInfo)request.getSession().getAttribute("stuInfomation");
            if(year.equals("请选择"))
            {
                request.setAttribute("stuClassesCoursesArrayList", null);
            }
            else
            {
                stuClassesCoursesArrayList = new StuCoursesDaoImpl().select_students_courses_of_classes(year,stuInfomation.getClname());
                request.setAttribute("stuClassesCoursesArrayList", stuClassesCoursesArrayList);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/stuWeb.jsp");
        dispatcher.forward(request,response);
    }
}
