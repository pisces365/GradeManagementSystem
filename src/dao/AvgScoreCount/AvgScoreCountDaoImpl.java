package dao.AvgScoreCount;

import com.model.teacher.AvgScoreCount;
import com.model.teacher.CoursesPlace;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AvgScoreCountDaoImpl implements AvgScoreCountDao{
    public ArrayList<AvgScoreCount> Yangjn_AvgScoreCount02(String year) throws DaoException
    {
        ArrayList<AvgScoreCount> AvgScoreCountArrayList = new ArrayList<AvgScoreCount>();
        String sql="SELECT * FROM Yangjn_AvgScoreCount02 WHERE yjn_SCyear02 = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, year);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                AvgScoreCount sc = new AvgScoreCount();

                sc.setCname(rst.getString("yjn_Cname02"));
                sc.setYear(rst.getString("yjn_SCyear02"));
                sc.setAveScore(rst.getDouble("AvgScore"));
                AvgScoreCountArrayList.add(sc);
            }
            conn.close();
            return AvgScoreCountArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }

    }

}
