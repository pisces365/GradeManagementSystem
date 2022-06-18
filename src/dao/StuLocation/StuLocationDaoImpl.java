package dao.StuLocation;

import com.model.teacher.Region;
import com.model.teacher.StuLocation;
import com.model.teacher.TeachersCourses;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StuLocationDaoImpl implements StuLocationDao{
    public ArrayList<StuLocation> SelectStuLocation(String p,String c,String d) throws DaoException
    {
        ArrayList<StuLocation> StuLocationArrayList = new ArrayList<StuLocation>();
        String sql="CALL Yangjn_StuLocation02(?,?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+p+"%");
            pstmt.setString(2, "%"+c+"%");
            pstmt.setString(3, "%"+d+"%");

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                StuLocation sg = new StuLocation();
                sg.setSno(rst.getString("yjn_Sno02"));
                sg.setSname(rst.getString("yjn_Sname02"));
                sg.setPname(rst.getString("yjn_Pname02"));
                sg.setCiname(rst.getString("yjn_Ciname02"));
                sg.setDname(rst.getString("yjn_Dname02"));

                StuLocationArrayList.add(sg);
            }
            conn.close();
            return StuLocationArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }

    }




    public ArrayList<Region> SelectProvince() throws DaoException
    {
        ArrayList<Region> R = new ArrayList<Region>();
        String sql="SELECT * FROM Yangjn_Province02";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                Region sg = new Region();
                sg.setNum(rst.getString("yjn_Pno02"));
                sg.setName(rst.getString("yjn_Pname02"));

                R.add(sg);
            }
            conn.close();
            return R;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Region> SelectCity(String loc) throws DaoException
    {
        ArrayList<Region> R = new ArrayList<Region>();
        String sql="SELECT yjn_Cino02, yjn_Ciname02 FROM Yangjn_City02 WHERE yjn_Pno02 = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, loc);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                Region sg = new Region();
                sg.setNum(rst.getString("yjn_Cino02"));
                sg.setName(rst.getString("yjn_Ciname02"));

                R.add(sg);
            }
            conn.close();
            return R;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Region> SelectDistrict(String loc) throws DaoException
    {
        ArrayList<Region> R = new ArrayList<Region>();
        String sql="SELECT yjn_Dno02, yjn_Dname02 FROM Yangjn_District02 WHERE yjn_Cino02 = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, loc);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                Region sg = new Region();
                sg.setNum(rst.getString("yjn_Dno02"));
                sg.setName(rst.getString("yjn_Dname02"));

                R.add(sg);
            }
            conn.close();
            return R;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
