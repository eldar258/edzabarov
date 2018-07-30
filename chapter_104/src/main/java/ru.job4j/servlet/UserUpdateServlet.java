package ru.job4j.servlet;

import ru.job4j.httpprotocol.ValidateService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class ru.job4j.servlet.
 *
 * @author edzabarov
 * @since 29.07.2018
 */
public class UserUpdateServlet extends HttpServlet {
    ValidateService validateService = ValidateService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (RuntimeException ex) {
            return;
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/html/servlet/edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (RuntimeException ex) {
            return;
        }
        String name = req.getParameter("txtName");
        boolean succ = validateService.update(id, name);
        PrintWriter printWriter = resp.getWriter();
        printWriter.append(succ ? "updated" : String.format("Пользователь с id %s не найден или некорректное имя %s", id, name));
        printWriter.flush();
    }
}
