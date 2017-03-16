package database;

import org.lightcouch.CouchDbClient;
import org.lightcouch.Response;

import java.util.List;

/**
 * Created by 23878410v on 09/03/17.
 */
public class MyCouch extends Database {
    CouchDbClient connection;

    public MyCouch(CouchDbClient connection) {
        this.connection = connection;
    }

    @Override
    public List findAll(Class cls) {
        return connection.view("_all_docs").includeDocs(true).query(cls);
    }

    @Override
    public Object findById(Object object) {
        return connection.find(object.getClass(), ((Model) object).getPrimaryKey());
    }

    @Override
    public boolean insert(Object obj) {
        Response r = connection.save(obj);
        if(r.getError() == null){
            ((Model) obj).setPrimaryKey(r.getId());
            ((Model) obj).setRev(r.getRev());
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(Object obj) {
        Response r = connection.update(obj);
        if(r.getError() == null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delete(Object obj) {
        Response r = connection.remove(obj);
        if(r.getError() == null){
            return true;
        }else{
            return false;
        }
    }
}
