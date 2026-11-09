package com.beruangemas.laundrymanagementsystem.util;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args){
        try(Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println(">>> Database connected successfully to laundry database! <<<");
            }
        } catch (Exception e) {
            System.err.println(">>> Connection failed! Check credentials or port! <<<");
            e.printStackTrace();
        }
    }
}
