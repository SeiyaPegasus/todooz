package fr.todooz.web.controller;

import fr.todooz.domain.Task;
import fr.todooz.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: bphan-luong
 * Date: 08/11/13
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class AdminController {
    @Inject
    private TaskService taskService;

    @RequestMapping("/add")
    public String add(Model model) {
        // on injecte une Task vierge dans le modèle
        model.addAttribute("task", new Task());

        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String post(Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }

        taskService.save(task);

        return "redirect:/";
    }
}
