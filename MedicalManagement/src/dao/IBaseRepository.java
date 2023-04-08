package dao;

import connection.ConnectionManager;

public abstract class IBaseRepository<T> {
    protected ConnectionManager connectionManager;

    public abstract int addModel(T model);

    public abstract boolean deleteModelByID(String id);

    public abstract int updateModel(String id, T model);

}
