package dao.AdminDao;

import dao.Dao;
import dao.DaoException;
import com.model.admin.*;

import java.util.ArrayList;

public interface AdminDao extends Dao {
    public boolean InsertMajors(String yjn_Mno02, String yjn_Mname02) throws DaoException;
    public boolean InsertClasses(String yjn_Clno02, String yjn_Clname02, String yjn_Mno02) throws DaoException;
    public boolean InsertTeachers(String yjn_Tno02, String yjn_Tname02, String yjn_Tsex02, int yjn_Tage02
            , String yjn_Tphone02, String yjn_Tprof02, String yjn_Tpassword02) throws DaoException;
    public boolean InsertStudents(String yjn_Sno02, String  yjn_Sname02, String yjn_Ssex02, int yjn_Sage02, double yjn_Scredits02,
                                  String yjn_Slocation02, String yjn_Spassword02, String yjn_Clno02, double yjn_Sscore02) throws DaoException;
    public boolean InsertCourses(String yjn_Cno02, String yjn_Clno02, String yjn_Cname02,
                                 double yjn_Ccredit02, String yjn_Cevaluation02, String yjn_Cterm02, int yjn_Cperiod02) throws DaoException;
    public boolean InsertSC(String yjn_Sno02, String yjn_Cno02, String yjn_Clno02, String yjn_SCyear02, int yjn_SCscore02) throws DaoException;
    public boolean InsertTC(String yjn_Tno02, String yjn_Cno02, String yjn_Clno02, String yjn_TCyear02) throws DaoException;
    public boolean InsertProvince(String yjn_Pno02, String yjn_Pname02) throws DaoException;
    public boolean InsertCity(String yjn_Cino02, String yjn_Ciname02, String yjn_Pno02) throws DaoException;
    public boolean InsertDistrict(String yjn_Dno02, String yjn_Dname02, String yjn_Cino02) throws DaoException;



    public ArrayList<City> SelectCity() throws DaoException;
    public ArrayList<Classes> SelectClasses() throws DaoException;
    public ArrayList<Courses> SelectCourses() throws DaoException;
    public ArrayList<District> SelectDistrict() throws DaoException;
    public ArrayList<Majors> SelectMajors() throws DaoException;
    public ArrayList<Province> SelectProvince() throws DaoException;
    public ArrayList<SC> SelectSC() throws DaoException;
    public ArrayList<Students> SelectStudents() throws DaoException;
    public ArrayList<TC> SelectTC() throws DaoException;
    public ArrayList<Teachers> SelectTeachers() throws DaoException;

    public boolean DeleteCity(String yjn_Cino02) throws DaoException;
    public boolean DeleteClasses(String yjn_Clno02) throws DaoException;
    public boolean DeleteCourses(String yjn_Cno02, String yjn_Clno02) throws DaoException;
    public boolean DeleteDistrict(String yjn_Dno02) throws DaoException;
    public boolean DeleteMajors(String yjn_Mno02) throws DaoException;
    public boolean DeleteProvince(String yjn_Pno02) throws DaoException;
    public boolean DeleteSC(String yjn_Sno02, String yjn_Cno02, String yjn_Clno02, String yjn_SCyear02) throws DaoException;
    public boolean DeleteStudents(String yjn_Sno02) throws DaoException;
    public boolean DeleteTC(String yjn_Tno02, String yjn_Cno02, String yjn_Clno02, String yjn_TCyear02) throws DaoException;
    public boolean DeleteTeachers(String yjn_Tno02) throws DaoException;


    public boolean UpdateCity(String yjn_Ciname02 , String yjn_Pno02,String yjn_Cino02 ) throws DaoException;
    public boolean UpdateClasses(String yjn_Clname02  , String yjn_Mno02,String yjn_Clno02 ) throws DaoException;
    public boolean UpdateCourses(String yjn_Cname02 , double yjn_Ccredit02 , String yjn_Cevaluation02 , String yjn_Cterm02 , int yjn_Cperiod02 ,
                                 String yjn_Cno02 , String yjn_Clno02 ) throws DaoException;
    public boolean UpdateDistrict(String yjn_Dname02 , String yjn_Cino02, String yjn_Dno02 ) throws DaoException;
    public boolean UpdateMajors(String yjn_Mname02,String yjn_Mno02 ) throws DaoException;
    public boolean UpdateProvince(String yjn_Pname02,String yjn_Pno02 ) throws DaoException;
    public boolean UpdateStudents(String yjn_Sname02 , String yjn_Ssex02 , int yjn_Sage02 , double yjn_Scredits02 , String yjn_Slocation02 , String yjn_Spassword02 , String yjn_Clno02 , double yjn_Sscore02,
                                  String yjn_Sno02 ) throws DaoException;
    public boolean UpdateTeachers(String yjn_Tname02  , String yjn_Tsex02  , int yjn_Tage02  , String yjn_Tphone02 , String  yjn_Tprof02 , String  yjn_Tpassword02,
                                  String yjn_Tno02 ) throws DaoException;

}



/*
* INSERT INTO Yangjn_Majors02 VALUES
(?,?)    yjn_Mno02  yjn_Mname02
INSERT INTO Yangjn_Classes02 VALUES
(?,?,?)    yjn_Clno02  yjn_Clname02   yjn_Mno02
INSERT INTO Yangjn_Teachers02 VALUES
(?,?,?,?,?,?,?)    yjn_Tno02  yjn_Tname02  yjn_Tsex02  yjn_Tage02  yjn_Tphone02  yjn_Tprof02  yjn_Tpassword02
INSERT INTO Yangjn_Students02 VALUES
(?,?,?,?,?,?,?,?)  yjn_Sno02    yjn_Sname02  yjn_Ssex02  yjn_Sage02  yjn_Scredits02  yjn_Slocation02  yjn_Spassword02  yjn_Clno02  yjn_Sscore02
INSERT INTO Yangjn_Courses02 VALUES
(?,?,?,?,?,?,?)    yjn_Cno02  yjn_Clno02  yjn_Cname02            yjn_Ccredit02  yjn_Cevaluation02  yjn_Cterm02  yjn_Cperiod02
INSERT INTO Yangjn_SC02 VALUES
(?,?,?,?,?)      yjn_Sno02    yjn_Cno02  yjn_Clno02  yjn_SCyear02  yjn_SCscore02
INSERT INTO Yangjn_TC02 VALUES
(?,?,?,?)       yjn_Tno02  yjn_Cno02  yjn_Clno02  yjn_TCyear02
INSERT INTO Yangjn_Province02 VALUES
(?,?)      yjn_Pno02  yjn_Pname02
INSERT INTO Yangjn_City02 VALUES
(?,?,?)    yjn_Cino02  yjn_Ciname02  yjn_Pno02
INSERT INTO Yangjn_District02 VALUES
(?,?,?)     yjn_Dno02  yjn_Dname02  yjn_Cino02

*  */