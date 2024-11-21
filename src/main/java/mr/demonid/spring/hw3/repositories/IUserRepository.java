package mr.demonid.spring.hw3.repositories;

import mr.demonid.spring.hw3.domain.User;

import java.util.List;


public interface IUserRepository {

    /**
     * Добавление пользователя в БД
     * @param user Новая заполненная структура пользователя, но ID должен быть нулевым! (его Hibernate заполнит)
     * @return Пользователя, или null - если такой пользователь уже существует
     */
    User addUser(User user);

    /**
     * Возвращает пользователя по его ID.
     * @param id Уникальный идентификатор пользователя
     * @return null - если такого пользователя нет
     */
    User getById(Long id);

    /**
     * Возвращает список всех имеющихся в БД пользователей.
     */
    List<User> getAll();

    /**
     * Обновление данных о пользователе.
     * @param user Пользователь
     * @return null в случае ошибки
     */
    User updateUser(User user);

    /**
     * Удаление пользователя из БД.
     * @param id Уикальный идентификатор пользователя/
     */
    void deleteUser(Long id);
}
