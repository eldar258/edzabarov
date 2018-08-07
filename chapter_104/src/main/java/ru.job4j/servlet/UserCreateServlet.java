package ru.job4j.servlet;

import ru.job4j.httpprotocol.ValidateService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Class ru.job4j.servlet.
 *
 * @author edzabarov
 * @since 29.07.2018
 */
public class UserCreateServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/UserCreate.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String role = req.getParameter("role");
        String  name = req.getParameter("txtName");
        String password = req.getParameter("password");
        boolean succ = validateService.add(name, password, role);
        printWriter.append(succ ? "registered" : "user exist");
        printWriter.flush();
    }
}
