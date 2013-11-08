package fr.todooz.web.controller;

import fr.todooz.domain.Task;
import fr.todooz.service.TagCloudService;
import fr.todooz.service.TaskService;
import fr.todooz.web.servlet.DummyData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bphan-luong
 * Date: 07/11/13
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class IndexController {
    @Inject
    private TaskService taskService;

    @Inject
    private TagCloudService tagCloudService;


    @RequestMapping({ "/", "/index" })
    public String index(Model model) {
        model.addAttribute("tasks", taskService.findAll());

        return "index";
    }

    @RequestMapping("/search")
    public String search(String query, Model model) {
        model.addAttribute("tasks", taskService.findByQuery(query));
        return "index";
    }

/*
    @RequestMapping("/tag/{tag}")
    public String tag(@PathVariable String tag, Model model) {
        model.addAttribute("tagCloud", tagCloudService.buildTagCloud());
        return "index";
    }

*/

    @PostConstruct
    public void bootstrap() {
        if (taskService.count()==0) {

            Task task = new Task();

            task.setDate(new Date());
            task.setTitle("Read Python");
            task.setText("Read Effective Python");
            task.setTags("Python");
            taskService.save(task);

            task.setDate(new Date());
            task.setTitle("Read Java");
            task.setText("Read Effective Java");
            task.setTags("Java");
            taskService.save(task);


        }

    }

}
