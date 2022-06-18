package servlet.logInAndOut;

import com.model.student.stuInfo;
import com.model.teacher.TeaInfo;
import dao.LogIn.LogInDaoImple;
import dao.MajorsAndClassesSelect.MajorsAndClassesSelectDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LogInServlet", value = "/LogIn.do")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        if(((String)request.getSession().getAttribute("person_type")).equals("学生"))
        {
            request.setAttribute("pageName", "stuMyPage");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/stuWeb.jsp");
            dispatcher.forward(request, response);
        }
        else if(((String)request.getSession().getAttribute("person_type")).equals("教师"))
        {
            request.setAttribute("pageName", "teaMyPage");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/teaWeb.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String person_type = request.getParameter("person-type");
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String password = request.getParameter("password");

        if(person_type.equals("学生"))
        {
            try
            {
                stuInfo stuInfomation = new LogInDaoImple().stuLogIn(number,name,password); //学生登陆信息
                if(stuInfomation == null)
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request,response);
                }
                else
                {
                    ArrayList<String> stuYears = new LogInDaoImple().stuYears(); //学年选项列表
                    request.setAttribute("pageName", "stuMyPage");
                    HttpSession session = request.getSession();
                    session.setAttribute("stuInfomation", stuInfomation);
                    session.setAttribute("stuYears", stuYears);
                    session.setAttribute("person_type", person_type);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/stuWeb.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (Exception e) {
                System.out.println("LogInServlet ERROR：" + e);
            }

        }
        else if(person_type.equals("教师"))
        {
            try
            {
                TeaInfo teaInfomation = new LogInDaoImple().teaLogIn(number,name,password); //学生登陆信息
                if(teaInfomation == null)
                {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request,response);
                }
                else
                {
                    ArrayList<String> teaYears = new LogInDaoImple().teaYears(); //学年选项列表
                    ArrayList<String> allMajors = new MajorsAndClassesSelectDaoImpl().SelectMajors();
                    ArrayList<String> allCourses = new MajorsAndClassesSelectDaoImpl().SelectCourses();
                    request.setAttribute("pageName", "teaMyPage");
                    HttpSession session = request.getSession();
                    session.setAttribute("teaInfomation", teaInfomation);
                    session.setAttribute("teaYears", teaYears);
                    session.setAttribute("allMajors", allMajors);
                    session.setAttribute("allCourses", allCourses);
                    session.setAttribute("person_type", person_type);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/teaWeb.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (Exception e) {
                System.out.println("LogInServlet ERROR：" + e);
            }

        }
        else if(person_type.equals("管理员"))
        {
            if(name.equals("admin")&&number.equals("admin")&&password.equals("123456"))
            {
                request.setAttribute("pageName", "adminMyPage");
                HttpSession session = request.getSession();
                session.setAttribute("person_type", person_type);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminWeb.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/backstage.jsp");
                dispatcher.forward(request, response);
            }
        }


    }
}
