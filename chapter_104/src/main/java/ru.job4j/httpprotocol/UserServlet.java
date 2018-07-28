package ru.job4j.httpprotocol;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class ru.job4j.httpprotocol.
 *
 * @author edzabarov
 * @since 28.07.2018
 */
public class UserServlet extends HttpServlet {

    private ValidateService validateService;
    private Map<String, Command> commands;

    public UserServlet() {
        validateService = ValidateService.getInstance();
        this.commands = new HashMap<>();

        commands.put("add", new CommandAdd());
        commands.put("delete", new CommandDelete());
        commands.put("update", new CommandUpdate());
        commands.put("findById", new CommandFindById());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        List<User>  userList = validateService.findAll();
        for (User el : userList) {
            printWriter.append(String.format("%s\n", el.toString()));
        }
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Command command = this.commands.getOrDefault(action, new NoCommand());
        command.execute(req, resp);
    }

    private class NoCommand implements Command {
        @Override
        public boolean execute(HttpServletRequest request, HttpServletResponse resp) {
            return false;
        }
    }

    private class CommandAdd implements Command {
        public boolean execute(HttpServletRequest request, HttpServletResponse resp) {
            String name = request.getParameter("name");
            return validateService.add(name);
        }
    }

    private class CommandFindById implements Command {
        @Override
        public boolean execute(HttpServletRequest request, HttpServletResponse resp) throws IOException{
            int id = Integer.parseInt(request.getParameter("id"));
            resp.setContentType("text/html");
            PrintWriter printWriter = resp.getWriter();
            User user = validateService.findById(id);
            boolean result = user != null;
            printWriter.append(result ? user.toString() : null);
            return result;
        }
    }

    private class CommandDelete implements Command {
        @Override
        public boolean execute(HttpServletRequest request, HttpServletResponse resp) throws IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            return validateService.delete(id);
        }
    }

    private class CommandUpdate implements Command {
        @Override
        public boolean execute(HttpServletRequest request, HttpServletResponse resp) throws IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            return validateService.update(id, name);
        }
    }
}
