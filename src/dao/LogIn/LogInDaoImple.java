package dao.LogIn;

import com.model.student.stuGrade;
import com.model.student.stuInfo;
import com.model.teacher.TeaInfo;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LogInDaoImple implements LogInDao{
    public stuInfo stuLogIn(String Sno, String Sname, String Spassword) throws DaoException
    {
        stuInfo si = null;
        String sql="SELECT S.yjn_Sno02,S.yjn_Sname02,Cl.yjn_Clname02 \n" +
                " FROM Yangjn_Students02 S, Yangjn_Classes02 Cl\n" +
                " WHERE  S.yjn_Clno02 = Cl.yjn_Clno02\n" +
                "\tAND S.yjn_Sno02 = ? \n" +
                "\tAND S.yjn_Sname02 = ? \n" +
                "\tAND S.yjn_Spassword02 = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Sno);
            pstmt.setString(2, Sname);
            pstmt.setString(3, Spassword);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next() == true)
            {
                si = new stuInfo();
                si.setSno(rst.getString("yjn_Sno02"));
                si.setSname(rst.getString("yjn_Sname02"));
                si.setClname(rst.getString("yjn_Clname02"));
            }
            conn.close();
            return si;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> stuYears() throws DaoException
    {
        ArrayList<String> stuYears = new ArrayList<String>();
        String sql="SELECT DISTINCT yjn_SCyear02 FROM Yangjn_SC02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                String year = rst.getString("yjn_SCyear02");
                stuYears.add(year);
            }
            conn.close();
            return stuYears;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }






    public TeaInfo teaLogIn(String Tno, String Tname, String Tpassword) throws DaoException
    {
        TeaInfo ti = null;
        String sql="SELECT yjn_Tno02,yjn_Tname02 FROM Yangjn_Teachers02\n" +
                " WHERE yjn_Tno02 = ? \n" +
                "\tAND yjn_Tname02 = ? \n" +
                "\tAND yjn_Tpassword02 = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Tno);
            pstmt.setString(2, Tname);
            pstmt.setString(3, Tpassword);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next() == true)
            {
                ti = new TeaInfo();
                ti.setTno(rst.getString("yjn_Tno02"));
                ti.setTname(rst.getString("yjn_Tname02"));
            }
            conn.close();
            return ti;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> teaYears() throws DaoException
    {
        ArrayList<String> teaYears = new ArrayList<String>();
        String sql="SELECT DISTINCT yjn_TCyear02 FROM Yangjn_TC02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                String year = rst.getString("yjn_TCyear02");
                teaYears.add(year);
            }
            conn.close();
            return teaYears;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
