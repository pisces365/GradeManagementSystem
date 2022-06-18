package dao.AdminDao;

import com.model.admin.*;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDaoImpl implements AdminDao{
    public boolean InsertMajors(String yjn_Mno02, String yjn_Mname02) throws DaoException
    {
        String sql="INSERT INTO Yangjn_Majors02 VALUES\n" +
                "(?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Mno02);
            pstmt.setString(2, yjn_Mname02);
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
    public boolean InsertClasses(String yjn_Clno02, String yjn_Clname02, String yjn_Mno02) throws DaoException
    {
        String sql="INSERT INTO Yangjn_Classes02 VALUES\n" +
                "(?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Clno02);
            pstmt.setString(2, yjn_Clname02);
            pstmt.setString(3, yjn_Mno02);
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
    public boolean InsertTeachers(String yjn_Tno02, String yjn_Tname02, String yjn_Tsex02, int yjn_Tage02
            , String yjn_Tphone02, String yjn_Tprof02, String yjn_Tpassword02) throws DaoException
    {
        String sql="INSERT INTO Yangjn_Teachers02 VALUES\n" +
                "(?,?,?,?,?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Tno02);
            pstmt.setString(2, yjn_Tname02);
            pstmt.setString(3, yjn_Tsex02);
            pstmt.setInt(4, yjn_Tage02);
            pstmt.setString(5, yjn_Tphone02);
            pstmt.setString(6, yjn_Tprof02);
            pstmt.setString(7, yjn_Tpassword02);
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
    public boolean InsertStudents(String yjn_Sno02, String  yjn_Sname02, String yjn_Ssex02, int yjn_Sage02, double yjn_Scredits02,
                                  String yjn_Slocation02, String yjn_Spassword02, String yjn_Clno02, double yjn_Sscore02) throws DaoException
    {
        String sql="INSERT INTO Yangjn_Students02 VALUES\n" +
                "(?,?,?,?,?,?,?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Sno02);
            pstmt.setString(2, yjn_Sname02);
            pstmt.setString(3, yjn_Ssex02);
            pstmt.setInt(4, yjn_Sage02);
            pstmt.setDouble(5, yjn_Scredits02);
            pstmt.setString(6, yjn_Slocation02);
            pstmt.setString(7, yjn_Spassword02);
            pstmt.setString(8, yjn_Clno02);
            pstmt.setDouble(9, yjn_Sscore02);
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
    public boolean InsertCourses(String yjn_Cno02, String yjn_Clno02, String yjn_Cname02,
                                 double yjn_Ccredit02, String yjn_Cevaluation02, String yjn_Cterm02, int yjn_Cperiod02) throws DaoException
    {
        String sql="INSERT INTO Yangjn_Courses02 VALUES\n" +
                "(?,?,?,?,?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Cno02);
            pstmt.setString(2, yjn_Clno02);
            pstmt.setString(3, yjn_Cname02);
            pstmt.setDouble(4, yjn_Ccredit02);
            pstmt.setString(5, yjn_Cevaluation02);
            pstmt.setString(6, yjn_Cterm02);
            pstmt.setInt(7, yjn_Cperiod02);
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
    public boolean InsertSC(String yjn_Sno02, String yjn_Cno02, String yjn_Clno02, String yjn_SCyear02, int yjn_SCscore02) throws DaoException
    {
        String sql="INSERT INTO Yangjn_SC02 VALUES\n" +
                "(?,?,?,?,null)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Sno02);
            pstmt.setString(2, yjn_Cno02);
            pstmt.setString(3, yjn_Clno02);
            pstmt.setString(4, yjn_SCyear02);
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
    public boolean InsertTC(String yjn_Tno02, String yjn_Cno02, String yjn_Clno02, String yjn_TCyear02) throws DaoException
    {
        String sql="INSERT INTO Yangjn_TC02 VALUES\n" +
                "(?,?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Tno02);
            pstmt.setString(2, yjn_Cno02);
            pstmt.setString(3, yjn_Clno02);
            pstmt.setString(4, yjn_TCyear02);

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
    public boolean InsertProvince(String yjn_Pno02, String yjn_Pname02) throws DaoException
    {
        String sql="INSERT INTO Yangjn_Province02 VALUES\n" +
                "(?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Pno02);
            pstmt.setString(2, yjn_Pname02);
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
    public boolean InsertCity(String yjn_Cino02, String yjn_Ciname02, String yjn_Pno02) throws DaoException
    {
        String sql="INSERT INTO Yangjn_City02 VALUES\n" +
                "(?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Cino02);
            pstmt.setString(2, yjn_Ciname02);
            pstmt.setString(3, yjn_Pno02);
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
    public boolean InsertDistrict(String yjn_Dno02, String yjn_Dname02, String yjn_Cino02) throws DaoException
    {
        String sql="INSERT INTO Yangjn_District02 VALUES\n" +
                "(?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Dno02);
            pstmt.setString(2, yjn_Dname02);
            pstmt.setString(3, yjn_Cino02);
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




    public ArrayList<City> SelectCity() throws DaoException
    {
        ArrayList<City> arr = new ArrayList<City>();
        String sql="SELECT * FROM Yangjn_City02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                City l = new City();
                l.setYjn_Cino02(rst.getString("yjn_Cino02"));
                l.setYjn_Ciname02(rst.getString("yjn_Ciname02"));
                l.setYjn_Pno02(rst.getString("yjn_Pno02"));
                arr.add(l);

            }
            conn.close();
            return arr;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Classes> SelectClasses() throws DaoException
    {
        ArrayList<Classes> arr = new ArrayList<Classes>();
        String sql="SELECT * FROM Yangjn_Classes02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                Classes l = new Classes();
                l.setYjn_Clno02(rst.getString("yjn_Clno02"));
                l.setYjn_Clname02(rst.getString("yjn_Clname02"));
                l.setYjn_Mno02(rst.getString("yjn_Mno02"));
                arr.add(l);

            }
            conn.close();
            return arr;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Courses> SelectCourses() throws DaoException
    {
        ArrayList<Courses> arr = new ArrayList<Courses>();
        String sql="SELECT * FROM Yangjn_Courses02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                Courses l = new Courses();
                l.setYjn_Cno02(rst.getString("yjn_Cno02"));
                l.setYjn_Clno02(rst.getString("yjn_Clno02"));
                l.setYjn_Cname02(rst.getString("yjn_Cname02"));
                l.setYjn_Ccredit02(rst.getDouble("yjn_Ccredit02"));
                l.setYjn_Cevaluation02(rst.getString("yjn_Cevaluation02"));
                l.setYjn_Cterm02(rst.getString("yjn_Cterm02"));
                l.setYjn_Cperiod02(rst.getInt("yjn_Cperiod02"));
                arr.add(l);

            }
            conn.close();
            return arr;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<District> SelectDistrict() throws DaoException
    {
        ArrayList<District> arr = new ArrayList<District>();
        String sql="SELECT * FROM Yangjn_District02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                District l = new District();
                l.setYjn_Dno02(rst.getString("yjn_Dno02"));
                l.setYjn_Dname02(rst.getString("yjn_Dname02"));
                l.setYjn_Cino02(rst.getString("yjn_Cino02"));
                arr.add(l);

            }
            conn.close();
            return arr;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Majors> SelectMajors() throws DaoException
    {
        ArrayList<Majors> arr = new ArrayList<Majors>();
        String sql="SELECT * FROM Yangjn_Majors02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                Majors l = new Majors();
                l.setYjn_Mno02(rst.getString("yjn_Mno02"));
                l.setYjn_Mname02(rst.getString("yjn_Mname02"));
                arr.add(l);

            }
            conn.close();
            return arr;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Province> SelectProvince() throws DaoException
    {
        ArrayList<Province> arr = new ArrayList<Province>();
        String sql="SELECT * FROM Yangjn_Province02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                Province l = new Province();
                l.setYjn_Pno02(rst.getString("yjn_Pno02"));
                l.setYjn_Pname02(rst.getString("yjn_Pname02"));
                arr.add(l);

            }
            conn.close();
            return arr;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<SC> SelectSC() throws DaoException
    {
        ArrayList<SC> arr = new ArrayList<SC>();
        String sql="SELECT * FROM Yangjn_SC02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                SC l = new SC();
                l.setYjn_Sno02(rst.getString("yjn_Sno02"));
                l.setYjn_Cno02(rst.getString("yjn_Cno02"));
                l.setYjn_Clno02(rst.getString("yjn_Clno02"));
                l.setYjn_SCyear02(rst.getString("yjn_SCyear02"));
                l.setYjn_SCscore02(rst.getInt("yjn_SCscore02"));
                arr.add(l);

            }
            conn.close();
            return arr;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Students> SelectStudents() throws DaoException
    {
        ArrayList<Students> arr = new ArrayList<Students>();
        String sql="SELECT * FROM Yangjn_Students02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                Students l = new Students();

                l.setYjn_Sno02(rst.getString("yjn_Sno02"));
                l.setYjn_Sname02(rst.getString("yjn_Sname02"));
                l.setYjn_Ssex02(rst.getString("yjn_Ssex02"));
                l.setYjn_Sage02(rst.getInt("yjn_Sage02"));
                l.setYjn_Scredits02(rst.getDouble("yjn_Scredits02"));
                l.setYjn_Slocation02(rst.getString("yjn_Slocation02"));
                l.setYjn_Spassword02(rst.getString("yjn_Spassword02"));
                l.setYjn_Clno02(rst.getString("yjn_Clno02"));
                l.setYjn_Sscore02(rst.getDouble("yjn_Sscore02"));
                arr.add(l);

            }
            conn.close();
            return arr;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<TC> SelectTC() throws DaoException
    {
        ArrayList<TC> arr = new ArrayList<TC>();
        String sql="SELECT * FROM Yangjn_TC02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                TC l = new TC();

                l.setYjn_Tno02(rst.getString("yjn_Tno02"));
                l.setYjn_Cno02(rst.getString("yjn_Cno02"));
                l.setYjn_Clno02(rst.getString("yjn_Clno02"));
                l.setYjn_TCyear02(rst.getString("yjn_TCyear02"));
                arr.add(l);

            }
            conn.close();
            return arr;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Teachers> SelectTeachers() throws DaoException
    {
        ArrayList<Teachers> arr = new ArrayList<Teachers>();
        String sql="SELECT * FROM Yangjn_Teachers02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                Teachers l = new Teachers();

                 l.setYjn_Tno02(rst.getString("yjn_Tno02"));
                 l.setYjn_Tname02(rst.getString("yjn_Tname02"));
                 l.setYjn_Tsex02(rst.getString("yjn_Tsex02"));
                 l.setYjn_Tage02(rst.getInt("yjn_Tage02"));
                 l.setYjn_Tphone02(rst.getString("yjn_Tphone02"));
                 l.setYjn_Tprof02(rst.getString("yjn_Tprof02"));
                 l.setYjn_Tpassword02(rst.getString("yjn_Tpassword02"));
                arr.add(l);

            }
            conn.close();
            return arr;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }



    public boolean DeleteCity(String yjn_Cino02) throws DaoException
    {
        String sql="DELETE FROM Yangjn_City02 WHERE yjn_Cino02 =?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Cino02);
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
    public boolean DeleteClasses(String yjn_Clno02) throws DaoException
    {
        String sql="DELETE FROM Yangjn_Classes02 WHERE yjn_Clno02 = ?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Clno02);

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
    public boolean DeleteCourses(String yjn_Cno02, String yjn_Clno02) throws DaoException
    {
        String sql="DELETE FROM Yangjn_Courses02 WHERE yjn_Cno02 = ? AND yjn_Clno02 = ? ";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Cno02);
            pstmt.setString(2, yjn_Clno02);
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
    public boolean DeleteDistrict(String yjn_Dno02) throws DaoException
    {
        String sql="DELETE FROM Yangjn_District02 WHERE  yjn_Dno02 = ?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Dno02);

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
    public boolean DeleteMajors(String yjn_Mno02) throws DaoException
    {
        String sql="DELETE FROM Yangjn_Majors02 WHERE yjn_Mno02 = ?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Mno02);

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
    public boolean DeleteProvince(String yjn_Pno02) throws DaoException
    {
        String sql="DELETE FROM Yangjn_Province02 WHERE yjn_Pno02 =?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Pno02);

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
    public boolean DeleteSC(String yjn_Sno02, String yjn_Cno02, String yjn_Clno02, String yjn_SCyear02) throws DaoException
    {
        String sql="DELETE FROM Yangjn_SC02 WHERE yjn_Sno02 = ? AND   yjn_Cno02 = ? AND yjn_Clno02 = ? AND yjn_SCyear02= ? \n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Sno02);
            pstmt.setString(2, yjn_Cno02);
            pstmt.setString(3, yjn_Clno02);
            pstmt.setString(4, yjn_SCyear02);
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
    public boolean DeleteStudents(String yjn_Sno02) throws DaoException
    {
        String sql="DELETE FROM Yangjn_Students02 WHERE yjn_Sno02 = ?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Sno02);

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
    public boolean DeleteTC(String yjn_Tno02, String yjn_Cno02, String yjn_Clno02, String yjn_TCyear02) throws DaoException
    {
        String sql="DELETE FROM Yangjn_TC02 WHERE yjn_Tno02 = ? AND yjn_Cno02 = ? AND yjn_Clno02 = ? AND yjn_TCyear02= ? \n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Tno02);
            pstmt.setString(2, yjn_Cno02);
            pstmt.setString(3, yjn_Clno02);
            pstmt.setString(4, yjn_TCyear02);
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
    public boolean DeleteTeachers(String yjn_Tno02) throws DaoException
    {
        String sql="DELETE FROM Yangjn_Teachers02 WHERE yjn_Tno02 = ?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Tno02);

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



    public boolean UpdateCity(String yjn_Ciname02 , String yjn_Pno02,String yjn_Cino02 ) throws DaoException
    {
        String sql="UPDATE Yangjn_City02\n" +
                "SET yjn_Ciname02= ? ,  yjn_Pno02= ? \n" +
                "WHERE yjn_Cino02 =?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Ciname02);
            pstmt.setString(2, yjn_Pno02);
            pstmt.setString(3, yjn_Cino02);

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
    public boolean UpdateClasses(String yjn_Clname02  , String yjn_Mno02,String yjn_Clno02 ) throws DaoException
    {
        String sql="UPDATE Yangjn_Classes02\n" +
                "SET yjn_Clname02 = ? ,  yjn_Mno02 = ?\n" +
                "where yjn_Clno02 = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Clname02);
            pstmt.setString(2, yjn_Mno02);
            pstmt.setString(3, yjn_Clno02);

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
    public boolean UpdateCourses(String yjn_Cname02 , double yjn_Ccredit02 , String yjn_Cevaluation02 , String yjn_Cterm02 , int yjn_Cperiod02 ,
                                 String yjn_Cno02 , String yjn_Clno02 ) throws DaoException
    {
        String sql="UPDATE Yangjn_Courses02\n" +
                "SET yjn_Cname02= ? , yjn_Ccredit02= ? ,  yjn_Cevaluation02= ? ,  yjn_Cterm02= ? ,  yjn_Cperiod02= ? \n" +
                "WHERE yjn_Cno02 = ? AND yjn_Clno02 = ?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Cname02);
            pstmt.setDouble(2, yjn_Ccredit02);
            pstmt.setString(3, yjn_Cevaluation02);
            pstmt.setString(4, yjn_Cterm02);
            pstmt.setInt(5, yjn_Cperiod02);
            pstmt.setString(6, yjn_Cno02);
            pstmt.setString(7, yjn_Clno02);

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
    public boolean UpdateDistrict(String yjn_Dname02 , String yjn_Cino02, String yjn_Dno02 ) throws DaoException
    {
        String sql="UPDATE Yangjn_District02\n" +
                "SET yjn_Dname02= ? ,  yjn_Cino02= ?\n" +
                "WHERE yjn_Dno02 = ?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Dname02);
            pstmt.setString(2, yjn_Cino02);
            pstmt.setString(3, yjn_Dno02);

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
    public boolean UpdateMajors(String yjn_Mname02,String yjn_Mno02 ) throws DaoException
    {
        String sql="UPDATE Yangjn_Majors02\n" +
                "SET yjn_Mname02 = ?\n" +
                "where yjn_Mno02 = ?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Mname02);
            pstmt.setString(2, yjn_Mno02);

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
    public boolean UpdateProvince(String yjn_Pname02,String yjn_Pno02 ) throws DaoException
    {
        String sql="UPDATE Yangjn_Province02\n" +
                "SET yjn_Pname02=?\n" +
                "WHERE yjn_Pno02 =?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Pname02);
            pstmt.setString(2, yjn_Pno02);


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
    public boolean UpdateStudents(String yjn_Sname02 , String yjn_Ssex02 , int yjn_Sage02 , double yjn_Scredits02 , String yjn_Slocation02 , String yjn_Spassword02 , String yjn_Clno02 , double yjn_Sscore02,
                                  String yjn_Sno02 ) throws DaoException
    {
        String sql="UPDATE Yangjn_Students02\n" +
                "SET yjn_Sname02= ? ,  yjn_Ssex02= ? ,  yjn_Sage02= ? ,  yjn_Scredits02= ? ,  yjn_Slocation02= ? ,  yjn_Spassword02= ? ,  yjn_Clno02= ? ,  yjn_Sscore02= ? \n" +
                "WHERE yjn_Sno02 = ?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Sname02);
            pstmt.setString(2, yjn_Ssex02);
            pstmt.setInt(3, yjn_Sage02);
            pstmt.setDouble(4, yjn_Scredits02);
            pstmt.setString(5, yjn_Slocation02);
            pstmt.setString(6, yjn_Spassword02);
            pstmt.setString(7, yjn_Clno02);
            pstmt.setDouble(8, yjn_Sscore02);
            pstmt.setString(9, yjn_Sno02);


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
    public boolean UpdateTeachers(String yjn_Tname02  , String yjn_Tsex02  , int yjn_Tage02  , String yjn_Tphone02 , String  yjn_Tprof02 , String  yjn_Tpassword02,
                                  String yjn_Tno02 ) throws DaoException
    {
        String sql="UPDATE Yangjn_Teachers02\n" +
                "SET yjn_Tname02 = ? ,  yjn_Tsex02 = ? ,  yjn_Tage02 = ? ,  yjn_Tphone02= ? ,   yjn_Tprof02= ? ,   yjn_Tpassword02= ? \n" +
                "where yjn_Tno02 = ?\n";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, yjn_Tname02);
            pstmt.setString(2, yjn_Tsex02);
            pstmt.setInt(3, yjn_Tage02);
            pstmt.setString(4, yjn_Tphone02);
            pstmt.setString(5, yjn_Tprof02);
            pstmt.setString(6, yjn_Tpassword02);
            pstmt.setString(7, yjn_Tno02);

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
