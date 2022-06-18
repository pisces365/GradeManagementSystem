package dao.Place;

import com.model.teacher.ClassesPlace;
import com.model.teacher.CoursesPlace;
import com.model.teacher.MajorPlace;
import dao.Dao;
import dao.DaoException;

import java.util.ArrayList;

public interface PlaceDao extends Dao {
    public ArrayList<CoursesPlace> SelectCoursesPlace(String Cname,String year) throws DaoException;//课程排名
    public ArrayList<String> SelectCoursesScoreDistribution(String Cname, String year) throws DaoException;//课程分数分布

    public ArrayList<ClassesPlace> SelectClassesPlace(String Clname) throws DaoException;//班级排名
    public ArrayList<MajorPlace> SelectMajorPlace(String Mname) throws DaoException;//专业排名

    public ArrayList<CoursesPlace> select_Courses_score_to_upload(String Cname,String Clname, String year) throws DaoException;//成绩录入

    public boolean UpdateScore(int score, String Sno,String Cno, String Clno, String year) throws DaoException;
}
