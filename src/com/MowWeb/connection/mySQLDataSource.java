package com.MowWeb.connection;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class mySQLDataSource {

    private static mySQLDataSource datasource;
    private ComboPooledDataSource cpds;
    final private DBConnData dbConnData = new DBConnData();

    private mySQLDataSource() throws IOException, SQLException, PropertyVetoException {
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

    public static mySQLDataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new mySQLDataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }

}