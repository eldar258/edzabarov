package ru.job4j.httpprotocol;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class ru.job4j.httpprotocol.
 *
 * @author edzabarov
 * @since 28.07.2018
 */
public interface Command {
    boolean execute(HttpServletRequest request, HttpServletResponse resp) throws IOException;
}
