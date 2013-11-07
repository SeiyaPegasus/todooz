package fr.todooz.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: bphan-luong
 * Date: 07/11/13
 * Time: 14:04
 * To change this template use File | Settings | File Templates.
 */

public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("tasks", DummyData.tasks());

        request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
    }

}
