package dao.stuGrade;

import com.model.student.stuGrade;
import dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StuGradeDaoImpl implements StuGradeDao{
    public ArrayList<stuGrade> selectAllScores(String Sno) throws DaoException
    {
        ArrayList<stuGrade> stuGradeArrayList = new ArrayList<stuGrade>();
        String sql="CALL Yangjn_select_students_allScores02(?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Sno);

            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                stuGrade sg = new stuGrade();
                sg.setCno(rst.getString("yjn_Cno02"));
                sg.setClname(rst.getString("yjn_Clname02"));
                sg.setSCscore(rst.getInt("yjn_SCscore02"));
                sg.setSCyear(rst.getString("yjn_SCyear02"));
                sg.setCname(rst.getString("yjn_Cname02"));
                sg.setCcredit(rst.getDouble("yjn_Ccredit02"));
                sg.setCevaluation(rst.getString("yjn_Cevaluation02"));
                sg.setCterm(rst.getString("yjn_Cterm02"));
                sg.setCperiod(rst.getInt("yjn_Cperiod02"));
                stuGradeArrayList.add(sg);
            }
            conn.close();
            return stuGradeArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<stuGrade> selectScores(String Sno,String year) throws DaoException
    {
        ArrayList<stuGrade> stuGradeArrayList = new ArrayList<stuGrade>();
        String sql="CALL Yangjn_select_students_scores02(?,?)";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Sno);
            pstmt.setString(2, year);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                stuGrade sg = new stuGrade();
                sg.setCno(rst.getString("yjn_Cno02"));
                sg.setClname(rst.getString("yjn_Clname02"));
                sg.setSCscore(rst.getInt("yjn_SCscore02"));
                sg.setSCyear(rst.getString("yjn_SCyear02"));
                sg.setCname(rst.getString("yjn_Cname02"));
                sg.setCcredit(rst.getDouble("yjn_Ccredit02"));
                sg.setCevaluation(rst.getString("yjn_Cevaluation02"));
                sg.setCterm(rst.getString("yjn_Cterm02"));
                sg.setCperiod(rst.getInt("yjn_Cperiod02"));
                stuGradeArrayList.add(sg);
            }
            conn.close();
            return stuGradeArrayList;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }

    }


    public ArrayList<String> CreditsAndScores(String Sno) throws DaoException
    {
        ArrayList<String> CS = new ArrayList<String>();
        String sql="SELECT yjn_Scredits02, yjn_Sscore02 FROM Yangjn_Students02 WHERE yjn_Sno02 = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Sno);

            ResultSet rst = pstmt.executeQuery();
            if (rst.next())
            {
                CS.add(rst.getString("yjn_Scredits02"));
                CS.add(rst.getString("yjn_Sscore02"));
            }
            conn.close();
            return CS;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
