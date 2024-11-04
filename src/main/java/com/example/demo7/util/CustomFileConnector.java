package com.example.demo7.util;

import java.io.File;

public class CustomFileConnector {
    public static void createDB(String DB_PATH) {
        try {
            File db = new File(DB_PATH);
            if (db.createNewFile()) {
                System.out.println(DB_PATH + " file not found, new one has been created");
            }
            else {
                System.out.println(DB_PATH + " has been successfully connected");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}
