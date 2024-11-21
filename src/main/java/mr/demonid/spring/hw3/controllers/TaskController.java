package mr.demonid.spring.hw3.controllers;


import mr.demonid.spring.hw3.domain.User;
import mr.demonid.spring.hw3.services.IDataProcessingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/task")
public class TaskController {

    IDataProcessingService dataProcessingService;

    // внедрение зависимостей через конструктор
    public TaskController(IDataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    /**
     * Вывод краткого перечня доступных адресов /task
     */
    @GetMapping
    public List<String> getAllTasks() {
        return new ArrayList<>(List.of("/sort-by-age - show users, sorted by ages", "/filter/{age} - show users, only age is great {age}", "/average - show average ages"));
    }

    /**
     * Вывод отсортированного списка всех пользователей
     */
    @GetMapping("/sort-by-age")
    public List<User> getSortByAge() {
        return dataProcessingService.sortUsersByAge(dataProcessingService.getAllUsers());
    }

    /**
     * Вывод пользователей старше {age} лет
     * Параметр передается в адресной строке (/task/filter/{age}
     * @param age возраст для фильтра
     */
    @GetMapping("/filter/{age}")
    public List<User> getFilterByAge(@PathVariable("age") int age) {
        return dataProcessingService.filterUsersByAge(dataProcessingService.getAllUsers(), age);
    }

    /**
     * Вывод среднего значения возраста всех пользователей
     */
    @GetMapping("/average")
    public double getAverage()
    {
        return dataProcessingService.calculateAverageAge(dataProcessingService.getAllUsers());
    }

}
