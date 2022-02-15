package gradle.spring.pet.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import entities.User;
import gradle.spring.pet.greeters.Greeter;
import repositories.UserDao;

@Component
public class Runner implements CommandLineRunner {
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public void run(String... args) throws Exception {
		var user1 = new User("Neptune", "neptune@example.com");
		userDao.save(user1);
		userDao.findByName("Neptune").forEach(u -> System.out.println(u.toString()));;
	}
	

}
