package fr.todooz.service;

import fr.todooz.domain.Task;
import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bphan-luong
 * Date: 08/11/13
 * Time: 09:11
 * To change this template use File | Settings | File Templates.
 */

@Service
public class TaskServiceImpl implements TaskService {
    @Inject
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void save(Task task) {
        Session session = sessionFactory.getCurrentSession();


        session.save(task);
        // TODO
    }


    @Override
    @Transactional
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Task where id = :id");
        query.setLong("id",id);

        query.executeUpdate();

    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findAll() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Task");

        //query.setString("title", "Read Effective Java");

        List<Task> tasks = query.list();

        return tasks;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findByQuery(String query) {
        Session session = sessionFactory.getCurrentSession();

        Criteria criteria = session.createCriteria(Task.class);

        criteria.add(Restrictions.ilike("title", query, MatchMode.ANYWHERE));

        List<Task> tasks = criteria.list();

        return tasks;
    }

    @Override
    @Transactional(readOnly = true)
    public int count() {
        // TODO


        return findAll().size();
    }

    @Transactional(readOnly = true)
    public Task findById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        return (Task) session.get(Task.class, id);


    }


}
