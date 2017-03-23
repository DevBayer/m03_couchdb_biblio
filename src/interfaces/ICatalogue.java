package interfaces;

import database.Model;

import java.util.List;

/**
 * Created by 23878410v on 16/03/17.
 */
public interface ICatalogue<T> {
    void add(T obj);
    List<T> get();
    Model get(String key);
}
