package io.moody.app;

import java.util.*;

public interface IDataAccessObject<T> {
    //crud - create, read, update, delete data from database;
    public boolean createRecord(T data);
    public T readRecord(long id);
    public boolean updateRecord(T data);

    public boolean deleteRecord(long id);

    public List<T> getAllRecords();
}
