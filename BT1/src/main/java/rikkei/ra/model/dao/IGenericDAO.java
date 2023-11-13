package rikkei.ra.model.dao;

import java.util.List;

public interface IGenericDAO<T, ID> {
    List<T> findAll();
    Boolean save(T t);
    T findById(ID id);
    Boolean update(T t, ID id);
    Boolean delete(ID id);
}
