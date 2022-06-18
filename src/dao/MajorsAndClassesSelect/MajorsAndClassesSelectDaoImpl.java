package dao.MajorsAndClassesSelect;

import com.model.student.stuGrade;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MajorsAndClassesSelectDaoImpl implements MajorsAndClassesSelectDao{
    public ArrayList<String> SelectMajors() throws DaoException
    {
        ArrayList<String> MajorsArrayList = new ArrayList<String>();
        String sql="SELECT yjn_Mname02 FROM Yangjn_Majors02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                MajorsArrayList.add(rst.getString("yjn_Mname02"));
            }
            conn.close();
            return MajorsArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }

    }
    public ArrayList<String> SelectClasses(String major) throws DaoException
    {
        ArrayList<String> ClassesArrayList = new ArrayList<String>();
        String sql="SELECT yjn_Clname02 \n" +
                "FROM Yangjn_Classes02 Cl,Yangjn_Majors02 M\n" +
                "\tWHERE Cl.yjn_Mno02 = M.yjn_Mno02\n" +
                "\tAND M.yjn_Mname02 = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, major);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                ClassesArrayList.add(rst.getString("yjn_Clname02"));
            }
            conn.close();
            return ClassesArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }




    public ArrayList<String> SelectCourses() throws DaoException
    {
        ArrayList<String> CoursesArrayList = new ArrayList<String>();
        String sql="SELECT DISTINCT yjn_Cname02 FROM Yangjn_Courses02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                CoursesArrayList.add(rst.getString("yjn_Cname02"));
            }
            conn.close();
            return CoursesArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
