package ru.job4j.servlet;

import ru.job4j.httpprotocol.ValidateService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Scanner;

/**
 * Class ru.job4j.servlet.
 *
 * @author edzabarov
 * @since 29.07.2018
 */
public class UsersServlet extends HttpServlet {
    ValidateService validateService = ValidateService.getInstance();

    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", this.validateService.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("html/servlet/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
