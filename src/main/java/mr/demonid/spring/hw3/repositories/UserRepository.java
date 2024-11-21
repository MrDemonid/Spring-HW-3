package mr.demonid.spring.hw3.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import mr.demonid.spring.hw3.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional                      // делаем каждый публичный класс транзакционным
public class UserRepository implements IUserRepository {

    @PersistenceContext                 // предоставит сервис, производящий все основные манипуляции с сущностями
    private EntityManager entityManager;


    @Override
    public User addUser(User user) {

        try {
            if (user.getId() == null)
            {
                entityManager.persist(user);
                return getById(user.getId());
            }
        } catch (Exception ignored) {}
        return null;
    }

    @Override
    public User getById(Long id) {
        try {
            return entityManager.find(User.class, id);
        } catch (Exception ignored) {}
        return null;
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User updateUser(User user) {
        try {
            return entityManager.merge(user);
        } catch (Exception ignored) {}
        return null;
    }

    public void deleteUser(Long id) {
        try {
            entityManager.remove(entityManager.find(User.class, id));
        } catch (Exception ignored) {}
    }

}
