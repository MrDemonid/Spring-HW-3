package mr.demonid.spring.hw3.services;

import mr.demonid.spring.hw3.domain.User;

import java.util.List;

public interface IDataProcessingService {

    /**
     * Возвращает отсортированный список пользователей
     * @param users Список пользователей
     */

    List<User> sortUsersByAge(List<User> users);

    /**
     * Возвращает список пользователей старше {age} лет
     * @param users Список всех пользователей
     * @param age   Возраст для фильтра
     */
    List<User> filterUsersByAge(List<User> users, int age);

    /**
     * Возвращает средний возраст всех пользователей
     * @param users Список всех пользователей
     */
    double calculateAverageAge(List<User> users);

    /**
     * Возвращает список всех пользователей из БД
     */
    List<User> getAllUsers();

    /**
     * Возвращает пользователя по его ID
     */
    User getUserById(Long id);

    /**
     * Обновляет данные о пользователе в БД.
     * @param user Данные существующего пользователя
     */
    User updateUser(User user);

    /**
     * Удаление пользователя из БД.
     * @param id Идентификатор пользователя.
     */
    void deleteUser(Long id);

}
