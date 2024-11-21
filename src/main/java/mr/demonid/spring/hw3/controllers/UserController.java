package mr.demonid.spring.hw3.controllers;

import mr.demonid.spring.hw3.domain.User;
import mr.demonid.spring.hw3.services.IDataProcessingService;
import mr.demonid.spring.hw3.services.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IRegistrationService registrationService;                   // внедрение зависимостей через @Autowired
    @Autowired
    IDataProcessingService dataProcessingService;

    /**
     * Возвращает список всех зарегистрированных пользователей
     */
    @GetMapping
    public List<User> getAllUsers()
    {
        return dataProcessingService.getAllUsers();
    }

    /**
     * Добавление нового пользователя, с передачей параметра через тело запроса
     * @param user Структура пользователя, с нулевым ID (его заполнит Hibernate).
     *             Передаётся в теле (body) запроса.
     * @return Строку, об успешном добавлении (или ошибке).
     */
    @PostMapping("/body")
    public String addUser(@RequestBody User user)
    {
        return doAddUser(user.getName(), user.getAge(), user.getEmail());
    }

    /**
     * Добавление нового пользователя, с передачей параметров в строке запроса
     * @param name  Имя
     * @param age   Возраст
     * @param email мыло
     */
    @PostMapping("/param")
    public String addUser(@RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "age", required = false) int age,
                          @RequestParam(value = "email", required = false) String email)
    {
        return doAddUser(name, age, email);
    }

    /**
     * Обновление данных о пользователе, с передачей параметра через тело запроса
     * @param user Структура с данными о пользователе
     */
    @PutMapping("update/body")
    public String updateUser(@RequestBody User user)
    {
        return doUpdateUser(user);
    }

    /**
     * Обновление данных о пользователе, с передачей параметров в строке запроса
     * @param id    Идентификатор пользователя
     * @param name  Имя
     * @param age   Возраст
     * @param email мыло
     */
    @PutMapping("update/param")
    public String updateUser(@RequestParam(value = "id") Long id,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "age") int age,
                             @RequestParam(value = "email") String email)
    {
        User user = dataProcessingService.getUserById(id);
        if (user != null)
        {
            user.setName(name);
            user.setAge(age);
            user.setEmail(email);
        }
        return doUpdateUser(user);
    }

    /**
     * Удаление пользователя из БД.
     * @param id Идентификатор пользователя.
     */
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        dataProcessingService.deleteUser(id);
        return "User deleted";
    }


    /*
        Вспомогательные методы
     */

    private String doAddUser(String name, int age, String email)
    {
        User t = registrationService.processRegistration(name, age, email);
        if (t == null)
            return "Error: can't added user!";
        return "User added!";
    }

    private String doUpdateUser(User user)
    {
        if (user != null && dataProcessingService.updateUser(user) != null)
            return "User update!";
        return "Error: user not found!";
    }
}
