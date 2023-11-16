package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user0 = new User("User1", "Lastname1", "user1@mail.ru");
      User user1 = new User("User2", "Lastname2", "user2@mail.ru");
      User user2 = new User("User3", "Lastname3", "user3@mail.ru");
      Car car0 = new Car("Nissan", 123);
      Car car1 = new Car("Volkswagen", 456);
      Car car2 = new Car("Kia", 789);
      user0.setCar(car0);
      user1.setCar(car1);
      user2.setCar(car2);
      userService.add(user0);
      userService.add(user1);
      userService.add(user2);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      System.out.println(userService.getByCar("Nissan", 123));
      context.close();
   }
}
