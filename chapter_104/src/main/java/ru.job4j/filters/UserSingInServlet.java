package ru.job4j.filters;

import ru.job4j.httpprotocol.ValidateService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class ru.job4j.filters.
 *
 * @author edzabarov
 * @since 04.08.2018
 */
public class UserSingInServlet extends HttpServlet {

    private final ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/UserSingIn.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        String role = validateService.findRoleByLoginPassword(login, password);
        if (role == null) {
            PrintWriter printWriter = resp.getWriter();
            printWriter.append("user not found");
            printWriter.flush();
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setAttribute("role", role);
            resp.sendRedirect("./list");
        }
    }
}
