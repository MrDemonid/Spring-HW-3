package mr.demonid.spring.hw3.services;

import mr.demonid.spring.hw3.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }
}
