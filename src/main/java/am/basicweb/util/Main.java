package am.basicweb.util;

import am.basicweb.Service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
  /*      UserRepositoryImpl userRepository = new UserRepositoryImpl();
        User user = new User();
        System.out.println(user);
        user.setName("Gayane");
        user.setPassword("hfjer");
        user.setSurname("Badalyan");
        user.setAge(15);
        user.setCode("jrgt");
        *//*    userRepositoryImpl.update(user);*//*
   *//*     user1.setAge(12);
        user1.setSurname("Sahakyan");
        user1.setPassword("hgfre");*//*
        Card card1 = new Card();
        card1.setNumber("123");
        card1.setOwnerName("Armen");
        user.setCard(card1);
        *//* userRepositoryImpl.addUser(user1);*//*
*//*        userRepository.getById(134);
        User user2 = userRepository.getById(134);*//*
        *//*        userRepository.getById(133);
         *//**//*       User user3 = userRepository.getById(133);
        System.out.println(1);
        System.out.println(user2.getCard());*//*
        Action action = new Action();
        action.setName("Name1");
        action.setName("ghefj");
        Action action1 = new Action();
        action1.setName("Name2");
        action1.setDescription("uyferjhfb");
        List<Action> list1 = Arrays.asList(action, action1);
        user.setActions(list1);
  *//*      userRepository.addUser(user);*//*
        System.out.println(user);
        User fromDB =userRepository.getById(135);
      System.out.println(fromDB);*//*
        UserRepository userRepositoryimplHiber= new UserRepositoryImpl();
        UserRepository userRepositoryimplJdbc= new UserRepositoryImplJdbc();
        UserService userServiceInterface= new UserServiceImpl(userRepositoryimplJdbc);
        userServiceInterface.getByUserName("jyt");*/
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("Aplication-Context.xml");
        System.out.println(1);
        UserService userService=applicationContext.getBean(UserService.class);
        System.out.println(2);
        UserService userService1=applicationContext.getBean(UserService.class);
        userService.getByUserName("jyt");
        System.out.println(userService);
        System.out.println(userService.getUserRepositoryImpl());
        System.out.println(1);
        System.out.println(userService1);
        System.out.println(userService1.getUserRepositoryImpl());
    }
}
