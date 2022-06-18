package dao.LogIn;

import com.model.student.stuInfo;
import com.model.teacher.TeaInfo;
import dao.Dao;
import dao.DaoException;

import java.util.ArrayList;

public interface LogInDao extends Dao {
    public stuInfo stuLogIn(String Sno,String Sname,String Spassword) throws DaoException;

    public ArrayList<String> stuYears() throws DaoException;





    public TeaInfo teaLogIn(String Tno, String Tname, String Tpassword) throws DaoException;

    public ArrayList<String> teaYears() throws DaoException;
}
