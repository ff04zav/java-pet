package com.google.ff04zav.db.mysql;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Properties props = new Profile().getProperties("db"); 
        var db = Database.instance();
        try {
			db.connect(props);
			UserDao userDao = new UserDaoImpl();
			//userDao.save(new User("Neptun"));
			
			int id = 6;
			var userOpt = userDao.findById(id);
			if (userOpt.isPresent()) {
				System.out.println("Retrived: " + userOpt.get() );
				userDao.update(new User(id, "Neptun"));
			} else {
				System.out.println("User not found");
			}
			
			userDao.delete(new User(7));
			List<User> users = userDao.getAll();
			users.forEach(System.out::println);
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
