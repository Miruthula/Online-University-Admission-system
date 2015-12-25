/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Application;
import java.net.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Admin
 */
public class DBConnection
{
    
    private static String dbURL = "jdbc:mysql://127.2.2.130:3306/";
    private static String schemaName = "UMC_db";
    //private static String dbUsername = "root";
    //private static String dbPassword = "sesame";
    private static String dbUsername = "adminpuF6qc1";
    private static String dbPassword = "cwHLdbwGmLN6";
    private static java.sql.Connection connection;
     public DBConnection() 
     {
        try {
            // load the DB driver
            Class.forName("com.mysql.jdbc.Driver");
            // get a DB connection
            connection = DriverManager.getConnection(dbURL + schemaName, dbUsername, dbPassword);
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR: Driver not found");
            connection = null;

        } catch (SQLException ex) {
            System.out.println("ERROR: Could not create DB connection");
        }

    }
     public static Statement getNewStatement() {
        Statement statement;
        try {
            if (connection == null) {
                new DBConnection();
            }
            /* Creating a statement object that we can use for running
             * SQL statements commands against the database.*/
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println("ERROR: Could not create SQL statement object: " + e);
            statement = null;
        }
        return statement;
    }
     public static java.sql.Connection getConnection() {
        if (connection == null) {
            new DBConnection();
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
