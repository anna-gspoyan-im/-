package am.basicweb.Service.Impl;

import am.basicweb.Service.UserService;
import am.basicweb.model.User;
import am.basicweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;

@Scope("singleton")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepositoryImpl;
    @PostConstruct
    public  void init1(){
        System.out.println("init1-UserServiceImpl");
    }
    @PreDestroy
    public void destroy1(){
        System.out.println("destroy1-UserServiceImpl");
    }

    @Override
    public User getByUserName(String username) {
        try {
            return userRepositoryImpl.getbyUserName(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public UserRepository getUserRepositoryImpl() {
        return userRepositoryImpl;
    }
}
