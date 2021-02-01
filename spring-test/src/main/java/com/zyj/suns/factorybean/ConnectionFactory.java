package com.zyj.suns.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 动态工厂
 */
public class ConnectionFactory {

    public Connection getConnection(){
        System.out.println("ConnectionFactory.getConnection");
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://172.16.6.6", "root", "beebankInvoker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
