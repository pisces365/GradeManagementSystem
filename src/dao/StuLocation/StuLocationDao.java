package dao.StuLocation;

import com.model.teacher.Region;
import com.model.teacher.StuLocation;
import dao.Dao;
import dao.DaoException;

import java.util.ArrayList;

public interface StuLocationDao extends Dao {
    public ArrayList<StuLocation> SelectStuLocation(String p,String c,String d) throws DaoException;



    public ArrayList<Region> SelectProvince() throws DaoException;
    public ArrayList<Region> SelectCity(String loc) throws DaoException;
    public ArrayList<Region> SelectDistrict(String loc) throws DaoException;
}
