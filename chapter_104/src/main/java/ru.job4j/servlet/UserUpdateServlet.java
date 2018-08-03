package ru.job4j.servlet;

import com.sun.org.apache.regexp.internal.RE;
import ru.job4j.httpprotocol.ValidateService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/**
 * Class ru.job4j.servlet.
 *
 * @author edzabarov
 * @since 29.07.2018
 */
public class UserUpdateServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getInstance();
    private final static String REGEX_TO_INT = "-?\\d+";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("id");
        int id;
        if (Pattern.matches(REGEX_TO_INT, num)) {
            id = Integer.parseInt(num);
        } else {
            return;
        }
        req.setAttribute("id", num);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/UserUpdate.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("id");
        int id;
        if (Pattern.matches(REGEX_TO_INT, num)) {
            id = Integer.parseInt(num);
        } else {

            return;
        }
        String name = req.getParameter("txtName");
        boolean succ = validateService.update(id, name);
        PrintWriter printWriter = resp.getWriter();
        printWriter.append(succ ? "updated" : String.format("Пользователь с id %s не найден или некорректное имя %s", id, name));
        printWriter.flush();
    }
}
