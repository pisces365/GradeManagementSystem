package servlet.teachers;

import com.model.teacher.ClassesPlace;
import com.model.teacher.MajorPlace;
import dao.Place.PlaceDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ClassesPlaceServlet", value = "/ClassesPlace.do")
public class ClassesPlaceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "ClassesPlace");

        request.setAttribute("ClassesPlaceArrayList", null);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/teaWeb.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "ClassesPlace");

        String Classes = request.getParameter("Classes");

        ArrayList<ClassesPlace> ClassesPlaceArrayList = null;  //课程排名列表
        try {
            if(Classes.equals("请选择"))
            {
                request.setAttribute("ClassesPlaceArrayList", null);
            }
            else
            {
                ClassesPlaceArrayList = new PlaceDaoImpl().SelectClassesPlace(Classes);
                request.setAttribute("ClassesPlaceArrayList", ClassesPlaceArrayList);
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
