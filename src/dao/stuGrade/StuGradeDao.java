package dao.stuGrade;

import com.model.student.stuGrade;
import dao.DaoException;

import java.util.ArrayList;

public interface StuGradeDao extends dao.Dao{
    public ArrayList<stuGrade> selectAllScores(String Sno) throws DaoException;

    public ArrayList<stuGrade> selectScores(String Sno,String year) throws DaoException;


    public ArrayList<String> CreditsAndScores(String Sno) throws DaoException;
}
