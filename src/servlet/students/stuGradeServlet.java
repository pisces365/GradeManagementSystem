package servlet.students;

import com.model.student.stuGrade;
import com.model.student.stuInfo;
import dao.stuGrade.StuGradeDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "stuGradeServlet", value = "/stuGrade.do")
public class stuGradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "stuGrade");

        ArrayList<stuGrade> stuGradeArrayList = null;  //学生成绩列表
        ArrayList<String> CreditsAndScores = null;
        try {
            stuInfo stuInfomation = (stuInfo)request.getSession().getAttribute("stuInfomation");
            CreditsAndScores = new StuGradeDaoImpl().CreditsAndScores(stuInfomation.getSno());
            stuGradeArrayList = new StuGradeDaoImpl().selectAllScores(stuInfomation.getSno());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        request.setAttribute("stuGradeArrayList", stuGradeArrayList);
        request.setAttribute("CreditsAndScores", CreditsAndScores);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/stuWeb.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("pageName", "stuGrade");

        String year = request.getParameter("SCyear");
        System.out.println(year);
        ArrayList<stuGrade> stuGradeArrayList = null;  //学生成绩列表
        ArrayList<String> CreditsAndScores = null;

        try {
            stuInfo stuInfomation = (stuInfo)request.getSession().getAttribute("stuInfomation");
            if(year.equals("请选择"))
            {
                stuGradeArrayList = new StuGradeDaoImpl().selectAllScores(stuInfomation.getSno());
            }
            else
            {
                stuGradeArrayList = new StuGradeDaoImpl().selectScores(stuInfomation.getSno(),year);
            }
            CreditsAndScores = new StuGradeDaoImpl().CreditsAndScores(stuInfomation.getSno());

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        request.setAttribute("stuGradeArrayList", stuGradeArrayList);
        request.setAttribute("CreditsAndScores", CreditsAndScores);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/stuWeb.jsp");
        dispatcher.forward(request,response);
    }
}
