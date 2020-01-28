package am.basicweb.Service;

import am.basicweb.model.User;
import am.basicweb.repository.UserRepository;

public interface UserService {
    User getByUserName(String username);

    UserRepository getUserRepositoryImpl();
}
