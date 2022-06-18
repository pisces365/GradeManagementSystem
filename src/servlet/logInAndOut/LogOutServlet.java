package servlet.logInAndOut;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogOutServlet", value = "/LogOut.do")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String person_type =  (String)request.getSession().getAttribute("person_type");
        if(person_type.equals("学生")||person_type.equals("教师"))
        {
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        }
        else if(person_type.equals("管理员"))
        {
            request.getSession().invalidate();
            response.sendRedirect("backstage.jsp");
        }
    }
}
