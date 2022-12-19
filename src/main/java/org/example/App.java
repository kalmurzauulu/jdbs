package org.example;

import db.DataBase;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
       // DataBase.connection();
//        DataBase.createTable();
//        DataBase.addDeveloper(1,"sher",200);
        DataBase.getAllDevelopers();

    }
}
