package dao.TeachersCourse;

import com.model.teacher.TeachersCourses;
import dao.Dao;
import dao.DaoException;

import java.util.ArrayList;

public interface TeachersCourseDao extends Dao {
    public ArrayList<TeachersCourses> SelectTeachersCourses(String Tname) throws DaoException;

    public ArrayList<String> SelectTeachersCoursesAsOption(String Tname) throws DaoException;
}
