package servlet.admin;

import com.model.admin.*;
import dao.AdminDao.AdminDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminInsertServlet", value = "/Admin.do")
public class AdminInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String pageName = request.getParameter("pageName");
            switch (pageName) {
                case "adminMyPage":
                    request.setAttribute("pageName", "adminMyPage");
                    break;
                case "Majors":
                    request.setAttribute("pageName", "Majors");
                    ArrayList<Majors> MajorsArrayList = new AdminDaoImpl().SelectMajors();
                    request.setAttribute("MajorsArrayList", MajorsArrayList);
                    break;
                case "Classes":
                    request.setAttribute("pageName", "Classes");
                    ArrayList<Classes> ClassesArrayList = new AdminDaoImpl().SelectClasses();
                    request.setAttribute("ClassesArrayList", ClassesArrayList);
                    break;
                case "Teachers":
                    request.setAttribute("pageName", "Teachers");
                    ArrayList<Teachers> TeachersArrayList = new AdminDaoImpl().SelectTeachers();
                    request.setAttribute("TeachersArrayList", TeachersArrayList);
                    break;
                case "Students":
                    request.setAttribute("pageName", "Students");
                    ArrayList<Students> StudentsArrayList = new AdminDaoImpl().SelectStudents();
                    request.setAttribute("StudentsArrayList", StudentsArrayList);
                    break;
                case "Courses":
                    request.setAttribute("pageName", "Courses");
                    ArrayList<Courses> CoursesArrayList = new AdminDaoImpl().SelectCourses();
                    request.setAttribute("CoursesArrayList", CoursesArrayList);
                    break;
                case "SC":
                    request.setAttribute("pageName", "SC");
                    ArrayList<SC> SCArrayList = new AdminDaoImpl().SelectSC();
                    request.setAttribute("SCArrayList", SCArrayList);
                    break;
                case "TC":
                    request.setAttribute("pageName", "TC");
                    ArrayList<TC> TCArrayList = new AdminDaoImpl().SelectTC();
                    request.setAttribute("TCArrayList", TCArrayList);
                    break;
                case "Province":
                    request.setAttribute("pageName", "Province");
                    ArrayList<Province> ProvinceArrayList = new AdminDaoImpl().SelectProvince();
                    request.setAttribute("ProvinceArrayList", ProvinceArrayList);
                    break;
                case "City":
                    request.setAttribute("pageName", "City");
                    ArrayList<City> CityArrayList = new AdminDaoImpl().SelectCity();
                    request.setAttribute("CityArrayList", CityArrayList);
                    break;
                case "District":
                    request.setAttribute("pageName", "District");
                    ArrayList<District> DistrictArrayList = new AdminDaoImpl().SelectDistrict();
                    request.setAttribute("DistrictArrayList", DistrictArrayList);
                    break;
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminWeb.jsp");
            dispatcher.forward(request, response);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            String pageName = request.getParameter("pageName");
            switch (pageName)
            {
                case "Majors":
                {String yjn_Mno02 = request.getParameter("yjn_MnoMajors02");
                    String yjn_Mname02 = request.getParameter("yjn_MnameMajors02");
                    new AdminDaoImpl().InsertMajors(yjn_Mno02, yjn_Mname02);}break;
                case "Classes":
                {String yjn_Clno02 = request.getParameter("yjn_ClnoClasses02");
                    String yjn_Clname02 = request.getParameter("yjn_ClnameClasses02");
                    String yjn_Mno02 = request.getParameter("yjn_MnoClasses02");
                    new AdminDaoImpl().InsertClasses(yjn_Clno02, yjn_Clname02, yjn_Mno02);}break;
                case "Teachers":
                {String yjn_Tno02 = request.getParameter("yjn_TnoTeachers02");
                    String yjn_Tname02 = request.getParameter("yjn_TnameTeachers02");
                    String yjn_Tsex02 = request.getParameter("yjn_TsexTeachers02");
                    int yjn_Tage02 = Integer.parseInt(request.getParameter("yjn_TageTeachers02"));
                    String yjn_Tphone02 = request.getParameter("yjn_TphoneTeachers02");
                    String yjn_Tprof02 = request.getParameter("yjn_TprofTeachers02");
                    String yjn_Tpassword02 = request.getParameter("yjn_TpasswordTeachers02");
                    new AdminDaoImpl().InsertTeachers(yjn_Tno02,  yjn_Tname02,  yjn_Tsex02,  yjn_Tage02
            ,  yjn_Tphone02,  yjn_Tprof02,  yjn_Tpassword02);}break;
                case "Students":
                {String yjn_Sno02 = request.getParameter("yjn_SnoStudents02");
                    String yjn_Sname02 = request.getParameter("yjn_SnameStudents02");
                    String yjn_Ssex02 = request.getParameter("yjn_SsexStudents02");
                    int yjn_Sage02 = Integer.parseInt(request.getParameter("yjn_SageStudents02"));
                    double yjn_Scredits02 = Double.parseDouble(request.getParameter("yjn_ScreditsStudents02")) ;
                    String yjn_Slocation02 = request.getParameter("yjn_SlocationStudents02");
                    String yjn_Spassword02 = request.getParameter("yjn_SpasswordStudents02");
                    String yjn_Clno02 = request.getParameter("yjn_ClnoStudents02");
                    double yjn_Sscore02 = Double.parseDouble(request.getParameter("yjn_SscoreStudents02"));
                    new AdminDaoImpl().InsertStudents( yjn_Sno02,   yjn_Sname02,  yjn_Ssex02,  yjn_Sage02,  yjn_Scredits02,
                     yjn_Slocation02,  yjn_Spassword02,  yjn_Clno02,  yjn_Sscore02);}break;
                case "Courses":
                {String yjn_Cno02 = request.getParameter("yjn_CnoCourses02");
                    String yjn_Clno02 = request.getParameter("yjn_ClnoCourses02");
                    String yjn_Cname02 = request.getParameter("yjn_CnameCourses02");
                    double yjn_Ccredit02 = Double.parseDouble(request.getParameter("yjn_CcreditCourses02"));
                    String yjn_Cevaluation02 = request.getParameter("yjn_CevaluationCourses02");
                    String yjn_Cterm02 = request.getParameter("yjn_CtermCourses02");
                    int yjn_Cperiod02 = Integer.parseInt(request.getParameter("yjn_CperiodCourses02"));
                    new AdminDaoImpl().InsertCourses( yjn_Cno02,  yjn_Clno02,  yjn_Cname02,
                     yjn_Ccredit02,  yjn_Cevaluation02,  yjn_Cterm02,  yjn_Cperiod02);}break;
                case "SC":
                {String yjn_Sno02 = request.getParameter("yjn_SnoSC02");
                    String yjn_Cno02 = request.getParameter("yjn_CnoSC02");
                    String yjn_Clno02 = request.getParameter("yjn_ClnoSC02");
                    String yjn_SCyear02 = request.getParameter("yjn_SCyearSC02");
                    new AdminDaoImpl().InsertSC(yjn_Sno02, yjn_Cno02, yjn_Clno02, yjn_SCyear02, 0);}break;
                case "TC":
                {String yjn_Tno02 = request.getParameter("yjn_TnoTC02");
                    String yjn_Cno02 = request.getParameter("yjn_CnoTC02");
                    String yjn_Clno02 = request.getParameter("yjn_ClnoTC02");
                    String yjn_TCyear02 = request.getParameter("yjn_TCyearTC02");
                    new AdminDaoImpl().InsertTC(yjn_Tno02, yjn_Cno02, yjn_Clno02, yjn_TCyear02);}break;
                case "Province":
                {String yjn_Pno02 = request.getParameter("yjn_PnoProvince02");
                    String yjn_Pname02 = request.getParameter("yjn_PnameProvince02");
                    new AdminDaoImpl().InsertProvince(yjn_Pno02, yjn_Pname02);}break;
                case "City":
                {String yjn_Cino02 = request.getParameter("yjn_CinoCity02");
                    String yjn_Ciname02 = request.getParameter("yjn_CinameCity02");
                    String yjn_Pno02 = request.getParameter("yjn_PnoCity02");
                    new AdminDaoImpl().InsertCity(yjn_Cino02, yjn_Ciname02, yjn_Pno02);}break;
                case "District":
                {String yjn_Dno02 = request.getParameter("yjn_DnoDistrict02");
                    String yjn_Dname02 = request.getParameter("yjn_DnameDistrict02");
                    String yjn_Cino02 = request.getParameter("yjn_CinoDistrict02");
                    new AdminDaoImpl().InsertDistrict(yjn_Dno02, yjn_Dname02, yjn_Cino02);}break;
            }

            request.setAttribute("pageName", "adminMyPage");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/adminWeb.jsp");
            dispatcher.forward(request,response);
//            String yjn_Mno02, String yjn_Mname02

//            String yjn_Clno02, String yjn_Clname02, String yjn_Mno02

//            String yjn_Tno02, String yjn_Tname02, String yjn_Tsex02,int yjn_Tage02
//            ,String yjn_Tphone02, String yjn_Tprof02, String yjn_Tpassword02

//            String yjn_Sno02, String yjn_Sname02, String yjn_Ssex02,int yjn_Sage02, double yjn_Scredits02,
//            String yjn_Slocation02, String yjn_Spassword02, String yjn_Clno02,double yjn_Sscore02

//            String yjn_Cno02, String yjn_Clno02, String yjn_Cname02,
//            double yjn_Ccredit02, String yjn_Cevaluation02, String yjn_Cterm02,int yjn_Cperiod02

//            String yjn_Sno02, String yjn_Cno02, String yjn_Clno02, String yjn_SCyear02,int yjn_SCscore02

//            String yjn_Tno02, String yjn_Cno02, String yjn_Clno02, String yjn_TCyear02

//            String yjn_Pno02, String yjn_Pname02

//            String yjn_Cino02, String yjn_Ciname02, String yjn_Pno02

//            String yjn_Dno02, String yjn_Dname02, String yjn_Cino02
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
