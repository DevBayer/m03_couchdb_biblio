package database;

import org.lightcouch.*;

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
    public List findAll(Class cls, String view) {
        return connection.view(view).includeDocs(true).query(cls);
    }

    @Override
    public List findById(Class cls, String view, String key) {
        return connection.view(view).key(key).includeDocs(true).query(cls);
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

    @Override
    public int count(Object object) {
        List<Model> list =connection.view(((Model) object)._view_key).key(((Model) object).getKey()).query(Model.class);
        return list.size();
    }
}
