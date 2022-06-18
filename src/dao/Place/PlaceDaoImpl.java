package dao.Place;

import com.model.teacher.ClassesPlace;
import com.model.teacher.CoursesPlace;
import com.model.teacher.MajorPlace;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceDaoImpl implements PlaceDao{
    public ArrayList<CoursesPlace> select_Courses_score_to_upload(String Cname,String Clname, String year) throws DaoException
    {
        ArrayList<CoursesPlace> stuCoursesArrayList = new ArrayList<CoursesPlace>();
        String sql="CALL Yangjn_select_Courses_score_to_upload02(?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Cname);
            pstmt.setString(2, Clname);
            pstmt.setString(3, year);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                CoursesPlace sc = new CoursesPlace();
                sc.setCno(rst.getString("yjn_Cno02"));
                sc.setCname(rst.getString("yjn_Cname02"));
                sc.setSCscore(rst.getInt("yjn_SCscore02"));
                sc.setSno(rst.getString("yjn_Sno02"));
                sc.setSname(rst.getString("yjn_Sname02"));
                sc.setClno(rst.getString("yjn_Clno02"));
                sc.setClname(rst.getString("yjn_Clname02"));
                sc.setSCyear(rst.getString("yjn_SCyear02"));
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

    public ArrayList<CoursesPlace> SelectCoursesPlace(String Cname, String year) throws DaoException
    {
        ArrayList<CoursesPlace> stuCoursesArrayList = new ArrayList<CoursesPlace>();
        String sql="CALL Yangjn_select_place_by_Courses02(?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Cname);
            pstmt.setString(2, year);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                CoursesPlace sc = new CoursesPlace();
                sc.setCno(rst.getString("yjn_Cno02"));
                sc.setCname(rst.getString("yjn_Cname02"));
                sc.setSCscore(rst.getInt("yjn_SCscore02"));
                sc.setSno(rst.getString("yjn_Sno02"));
                sc.setSname(rst.getString("yjn_Sname02"));
                sc.setClno(rst.getString("yjn_Clno02"));
                sc.setClname(rst.getString("yjn_Clname02"));
                sc.setSCyear(rst.getString("yjn_SCyear02"));
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
    public ArrayList<String> SelectCoursesScoreDistribution(String Cname, String year) throws DaoException
    {
        ArrayList<String> csd = new ArrayList<String>();
        String sql="CALL Yangjn_select_Courses_Score_Distribution02(?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Cname);
            pstmt.setString(2, year);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                csd.add(rst.getString("num"));
            }
            conn.close();
            return csd;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }


    public ArrayList<ClassesPlace> SelectClassesPlace(String Clname) throws DaoException
    {
        ArrayList<ClassesPlace> stuClassesArrayList = new ArrayList<ClassesPlace>();
        String sql="CALL Yangjn_select_place_by_Classes02(?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Clname);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                ClassesPlace sc = new ClassesPlace();

                sc.setSno(rst.getString("yjn_Sno02"));
                sc.setSname(rst.getString("yjn_Sname02"));
                sc.setSsex(rst.getString("yjn_Ssex02"));
                sc.setSscore(rst.getDouble("yjn_Sscore02"));
                sc.setClno(rst.getString("yjn_Clno02"));
                sc.setClname(rst.getString("yjn_Clname02"));

                stuClassesArrayList.add(sc);
            }
            conn.close();
            return stuClassesArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<MajorPlace> SelectMajorPlace(String Mname) throws DaoException
    {
        ArrayList<MajorPlace> stuMajorArrayList = new ArrayList<MajorPlace>();
        String sql="CALL Yangjn_select_place_by_Majors02(?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Mname);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                MajorPlace sc = new MajorPlace();

                sc.setSno(rst.getString("yjn_Sno02"));
                sc.setSname(rst.getString("yjn_Sname02"));
                sc.setSsex(rst.getString("yjn_Ssex02"));
                sc.setSscore(rst.getDouble("yjn_Sscore02"));
                sc.setClno(rst.getString("yjn_Clno02"));
                sc.setClname(rst.getString("yjn_Clname02"));
                sc.setMno(rst.getString("yjn_Mno02"));
                sc.setMname(rst.getString("yjn_Mname02"));

                stuMajorArrayList.add(sc);
            }
            conn.close();
            return stuMajorArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public boolean UpdateScore(int score, String Sno,String Cno, String Clno, String year) throws DaoException
    {
        String sql="UPDATE Yangjn_SC02\n" +
                "SET yjn_SCscore02 = ?\n" +
                "WHERE yjn_Sno02 = ? AND yjn_Cno02 = ? AND yjn_Clno02 = ? AND yjn_SCyear02 = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, score);
            pstmt.setString(2, Sno);
            pstmt.setString(3, Cno);
            pstmt.setString(4, Clno);
            pstmt.setString(5, year);
            int n = pstmt.executeUpdate();
            conn.close();
            if(n!=0)
            {
                return true;
            }
            return false;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
