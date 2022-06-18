package dao.AvgScoreCount;

import com.model.teacher.AvgScoreCount;
import dao.Dao;
import dao.DaoException;

import java.util.ArrayList;

public interface AvgScoreCountDao extends Dao {
    public ArrayList<AvgScoreCount> Yangjn_AvgScoreCount02(String year) throws DaoException;

}
