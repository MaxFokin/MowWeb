package com.MowWeb.connection;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSource {

    private static DataSource datasource;
    private ComboPooledDataSource cpds;
    final private DBConnData dbConnData = new DBConnData();

    private DataSource() throws IOException, SQLException, PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://" + dbConnData.getHost() + "/mowwebdb?autoReconnect=true&useSSL=false");
        cpds.setUser(dbConnData.getUser());
        cpds.setPassword(dbConnData.getPass());

        // the settings below are optional -- c3p0 can work with defaults
        //cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);
    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }

}