package servlet.teachers;

import com.model.teacher.AvgScoreCount;
import com.model.teacher.CoursesPlace;
import dao.AvgScoreCount.AvgScoreCountDaoImpl;
import dao.Place.PlaceDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AvgScoreCountServlet", value = "/AvgScoreCount.do")
public class AvgScoreCountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "AvgScoreCount");

        request.setAttribute("AvgScoreCountArrayList", null);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/teaWeb.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "AvgScoreCount");

        String year = request.getParameter("TCyear");

        ArrayList<AvgScoreCount> AvgScoreCountArrayList = null;  //课程排名列表
        try {
            if(year.equals("请选择"))
            {
                request.setAttribute("AvgScoreCountArrayList", null);
            }
            else
            {
                AvgScoreCountArrayList = new AvgScoreCountDaoImpl().Yangjn_AvgScoreCount02(year);
                request.setAttribute("AvgScoreCountArrayList", AvgScoreCountArrayList);
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
