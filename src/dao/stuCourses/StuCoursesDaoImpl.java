package dao.stuCourses;

import com.model.student.stuCourses;
import com.model.student.stuGrade;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StuCoursesDaoImpl implements StuCoursesDao{
    public ArrayList<stuCourses> select_students_courses_and_credits(String Sno) throws DaoException
    {
        ArrayList<stuCourses> stuCoursesArrayList = new ArrayList<stuCourses>();
        String sql="CALL Yangjn_select_students_courses_and_credits02(?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Sno);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                stuCourses sc = new stuCourses();
                sc.setCno(rst.getString("yjn_Cno02"));
                sc.setClname(rst.getString("yjn_Clname02"));
                sc.setCname(rst.getString("yjn_Cname02"));
                sc.setCcredit(rst.getDouble("yjn_Ccredit02"));
                sc.setCevaluation(rst.getString("yjn_Cevaluation02"));
                sc.setSCyear(rst.getString("yjn_SCyear02"));
                sc.setCterm(rst.getString("yjn_Cterm02"));
                sc.setCperiod(rst.getInt("yjn_Cperiod02"));
                stuCoursesArrayList.add(sc);
            }
            conn.close();
            return stuCoursesArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<stuCourses> select_students_courses_and_credits_by_year(String Sno,String year) throws DaoException
    {
        ArrayList<stuCourses> stuCoursesArrayList = new ArrayList<stuCourses>();
        String sql="CALL Yangjn_select_students_courses_and_credits_by_year02(?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Sno);
            pstmt.setString(2, year);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                stuCourses sc = new stuCourses();
                sc.setCno(rst.getString("yjn_Cno02"));
                sc.setClname(rst.getString("yjn_Clname02"));
                sc.setCname(rst.getString("yjn_Cname02"));
                sc.setCcredit(rst.getDouble("yjn_Ccredit02"));
                sc.setCevaluation(rst.getString("yjn_Cevaluation02"));
                sc.setSCyear(rst.getString("yjn_SCyear02"));
                sc.setCterm(rst.getString("yjn_Cterm02"));
                sc.setCperiod(rst.getInt("yjn_Cperiod02"));
                stuCoursesArrayList.add(sc);
            }
            conn.close();
            return stuCoursesArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }



    public ArrayList<stuCourses> select_students_courses_of_classes(String year,String Clname) throws DaoException
    {
        ArrayList<stuCourses> stuCoursesArrayList = new ArrayList<stuCourses>();
        String sql="SELECT * FROM Yangjn_classesCourses02 \n" +
                "WHERE yjn_SCyear02 = ? AND yjn_Clname02 = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, year);
            pstmt.setString(2, Clname);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                stuCourses sc = new stuCourses();
                sc.setCno(rst.getString("yjn_Cno02"));
                sc.setClname(rst.getString("yjn_Clname02"));
                sc.setCname(rst.getString("yjn_Cname02"));
                sc.setCcredit(rst.getDouble("yjn_Ccredit02"));
                sc.setCevaluation(rst.getString("yjn_Cevaluation02"));
                sc.setSCyear(rst.getString("yjn_SCyear02"));
                sc.setCterm(rst.getString("yjn_Cterm02"));
                sc.setCperiod(rst.getInt("yjn_Cperiod02"));
                stuCoursesArrayList.add(sc);
            }
            conn.close();
            return stuCoursesArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
