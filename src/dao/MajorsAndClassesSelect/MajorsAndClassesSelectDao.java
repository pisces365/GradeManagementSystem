package dao.MajorsAndClassesSelect;

import dao.Dao;
import dao.DaoException;

import java.util.ArrayList;

public interface MajorsAndClassesSelectDao extends Dao {
    public ArrayList<String> SelectMajors() throws DaoException;
    public ArrayList<String> SelectClasses(String major) throws DaoException;

    public ArrayList<String> SelectCourses() throws DaoException;
}
