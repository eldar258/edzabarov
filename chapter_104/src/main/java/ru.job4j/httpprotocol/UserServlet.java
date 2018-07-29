package ru.job4j.httpprotocol;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

/**
 * Class ru.job4j.httpprotocol.
 *
 * @author edzabarov
 * @since 28.07.2018
 */
public class UserServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(HttpServlet.class);


    private ValidateService validateService;
    private Map<String, BiPredicate<HttpServletRequest, HttpServletResponse>> commands;

    public UserServlet() {
        validateService = ValidateService.getInstance();
        this.commands = new HashMap<>();

        commands.put("", (req, resp) -> false);
        commands.put("add", this::add);
        commands.put("delete", this::delete);
        commands.put("update", this::update);
        commands.put("findById", this::findById);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        List<User> userList = validateService.findAll();
        for (User el : userList) {
            printWriter.append(String.format("%s\n", el.toString()));
        }
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        this.commands.getOrDefault(action, this.commands.get("")).test(req, resp);
    }

    private boolean add(HttpServletRequest request, HttpServletResponse resp) {
        String name = request.getParameter("name");
        return validateService.add(name);
    }

    private boolean findById(HttpServletRequest request, HttpServletResponse resp) {
        int id = Integer.parseInt(request.getParameter("id"));
        resp.setContentType("text/html");
        User user = validateService.findById(id);
        boolean result = user != null;
        PrintWriter printWriter = null;
        try {
            printWriter = resp.getWriter();
            printWriter.append(result ? user.toString() : null);

        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    private boolean delete(HttpServletRequest request, HttpServletResponse resp) {
        int id = Integer.parseInt(request.getParameter("id"));
        return validateService.delete(id);
    }

    private boolean update(HttpServletRequest request, HttpServletResponse resp) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        return validateService.update(id, name);
    }
}
