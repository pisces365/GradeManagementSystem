package dao.stuCourses;

import com.model.student.stuCourses;
import dao.Dao;
import dao.DaoException;

import java.util.ArrayList;

public interface StuCoursesDao extends Dao {
    public ArrayList<stuCourses> select_students_courses_and_credits(String Sno) throws DaoException;

    public ArrayList<stuCourses> select_students_courses_and_credits_by_year(String Sno,String year) throws DaoException;
    public ArrayList<stuCourses> select_students_courses_of_classes(String year,String Clname) throws DaoException;
}
