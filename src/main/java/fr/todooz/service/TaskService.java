package fr.todooz.service;

import fr.todooz.domain.Task;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bphan-luong
 * Date: 08/11/13
 * Time: 11:26
 * To change this template use File | Settings | File Templates.
 */
public interface TaskService {
    void save(Task task);

    void delete(Long id);

    List<Task> findAll();

    List<Task> findByQuery(String query);

    int count();

    Task findById(Long id);
}
