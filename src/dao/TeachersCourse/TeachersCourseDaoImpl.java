package dao.TeachersCourse;

import com.model.student.stuGrade;
import com.model.teacher.TeachersCourses;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeachersCourseDaoImpl implements TeachersCourseDao{
    public ArrayList<TeachersCourses> SelectTeachersCourses(String Tname) throws DaoException
    {
        ArrayList<TeachersCourses> TeachersCoursesArrayList = new ArrayList<TeachersCourses>();
        String sql="CALL Yangjn_select_Teachers_courses02(?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Tname);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                TeachersCourses sg = new TeachersCourses();
                sg.setTno(rst.getString("yjn_Tno02"));
                sg.setTname(rst.getString("yjn_Tname02"));
                sg.setCno(rst.getString("yjn_Cno02"));
                sg.setClname(rst.getString("yjn_Clname02"));
                sg.setTCyear(rst.getString("yjn_TCyear02"));
                sg.setCname(rst.getString("yjn_Cname02"));

                TeachersCoursesArrayList.add(sg);
            }
            conn.close();
            return TeachersCoursesArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }

    }


    public ArrayList<String> SelectTeachersCoursesAsOption(String Tname) throws DaoException
    {
        ArrayList<String> TeachersCoursesArrayList = new ArrayList<String>();
        String sql="CALL Yangjn_select_Teachers_courses02(?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Tname);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                TeachersCoursesArrayList.add(
                        rst.getString("yjn_Cname02")+"——"+
                        rst.getString("yjn_Clname02")+"——"+
                        rst.getString("yjn_TCyear02"));

            }
            conn.close();
            return TeachersCoursesArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

}
