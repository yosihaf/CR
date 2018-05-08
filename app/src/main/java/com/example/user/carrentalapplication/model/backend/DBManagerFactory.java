package com.example.user.carrentalapplication.model.backend;

/**
 * Created by User on 12/04/2018.
 */
import com.example.user.carrentalapplication.model.datasource.List_DBManager;
import com.example.user.carrentalapplication.model.datasource.MySQL_DBManager;

public class DBManagerFactory {
    static DB_manager manager = null;

    public static DB_manager getManager() {
        if (manager == null)
            manager = new MySQL_DBManager();
        return manager;
    }
}
