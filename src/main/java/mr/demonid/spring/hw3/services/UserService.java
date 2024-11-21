package mr.demonid.spring.hw3.services;

import lombok.AllArgsConstructor;
import mr.demonid.spring.hw3.domain.User;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private NotificationService notificationService;


    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);
        return user;
    }
}
