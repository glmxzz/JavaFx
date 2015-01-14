package ch.makery.address.dao;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Jace
 * Date: 13-8-22
 * Time: 下午2:37
 * 数据库连接池
 */
public class DBConnectionPool {
    public static String SQL_URL = "jdbc:mysql://localhost:3306/javafx" ;
    public static String USERNAME  = "root";
    public static String PASSWORD  = "3348635";
    private static JdbcPooledConnectionSource jdbcConnectionSource;

    public static JdbcConnectionSource getConnectSource() {
        try {
            if (jdbcConnectionSource == null) {

                jdbcConnectionSource = new JdbcPooledConnectionSource(SQL_URL);

                jdbcConnectionSource.setMaxConnectionsFree(100);
                jdbcConnectionSource.setUsername(USERNAME);
                jdbcConnectionSource.setPassword(PASSWORD);

//                jdbcConnectionSource = new JdbcPooledConnectionSource("jdbc:mysql://127.0.0.1:3306/interview");
//
//                jdbcConnectionSource.setMaxConnectionsFree(100);
//                jdbcConnectionSource.setUsername("root");
//                jdbcConnectionSource.setPassword("3348635");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jdbcConnectionSource;
    }

    public static void close() {
        try {
            jdbcConnectionSource.close();
            jdbcConnectionSource = null ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
