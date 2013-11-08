package fr.todooz.service;

import fr.todooz.domain.Task;
import junit.framework.Assert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: bphan-luong
 * Date: 08/11/13
 * Time: 09:15
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TaskServiceTest {

    @Inject
    private SessionFactory sessionFactory;

    @Inject
    private TaskService taskService;


    @After
    public void cleanDb() {
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        session.createQuery("delete from Task").executeUpdate();

        transaction.commit();

        session.close();


    }

    @Test
    public void save() {

        taskService.save(task());

    }

    private Task task() {
        Task task = new Task();
        task.setDate(new Date());
        task.setTitle("Read Effective Java");
        task.setText("Read Effective Java before it's too late");
        task.setTags("java,java");
        return task;
    }

    @Test
    public void delete() {


        Task task = task();

        taskService.save(task);

        taskService.delete(task.getId());

        Session session = sessionFactory.openSession();

        Assert.assertEquals(0, session.createQuery("from Task").list().size());

        session.close();
    }

    @Test
    public void findAll() {


        taskService.save(task());
        taskService.save(task());

        Assert.assertEquals(2, taskService.findAll().size());
    }

    @Test
    public void findByQuery() {


        taskService.save(task());
        taskService.save(task());

        Assert.assertEquals(2, taskService.findByQuery("read").size());
        Assert.assertEquals(2, taskService.findByQuery("java").size());
        Assert.assertEquals(0, taskService.findByQuery("driven").size());
    }

    @Test
    public void count() {


        taskService.save(task());
        taskService.save(task());

        Assert.assertEquals(2, taskService.count());
    }
}
