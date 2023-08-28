package io.moody.app;

public interface IDAOSingle<T> {
    //crud - create, read, update, delete data from database;
    public boolean createRecord(T data);
    public T readRecord(long id);
    public boolean updateRecord(T data);

    public boolean deleteRecord(long id);

}
