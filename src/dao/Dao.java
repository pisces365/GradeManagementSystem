package dao;

import javax.naming.*;
import javax.sql.DataSource;
import javax.sql.*;
import java.sql.Connection;
import java.sql.SQLException;

public interface Dao {
    public static DataSource getDataSource()
    {
        DataSource dataSource = null;
        try {
            Context context = new InitialContext();
            dataSource=(DataSource)context.lookup("java:comp/env/jdbc/mis");
        }catch (NamingException ne)
        {
            System.out.println("异常："+ne);
        }
        return dataSource;
    }

    public default Connection getConnection() throws DaoException
    {
        DataSource dataSource = getDataSource();
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
        }catch(SQLException sqle)
        {
            System.out.println("异常："+sqle);
        }
        return conn;
    }
}
