package interfaces;

import database.Model;

import java.util.List;

/**
 * Created by 23878410v on 09/03/17.
 */
public interface OBJConnector<T> {
    List<T> findAll(Class<? extends Model> cls);
    Object findById(T id);
    boolean insert(T obj);
    boolean update(T obj);
    boolean delete(T obj);
}
