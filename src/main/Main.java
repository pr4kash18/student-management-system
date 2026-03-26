package main;

import db.DBConnection;

import java.sql.Connection;

public class Main{
    public static void main(String[] args) throws Exception {
        Connection con = DBConnection.getConnection();
        if (con != null) {
            System.out.println("Connected");
        }
    }
}
