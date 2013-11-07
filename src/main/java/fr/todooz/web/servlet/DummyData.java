package fr.todooz.web.servlet;

import fr.todooz.domain.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bphan-luong
 * Date: 07/11/13
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
public class DummyData {
    private static final int TASK_COUNT = 8;

    public static List<Task> tasks() {
        List<Task> tasks = new ArrayList<Task>();

        for (int i = 0; i < TASK_COUNT; i++) {
            tasks.add(task());
        }

        return tasks;
    }

    private static Task task() {
        Task task = new Task();

        task.setDate(new Date());
        task.setTitle("Read Effective Java MAMA");
        task.setText("Read Effective Java before it's too late");
        task.setTags("java,java");

        return task;
    }
}
