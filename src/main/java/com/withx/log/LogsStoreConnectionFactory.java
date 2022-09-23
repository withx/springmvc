package com.withx.log;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class LogsStoreConnectionFactory
{
    private static interface Singleton {
        final LogsStoreConnectionFactory INSTANCE = new LogsStoreConnectionFactory();
    }
    private static BasicDataSource logds;

    private LogsStoreConnectionFactory() {
    }

    private static String driver ="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://10.0.1.8:63306/log";
    private static String username="root";
    private static String password="abc123!@#";


    public static Connection getConnection() throws SQLException {
        if (logds == null) {
            logds = new BasicDataSource();
            logds.setDriverClassName(driver);
            logds.setUrl(url);
            logds.setUsername(username);
            logds.setPassword(password);
        }
        return logds.getConnection();
    }
}