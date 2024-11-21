package mr.demonid.spring.hw3.services;

import mr.demonid.spring.hw3.domain.User;

public interface IRegistrationService {

    /**
     * Процесс добавления нового пользователя в БД
     * @param name  Имя
     * @param age   Кол-во лет
     * @param email мыло
     * @return      Структура пользователя, или NULL (при ошибке)
     */
    User processRegistration(String name, int age, String email);
}
