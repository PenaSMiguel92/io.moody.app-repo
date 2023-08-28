package io.moody.app;
import java.util.*;

public interface IDAOMulti<T> {
    public boolean createRecord(List<T> data);
    public List<T> readRecord(long id);
    public boolean updateRecord(List<T> data);
    public boolean deleteRecord(long id);
}
