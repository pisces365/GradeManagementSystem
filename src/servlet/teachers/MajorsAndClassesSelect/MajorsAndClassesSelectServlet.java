package servlet.teachers.MajorsAndClassesSelect;

import dao.MajorsAndClassesSelect.MajorsAndClassesSelectDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MajorsAndClassesSelectServlet", value = "/MajorsAndClassesSelect.do")
public class MajorsAndClassesSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String major = request.getParameter("Major");
        ArrayList<String> classes = null;
        try
        {
            classes = new MajorsAndClassesSelectDaoImpl().SelectClasses(major);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        StringBuffer results = new StringBuffer("<CNames>");
        for(int i=0;i<classes.size();++i)
        {
            results.append("<CName>");
            results.append(classes.get(i));
            results.append("</CName>");
        }
        results.append("</CNames>");
        response.setContentType("text/xml;charset=UTF-8");
        response.getWriter().println(results.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
