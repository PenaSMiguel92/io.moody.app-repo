package io.moody.app;

public interface IDataAccessObject<T> {
    //crud - create, read, update, delete data from database;
    public boolean createRecord(T data);
    public T readRecord(int id);
    public boolean updateRecord(T data);
    public boolean deleteRecord(int id);
}
