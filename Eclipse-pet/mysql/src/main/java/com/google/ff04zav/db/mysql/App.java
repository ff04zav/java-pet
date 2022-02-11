package com.google.ff04zav.db.mysql;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var db = Database.instance();
        try {
			db.connect();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println( "Hello World!" );
    }
}
