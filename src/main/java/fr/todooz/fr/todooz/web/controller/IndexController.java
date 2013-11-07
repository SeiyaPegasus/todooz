package fr.todooz.fr.todooz.web.controller;

import fr.todooz.web.servlet.DummyData;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: bphan-luong
 * Date: 07/11/13
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */
public class IndexController {
    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("tasks", DummyData.tasks());
        return "index";
    }

}
