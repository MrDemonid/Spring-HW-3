package mr.demonid.spring.hw3.services;

import lombok.AllArgsConstructor;
import mr.demonid.spring.hw3.domain.User;
import mr.demonid.spring.hw3.repositories.IUserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService implements IRegistrationService {

    UserService userService;
    IUserRepository userRepository;

    @Override
    public User processRegistration(String name, int age, String email)
    {
        User user = userService.createUser(name, age, email);
        userRepository.addUser(user);
        return user;
    }

}
