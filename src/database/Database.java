package database;

import interfaces.OBJConnector;
import models.Catalogues.Books;

import java.util.List;

/**
 * Created by 23878410v on 09/03/17.
 */
public class Database implements OBJConnector {
    @Override
    public List findAll(Class cls) {
        return null;
    }

    @Override
    public Object findById(Object id) {
        return null;
    }

    @Override
    public boolean insert(Object obj) {
        return false;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
