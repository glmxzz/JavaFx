package ch.makery.address.dao;

import ch.makery.address.model.Person;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class PersonDao extends BaseDaoImpl<Person, String> {

    private static Dao<Person, String> paperDao ;

    public static Dao getInstance(ConnectionSource connectionSource) throws SQLException {
        if (paperDao == null) {
            paperDao = new PersonDao(connectionSource) ;
        }

        return paperDao ;
    }

    private PersonDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Person.class);
        paperDao = DaoManager.createDao(connectionSource, Person.class) ;
    }
}
